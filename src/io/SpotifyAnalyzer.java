package io;

import java.util.List;

public class SpotifyAnalyzer {

    // How many songs are explicit vs clean?
    public int countExplicit(List<Song> songs) {
        int count = 0;
        for (Song s : songs) {
            if (s.getIsExplicit()) { // from AudioItem
                count++;
            }
        }
        return count;
    }

}
