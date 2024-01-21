package org.example.bean.manager;

import org.example.util.InfoStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AppManager {
  private final ContactManager contactManager;

  @Autowired
  public AppManager(ContactManager contactManager) {
    this.contactManager = contactManager;
  }

  public void doWork() {
    final Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println(InfoStrings.MAIN_MENU);
      String input = scanner.nextLine();

      if (input.isEmpty()) {
        System.out.println(InfoStrings.BYE);
        break;
      }
      this.handleMainMenu(input);
    }
  }

  private void handleMainMenu(String input) {
    switch (input) {
      case "1" -> contactManager.listContacts();
      case "2" -> contactManager.addContact();
      case "3" -> contactManager.removeContact();
      case "4" -> contactManager.saveContacts();
      default -> System.out.println(input + InfoStrings.MAIN_MENU_INCORRECT_INPUT);
    }
  }

}