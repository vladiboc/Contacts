package org.example.config;

import org.example.bean.io.ContactFileLoader;
import org.example.bean.io.ContactInitializer;
import org.example.bean.io.ContactParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:contacts-init.properties")
@Profile("init")
public class InitAppConfig {
  private final ContactParser contactParser;

  @Autowired
  public InitAppConfig(ContactParser contactParser) {
    this.contactParser = contactParser;
  }

  @Bean
  @Primary
  public ContactInitializer contactInitializer() {
    return new ContactFileLoader(this.contactParser);
  }

}