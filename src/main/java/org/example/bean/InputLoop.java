package org.example.bean;

import java.util.Scanner;

public class InputLoop {

  public void readInput(String message, InputHandler handler) {
    final Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println(message);
      String input = scanner.nextLine();
      if (input.equals("0")) {
        System.out.println("Всего наилучшего!");
        break;
      }
      handler.handle(input);
    }
    scanner.close();
  }

}