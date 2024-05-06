
import com.structure.browser.Browser;
import com.structure.musicplayer.MusicPlayer;
import com.structure.phone.Phone;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Phone phone = new Phone();
        MusicPlayer mp = new MusicPlayer();
        Browser bw = new Browser();
        System.out.println("Welcome to Smartphone in CLI. By Brian Farias (github.com/brianvfarias)");
        System.out.println(
                "You can choose between three main functionalities\n1- Phone\n2- Music Player\n3- Web Browser");
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Type the functionality you wish to use now\n(ph) Phone\n(mp) Music Player\n(bw) Browser\n(ex) Exit App");
        String functionalityNumber = scan.next();
        do {

            if (functionalityNumber.contains("ex")) {
                System.out.println("Leaving app");
            } else if (functionalityNumber.contains("ph")) {
                System.out.println(phone);
            } else if (functionalityNumber.contains("mp")) {
                mp.musicplayer(scan);
            } else if (functionalityNumber.contains("bw")) {
                bw.browse(scan);
            } else {
                System.out.println("Invalid option");
            }
            System.out.println(
                    "Type the functionality you wish to use now\n(ph) Phone\n(mp) Music Player\n(bw) Browser\n(ex) Exit App");
            functionalityNumber = scan.next();
        } while (!functionalityNumber.equals("ex"));
        scan.close();
    }
}
