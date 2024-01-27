package org.example.config;

import org.example.bean.io.ContactFileLoader;
import org.example.bean.io.ContactLoader;
import org.example.bean.io.ContactParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:contacts-init.properties")
//@PropertySource("file:contacts-init.properties")
@Profile("init")
public class InitAppConfig {
  private final ContactParser contactParser;

  @Autowired
  public InitAppConfig(ContactParser contactParser) {
    this.contactParser = contactParser;
  }

  @Bean
  @Primary
  public ContactLoader contactLoader() {
    return new ContactFileLoader(this.contactParser);
  }

}