

public class Artist {
    // Instance Strings
    private String artist_name;
    private String genre;
    private int artistPopularity;
    private int artistFollowers;

    public Artist(String name, String genre) {
        this.artist_name = name;
        this.genre = genre;
    }
    // Getters for name and genre.
    public String getName() {
        return this.artist_name;
    }

    public String getGenre() {
        return this.genre;
    }

    public int getArtistPopularity() {
        return this.artistPopularity;
    }

    //Equals method for Artist class.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
    
    // To String method for Artist class.
    @Override
    public String toString() {
        return "Artist{" +
                "name:'" + name + '\'' +
                ", genre:'" + genre + '\'' +
                ", artistPopularity:" + artistPopularity +
                '}';
    }
}