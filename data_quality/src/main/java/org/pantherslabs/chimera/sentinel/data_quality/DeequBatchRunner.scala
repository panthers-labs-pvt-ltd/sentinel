package org.pantherslabs.chimera.sentinel.data_quality

import com.amazon.deequ.VerificationSuite
import com.amazon.deequ.VerificationResult
import com.amazon.deequ.checks.{Check, CheckLevel}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

object DeequBatchRunner {

  def runDQRulesBatch(
                       spark: SparkSession,
                       rulesDf: DataFrame,
                       targetDf: DataFrame
                     ): (DataFrame, DataFrame) = {

    import spark.implicits._

    val rules = rulesDf.collect()

    val checks: Seq[Check] = rules
      .groupBy(row => row.getAs[String]("checkLevel"))
      .flatMap {
        case (level, ruleRows) =>
          val checkLevel = level match {
            case "Error"   => CheckLevel.Error
            case "Warning" => CheckLevel.Warning
            case _         => throw new IllegalArgumentException(s"Unknown level: $level")
          }

          val check = Check(checkLevel, s"${level}_check")
          val finalCheck = ruleRows.foldLeft(check) { (acc, row) =>
            val ruleType = row.getAs[String]("ruleType")
            val column = row.getAs[String]("ruleColumn")
            val ruleName = row.getAs[String]("ruleName")

            ruleType match {
              case "isComplete"     => acc.isComplete(column)
              case "isUnique"       => acc.isUnique(column)
              case "hasSize"        => acc.hasSize(_ > 0)
              case "hasMinLength"   => acc.hasMinLength(column, _ >= 1)
              case "hasMaxLength"   => acc.hasMaxLength(column, _ <= 20)
              // Add more rule types as needed
              case unknown =>
                println(s"[WARN] Unknown rule type: $unknown")
                acc
            }
          }

          Some(finalCheck)
      }.toSeq

    if (checks.isEmpty) {
      throw new IllegalArgumentException("No valid checks generated from rules")
    }

    val result = VerificationSuite()
      .onData(targetDf)
      .addChecks(checks)
      .run()

    val metricsDf = VerificationResult.successMetricsAsDataFrame(spark, result)
    val checkResultsDf = VerificationResult.checkResultsAsDataFrame(spark, result)

    (metricsDf, checkResultsDf)
  }
}
