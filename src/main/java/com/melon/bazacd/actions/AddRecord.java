package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;

import java.util.*;

public class AddRecord {


    public void addRecord(List<Album> albums) {
        String band;
        String title;
        String genre;
        String s;
        int releaseDate;
        boolean isAlbumAlreadyInCollection = false;

        int actualYear = Calendar.getInstance().get(Calendar.YEAR);

        do {
            band = readStringFromUserHandlingEmptyInput("Podaj nazwę zespołu:",
                    "Nie podano żadnej nazwy");

            title = readStringFromUserHandlingEmptyInput("Podaj tytuł płyty: ",
                    "Nie podano rzadnej nazwy płyty");

            for (Album a : albums) {
                if (a.getBand().equals(band) && a.getTitle().equals(title)) {
                    isAlbumAlreadyInCollection = true;
                    break;
                }
            }
            // TODO: 2020-05-02 lambda zamiast petli
            if (!isAlbumAlreadyInCollection) {
                System.out.println("Wprowadzony album z podanym wykonawcą już istnieje na tej liście, spróbuj ponownie \n");
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
            try (Scanner scanner = new Scanner(System.in)) {
                s = scanner.nextLine();
            }
        }
        while (s.equals("T") || s.toLowerCase().equals("t"));
    }

    private int readIntFromUserHandlingEmptyInput(String mainMessage, String exceptionMessage, int lowerConstraint, int upperConstraint) {
        int number;
        do {
            System.out.println(mainMessage);
            try (Scanner scanner = new Scanner(System.in)) {
                number = scanner.nextInt();
            }
            if (number < lowerConstraint || number > upperConstraint)
                System.out.println(exceptionMessage);
        } while (number < lowerConstraint || number > upperConstraint);
        return number;
    }

    private String readStringFromUserHandlingEmptyInput(String mainMessage, String exceptionMessage) {
        String result;
        do {
            System.out.println(mainMessage);
            try (Scanner scanner = new Scanner(System.in)) {
                result = scanner.nextLine();
            }
            if (result.isEmpty()) {
                System.out.println(exceptionMessage);
            }
        } while (result.isEmpty());

        return result;
    }
}
