package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Edit {
    PrintToConsole printToConsole = new PrintToConsole();

    Scanner scan = new Scanner(System.in);
    String lines = " ";

    public List<Album> edit(List<Album> albums) {
        List<Album> wrongTitle = new LinkedList<>();
        do {
            System.out.println("Wpisz tytuł albumu, którego elementy chciałbyś edytować: ");
            lines = scan.nextLine().trim();
                for (Album a : albums) {
                    if (lines.equals(a.getTitle())) {
                        System.out.println("Wyszukano rekord: ");
                        System.out.println(printToConsole.heading());
                        System.out.format(Locale.GERMAN, "%-25s|%-19s|%-17s| %-13s\n",
                                a.getTitle(), a.getBand(), a.getGenre(), a.getReleaseDate());
                        System.out.println("Wybierz pozycję do zmiany: ");
                        String line2 = scan.nextLine();
                        if (line2.equals("Tytuł")) {
                            System.out.println("Podaj nowy tytuł albumu:");
                            String line3 = scan.nextLine();
                            System.out.println("Zmieniono " + a.getTitle() + " na " + line3);
                            a.setTitle(line3);
                        }
                        if (line2.equals("Wykonawca")) {
                            System.out.println("Podaj nowego wykonawcę albumu:");
                            String line3 = scan.nextLine();
                            System.out.println("Zmieniono " + a.getBand() + " na " + line3);
                            a.setBand(line3);
                        }
                        if (line2.equals("Gatunek")) {
                            System.out.println("Podaj nowy gatunek muzyki na albumie:");
                            String line3 = scan.nextLine();
                            System.out.println("Zmieniono " + a.getGenre() + " na " + line3);
                            a.setGenre(line3);
                        }
                        if (line2.equals("Rok Wydania")) {
                            System.out.println("Podaj nowy rok wydania albumu:");
                            String line3 = scan.nextLine();
                            System.out.println("Zmieniono " + a.getReleaseDate() + " na " + line3);
                            a.setReleaseDate(line3);
                        }

                    } else {
                        wrongTitle.add(a);
                    }
                }
                if (albums.size()==wrongTitle.size()) {
                    System.out.println("Nie ma takiego albumu lub błąd pisowni");
                }

            System.out.println("Wprowadź 'T/t' aby wyszukać i edytować kolejne albumy lub EXIT aby wrócić do MENU: ");
            lines = scan.nextLine();
        } while (lines.equals("T")||lines.equals("t"));
        return albums;
    }
}
