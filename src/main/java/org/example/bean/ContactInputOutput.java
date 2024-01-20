package org.example.bean;

import org.example.data.Contact;
import org.example.exception.ContactInputOutputException;
import org.example.exception.WrongContactStringException;
import org.example.util.Checkers;
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

  public Map<String, Contact> initContacts() {
    Map<String, Contact> contacts = new TreeMap<>();
//    if (this.contactsProfiles.equals("init")) {
//      try {
//        contacts = contactIO.load();
//        System.out.println(InfoStrings.CONTACTS_LOADED);
//      } catch (ContactInputOutputException e) {
//        System.out.println(e.getMessage());
//      }
//    }
    return contacts;
  }

  public Map<String, Contact> load() throws ContactInputOutputException, WrongContactStringException {
    Map<String, Contact> contactsMap = new TreeMap<>();
    int lineNumber = 0;
    try {
      if (this.maxLoadSize < Files.size(Path.of(this.loadPath))) {
        throw new ContactInputOutputException(ErrorStrings.FILE_TOO_BIG);
      }
      List<String> contactsList = Files.readAllLines(Path.of(this.loadPath));
      for (; lineNumber < contactsList.size(); lineNumber++) {
        Contact contact = this.parseContactFromFile(contactsList.get(lineNumber));
        contactsMap.put(contact.emailAddress(), contact);
      }
    } catch (IOException e) {
      throw new ContactInputOutputException(ErrorStrings.LOAD_FILE_ERROR + e);
    } catch (WrongContactStringException e) {
      throw new WrongContactStringException(ErrorStrings.LOAD_FILE_ERROR + ErrorStrings.STRING_NUMBER + lineNumber + " " + e);
    }
    return contactsMap;
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
    return this.parseContactString(input, Contact.FIELD_SEPARATOR_FOR_INPUT);
  }

  public Contact parseContactFromFile(String contactString) throws WrongContactStringException {
    return this.parseContactString(contactString, Contact.FIELD_SEPARATOR_FOR_FILE);
  }

  private Contact parseContactString(String contactString, String fieldSeparator) throws WrongContactStringException {
    String[] inputFields = Checkers.checkInputFields(contactString, fieldSeparator);

    String fio = Checkers.checkFio(inputFields[0]);
    String phoneNumber = Checkers.checkPhoneNumber(inputFields[1]);
    String emailAddress = Checkers.checkEmailAddress(inputFields[2]);

    return new Contact(fio, phoneNumber, emailAddress);
  }

}