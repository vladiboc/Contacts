package org.example;

import org.example.config.AppConfig;
import org.example.bean.AppManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    AppManager appManager = context.getBean(AppManager.class);
    appManager.doWork();
  }

}