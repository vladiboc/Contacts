package org.example.manager;

import org.example.data.Contact;
import org.example.exception.NewContactStringException;
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
  private final ObjectFactory<Contact> contactObjectFactory;

  @Autowired
  public ContactManager(ObjectFactory<Contact> contactObjectFactory) {
    this.contactObjectFactory = contactObjectFactory;
  }

  public void listContacts() {
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
      Contact newContact = parseContact(input);
      this.contacts.put(newContact.getEmailAddress(), newContact);
      System.out.println(InfoStrings.CONTACT_ADDED + newContact);
    } catch (Exception e) {
      System.out.println(InfoStrings.CONTACT_INPUT_ERROR + e.getMessage());
    }
  }

  public void removeContact() {

  }

  public void saveContacts() {

  }

  private Contact parseContact(String input) throws NewContactStringException {
    String[] inputFields = input.split("; ");
    if (inputFields.length != 3) {
      throw new NewContactStringException(ErrorStrings.THREE_FIELDS_NEEDED);
    }
    String fio = inputFields[0];
    String[] fioFields = fio.split(" ");
    if (fioFields.length != 3) {
      throw new NewContactStringException(ErrorStrings.FIO_NOT_THREE_WORDS);
    }
    for (String s : fioFields) {
      if (!s.matches("^[А-ЯЁ][а-яё]+$")) {
        throw new NewContactStringException(ErrorStrings.NANE_TO_BE_CORRECT);
      }
    }
    String phoneNumber = inputFields[1];
    if (!phoneNumber.matches("^[+]7[0-9]{10}$")) {
      throw new NewContactStringException(ErrorStrings.PHONE_NUMBER_TO_BE_CORRECT);
    }
    String emailAddress = inputFields[2];
    if (!emailAddress.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
      throw new NewContactStringException(ErrorStrings.EMAIL_ADDRESS_TO_BE_CORRECT);
    }
    Contact newContact = contactObjectFactory.getObject();
    newContact.setFio(fio);
    newContact.setPhoneNumber(phoneNumber);
    newContact.setEmailAddress(emailAddress);
    return newContact;
  }

}