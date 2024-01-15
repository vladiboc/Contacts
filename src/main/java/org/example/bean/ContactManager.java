package org.example.bean;

import org.example.util.Values;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactManager {

  private final InputLoop inputLoop;

  @Autowired
  public ContactManager(InputLoop inputLoop) {
    this.inputLoop = inputLoop;
  }

  public void doWork() {
    this.inputLoop.readInput(Values.MAIN_MENU, this::handleMainMenu);
  }

  private void handleMainMenu(String input) {
    switch (input) {
      case "1" -> this.listContacts();
      case "2" -> this.addContact();
      case "3" -> this.removeContact();
      case "4" -> this.saveContacts();
      case "0" -> {}
      default -> System.out.println(input + " - неправильный ввод. Введите цифру из меню и Enter.");
    }
  }

  private void listContacts() {

  }

  private void addContact() {

  }

  private void removeContact() {

  }

  private void saveContacts() {

  }

}