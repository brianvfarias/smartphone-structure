
// import com.structure.musicplayer.MusicPlayer;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.structure.browser.Browser;

// import com.structure.browser.Browser;

public class App {
    public static void main(String[] args) throws Exception {
        // MusicPlayer mp = new MusicPlayer();
        // mp.musicplayer();
        Browser bw = new Browser();
        bw.search("https://github.com/brianvfarias");
    }
}
