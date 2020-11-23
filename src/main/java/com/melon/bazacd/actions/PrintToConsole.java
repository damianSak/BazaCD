package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;
import com.melon.bazacd.utils.StringUtils;

import java.util.List;

public class PrintToConsole {

    public PrintToConsole() {
    }

    public String printHeading() {
        return "-------------------------+-------------------+-----------------+-------------\n" +
                "          Tytuł          |     Wykonawca     |     Gatunek     | Rok Wydania \n" +
                "-------------------------+-------------------+-----------------+-------------";
    }


    protected void printAlbumRecrds(List<Album> albums) {
        for (Album album : albums) {
            StringUtils.printSingleRecord(album.getTitle(), album.getBand(), album.getGenre(), album.getReleaseYear());
        }
    }

    protected String printEnding() {
        return "-------------------------+-------------------+-----------------+-------------";
    }

    public void printToConsole(List<Album> albums) {

        System.out.println(printHeading());
        printAlbumRecrds(albums);
        System.out.println(" ");
    }
}
