package edu.uca;

import java.util.List;

class Track {
    private String trackID;
    private String trackName;
    private String albumName;
    private List<String> artists;
    private int durationMs;
    private int popularity;
    private List<String> genres;
    private double danceability;
    private double energy;
    private int key;
    private double loudness;
    private double speechiness;
    private double acousticness;
    private double instrumentalness;
    private double liveness;
    private double valence;
    private double tempo;
    private int timeSignature;

    public Track(String trackID, String trackName, String albumName, List<String> artists,
                 int durationMs, int popularity, List<String> genres, double danceability, double energy,
                 int key, double loudness, double speechiness, double acousticness, double instrumentalness,
                 double liveness, double valence, double tempo, int timeSignature) {
        this.trackID = trackID;
        this.trackName = trackName;
        this.albumName = albumName;
        this.artists = artists;
        this.durationMs = durationMs;
        this.popularity = popularity;
        this.genres = genres;
        this.danceability = danceability;
        this.energy = energy;
        this.key = key;
        this.loudness = loudness;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.timeSignature = timeSignature;
    }

    public int getPopularity() {
        return popularity;
    }

    public double getDanceability() {
        return danceability;
    }

    public String getTrackName() {
        return trackName;
    }

    public List<String> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return trackName + " by " + artists + " (Popularity: " + popularity + ")";
    }
}
