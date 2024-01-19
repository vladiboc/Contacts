package org.example.bean;

import org.example.data.Contact;
import org.example.exception.ContactInputOutputException;
import org.example.exception.WrongContactStringException;
import org.example.util.Checkers;
import org.example.util.ErrorStrings;
import org.example.util.InfoStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

@Component
public class ContactManager {
  private final Map<String, Contact> contacts;
  private final ContactInputOutput contactIO;

  @Autowired
  public ContactManager(ContactInputOutput contactIO) {
    this.contactIO = contactIO;
    this.contacts = this.initContacts();
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
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    try {
      Contact newContact = parseContactInput(input);
      this.contacts.put(newContact.emailAddress(), newContact);
      System.out.println(InfoStrings.CONTACT_ADDED + newContact);
    } catch (Exception e) {
      System.out.println(InfoStrings.CONTACT_INPUT_ERROR + e.getMessage());
    }
  }

  public void removeContact() {
    if (this.isContactsListEmpty()) {
      return;
    }
    System.out.println(InfoStrings.ENTER_EMAIL);
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    Contact removedContact = this.contacts.remove(input);
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
    try {
      contactIO.save(this.contacts);
      System.out.println(InfoStrings.CONTACTS_SAVED);
    } catch (ContactInputOutputException e) {
      System.out.println(e.getMessage());
    }
  }

  private Map<String, Contact> initContacts() {
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

  private boolean isContactsListEmpty() {
    boolean isContactsListEmpty = this.contacts.isEmpty();
    if (isContactsListEmpty) {
      System.out.println(InfoStrings.EMPTY_CONTACTS);
    }
    return isContactsListEmpty;
  }

  private Contact parseContactInput(String input) throws WrongContactStringException {
    String[] inputFields = Checkers.checkInputFields(input);

    String fio = Checkers.checkFio(inputFields[0]);
    String phoneNumber = Checkers.checkPhoneNumber(inputFields[1]);
    String emailAddress = Checkers.checkEmailAddress(inputFields[2]);

    return new Contact(fio, phoneNumber, emailAddress);
  }

}