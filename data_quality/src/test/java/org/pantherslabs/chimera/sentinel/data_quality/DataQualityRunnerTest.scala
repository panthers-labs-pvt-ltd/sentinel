package org.pantherslabs.chimera.sentinel.data_quality

import junit.framework.TestCase
import org.apache.spark.sql.DataFrame
import org.pantherslabs.chimera.sentinel.data_quality.DataQualityRunner.{execute, loggerTag}
import org.pantherslabs.chimera.unisca.execution_engine.OptimizedSparkSession

class DataQualityRunnerTest extends TestCase {
  def testGetDqRules(): Unit = {
    val spark: OptimizedSparkSession = OptimizedSparkSession.get("DataQualityRunnerTest", "test")
    val DatabaseName= "data_management";
    val TableName= "goods_classification";

    val resource = getClass.getResource("/goods_classification.csv").getPath
    val goods_classification_df : DataFrame = spark.read.option("header", "true")
      .option("inferSchema", "true").csv(resource)
    goods_classification_df.createOrReplaceTempView("sample_table")
    spark.sql(f"create database if not exists $DatabaseName")
    spark.sql(f"CREATE TABLE IF NOT EXISTS $DatabaseName.$TableName AS SELECT * FROM sample_table")

    execute("inBatchId", goods_classification_df, DatabaseName, TableName,
      "2025-12-31", null, "inPipelineName","CoarseDQService")

  }
}