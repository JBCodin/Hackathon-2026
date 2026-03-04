
// A simple class focused on Data and its structure, without any additional logic or methods.
public class Song extends AudioItem {
    // Instance Variables
    private String artistGenre;
    private int artistPopularity;
    private int artistFollowers;

    // Constructor for Song class.
    public Song(String trackName, String artistName, boolean isExplicit, int trackPopularity, String artistGenre, int artistPopularity, int artistFollowers) {
        super(trackName, artistName, isExplicit, trackPopularity);
        this.artistGenre = artistGenre;
        this.artistPopularity = artistPopularity;
        this.artistFollowers = artistFollowers;

    }

    // Getters for artistGenre, artistPopularity, and artistFollowers.
    public String getArtistGenre() {
        return this.artistGenre;
    }
    public int getArtistPopularity() {
        return this.artistPopularity;
    }
    
    public int getArtistFollowers() {
        return this.artistFollowers;
    }

    // Equals method for Song class.
    @Override
    public boolean equals(Object obj) {
        // If the object is compared with itself, return true.
        if (this == obj) {
            return true;
        }
        // If the object is null or not of the same class, return false.
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        // Typecast obj to Song so that to compare data members.
        Song song = (Song) obj;
        return this.getTrackName().equals(song.getTrackName()) && this.getArtist().equals(song.getArtist());
    }

    // To String method for Song class.
    @Override
    public String toString() {
        return "Song{" +
                "title:'" + getTrackName() + '\'' +
                ", artist:'" + getArtist() + '\'' +
                ", Explicit:" + getIsExplicit() +
                ", Artist Popularity:" + getArtistPopularity() +
                ", Artist Followers:" + getArtistFollowers() +
                ", Track Popularity:" + getTrackPopularity() + '' +
                ", Artist Genre:" + getArtistGenre() +
                '}';
    }
}