package org.example.bean;

public class ContactManager {

  InputLoop inputLoop = new InputLoop();

  public void doWork() {
    inputLoop.readInput("Введите строку:", this::handle);
  }

  public void handle(String input) {
    System.out.println("Строка: " + input);
    inputLoop.readInput("Еще одну строку: ", this::handle2);
  }

  public void handle2(String input) {
    System.out.println("2-я строка: " + input);
  }

}