package io;
import io.DataReader;
import io.Song;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        
        // CSV file path
        String filePath = "SpotifyData.csv"; 

        // Create an instance of DataReader and read songs from the file
        DataReader reader = new DataReader();
        List<Song> songs = reader.readSongsFromFile(filePath);

       
        System.out.println("Total songs loaded: " + songs.size());

        // Print the first few songs
        int limit = Math.min(10, songs.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(songs.get(i));
        }

    }

}
