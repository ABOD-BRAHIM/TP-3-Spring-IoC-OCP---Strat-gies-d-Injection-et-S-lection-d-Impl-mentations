package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.example.dao", "com.example.metier"})
@PropertySource("classpath:app.properties")
@Import(DynamicDaoConfig.class)
public class AppConfig {

}
