package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * AddRecord class
 */
public class AddRecord {

    private Scanner scanner = new Scanner(System.in);


    protected void addRecord(List<Album> albums) {
        String band;
        String title;
        String genre;
        int releaseDate;
        int actualYear = Calendar.getInstance().get(Calendar.YEAR);
        String s;
        List<Album> repet = new LinkedList<>();

        do {
            do {
                System.out.println("Podaj nazwę zespołu");
                band = scanner.nextLine();
                if (band.isEmpty()) {
                    System.out.println("Nie podano rzadnej nazwy");
                }
            } while (band.isEmpty());
            do {
                System.out.println("Podaj tytuł płyty: ");
                title = scanner.nextLine();
                if (title.isEmpty()) {
                    System.out.println("Nie podano rzadnej nazwy płyty");
                }
            } while (title.isEmpty());

            for (Album a : albums) {
                if (a.getBand().equals(band) && a.getTitle().equals(title)) {
                    repet.add(a);
                }
            }
            if (repet.size() > 0) {
                System.out.println("Wprowadzony album z podanym wykonawcą już istnieje na tej liście, spróbuj ponownie \n");
                addRecord(albums);
            }
            do {
                System.out.println("Podaj gatunek wykonywanej muzyki: ");
                genre = scanner.nextLine();
                if (genre.isEmpty()) {
                    System.out.println("Nie podano rzadnego gatunku");
                }
            } while (genre.isEmpty());
            do {
                System.out.println("Podaj rok wydania albumu: ");
                releaseDate = scanner.nextInt();
                if (releaseDate < 1887 || releaseDate > actualYear)
                    System.out.println("Nie podano roku wydania płyty lub data wykracza poza możliwy relany historyczny zakres ");
            } while (releaseDate < 1887 || releaseDate > actualYear);

                albums.add(new Album(band, title, genre, releaseDate));

            System.out.println("Wprowadź 'T'/'t' aby dodać kolejną pozycję lub 'N'/'n' aby wrócić do MENU: ");
            s = scanner.nextLine();
        }
        while (s.equals("T") || s.equals("t"));

    }
}
