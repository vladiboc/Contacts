package org.example.manager;

import org.example.util.InfoStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppManager {
  private final InputLoop inputLoop;
  private final ContactManager contactManager;

  @Autowired
  public AppManager(InputLoop inputLoop, ContactManager contactManager) {
    this.inputLoop = inputLoop;
    this.contactManager = contactManager;
  }

  public void doWork() {
    this.inputLoop.readInput(InfoStrings.MAIN_MENU, InfoStrings.BYE, this::handleMainMenu);
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