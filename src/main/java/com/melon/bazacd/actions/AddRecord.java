package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;
import com.melon.bazacd.utils.ConsoleInputProvider;

import java.util.*;

public class AddRecord {
    List<Album> albums;

    public AddRecord(List<Album> albums) {
        this.albums = albums;
    }

    public void addRecord(List<Album> albums) {
        String band;
        String title;
        String genre;
        String s;
        int releaseDate;
        boolean isAlbumAlreadyInCollectionLambda;

        int actualYear = Calendar.getInstance().get(Calendar.YEAR);

        do {
            band = readStringFromUserHandlingEmptyInput("Podaj nazwę zespołu:",
                    "Nie podano żadnej nazwy");

            title = readStringFromUserHandlingEmptyInput("Podaj tytuł płyty: ",
                    "Nie podano rzadnej nazwy płyty");

            String finalBand = band;
            String finalTitle = title;
            isAlbumAlreadyInCollectionLambda = albums.stream().anyMatch(h -> h.getBand().equals(finalBand) &&
                    h.getTitle().equals(finalTitle));
            if (!isAlbumAlreadyInCollectionLambda) {
                genre = readStringFromUserHandlingEmptyInput("Podaj gatunek wykonywanej muzyki: ",
                        "Nie podano rzadnego gatunku");

                releaseDate = readIntFromUserHandlingEmptyInput("Podaj rok wydania albumu: ",
                        "Nie podano roku wydania płyty lub data wykracza poza możliwy relany historyczny zakres "
                        , 1887, actualYear);

                albums.add(new Album(band, title, genre, releaseDate));
            } else {
                System.out.println("Wprowadzony album z podanym wykonawcą już istnieje na tej liście, spróbuj ponownie \n");
            }
            System.out.println("Wprowadź 'T'/'t' aby dodać kolejną pozycję lub 'N'/'n' aby wrócić do MENU: ");

            s = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();

        }
        while (s.equals("T") || s.toLowerCase().equals("t"));
    }

    private int readIntFromUserHandlingEmptyInput(String mainMessage, String exceptionMessage, int lowerConstraint, int upperConstraint) {
        int number;
        do {
            System.out.println(mainMessage);
            number = ConsoleInputProvider.readIntFromUserHandlingEmptyInput();
            if (number < lowerConstraint || number > upperConstraint)
                System.out.println(exceptionMessage);
        } while (number < lowerConstraint || number > upperConstraint);
        return number;
    }

    private String readStringFromUserHandlingEmptyInput(String mainMessage, String exceptionMessage) {
        String result;
        do {
            System.out.println(mainMessage);
            result = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
            if (result.isEmpty()) {
                System.out.println(exceptionMessage);
            }
        } while (result.isEmpty());

        return result;
    }
}
