package org.pantherslabs.chimera.sentinel.data_quality

import junit.framework.TestCase
import org.apache.spark.sql.DataFrame
import org.junit.Test
import org.pantherslabs.chimera.sentinel.data_quality.DataQualityRunner.{execute, loggerTag}
import org.pantherslabs.chimera.unisca.execution_engine.OptimizedSparkSession

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DataQualityRunnerTest {

  @Test
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
    val timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))
    val batch_id = f"${DatabaseName}_${TableName}_${timestamp}"
    var curr_date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
    spark.sql(f"SELECT * FROM $DatabaseName.$TableName").show(10)
/*    execute(batch_id, goods_classification_df, DatabaseName, TableName,
      curr_date)*/

  }
}