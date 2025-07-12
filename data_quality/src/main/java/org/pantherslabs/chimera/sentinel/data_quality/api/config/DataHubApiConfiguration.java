package org.pantherslabs.chimera.sentinel.data_quality.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class DataHubApiConfiguration {
  /*  @Bean
  public ManagePipeline managePipeline(ManagePipeline managePipeline){
     return new ManagePipeline();
  }*/
/*
  @Bean
  public HttpMessageConverter<Object> yamlHttpMessageConverter() {
    return new AbstractJackson2HttpMessageConverter(
            new YAMLMapper(),
            MediaType.valueOf("application/x-yaml")
    ) {};
  }

  @Bean
  public ObjectMapper yamlObjectMapper() {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    mapper.findAndRegisterModules();
    return mapper;
  }*/

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                    .anyRequest().permitAll()
            );
    return http.build();
  }
}
