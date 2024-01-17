package org.example.manager;

import org.example.data.Contact;
import org.example.exception.NewContactStringException;
import org.example.util.Checkers;
import org.example.util.ErrorStrings;
import org.example.util.InfoStrings;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

@Component
public class ContactManager {
  private final Map<String, Contact> contacts = new TreeMap<>();

  public void listContacts() {
    if (this.contacts.isEmpty()) {
      System.out.println(InfoStrings.EMPTY_CONTACTS);
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
    if (this.contacts.isEmpty()) {
      System.out.println(InfoStrings.EMPTY_CONTACTS);
      return;
    }
    System.out.println(InfoStrings.ENTER_EMAIL);
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    Contact removedContact = this.contacts.remove(input);
    if (removedContact != null) {
      System.out.println(InfoStrings.CONTACT_REMOVED + removedContact);
    } else {
      System.out.println(ErrorStrings.CONTACT_REMOVE_ERROR);
    }
  }

  public void saveContacts() {

  }

  private Contact parseContactInput(String input) throws NewContactStringException {
    String[] inputFields = Checkers.checkInputFields(input);

    String fio = Checkers.checkFio(inputFields[0]);
    String phoneNumber = Checkers.checkPhoneNumber(inputFields[1]);
    String emailAddress = Checkers.checkEmailAddress(inputFields[2]);

    return new Contact(fio, phoneNumber, emailAddress);
  }

}