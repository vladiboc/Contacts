package org.example.bean;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InputLoop {
  private final Scanner scanner = new Scanner(System.in);

  public void readInput(String message, InputHandler handler) {
    while (true) {
      System.out.println(message);
      String input = this.scanner.nextLine();
      handler.handle(input);
      if (input.equals("0")) {
        System.out.println("До свидания!");
        break;
      }
    }
  }

  public interface InputHandler {
    void handle(String input);
  }

}