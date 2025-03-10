package edu.uca;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class DataCollection {
    public static void main(String[] args) {
        String filePath = "src/main/resources/familyFriendlyPlaylist.csv";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            List<Track> trackList = br.lines()
                    .skip(1)
                    .limit(10)
                    .map(DataCollection::parseTrack)
                    .collect(Collectors.toList());

            // Print all collected tracks
            System.out.println("First 10 Songs:");
            trackList.forEach(System.out::println);

            // Collect popular tracks (popularity > 50)
            List<Track> popularTracks = trackList.stream()
                    .filter(t -> t.getPopularity() > 50)
                    .collect(Collectors.toList());
            System.out.println("\nPopular Tracks:");
            popularTracks.forEach(System.out::println);

            // Collect average danceability
            double avgDanceability = trackList.stream()
                    .collect(Collectors.averagingDouble(Track::getDanceability));
            System.out.println("\nAverage Danceability: " + avgDanceability);

            // Group by genre
            Map<String, List<Track>> tracksByGenre = trackList.stream()
                    .flatMap(t -> t.getGenres().stream().map(g -> Map.entry(g, t)))  // Flatten genre-track pairs
                    .collect(Collectors.groupingBy(Map.Entry::getKey,
                            Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
            System.out.println("\nTracks Grouped by Genre:");
            tracksByGenre.forEach((genre, tracks) -> {
                System.out.println(genre + ": " + tracks);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Use comma as the separator in CSV
    private static Track parseTrack(String line) {
        String[] fields = line.split(",");
        return new Track(
                fields[0],
                fields[1],
                fields[2],
                List.of(fields[3].split(";")),  // Artists (split if multiple; changed separator to semicolon)
                Integer.parseInt(fields[4]),
                Integer.parseInt(fields[5]),
                List.of(fields[6].split(";")),  // Genres (split if multiple)
                Double.parseDouble(fields[7]),
                Double.parseDouble(fields[8]),
                Integer.parseInt(fields[9]),
                Double.parseDouble(fields[10]),
                Double.parseDouble(fields[11]),
                Double.parseDouble(fields[12]),
                Double.parseDouble(fields[13]),
                Double.parseDouble(fields[14]),
                Double.parseDouble(fields[15]),
                Double.parseDouble(fields[16]),
                Integer.parseInt(fields[17])
        );
    }
}
