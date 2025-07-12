package org.pantherslabs.chimera.sentinel.data_quality;

import org.junit.Test;
import org.pantherslabs.chimera.sentinel.data_quality.DataQualityRunner;
import org.pantherslabs.chimera.unisca.execution_engine.OptimizedSparkSession;

import java.io.IOException;

public class SparkSessionTest {

    @Test
    public void GetControl()  {
        OptimizedSparkSession spark = OptimizedSparkSession.get("DataQuality","test");
        String isHiveEnabled = spark.conf().get("spark.sql.catalogImplementation");
        System.out.println(isHiveEnabled);
    }

    @Test
    public void Test() throws IOException, InterruptedException {

     //   DataQualityRunner dq =new  DataQualityRunner();
    //        dq.execute("chimera_db","demo_table");
    }
}
