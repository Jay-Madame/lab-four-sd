package edu.uca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class DataViewer {
    private static final String FILE_NAME = "src/main/resources/familyFriendlyPlaylist.csv";
    private JTable table;
    private DefaultTableModel tableModel;
    private DetailPanel detailPanel;
    private StatsPanel statsPanel;
    private ChartPanelComponent chartPanel;
    private PlayerControls playerControls;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataViewer().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Music Data Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        List<Track> tracks = DataCollection.loadTracks(FILE_NAME);

        // Create components
        detailPanel = new DetailPanel();
        statsPanel = new StatsPanel();
        chartPanel = new ChartPanelComponent();

        // Table setup
        tableModel = createTableModel(tracks);
        table = new JTable(tableModel);
        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                detailPanel.updateDetails(tracks.get(selectedRow));
            }
        });

        // Filter panel
        JPanel filterPanel = new JPanel(new BorderLayout());
        JTextField filterField = new JTextField();
        filterField.addActionListener(e -> applyFilter(tracks, filterField.getText()));
        filterPanel.add(filterField, BorderLayout.CENTER);
        JButton clearFilterButton = new JButton("Clear");
        clearFilterButton.addActionListener(e -> resetFilter(tracks));
        filterPanel.add(clearFilterButton, BorderLayout.EAST);

        playerControls = new PlayerControls();
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(statsPanel, BorderLayout.CENTER);
        bottomPanel.add(playerControls, BorderLayout.SOUTH);

        // Update table selection listener
        table.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                Track selectedTrack = tracks.get(selectedRow);
                detailPanel.updateDetails(selectedTrack);
                playerControls.setCurrentTrack(selectedTrack);
            }
        });

        // Update layout
        frame.setLayout(new BorderLayout());
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(filterPanel, BorderLayout.NORTH);
        frame.add(detailPanel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH); // Updated this line
        frame.add(chartPanel, BorderLayout.WEST);

        updateStatsAndChart(tracks);

        frame.setVisible(true);
    }

    private DefaultTableModel createTableModel(List<Track> tracks) {
        String[] columnNames = {"Track", "Artist", "Popularity"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (Track track : tracks) {
            model.addRow(new Object[]{
                    track.getTrackName(),
                    String.join(", ", track.getGenres()),
                    track.getPopularity()
            });
        }
        return model;
    }

    private void applyFilter(List<Track> originalTracks, String query) {
        List<Track> filteredTracks = originalTracks.stream()
                .filter(t -> t.getTrackName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());

        updateTable(filteredTracks);
        updateStatsAndChart(filteredTracks);
    }

    private void resetFilter(List<Track> originalTracks) {
        updateTable(originalTracks);
        updateStatsAndChart(originalTracks);
    }

    private void updateTable(List<Track> tracks) {
        tableModel.setRowCount(0);
        for (Track track : tracks) {
            tableModel.addRow(new Object[]{
                    track.getTrackName(),
                    String.join(", ", track.getGenres()),
                    track.getPopularity()
            });
        }
    }

    private void updateStatsAndChart(List<Track> tracks) {
        statsPanel.updateStats(tracks);
        chartPanel.updateChart(tracks);
    }
}
