package org.pantherslabs.chimera.sentinel.data_quality

//@import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import com.amazon.deequ.VerificationResult
import org.apache.spark.sql.functions.lit
import org.apache.spark.sql.types.{DoubleType, StringType, StructField, StructType}

import java.util
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.pantherslabs.chimera.sentinel.data_quality.entities.{DeequRunnerMetrics, DeequRunnerProcessStatus}
import org.pantherslabs.chimera.sentinel.data_quality.profiling.utils.DeequUtils
import org.pantherslabs.chimera.unisca.exception.ChimeraException
import org.pantherslabs.chimera.unisca.logging.{ChimeraLogger, ChimeraLoggerFactory}
import org.pantherslabs.chimera.unisca.utilities.ChimeraUtils
import scala.collection.mutable

object DataQualityRunner {

  private val logger: ChimeraLogger = ChimeraLoggerFactory.getLogger(this.getClass)
  private val loggerTag = "DataQualityRunner"

  private def getDqRules(spark: SparkSession, databaseName: String, tableName: String, stageName: String): DataFrame = {
    
    logger.logInfo(s"Fetching Data Quality Rules for $databaseName.$tableName")
    var scalaMap = mutable.Map.empty[String, String]
    if (stageName.isEmpty) {
      scalaMap = mutable.Map("databaseNm" -> databaseName, "tableNm" -> tableName, "activeFlg" -> "Y")
    }
    else {
      scalaMap = mutable.Map("databaseNm" -> databaseName, "tableNm" -> tableName, "procecssTypNm" -> stageName, "activeFlg" -> "Y")
    }
    val rules_df = EdlDqUserConfigRepository.listEdlDqUserConfigByColumns(spark, new util.HashMap[String,String](scalaMap)).asJava
    rules_df.show()
    rules_df
  }


  def execute(spark: SparkSession, batchId: String, dataFrame: DataFrame, databaseName: String,
              tableName: String, businessDate: String, instance: String, pipelineName: String,
              controlNames: Option[Seq[String]], stageName: Option[String], pipelineVersion: String): DeequRunnerMetrics = {
    val audit_time = ChimeraUtils.convertTimeFormat("yyyy-MM-dd HH:mm::ss.SSS", ChimeraUtils.currentGMTCalendar())
    var sourceRecordDuplicateCount: Double = 0
    var blank_row: Double = 0
    var actual_count: Double = 0
    val metrics = new DeequRunnerMetrics
    if (dataFrame.limit(1).count() == 0) {
      logger.logError(" There is no records in Dataframe for which DQ check is requested")
      return null
    }
    try {
      val dataFrameTmp = dataFrame.cache
      metrics.runnerStartTime = ChimeraUtils.currentGMTCalendar()
      metrics.getRulesStartTime = ChimeraUtils.currentGMTCalendar()

      val edlCheckResultSchema = StructType(Array(
        StructField("check", StringType, nullable = true),
        StructField("check_level", StringType, nullable = true),
        StructField("check_status", StringType, nullable = true),
        StructField("constraint", StringType, nullable = true),
        StructField("constraint_status", StringType, nullable = true),
        StructField("constraint_message", StringType, nullable = true),
        StructField("table_name", StringType, nullable = false),
        StructField("database_name", StringType, nullable = false),
        StructField("edi_business_day", StringType, nullable = false),
        StructField("src_sys_inst_id", StringType, nullable = false)))
      var edlCheckResultsDf = spark.createDataFrame(spark.sparkContext.emptyRDD[Row], edlCheckResultSchema)

      val checkResultsSchema = StructType(Array(
        StructField("dqCheck", StringType, nullable = true),
        StructField("checkLevel", StringType, nullable = true),
        StructField("checkStatus", StringType, nullable = true),
        StructField("dqConstraint ", StringType, nullable = true),
        StructField("constraintStatus", StringType, nullable = true),
        StructField("constraintMesg", StringType, nullable = true),
        StructField("batchId", StringType, nullable = false),
        StructField("processTypNm", StringType, nullable = false),
        StructField("tableNm", StringType, nullable = false),
        StructField("databaseNm", StringType, nullable = false),
        StructField("ruleCol", StringType, nullable = false),
        StructField("controlNn", StringType, nullable = false),
        StructField("ruleNm", StringType, nullable = false)))
      var checkResultsDf = spark.createDataFrame(spark.sparkContext.emptyRDD[Row], checkResultsSchema)

      val edlanalysisResultSchema = StructType(Array(
        StructField("entity", StringType, nullable = true),
        StructField("instance", StringType, nullable = true),
        StructField("name", StringType, nullable = true),
        StructField("value", DoubleType,nullable =  false),
        StructField("table_name", StringType,nullable =  false),
        StructField("database_name", StringType, nullable = false),
        StructField("edi_business_day", StringType,nullable =  false),
        StructField("src_sys_inst_id", StringType,nullable =  false)))
      var edlAnalysisResultDf = spark.createDataFrame(spark.sparkContext.emptyRDD[Row], edlanalysisResultSchema)

      val analysisResultSchema = StructType(Array(
        StructField("entityTyp", StringType, nullable = true),
        StructField("instance", StringType, nullable = true),
        StructField("ruleName", StringType, nullable = true),
        StructField("actualValue", DoubleType,nullable =  false),
        StructField("batchId", StringType, nullable = false),
        StructField("processTypNm", StringType, nullable = false),
        StructField("tableNm", StringType, nullable = false),
        StructField("databaseNm", StringType, nullable = false)))
      var analysisResultDf = spark.createDataFrame(spark.sparkContext.emptyRDD[Row], analysisResultSchema)

      val rulesDf = getDqRules(spark, databaseName, tableName, stageName.getOrElse(""))
      metrics.deequRules = rulesDf.count()
      metrics.getRulesEndTime = ChimeraUtils.currentGMTCalendar()
      if (metrics.deequRules == 0) {
        logger.logError(metrics.deequRules + "rules returned for table: %s "
          .format(tableName))
        return null
      } else {
        rulesDf.collect().foreach(row => {
          val ruleControlNm = row.getAs[String](fieldName = "controlNm")
          val ruleNm = row.getAs[String](fieldName = "ruleNm")
          val ruleColNm = row.getAs[String](fieldName = "ruleCol")
          logger.logInfo(s"Executing DQ Rule $ruleNm for $ruleColNm")

          val schema = rulesDf.schema
          val rowRdd = spark.sparkContext.parallelize(Seq(row))
          val rowDf = spark.createDataFrame(rowRdd, schema)
          metrics.executeRulesStartTime = ChimeraUtils.currentGMTCalendar()
          val result = DeequUtils.executeRulesNoRepo(rowDf, dataFrameTmp)
          metrics.executeRulesEndTime = ChimeraUtils.currentGMTCalendar()
          metrics.persistAnalysersStartTime = ChimeraUtils.currentGMTCalendar()

          val edlAnalysisResultTmp = VerificationResult.successMetricsAsDataFrame(spark, result)
            .withColumn("table_name", lit(tableName))
            .withColumn("database_name", lit(databaseName))
            .withColumn("edi_business_day", lit(businessDate))
            .withColumn("src_sys_inst_id", lit(instance))
          edlAnalysisResultDf = edlAnalysisResultDf.union(edlAnalysisResultTmp)

          val analysisResultDfTmp = VerificationResult.successMetricsAsDataFrame(spark, result)
            .withColumnRenamed("entity", "entityTyp")
            .withColumn("batchId", lit(batchId))
            .withColumn("processTypNm", lit(stageName.getOrElse("")))
            .withColumn("tableNm", lit(tableName))
            .withColumn("databaseNm", lit(databaseName))
            .withColumnRenamed("value", "actualValue")
            .withColumnRenamed("name", "ruleName")
          analysisResultDf = analysisResultDf.union(analysisResultDfTmp)

          val edlCheckResultsDfTmp = VerificationResult.checkResultsAsDataFrame(spark, result)
            .withColumnRenamed("entity", "entityTyp")
            .withColumn("table_name", lit(tableName))
            .withColumn("database_name", lit(databaseName))
            .withColumn("edi_business_day", lit(businessDate))
            .withColumn("src_sys_inst_id", lit(instance))
          edlCheckResultsDf = edlCheckResultsDf.union(edlCheckResultsDfTmp)

          val checkResultsDfTmp = VerificationResult.checkResultsAsDataFrame(spark, result)
            .withColumn("batchId", lit(batchId))
            .withColumn("processTypNm", lit(stageName.getOrElse("")))
            .withColumn("tableNm", lit(tableName))
            .withColumn("databaseNm", lit(databaseName))
            .withColumn("ruleCol", lit(ruleColNm))
            .withColumn("controlNm", lit(ruleControlNm))
            .withColumn("ruleNm", lit(ruleNm))
            .withColumnRenamed("constraint_status", "constraintStatus")
            .withColumnRenamed("constraint_message", "constraintMesg")
            .withColumnRenamed("check_status", "checkStatus")
            .withColumnRenamed("check_level", "checkLevel")
            .withColumnRenamed("check", "dqCheck")
            .withColumnRenamed("constraint", "dqConstraint")

          checkResultsDf = checkResultsDf.union(checkResultsDfTmp)
          logger.logInfo(s"DQ Rule $ruleNm for $ruleColNm Executes Successfully")
        })

        edlAnalysisResultDf.createOrReplaceTempView("dqAnalysisResults")
        analysisResultDf.show(false)
        EdlDqUserConfigLogRepository.addNewEdlDqUserConfigLogs(analysisResultDf)

        metrics.persistAnalysersEndTime = ChimeraUtils.currentGMTCalendar()
        logger.logInfo("Deequ analysis results Added in Tachyon")
        logger.logInfo("Writing deequ check results")
        metrics.persistChecksStartTime = ChimeraUtils.currentGMTCalendar()
        edlCheckResultsDf.createOrReplaceTempView("dqCheckResults")
        logger.logInfo("Temporary Deequ Check results created")

        logger.logInfo("Check results of created")
        checkResultsDf.show(false)
        EdlDataQualityLogRepository.addNewEdlDataQualityLogs(checkResultsDf)
        logger.logInfo("check results Dataframe added to DataQualityLogs")
        metrics.persistChecksEndTime = ChimeraUtils.currentGMTCalendar()
        metrics.runnerEndTime = ChimeraUtils.currentGMTCalendar()


        metrics.deequErrors = checkResultsDf
          .where("checkLevel = 'Error' and constraintStatus = 'Failure'")
          .count()

        metrics.deequWarnings = checkResultsDf
          .where("checkLevel = 'Warning' and constraintStatus = 'Success'")
          .count()

        metrics.deequPasses = checkResultsDf.where("constraintStatus = 'Success'")
          .count()

        logger.logInfo("deequErrors, deequWarnings, deeqPasses :: +" +
          s"${metrics.deequErrors}, ${metrics.deequWarnings}, ${metrics.deequPasses}")

        val uniqueness_df_count = analysisResultDf.where("ruleName = 'Uniqueness'").limit(1).count()
        logger.logInfo(s"uniqueness_df_count is $uniqueness_df_count")
        val size_df_count = analysisResultDf.where("ruleName = 'Size'").limit(1).count()
        logger.logInfo(s"size_df_count is $size_df_count")
        val completeness_df_count = analysisResultDf.where("ruleName = 'Completeness'").limit(1).count()
        logger.logInfo(s"completeness_df_count is $completeness_df_count")
        var raw_dup_count = ""
        var raw_count = ""
        var raw_blank = ""
        if (uniqueness_df_count > 0) {
          raw_dup_count = analysisResultDf.where("ruleName = 'Uniqueness'")
            .select("actua;Value").first().mkString("")
          logger.logInfo("raw_dup_count :: " + raw_dup_count)
        }

        if (size_df_count > 0) {
          raw_count = analysisResultDf.where("ruleName = 'Size'")
            .select("actua;Value").first().mkString("")
          logger.logInfo("raw_count :: " + raw_count)
        }

        if (completeness_df_count > 0) {
          raw_blank = analysisResultDf.where("ruleName = 'Completeness'")
            .select("actua;Value").first().mkString("")
          logger.logInfo("raw_blank :: " + raw_blank)
        }

        if (raw_count.nonEmpty) {
          actual_count = raw_count.toDouble
          logger.logInfo("actual_count :: " + actual_count.toString)
        }

        if (raw_dup_count.nonEmpty && actual_count != 0) {
          sourceRecordDuplicateCount = actual_count - (actual_count * raw_dup_count.toDouble)
          logger.logInfo("sourceDuplicateCount :: " + sourceRecordDuplicateCount.toString)
        }

        if (raw_blank.nonEmpty && actual_count != 0) {
          blank_row = actual_count - (actual_count * raw_blank.toDouble)
          logger.logInfo("blank_row :: " + blank_row.toString)
        }

        if (metrics.deequWarnings > 0) {
          logger.logWarning("Dq processing has generated %s warnings".format(metrics.deequWarnings))
        }

        if (metrics.deequErrors > 0) {
          logger.logError("Dq processing has generated %s errors".format(metrics.deequErrors))
          throw new ChimeraException("EDLDataQualityException.DEEQU_FAILURE",
            scala.collection.immutable.Map("exception" ->
              "Dq Processing has generated %s errors".format(metrics.deequErrors)).asJava,null)
        }
        metrics.processStatus = DeequRunnerProcessStatus.Success
      }
      logger.logInfo(s"execute function completed")

    }
    catch {
      case e: ChimeraException =>
        logger.logError(s"An unexpected error has occurred - $e")
        metrics.processStatus = DeequRunnerProcessStatus.Error
        throw new ChimeraException("EDLDataQualityException.DEEQU_FAILURE",
          scala.collection.immutable.Map("exception" ->
            "Dq Processing has generated %s errors".format(metrics.deequErrors)).asJava,e)
    }

    val metricsDf = metrics.toDf(spark).withColumn("job_id", lit(batchId))
      .withColumn("audit_time", lit(audit_time))
      .withColumn("table_name", lit(tableName))
      .withColumn("database_name", lit(databaseName))
      .withColumn("instance", lit(instance))
      .withColumn("business_date", lit(businessDate))
      .withColumn("pipeline_name", lit(pipelineName))
      .withColumn("client_name", lit("CHIMERA"))
      .withColumn("process_type_name", lit(stageName.getOrElse("")))
      .withColumn("source_count", lit(actual_count.toLong))
      .withColumn("target_count", lit(actual_count.toLong))
      .withColumn("blank_row", lit(blank_row.toLong))
      .withColumn("source_duplicate_count", lit(sourceRecordDuplicateCount))
      .withColumn("id", lit(null).cast("long"))
      .withColumn("pipeline_version", lit(pipelineVersion))

    metricsDf.createOrReplaceTempView("dqMetrics")
    metricsDf.show(false)
    logger.logInfo("DQ Full Metrics results")
    metrics
  }
}


