package org.pantherslabs.chimera.sentinel.data_quality
import scala.reflect.runtime.universe
import scala.tools.reflect.ToolBox
import scala.collection.JavaConverters._
import org.apache.spark.sql.functions.{col, current_timestamp, lit, regexp_extract}
import com.amazon.deequ.{VerificationResult, VerificationSuite}
import com.amazon.deequ.checks.Check
import com.fasterxml.jackson.core.`type`.TypeReference
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.pantherslabs.chimera.unisca.exception.ChimeraException
import org.pantherslabs.chimera.unisca.utilities.ChimeraUtils
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.consumer.ApiConsumer
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ErrorResponse
import org.pantherslabs.chimera.sentinel.data_quality.entities.DeequRunnerMetrics
import org.pantherslabs.chimera.unisca.logging.{ChimeraLogger, ChimeraLoggerFactory}
import org.pantherslabs.chimera.unisca.execution_engine.OptimizedSparkSession
import org.pantherslabs.chimera.sentinel.data_quality.api.model.generated.{DataControlsLog, DataQualityVw}

object DataQualityRunner {
  private val filterApiUrl = "http://localhost:9001/api/data-quality/filter"
  private val logApiUrl = "http://localhost:9001/api/data-controls/addDQLog"
  private val logger: ChimeraLogger = ChimeraLoggerFactory.getLogger(this.getClass)
  private val loggerTag = "DataQualityRunner"
  private val consumer = new ApiConsumer

  private def getDataQualityRules(sparkSession: SparkSession, databaseName: String, tableName: String,
                                  dataQualityType: String = "CoarseDQService"): DataFrame = {
    logger.logInfo(s"Fetching Data Quality Rules for $databaseName.$tableName")
    var filter: String = ""
    var rules_df = sparkSession.emptyDataFrame
    filter =
      s"""{
                  "table": "sentinel.data_quality_vw",
                  "filters": [
                    { "field": "database_name", "operator": "=", "value": ["$databaseName"] },
                    { "field": "table_name", "operator": "=", "value": ["$tableName"] },
                    { "field": "process_name", "operator": "=", "value": ["$dataQualityType"] }
                  ]
                }"""
    val response = consumer.post(filterApiUrl, filter, new TypeReference[java.util.List[DataQualityVw]]() {}, new TypeReference[ErrorResponse]() {})
    if (response.isSuccess) {
      rules_df = sparkSession.createDataFrame(response.getSuccessBody, classOf[DataQualityVw])
    }
    else {
      val error = response.getFailureBody
      logger.logError(s"Error Code : ${error.getErrorCode}")
      logger.logError(s"Error Type : ${error.getErrorType}")
      logger.logError(s"Message : ${error.getErrorMessage}")
      logger.logError(s"Request URI : ${error.getErrorRequestURI}")
      logger.logError(s"Timestamp : ${error.getErrorTimestamp}")
      throw new ChimeraException(error.toString, "DataQualityException.DEEQU_FAILURE",
        scala.collection.immutable.Map("exception" -> "Dq processing has generated %s errors").asJava)
    }
    rules_df.show()
    rules_df
  }

  def execute(inBatchId: String, inDataFrame: DataFrame, inDatabaseName: String, inTableName: String,
              inBusinessDate: String): Unit = {
    val spark: OptimizedSparkSession = OptimizedSparkSession.get(loggerTag, "test")

    executeDataQualityRules(spark, inBatchId, inDataFrame, inDatabaseName, inTableName, inBusinessDate)
  }

  private def extractMeta(colName: String, key: String) =
    regexp_extract(col(colName), s"(?<=\\b$key=)[^|]+", 0).cast("long")

  private def executeDataQualityRules(spark: SparkSession, batchId: String, dataFrame: DataFrame,
                                      databaseName: String, tableName: String, businessDate: String): Unit = {
    val audit_time = ChimeraUtils.convertTimeFormat("yyyy-MM-dd HH:mm::ss.SSS", ChimeraUtils.currentGMTCalendar())
    val metrics = new DeequRunnerMetrics
    if (dataFrame.limit(1).count() == 0) {
      logger.logError(" There is no records in Dataframe for which DQ check is requested")
      return
    }
    try {
      val dataFrameTmp = dataFrame.cache
      metrics.runnerStartTime = ChimeraUtils.currentGMTCalendar()
      metrics.getRulesStartTime = ChimeraUtils.currentGMTCalendar()

      val rulesDf = getDataQualityRules(spark, databaseName, tableName)
      metrics.deequRules = rulesDf.count()
      metrics.getRulesEndTime = ChimeraUtils.currentGMTCalendar()
      if (metrics.deequRules == 0) {
        logger.logError(metrics.deequRules + "rules returned for table: %s "
          .format(tableName))
      } else {
         val rules = rulesDf.collect()
          val checks = rules.map { row =>
          val ruleValue = row.getAs[String]("ruleValue")
          val checkLevel = row.getAs[String]("checkLevel")
          val rownum = row.getAs[Long]("rownum")
          val checkMetadata = s"rownum=$rownum"

          val checkCode =
            s"""
               |import com.amazon.deequ.checks._
               |Check(CheckLevel.$checkLevel, "$checkMetadata").$ruleValue
               |""".stripMargin

          val mirror = universe.runtimeMirror(getClass.getClassLoader)
          val toolbox = mirror.mkToolBox()
          toolbox.eval(toolbox.parse(checkCode)).asInstanceOf[Check]
        }

        val verificationResult = VerificationSuite()
          .onData(dataFrameTmp)
          .addChecks(checks)
          .run()

        val checkDf = VerificationResult.checkResultsAsDataFrame(spark, verificationResult)
          .withColumn("rownum", extractMeta("check", "rownum"))
        val executionTs = current_timestamp()
        val enrichedCheckDf = checkDf.join(rulesDf, Seq("rownum"), "left").select(
          lit(batchId).as("batchId"),
          col("controlName").as("controlType"),
          col("dimensionName").as("controlDimension"),
          col("processName").as("processType"),
          col("databaseName"),
          col("schemaName"),
          col("tableName"),
          col("partitionKeys") ,
          lit(businessDate).cast("date").as("businessDate"),
          col("ruleColumn"),
          col("ruleName"),
          col("ruleValue"),
          col("checkLevel"),
          col("constraint").as("constraintDesc"),
          col("constraint_message").as("constraintMsg"),
          col("constraint_status").as("status"),
          executionTs.as("executionTs")
        )
        enrichedCheckDf.show(false)
        val jsonStrings: Array[String] = enrichedCheckDf.toJSON.collect()
        val fullJson = "[" + jsonStrings.mkString(",") + "]"
        println(fullJson)
        val response = consumer.post(logApiUrl, fullJson)
        println(response)
        /*
        //val response = consumer.post(logApiUrl, fullJson, new TypeReference[java.util.List[DataControlsLog]]() {}, new TypeReference[ErrorResponse]() {})
        if (response.isSuccess) {
          logger.logInfo(response.getSuccessBody.toString)
        }
        else {
          val error = response.getFailureBody
          logger.logError(s"Error Code : ${error.getErrorCode}")
          logger.logError(s"Error Type : ${error.getErrorType}")
          logger.logError(s"Message : ${error.getErrorMessage}")
          logger.logError(s"Request URI : ${error.getErrorRequestURI}")
          logger.logError(s"Timestamp : ${error.getErrorTimestamp}")
          throw new ChimeraException(error.toString, "DataQualityException.DEEQU_FAILURE",
            scala.collection.immutable.Map("exception" -> "Dq processing has generated %s errors").asJava)
        }*/

      }
    }
  }
}
