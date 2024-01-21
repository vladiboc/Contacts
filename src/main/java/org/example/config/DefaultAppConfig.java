package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@ComponentScan("org.example.bean")
@Configuration
@PropertySource("classpath:contacts.properties")
@Profile("default")
public class DefaultAppConfig {
}