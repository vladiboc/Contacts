package org.example.bean;

import org.example.data.Contact;
import org.example.exception.ContactInputOutputException;
import org.example.exception.WrongContactStringException;
import org.example.util.Checkers;
import org.example.util.ErrorStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component
public class ContactInputOutput implements ContactInitializer {

  @Value("${contacts.file.save}")
  private String savePath;
  private final ContactParser contactParser;

  @Autowired
  public ContactInputOutput(ContactParser contactParser) {
    this.contactParser = contactParser;
  }

  public Map<String, Contact> init() {
    return new TreeMap<>();
  }

  public void save(Map<String, Contact> contacts) throws ContactInputOutputException {
    List<String> contactsList = new ArrayList<>();
    for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
      contactsList.add(entry.getValue().toFileString());
    }
    try {
      Files.write(Path.of(this.savePath), contactsList);
    } catch (IOException e) {
      throw new ContactInputOutputException(ErrorStrings.SAVE_FILE_ERROR + e);
    }
  }

  public Contact parseContactFromInput(String input) throws WrongContactStringException {
    return contactParser.parseContactString(input, Contact.FIELD_SEPARATOR_FOR_INPUT);
  }

}