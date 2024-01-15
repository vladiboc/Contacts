package org.example.bean;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InputLoop {
  private final Scanner scanner = new Scanner(System.in);

  public void readInput(String menuMessage, String byeMessage, InputHandler handler) {
    while (true) {
      System.out.println(menuMessage);
      String input = this.scanner.nextLine();

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