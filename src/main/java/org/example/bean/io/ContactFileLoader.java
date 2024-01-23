package org.example.bean.io;

import org.example.data.Contact;
import org.example.exception.ContactInputOutputException;
import org.example.exception.WrongContactStringException;
import org.example.util.ErrorStrings;
import org.example.util.InfoStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ContactFileLoader implements ContactLoader {
  @Value("${contacts.file.load}")
  private String loadPath;
  @Value("${contacts.file.max-load-size}")
  private String maxLoadSize;
  private final ContactParser contactParser;

  @Autowired
  public ContactFileLoader(ContactParser contactParser) {
    this.contactParser = contactParser;
  }

  @PostConstruct
  public void afterInit() {
    System.out.println(InfoStrings.LOAD_CONTACTS_FROM + this.loadPath);
  }

  @Override
  public Map<String, Contact> load() {
    final Map<String, Contact> contactsMap = new TreeMap<>();
    int lineNumber = 0;
    try {
      if (Integer.valueOf(this.maxLoadSize) < Files.size(Path.of(this.loadPath))) {
        throw new ContactInputOutputException(ErrorStrings.FILE_TOO_BIG);
      }
      final List<String> contactsList = Files.readAllLines(Path.of(this.loadPath));
      for (; lineNumber < contactsList.size(); lineNumber++) {
        final Contact contact = contactParser.parseContactFromFile(contactsList.get(lineNumber));
        contactsMap.put(contact.emailAddress(), contact);
      }
      System.out.println(InfoStrings.CONTACTS_LOADED);
    } catch (IOException | ContactInputOutputException e) {
      System.out.println(ErrorStrings.LOAD_FILE_ERROR + e);
    } catch (WrongContactStringException e) {
      System.out.println(ErrorStrings.LOAD_FILE_ERROR + ErrorStrings.LINE_NUMBER + lineNumber + " " + e);
    }
    return contactsMap;
  }

}