package org.example.manager;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InputLoop {

  public void readInput(String menuMessage, String byeMessage, InputHandler handler) {
    final Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println(menuMessage);
      String input = scanner.nextLine();

      if (input.isEmpty()) {
        System.out.println(byeMessage);
        break;
      }
      handler.handle(input);
    }
  }

  public interface InputHandler {
    void handle(String input);
  }

}