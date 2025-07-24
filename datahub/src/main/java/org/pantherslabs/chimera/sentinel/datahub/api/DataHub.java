package org.pantherslabs.chimera.sentinel.datahub.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.pantherslabs.chimera.sentinel.datahub.api")
@MapperScan("org.pantherslabs.chimera.sentinel.datahub.api.mapper.generated")
@MapperScan("org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.mapper")
public class DataHub {
    public static void main(String[] args) {
        SpringApplication.run(DataHub.class, args);
    }
}
