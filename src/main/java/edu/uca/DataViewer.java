package edu.uca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataViewer {
    private static final String FILE_NAME = "src/main/resources/familyFriendlyPlaylist.csv"; // Change this to your actual file name

    public static void main(String[] args) {
        List<DataItem> dataItems = loadData(FILE_NAME);
        if (dataItems.isEmpty()) {
            System.out.println("No data found.");
            return;
        }

        // Console Test Application
        printConsoleData(dataItems);

        // GUI Test Application
        SwingUtilities.invokeLater(() -> createAndShowGUI(dataItems));
    }

    private static List<DataItem> loadData(String fileName) {
        List<DataItem> dataItems = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(","); // Assuming CSV format
                dataItems.add(new DataItem(attributes));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return dataItems;
    }

    private static void printConsoleData(List<DataItem> dataItems) {
        // Print specific item attributes (consolidating repeated logic into one method)
        System.out.println("First item attributes:");
        printItemAttributes(dataItems, 0);

        if (dataItems.size() >= 10) {
            System.out.println("\nTenth item attributes:");
            printItemAttributes(dataItems, 9);
        } else {
            System.out.println("\nDataset has less than 10 items.");
        }

        System.out.println("\nTotal number of entries: " + dataItems.size());
    }

    // Consolidated method to print item attributes (console and GUI)
    private static void printItemAttributes(List<DataItem> dataItems, int index) {
        if (index < dataItems.size()) {
            System.out.println(String.join(", ", dataItems.get(index).attributes));
        } else {
            System.out.println("Index out of bounds.");
        }
    }

    private static void createAndShowGUI(List<DataItem> dataItems) {
        JFrame frame = new JFrame("Data Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Use common logic to populate table
        DefaultTableModel tableModel = createTableModel(dataItems);

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Helper method to create table model
    private static DefaultTableModel createTableModel(List<DataItem> dataItems) {
        String[] columnNames = {"Column1", "Column2", "Column3"}; // Adjust as needed
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (DataItem item : dataItems) {
            tableModel.addRow(item.attributes);
        }

        return tableModel;
    }
}