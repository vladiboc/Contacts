package org.example.bean;

import org.example.data.Contact;

import java.util.Map;

public interface ContactInitializer {

  Map<String, Contact> init();
}
