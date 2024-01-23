package org.example.bean.io;

import org.example.data.Contact;
import org.example.util.InfoStrings;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.TreeMap;

@Component
public class ContactEmptyLoader implements ContactLoader {

  @Override
  public Map<String, Contact> load() {
    return new TreeMap<>();
  }

}