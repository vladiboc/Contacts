package org.example.bean.io;

import org.example.data.Contact;

import java.util.Map;

public interface ContactLoader {

  Map<String, Contact> load();
}
