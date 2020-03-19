package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class AddRecord {

    private Scanner scanner = new Scanner(System.in);
    private String s=" ";

    protected void addRecord(List<Album> albums) {
        String band;
        String title;
        String genre;
        String releaseDate="";

        do {
            System.out.println("Podaj nazwę zespołu");
            band = scanner.nextLine();
            System.out.println("Podaj tytuł płyty: ");
            title = scanner.nextLine();
            System.out.println("Podaj gatunek wykonywanej muzyki: ");
            genre = scanner.nextLine();
            System.out.println("Podaj rok wydania albumu: ");
            try {
                releaseDate = scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Błąd: słowo zamiast liczby " + e);
            }
            albums.add(new Album(band, title, genre, releaseDate));

            System.out.println("Wprowadź 'T'/'t' aby dodać kolejną pozycję lub 'N'/'n' aby wrócić do MENU: ");

            s = scanner.nextLine();

        }while(s.equals("T")||s.equals("t"));

    }
}
