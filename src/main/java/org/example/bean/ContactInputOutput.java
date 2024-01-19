package org.example.bean;

import org.example.data.Contact;
import org.example.exception.ContactInputOutputException;
import org.example.exception.WrongContactStringException;
import org.example.util.ErrorStrings;
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
public class ContactInputOutput {
  @Value("${contacts.file.load}")
  private String loadPath;
  @Value("${contacts.file.max-load-size}")
  private int maxLoadSize;
  @Value("${contacts.file.save}")
  private String savePath;

  public Map<String, Contact> load() throws ContactInputOutputException {
    Map<String, Contact> contactsMap = new TreeMap<>();
    try {
      if (this.maxLoadSize < Files.size(Path.of(this.loadPath))) {
        throw new ContactInputOutputException(ErrorStrings.FILE_TOO_BIG);
      }
      List<String> contactsList = Files.readAllLines(Path.of(this.loadPath));
      for (int i = 0; i < contactsList.size(); i++) {
        Contact contact = this.parseContactString(i, contactsList.get(i));
        contactsMap.put(contact.emailAddress(), contact);
      }
    } catch (IOException | WrongContactStringException e) {
      throw new ContactInputOutputException(ErrorStrings.LOAD_FILE_ERROR + e);
    }
    return contactsMap;
  }

  public void save(Map<String, Contact> contacts) throws ContactInputOutputException {
    List<String> contactsList = new ArrayList<>();
    for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
      contactsList.add(entry.getValue().toString());
    }
    try {
      Files.write(Path.of(this.savePath), contactsList);
    } catch (IOException e) {
      throw new ContactInputOutputException(ErrorStrings.SAVE_FILE_ERROR + e);
    }
  }

  private Contact parseContactString(int lineNumber, String contactString) throws WrongContactStringException {

    return new Contact("", "", "");
  }

}