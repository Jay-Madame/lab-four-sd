package edu.uca;

import javax.swing.*;
import java.awt.*;

public class DetailPanel extends JPanel {
    private final JLabel trackNameLabel;
    private final JLabel artistLabel;
    private final JLabel popularityLabel;

    private final int ROWS = 3;
    private final int COLUMNS = 1;

    public DetailPanel() {
        setLayout(new GridLayout(ROWS, COLUMNS));
        trackNameLabel = new JLabel("Track: ");
        artistLabel = new JLabel("Artist: ");
        popularityLabel = new JLabel("Popularity: ");

        add(trackNameLabel);
        add(artistLabel);
        add(popularityLabel);
    }

    public void updateDetails(Track track) {
        trackNameLabel.setText("Track: " + track.getTrackName());
        artistLabel.setText("Artist: " + String.join(", ", track.getGenres()));
        popularityLabel.setText("Popularity: " + track.getPopularity());
    }

    public void clearDetails() {
        trackNameLabel.setText("Track: ");
        artistLabel.setText("Artist: ");
        popularityLabel.setText("Popularity: ");
    }
}
