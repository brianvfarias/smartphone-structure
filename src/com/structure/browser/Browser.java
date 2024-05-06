package com.structure.browser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class Browser {
  private List<String> history = new ArrayList<String>();

  public void search(String url) {
    this.setHistory(url);
    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest req = HttpRequest.newBuilder()
          .uri(new URI(url))
          .GET()
          .build();

      HttpResponse<String> res = client.send(req, BodyHandlers.ofString());
      System.out.println(res.body());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void browse(Scanner scan) {

    String keepSearching = "y";
    do {
      System.out.println("Do you want to search something? [Y/n]");
      keepSearching = scan.next();
      if (keepSearching.toLowerCase().equals("y")) {
        System.out.println("Insert the url you want to search");
        String url = scan.next();
        System.out.println("Here is the page at " + url);
        this.search(url);
      }
    } while (keepSearching.toLowerCase().equals("y"));
    System.out.println("Leaving browser");
  }

  public List<String> getHistory() {
    return history;
  }

  public void setHistory(String history) {
    this.history.add(history);
  }
}
