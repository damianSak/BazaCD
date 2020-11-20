package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;

import java.util.List;
import java.util.Locale;

public class PrintToConsole {

     List<Album> albums;

    public PrintToConsole(List<Album> albums) {
        this.albums = albums;
    }

    public String heading() {
        return "-------------------------+-------------------+-----------------+-------------\n" +
                "          Tytuł          |     Wykonawca     |     Gatunek     | Rok Wydania \n" +
                "-------------------------+-------------------+-----------------+-------------";
    }

    protected String ending() {
        return "-------------------------+-------------------+-----------------+-------------";
    }

    public void printToConsole(List<Album> albums) {

        System.out.println(heading());

        for (Album a : albums) {
            System.out.format(Locale.GERMAN, "%-25s|%-19s|%-17s| %-13s\n",
                    a.getTitle(), a.getBand(), a.getGenre(), a.getReleaseYear());
        }
        System.out.println(ending());

        System.out.println(" ");
    }
}
