package com.structure.musicplayer;

// import java.util.Date;

public class Song {
  protected String title;
  protected String author;
  // protected Date lauchDate;
  protected int secondsLength;

  public Song(String title, String author, int secondsLength) {
    this.title = title;
    this.author = author;
    // this.lauchDate = lauchDate;
    this.secondsLength = secondsLength;
  }

}
