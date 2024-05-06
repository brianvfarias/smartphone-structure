package com.structure.musicplayer;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.*;

public class MusicPlayer {
  private List<String> fileNames = new ArrayList<String>();
  private Clip currentSong;

  public void setFileNames() {
    File rootPath = new File(".");
    File[] musicFiles = rootPath.listFiles();
    for (File musicFile : musicFiles) {
      if (musicFile.getName().endsWith(".wav")) {
        this.fileNames.add(musicFile.getName());
      }
    }
  }

  public List<String> getFileNames() {
    if (fileNames.size() > 0) {
      return this.fileNames;
    }
    setFileNames();
    return this.fileNames;
  }

  private void playMusic(String musicLocation) {
    try {
      File musicPath = new File(musicLocation);
      if (musicPath.exists()) {
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
        this.currentSong = AudioSystem.getClip();
        this.currentSong.open(audioInput);
        this.currentSong.start();
      } else {
        System.out.println("Sorry, file couldn't be found!");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void musicplayer(Scanner scan) {
    List<String> availableMusics = this.getFileNames();
    System.out.println("Type the number of the music you wanna hear to play it");
    int c = 1;
    for (String music : availableMusics) {
      System.out.println(c + music);
      c++;
    }

    // Scanner scan = new Scanner(System.in);
    String musicLocation = availableMusics.get(scan.nextInt() - 1);
    this.playMusic(musicLocation);
    String input = "";
    while (!input.toUpperCase().equals("Q")) {
      System.out.println("P = play, S = stop, R = reset, Q = quit");
      System.out.print("Enter your choice ");
      input = scan.next().toUpperCase();

      switch (input) {
        case ("P"):
          this.currentSong.start();
          break;
        case ("S"):
          this.currentSong.stop();
          System.out.println("Should stop");
          break;
        case ("R"):
          this.currentSong.setMicrosecondPosition(0);
          break;
        case ("Q"):
          this.currentSong.close();
          System.out.println("Quitting music player...");
          break;
        default:
          System.out.println("Not a valid input");
          // break;
      }
      // clip.start();
    }
  }
}