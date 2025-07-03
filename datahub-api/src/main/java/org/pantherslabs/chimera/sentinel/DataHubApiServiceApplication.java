package org.pantherslabs.chimera.sentinel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.pantherslabs.chimera.sentinel")
@MapperScan("org.pantherslabs.chimera.sentinel.mapper.generated")
public class DataHubApiServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(DataHubApiServiceApplication.class, args);
  }
}
