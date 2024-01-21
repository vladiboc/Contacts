package org.example.bean.io;

import org.example.data.Contact;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

@Component
public class ContactEmptyList implements ContactInitializer {

  @Override
  public Map<String, Contact> init() {
    return new TreeMap<>();
  }

}