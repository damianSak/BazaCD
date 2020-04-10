package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class ReadAlbum {

    public List<Album> read(File chosenDb, int headingSize) {
        List<Album> albums = new LinkedList<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(chosenDb.getPath()));
            List<String> albumElements = lines.subList(headingSize, lines.size() - 1);

            for (String s : albumElements) {
                String[] singleAlbums = s.split("\\|");
                String singleAlbum1 = singleAlbums[0].trim();
                String singleAlbum2 = singleAlbums[1].trim();
                String singleAlbum3 = singleAlbums[2].trim();
                String singleAlbum4 = singleAlbums[3].trim();
                albums.add(new Album(singleAlbum2, singleAlbum1, singleAlbum3, Integer.parseInt(singleAlbum4)));
            }
        } catch (IOException e) {
            System.out.println("Błąd IO" + e.fillInStackTrace());
        }
        return albums;
    }
}
