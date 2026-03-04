import io.DataReader;
import io.Song;
import io.SpotifyAnalyzer;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		String filePath = "SpotifyData.csv";
		DataReader reader = new DataReader();
		List<Song> songs = reader.readSongsFromFile(filePath);
		

        // Use SpotifyAnalyzer
        SpotifyAnalyzer analyzer = new SpotifyAnalyzer();

        Scanner in = new Scanner(System.in);

        System.out.print("Show number of explicit songs? (y/n): ");
        String answer = in.nextLine().trim().toLowerCase();

        if (answer.equals("y")) {
            int explicitCount = analyzer.countExplicit(songs);
            double percent = songs.isEmpty()
                    ? 0.0
                    : explicitCount * 100.0 / songs.size();
            System.out.println("Explicit songs: " + explicitCount +
                    " (" + percent + "% of all songs)");
        } else {
            System.out.println("Okay, skipping explicit-song stats.");
        }

        in.close();
        int explicitCount = analyzer.countExplicit(songs);
        System.out.println("Number of explicit songs: " + explicitCount);

        if (!songs.isEmpty()) {
            double percent = explicitCount * 100.0 / songs.size();
            System.out.println("Percent explicit: " + percent + "%");
        }

		}

}


