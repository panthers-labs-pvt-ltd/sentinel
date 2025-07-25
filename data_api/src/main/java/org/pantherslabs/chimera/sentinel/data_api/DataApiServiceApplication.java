package org.pantherslabs.chimera.sentinel.data_api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.pantherslabs.chimera.sentinel.data_api")
@MapperScan("org.pantherslabs.chimera.sentinel.data_api.mapper.generated")
@MapperScan("org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.mapper")
public class DataApiServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(DataApiServiceApplication.class, args);
  }
}
