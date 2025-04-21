package edu.uca;

// uses the JFreeChart dependency!

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChartPanelComponent extends JPanel {
    private DefaultCategoryDataset dataset;

    public ChartPanelComponent() {
        dataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createLineChart(
                "Track Popularity",
                "Track",
                "Popularity",
                dataset
        );
        setLayout(new BorderLayout());
        add(new ChartPanel(chart), BorderLayout.CENTER);
    }

    public void updateChart(List<Track> tracks) {
        dataset.clear();
        for (int i = 0; i < tracks.size(); i++) {
            dataset.addValue(tracks.get(i).getPopularity(), "Popularity", tracks.get(i).getTrackName());
        }
    }
}
