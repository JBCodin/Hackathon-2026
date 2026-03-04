package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

Public class DataReader {

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

        // Extracting fields based on the expected order in the CSV.
        String trackName = fields[1].trim();


    }
}