package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@ComponentScan({"org.example.config", "org.example.bean"})
@Configuration
@PropertySource("classpath:contacts.properties")
public class DefaultAppConfig {
}