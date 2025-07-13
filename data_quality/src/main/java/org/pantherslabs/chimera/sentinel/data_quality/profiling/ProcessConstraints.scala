package org.pantherslabs.chimera.sentinel.data_quality.profiling

import org.apache.spark.sql.functions.{col, expr, lit}
import org.apache.spark.sql.types.{LongType, StringType, StructField, StructType}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.pantherslabs.chimera.unisca.logging.{ChimeraLogger, ChimeraLoggerFactory}

object ProcessConstraints {
  private val edlLogger: ChimeraLogger = ChimeraLoggerFactory.getLogger(this.getClass)

  def getConstraints(spark: SparkSession, tableName: String): DataFrame = {
    // TODO check how we can do IN caluse
    // val scolaMap Mop (tableName" -> sql Text)
    // val constraints_df = OqConstrointSuggestionRepository ListDqConstraintSuggestionByColumn
    try {
      print("Add Logic to add Suggestion Repo")
      spark.emptyDataFrame
      /*val constraints_df = EdlDqSuggestionsRepository.listEdlDqSuggestionsByColumn(
        spark, "sql_Text", tableName)
      constraints_df.show()
      constraints_df*/
    }
    catch {
      case e: Exception => edlLogger.logError("ProcessConstraints" + e.toString)
        throw e
    }
  }

  def processConstraintsIntoRules(spark: SparkSession, suggestionsDf: DataFrame, ids: Seq[String],
                                  constraints: Seq[String]): DataFrame = {
    val schema = StructType(Array(
      StructField("databaseName", StringType, true),
      StructField("dqConstraint", StringType, true),
      StructField("id", LongType, true),
      StructField("processNm", StringType, true),
      StructField("ruleColumn", StringType, true),
      StructField("scalaCode", StringType, true),
      StructField("sql_Text", StringType, true)
    ))
    var idsDf = spark.createDataFrame(spark.sparkContext.emptyRDD[Row], schema)
    var constraintsDf = spark.createDataFrame(spark.sparkContext.emptyRDD[Row], schema)

    if (!ids.isEmpty) {
      for (id <- ids) {
        idsDf = idsDf.union(suggestionsDf.filter(col("id").contains(id)))
        idsDf.show()
      }
    }

    if (!constraints.isEmpty) {
      for (constraint <- constraints) {
        constraintsDf = constraintsDf.union(suggestionsDf.filter(col("scalaCode").
          startsWith("." + constraint.toString())))
      }
    }
    val rulesDf = idsDf.union(constraintsDf)
    rulesDf.show()

    rulesDf
  }

  def persistRules(df: DataFrame): Unit = {
    print("Add Logic to Add DQ Rule")
    // EdlDqRulesRepository.addNewEdlDqRules(df)
  }

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .master("local")
      .appName("DeequRunner Test example")
      .getOrCreate()
    val params = collection.mutable.Map[String, String]()

    for (arg <- args) {
      val Array(key, value) = arg.split("=")
      params += (key -> value)
    }

    val regexp = "\\s+"

    if (params.contains("table")) {
      val table = params("table")
      val df = getConstraints(spark, table)
      val constraints = params("constraints").split(",").toSeq
      val ids = params("ids").split(",").toSeq
      val rulesDf = ProcessConstraints.processConstraintsIntoRules(spark, df, ids, constraints)
        .drop(colName = "dqConstraint")
        .drop(colName = "id")

      val formattedDf = rulesDf.withColumn("scalaCode",
          expr("substring(scalaCode, 2, length(scalaCode))"))
        .withColumn("checkLevel", lit("Warning"))
        .withColumn("statusCd", lit("N"))
        .withColumn("controlNm", lit("Default"))
        .withColumn("ruleId", lit(null).cast("long"))

      val processedRulesDF = formattedDf.withColumnRenamed("scalaCode", "ruleValue")
      processedRulesDF.show()
      persistRules(processedRulesDF)
    }
  }
}

