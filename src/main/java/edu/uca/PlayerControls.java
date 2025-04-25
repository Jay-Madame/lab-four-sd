package edu.uca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PlayerControls extends JPanel {
    private final JButton playButton;
    private final JButton pauseButton;
    private final JButton stopButton;
    private Track currentTrack;

    public PlayerControls() {
        setLayout(new FlowLayout());

        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        stopButton = new JButton("Stop");

        playButton.addActionListener(this::handlePlay);
        pauseButton.addActionListener(this::handlePause);
        stopButton.addActionListener(this::handleStop);

        add(playButton);
        add(pauseButton);
        add(stopButton);
    }

    public void setCurrentTrack(Track track) {
        if (currentTrack != null) {
            currentTrack.stop();
        }
        currentTrack = track;
    }

    private void handlePlay(ActionEvent e) {
        if (currentTrack != null) {
            if (currentTrack.isPlaying()) {
                currentTrack.resume();
            } else {
                currentTrack.play();
            }
        }
    }

    private void handlePause(ActionEvent e) {
        if (currentTrack != null) {
            currentTrack.pause();
        }
    }

    private void handleStop(ActionEvent e) {
        if (currentTrack != null) {
            currentTrack.stop();
        }
    }
}