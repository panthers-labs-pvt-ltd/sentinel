package org.pantherslabs.chimera.sentinel.data_quality.dimensions

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions.col
import org.apache.spark.sql.types.StructType
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale


class DataAccuracyControl() extends DataControls {
  final private val edlLogger = new ChimeraLogger()
  val errorStr: StringBuffer = new StringBuffer()
  private var sourceDf: DataFrame = _
  private var targetDf: DataFrame = _
  private var partitionColumn: String = _
  private var processTypeName: String = _
  private var batchPipelineDetails: PipelineDetails = _
  private var checkLevel: String = _
  private var schemaCheck: Boolean = true

  override def apply(sparkSession: SparkSession, sourceDF: DataFrame, targetDf: DataFrame,
                     processTypeName: String, instanceId: String, partitionColumn: String,
                     databaseName: String, tableName: String, checkLevel: String, inboundSchema: StructType,
                     batchPipelineDetails: PipelineDetails): Unit = {
    this.sourceDf = sourceDF
    this.targetDf = targetDf
    this.partitionColumn = partitionColumn
    this.processTypeName = processTypeName
    this.batchPipelineDetails = batchPipelineDetails
    this.checkLevel = checkLevel
  }

  override def validate(): Boolean = {
    val loggerTag = "validate"
    edlLogger.logInfo( "Started")
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val startTime = LocalDateTime.now().format(formatter)
    val result = compareDf(sourceDf, targetDf)
    val endTime = LocalDateTime.now().format(formatter)
    var resultMessage: String = ""
    if (result) {
      resultMessage = s"Data Accuracy Control Completed Successfully"
    }
    else {
      resultMessage = s"Data Accuracy Control has failed. " + errorStr
    }
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    val controlResult: EdlDataControlsLog = new EdlDataControlsLog(batchPipelineDetails.getBatchId,
      processTypeName, "Accuracy", format.parse(startTime), format.parse(endTime),
      resultMessage,
      if (result) EdlDataControlsLog.SUCCESS
      else EdlDataControlsLog.FAILED
    )
    super.registerResult(controlResult)

    if (schemaCheck == false) {
      resultMessage += " For Schema Check"
      throw new EDLException(errorClass = "EDLDataQualityException.DATA_ACCURACY_EXCEPTION",
        messageParameters = Map("exception" -> resultMessage), cause = null)
    }
    edlLogger.logInfo( "Completed")
    true
  }

  def compareDf(sourceDf: DataFrame, targetDf: DataFrame): Boolean = {
    var result: Boolean = false
    var loggerTag = "compareDF"
    val partitions = partitionColumn.toLowerCase(Locale.ROOT).split(",").map(_.trim)
    val sourceLimitDf = sourceDf.limit(1000)
    val targetLimitDf = targetDf.limit(1000)

    val sourceLowerColumns = sourceLimitDf.columns.map(_.toLowerCase(Locale.ROOT))
    val targetLowerColumns = targetLimitDf.columns.map(_.toLowerCase(Locale.ROOT))

    val sourceRenameDf = sourceLimitDf.toDF(sourceLowerColumns: _*)
    val targetRenameDf = targetLimitDf.toDF(targetLowerColumns: _*)

    val sourceNonPartitionedColumns = sourceRenameDf.columns.filter(col => !partitions.contains(col))
    val targetNonPartitionedColumns = targetRenameDf.columns.filter(col => !partitions.contains(col))

    val sourceNewDf = sourceRenameDf.select(sourceNonPartitionedColumns.head, sourceNonPartitionedColumns.tail: _*)
    val targetNewDf = targetRenameDf.select(targetNonPartitionedColumns.head, targetNonPartitionedColumns.tail: _*)

    val sourceSchema = sourceNewDf.schema
    val targetSchema = targetNewDf.schema
    val isCompatible = compareSchemas(sourceSchema, targetSchema)
    edlLogger.logInfo( "Schema Matched :: " + isCompatible)

    if (sourceSchema.equals(targetSchema)) {
      val diffDF = compareDataFrameInChunks(sourceNewDf, targetNewDf)
      val compareCount = diffDF.count()
      if (compareCount == 0) {
        result = true
      } else {
        edlLogger.logInfo( s"DataFrame has mismatched input from source" +
          s" to Target: " + diffDF.show(false))
        errorStr.append(s"Data level comparison between 1000 records is not matching. Number of mismatch from source " +
          s" to target for sample 1000 record is : "
          + compareCount)
      }
    } else {
      errorStr.append(s"Schema between Source Dataframe and target DataFrame is not matching")
      edlLogger.logInfo( "Source_Schema " + sourceSchema)
      edlLogger.logInfo( "Target_Schema " + targetSchema)
      result = false
      schemaCheck = false
    }
    result
  }

  def compareDataFrameInChunks(df1: DataFrame, df2: DataFrame): DataFrame = {
    val loggerTag = "CompareDataFrameInChunks"
    val chunkSize = 500
    edlLogger.logInfo( "DataFrames comaprison in chunks for Accuracy Check")
    val columnChunks = df1.columns.grouped(chunkSize).toList
    var diffDF: DataFrame = null

    for (chunk <- columnChunks) {
      val selectedColumns = chunk.map(col)
      val df1Chunk = df1.select(selectedColumns: _*)
      val df2Chunk = df2.select(selectedColumns: _*)

      val chunkDiffDf = df1Chunk.except(df2Chunk)

      if (diffDF == null) {
        diffDF = chunkDiffDf
      } else {
        val commonColumns = diffDF.columns.toSet.intersect(chunkDiffDf.columns.toSet).toSeq
        val commonDiffDF = diffDF.select(commonColumns.map(col): _*)
        val commonChunkDiffDF = chunkDiffDf.select(commonColumns.map(col): _*)
        diffDF = commonDiffDF.union(commonChunkDiffDF)
      }
    }
    if (diffDF == null) {
      df1.sqlContext.emptyDataFrame
    } else {
      diffDF
    }
  }

  def compareSchemas(sourceSchema: StructType, targetSchema: StructType): Boolean = {

    val targetSchemaMap = targetSchema.map(f => f.name -> f).toMap

    sourceSchema.forall { sourceField =>
      targetSchemaMap.get(sourceField.name) match {
        case Some(targetField) =>
          sourceField.dataType == targetField.dataType && (!sourceField.nullable || targetField.nullable)
        case None =>
          false
      }
    }
  }

}
