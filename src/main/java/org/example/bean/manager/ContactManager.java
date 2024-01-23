package org.example.bean.manager;

import org.example.bean.io.ContactLoader;
import org.example.bean.io.ContactParser;
import org.example.bean.io.ContactSaver;
import org.example.data.Contact;
import org.example.exception.WrongContactStringException;
import org.example.util.ErrorStrings;
import org.example.util.InfoStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Scanner;

@Component
public class ContactManager {
  private final Map<String, Contact> contacts;
  private final ContactParser contactParser;
  private final ContactSaver contactSaver;

  @Autowired
  public ContactManager(
      ContactSaver contactSaver, ContactParser contactParser, ContactLoader contactLoader) {
    this.contactSaver = contactSaver;
    this.contactParser = contactParser;
    this.contacts = contactLoader.load();
  }

  public void listContacts() {
    if (this.isContactsListEmpty()) {
      return;
    }
    System.out.println(InfoStrings.LIST_OF_CONTACTS);
    for(Map.Entry<String, Contact> entry : contacts.entrySet()) {
      System.out.println(entry.getValue());
    }
  }

  public void addContact() {
    System.out.println(InfoStrings.ADD_CONTACT);
    final Scanner scanner = new Scanner(System.in);
    final String input = scanner.nextLine();
    try {
      final Contact newContact = contactParser.parseContactFromInput(input);
      this.contacts.put(newContact.emailAddress(), newContact);
      System.out.println(InfoStrings.CONTACT_ADDED + newContact);
    } catch (WrongContactStringException e) {
      System.out.println(InfoStrings.CONTACT_INPUT_ERROR + e.getMessage());
    }
  }

  public void removeContact() {
    if (this.isContactsListEmpty()) {
      return;
    }
    System.out.println(InfoStrings.ENTER_EMAIL);
    final Scanner scanner = new Scanner(System.in);
    final String input = scanner.nextLine();
    final Contact removedContact = this.contacts.remove(input);
    if (removedContact == null) {
      System.out.println(ErrorStrings.CONTACT_REMOVE_ERROR);
    } else {
      System.out.println(InfoStrings.CONTACT_REMOVED + removedContact);
    }
  }

  public void saveContacts() {
    if (this.isContactsListEmpty()) {
      return;
    }
    contactSaver.save(this.contacts);
  }

  private boolean isContactsListEmpty() {
    final boolean isContactsListEmpty = this.contacts.isEmpty();
    if (isContactsListEmpty) {
      System.out.println(InfoStrings.EMPTY_CONTACTS);
    }
    return isContactsListEmpty;
  }

}