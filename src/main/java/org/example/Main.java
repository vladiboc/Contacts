package org.example;

import org.example.config.DefaultAppConfig;
import org.example.bean.manager.AppManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(DefaultAppConfig.class);
    AppManager appManager = context.getBean(AppManager.class);
    appManager.doWork();
  }

}