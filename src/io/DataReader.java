package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    // Method to parse the CSV
    public List<Song> readSongsFromFile(String filePath) {
        List<Song> songs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {


            //Read and skip/ignore the header line.
            String header = br.readLine();
            if (header == null) {
                return songs; // Return empty list if file is empty.
            }

            // Empty variable to hold each line of the file as we read it.
            String line;
            int lineNumber = 2; // Start from 2 since we've already skipped the header.

            // while the line is the line we're on and it does not equal null
            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    lineNumber++;
                    continue; // Skip empty lines
                }

                try {

                    // 
                    Song song = parseLine(line);
                    if (song != null) {
                        songs.add(song);
                    }

                } catch (Exception e) {
                    System.err.printf("Error parsing line %d: %s%n", lineNumber, e.getMessage());

                }
                lineNumber++;
            }

        } catch (IOException e) {
            //
            throw new RuntimeException("Could not read file: " +  filePath, e);
        }

        return songs;
    }

    private Song parseLine(String line){
       
        // Split the line by commas, but this is a limited approach because if a field contains a comma, it will be incorrectly split.
        String[] fields = line.split(",");

        if (fields.length < 15) {
            throw new IllegalArgumentException("Line does not contain enough fields: " + line);
        }

        // Extracting fields based on the  order in the CSV.
        String trackName = fields[1].trim();   // track_name
         int trackPopularity = Integer.parseInt(fields[3].trim()); // track_popularity

        // explicit
        String explicitRaw = fields[4].trim();
        boolean isExplicit = Boolean.parseBoolean(explicitRaw); // this works because the CSV uses "TRUE" and "FALSE" which can be parsed because it isn't case-sensitive.

        String artistName = fields[5].trim();         // artist_name
        int artistPopularity = Integer.parseInt(fields[6].trim()); // artist_popularity
        int artistFollowers = Integer.parseInt(fields[7].trim());  // artist_followers
        String artistGenre = fields[8].trim();        // artist_genres (keep as single string for now)

    // Build and return the Song object
    return new Song(
            trackName,
            artistName,
            isExplicit,
            trackPopularity,
            artistGenre,
            artistPopularity,
            artistFollowers
    );


    }
}
