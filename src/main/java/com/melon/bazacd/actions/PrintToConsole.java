package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;
import com.melon.bazacd.utils.StringUtils;

import java.util.List;

public class PrintToConsole {
    private String ending = "-------------------------+-------------------+-----------------+-------------";

    public String printHeading() {
        return "-------------------------+-------------------+-----------------+-------------\n" +
                "          Tytuł          |     Wykonawca     |     Gatunek     | Rok Wydania \n" +
                "-------------------------+-------------------+-----------------+-------------";
    }

    private void printAlbumRecrds(List<Album> albums) {
        for (Album album : albums) {
            StringUtils.printSingleRecord(album.getTitle(), album.getBand(), album.getGenre(), album.getReleaseYear());
        }
    }

    String printEnding() {
        return ending;
    }

    public void printAlbumsDbOnConsole(List<Album> albums) {

        System.out.println(printHeading());
        printAlbumRecrds(albums);
        System.out.println(printEnding());
    }
}
