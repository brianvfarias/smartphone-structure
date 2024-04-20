import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.structure.musicplayer.MusicPlayer;

public class App {
    public static void main(String[] args) throws Exception {
        // String song = "I-Wonder-Whose-Kissing-Her-Now-Freedom-Trail-Studio.wav";
        // MusicPlayer mp = new MusicPlayer();
        // mp.playMusic(song);
        File directory = new File(".");
        File[] files = directory.listFiles();
        List<String> fileNames = new ArrayList<String>();
        int c = 1;
        for (File file : files) {
            if (file.getName().endsWith(".wav")) {
                String fileName = file.getName();
                fileNames.add(fileName);
                System.out.println(c + " - " + fileName);
                c++;
            }
        }
        System.out.println("Type the number of the music you want to listen from our Library");
        Scanner scan = new Scanner(System.in);
        int musicNumber = scan.nextInt();
        if (musicNumber > fileNames.size()) {
            System.out.println("No music available");
            scan.close();
        }
        if (musicNumber <= fileNames.size()) {
            String song = fileNames.get(musicNumber - 1);
            System.out.println(song);
            MusicPlayer mp = new MusicPlayer();
            mp.playMusic(song);
        }
    }
}
