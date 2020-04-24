package com.melon.bazacd.actions;

import com.melon.bazacd.AlbumsCollection;
import com.melon.bazacd.model.Album;

import java.util.*;

public class AddRecord {


    public void addRecord(List<Album> albums) {
        String band = "";
        String title = "";
        String genre = "";
        String s;
        int releaseDate = 0;
        int helperIntOnAQuestOfFindingIfAlbumIsAlreadyInsideCollection = 0;

        int actualYear = Calendar.getInstance().get(Calendar.YEAR);
        Scanner scanner = new Scanner(System.in);

        do {
            do {
                System.out.println("Podaj nazwę zespołu");
                readFromUserHandlingEmptyInput(band);
                if (band.isEmpty()) {
                    System.out.println("Nie podano rzadnej nazwy");
                }
            } while (band.isEmpty());
            do {
                System.out.println("Podaj tytuł płyty: ");
                readFromUserHandlingEmptyInput(title);
                if (title.isEmpty()) {
                    System.out.println("Nie podano rzadnej nazwy płyty");
                }
            } while (title.isEmpty());

            for (Album a : albums) {
                if (a.getBand().equals(band) && a.getTitle().equals(title)) {
                    helperIntOnAQuestOfFindingIfAlbumIsAlreadyInsideCollection++;
                }
            }
            if (helperIntOnAQuestOfFindingIfAlbumIsAlreadyInsideCollection > 0) {
                System.out.println("Wprowadzony album z podanym wykonawcą już istnieje na tej liście, spróbuj ponownie \n");

            } else {
                do {
                    System.out.println("Podaj gatunek wykonywanej muzyki: ");
                    readFromUserHandlingEmptyInput(genre);
                    if (genre.isEmpty()) {
                        System.out.println("Nie podano rzadnego gatunku");
                    }
                } while (genre.isEmpty());
                do {
                    System.out.println("Podaj rok wydania albumu: ");
                    readIntFromUserHandlingEmptyInput(releaseDate);
                    if (releaseDate < 1887 || releaseDate > actualYear)
                        System.out.println("Nie podano roku wydania płyty lub data wykracza poza możliwy relany historyczny zakres ");
                } while (releaseDate < 1887 || releaseDate > actualYear);

                albums.add(new Album(band, title, genre, releaseDate));
            }
            System.out.println("Wprowadź 'T'/'t' aby dodać kolejną pozycję lub 'N'/'n' aby wrócić do MENU: ");
            s = scanner.nextLine();
        }
        while (s.equals("T") || s.toLowerCase().equals("t"));

    }

    private int readIntFromUserHandlingEmptyInput(int variable) {
        try (Scanner scanner = new Scanner(System.in)) {
            variable = scanner.nextInt();
        }
        return variable;
    }

    private String readFromUserHandlingEmptyInput(String variable) {
        try (Scanner scanner = new Scanner(System.in)) {
            variable = scanner.nextLine();
        }
        return variable;
    }
}
