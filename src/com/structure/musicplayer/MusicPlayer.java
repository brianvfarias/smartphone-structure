package com.structure.musicplayer;

import java.io.File;
import java.util.Scanner;

import javax.sound.sampled.*;

public class MusicPlayer {
  public void playMusic(String musicLocation) {
    try {
      File musicPath = new File(musicLocation);
      if (musicPath.exists()) {
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInput);
        Scanner scan = new Scanner(System.in);
        String input = "";
        while (!input.toUpperCase().equals("Q")) {
          System.out.println("P = play, S = stop, R = reset, Q = quit");
          System.out.print("Enter your choice ");
          input = scan.next().toUpperCase();
          switch (input) {
            case ("P"):
              clip.start();
              break;
            case ("S"):
              clip.stop();
              System.out.println("Should stop");
              break;
            case ("R"):
              clip.setMicrosecondPosition(0);
              break;
            case ("Q"):
              clip.close();
              System.out.println("Quitting music player...");
              scan.close();
              break;
            default:
              System.out.println("Not a valid input");
              // break;
          }
          // clip.start();
        }
      } else {
        System.out.println("Can't find file");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}