package com.structure.phone;

import java.util.Scanner;

public class Phone {

  public void call(String callTo) {
    System.out.println("Calling to " + callTo);
  }

  // public void answer(String caller) {
  // Scanner scan = new Scanner(System.in);
  // System.out.println(caller + " is calling you. Do you want to answer the
  // phone? [Y/n] ");
  // String answer = scan.next();
  // // scan.close();
  // if (answer.toLowerCase().equals("y")) {
  // System.out.println(caller + " answered");
  // return;
  // }
  // System.out.println("Hanging up!");
  // }

  public void sendTextMessage(String messageTo, String message) {
    System.out.println("Sending message to " + messageTo);
    System.out.println("To: " + messageTo);
    System.out.println("Message: " + message);
  }

  public void managePhone(Scanner scan) {
    String input = "";
    do {
      System.out.println("Choose the action to perform in phone mode.\n(C)all\n(S)MS\n(L)eave phone");
      input = scan.next();
      if (input.toUpperCase().equals("C")) {
        System.out.println("Who do you want to call?");
        String callTo = scan.next();
        this.call(callTo);
      } else if (input.toUpperCase().equals("S")) {
        System.out.println("Who do you want to send a SMS to?");
        String messageTo = scan.next();
        System.out.println("Type the message you want to send");
        String message = scan.next();
        this.sendTextMessage(messageTo, message);
      }
    } while (!input.toUpperCase().equals("L"));
  }

}
