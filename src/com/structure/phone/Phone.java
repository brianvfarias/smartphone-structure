package com.structure.phone;

import java.util.Scanner;

public class Phone {

  public void call(String callTo) {
    System.out.println("Calling to " + callTo);
  }

  public void answer(String caller) {
    Scanner scan = new Scanner(System.in);
    System.out.println(caller + " is calling you. Do you want to answer the phone? [Y/n] ");
    String answer = scan.next();
    scan.close();
    if (answer.toLowerCase().equals("y")) {
      System.out.println(caller + " answered");
      return;
    }
    System.out.println("Hanging up!");
  }

  public void sendTextMessage(String messageTo, String message) {
    System.out.println("Sending message to " + messageTo);
    System.out.println("To: " + messageTo);
    System.out.println("Message: " + message);
  }

}
