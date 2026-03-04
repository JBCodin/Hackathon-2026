package io;

import java.util.List;

public class SpotifyAnalyzer {

    // How many songs are explicit?
    public int countExplicit(List<Song> songs) {
        int count = 0;
        for (Song s : songs) {
            if (s.getIsExplicit()) { // method from AudioItem
                count++;
            }
        }
        return count;
    }

}
