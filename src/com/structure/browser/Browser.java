package com.structure.browser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.net.http.HttpResponse.BodyHandlers;

public class Browser {
  private List<String> history = new ArrayList<String>();

  public void search(String url) {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest req = HttpRequest.newBuilder()
        .uri(new URI(url))
        .GET()
        .build();

    HttpResponse<String> res = client.send(req, BodyHandlers.ofString());
    System.out.println(res.body());
  }

  public List<String> getHistory() {
    return history;
  }

  public void setHistory(List<String> history) {
    this.history = history;
  }
}
