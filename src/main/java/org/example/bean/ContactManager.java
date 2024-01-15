package org.example.bean;

import org.example.data.Contact;
import org.example.util.InfoStrings;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

@Component
public class ContactManager {
  private final Map<String, Contact> contacts = new TreeMap<>();

  public void listContacts() {
    for(Map.Entry<String, Contact> entry : contacts.entrySet()) {
      System.out.println(entry.getValue());
    }
  }

  public void addContact() {
    System.out.println(InfoStrings.ADD_CONTACT);
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    System.out.println("Введено: " + input);
  }

  public void removeContact() {

  }

  public void saveContacts() {

  }

}