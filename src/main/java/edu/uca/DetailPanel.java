package edu.uca;

import javax.swing.*;
import java.awt.*;

public class DetailPanel extends JPanel {
    private final JLabel trackNameLabel;
    private final JLabel artistLabel;
    private final JLabel albumLabel;
    private final JLabel durationLabel;
    private final JLabel popularityLabel;
    private final JLabel genresLabel;

    public DetailPanel() {
        setLayout(new GridLayout(6, 1));
        trackNameLabel = new JLabel("Track: ");
        artistLabel = new JLabel("Artist: ");
        albumLabel = new JLabel("Album: ");
        durationLabel = new JLabel("Duration: ");
        popularityLabel = new JLabel("Popularity: ");
        genresLabel = new JLabel("Genres: ");

        add(trackNameLabel);
        add(artistLabel);
        add(albumLabel);
        add(durationLabel);
        add(popularityLabel);
        add(genresLabel);
    }

    public void updateDetails(Track track) {
        trackNameLabel.setText("Track: " + track.getTrackName());
        artistLabel.setText("Artist: " + String.join(", ", track.getArtists()));
        albumLabel.setText("Album: " + track.getAlbumName());
        durationLabel.setText("Duration: " + formatDuration(track.getDurationMs()));
        popularityLabel.setText("Popularity: " + track.getPopularity());
        genresLabel.setText("Genres: " + String.join(", ", track.getGenres()));
    }

    private String formatDuration(int ms) {
        int seconds = (ms / 1000) % 60;
        int minutes = (ms / (1000 * 60)) % 60;
        return String.format("%d:%02d", minutes, seconds);
    }
}