package org.example.bean;

public class AppManager implements InputHandler {

  public void doWork() {
    InputLoop inputLoop = new InputLoop();
    inputLoop.readInput("Введите строку:", this);
  }

  @Override
  public void handle(String input) {
    System.out.println("Строка: " + input);
  }

}