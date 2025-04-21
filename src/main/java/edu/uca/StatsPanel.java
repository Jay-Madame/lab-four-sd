package edu.uca;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StatsPanel extends JPanel {
    private final JLabel avgDanceabilityLabel;
    private final JLabel trackCountLabel;

    private final int ROWS = 2;
    private final int COLUMNS = 1;

    public StatsPanel() {
        setLayout(new GridLayout(ROWS, COLUMNS));
        avgDanceabilityLabel = new JLabel("Average Danceability: ");
        trackCountLabel = new JLabel("Track Count: ");

        add(avgDanceabilityLabel);
        add(trackCountLabel);
    }

    public void updateStats(List<Track> tracks) {
        if (tracks.isEmpty()) {
            avgDanceabilityLabel.setText("Average Danceability: N/A");
            trackCountLabel.setText("Track Count: 0");
            return;
        }

        double avgDanceability = tracks.stream()
                .mapToDouble(Track::getDanceability)
                .average()
                .orElse(0.0);

        avgDanceabilityLabel.setText(String.format("Average Danceability: %.2f", avgDanceability));
        trackCountLabel.setText("Track Count: " + tracks.size());
    }
}
