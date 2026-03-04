public class AudioItem {
    private String trackName;
    private String artistName;
    private boolean isExplicit;
    private int trackPopularity;

    public AudioItem(String trackName, String artistName, boolean isExplicit, int trackPopularity) {
        this.trackName = trackName;
        this.artistName = artistName;
        this.isExplicit = isExplicit;
        this.trackPopularity = trackPopularity;
    }
    
    // Getters for title,  artistName, isExplicit, and trackPopularity.
    public String getTrackName() {
        return this.trackName;
    }

    public String getArtist() {
        return this.artistName;
    }

    public boolean getIsExplicit() {
        return this.isExplicit;
    }

    public int getTrackPopularity() {
        return this.trackPopularity;
    }
}
