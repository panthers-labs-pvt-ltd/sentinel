package org.pantherslabs.chimera.sentinel.data_quality

import com.amazon.deequ.VerificationResult
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

object DeequDebugHelper {

  def showFailingRows(df: DataFrame, verificationResult: VerificationResult)(implicit spark: SparkSession): Unit = {
    import spark.implicits._

    val resultDf = VerificationResult.checkResultsAsDataFrame(spark, verificationResult)

    resultDf.filter($"constraint_status" === "Failure").collect().foreach { row =>
      val constraint = row.getAs[String]("constraint")
      val messageOpt = Option(row.getAs[String]("message"))

      println(s"Failed constraint: $constraint")
      println(s"Message: ${messageOpt.getOrElse("No message")}")

      // Try to extract column name from the constraint string
      val colPattern = """\[(.*?)\]""".r
      val columnNameOpt = colPattern.findFirstMatchIn(constraint).map(_.group(1))

      columnNameOpt match {
        case Some(column) =>
          // Basic heuristics: match common constraint types and apply filters
          if (constraint.contains("Completeness")) {
            println(s"Rows with null or empty values in '$column':")
            df.filter(col(column).isNull || col(column) === "").show(false)

          } else if (constraint.contains("Uniqueness")) {
            println(s"Rows with duplicate values in '$column':")
            df.groupBy(column).count().filter($"count" > 1).join(df, Seq(column)).show(false)

          } else if (constraint.contains("Minimum")) {
            println(s"Rows with unusually low values in '$column':")
            // You can get actual min value from metrics if available
            df.orderBy(col(column).asc).show(10, truncate = false)

          } else if (constraint.contains("Maximum")) {
            println(s"Rows with unusually high values in '$column':")
            df.orderBy(col(column).desc).show(10, truncate = false)

          } else {
            println(s"Could not identify specific filter for constraint type: $constraint")
          }

        case None =>
          println("Could not extract column name from constraint.")
      }

      println("----------------------------------------------------------")
    }
  }
}
