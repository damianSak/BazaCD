package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class EditRecord {
    PrintToConsole printToConsole = new PrintToConsole();


    public void edit(List<Album> albums) {

        try (Scanner scan = new Scanner(System.in)) {
            String line;
            int number;
            boolean isThereAWrongTitleInput = false;

            do {
                System.out.println("Wpisz tytuł albumu, którego elementy chciałbyś edytować: ");
                line = scan.nextLine().trim();
                for (Album a : albums) {
                    if (line.equals(a.getTitle())) {
                        System.out.println("Wyszukano rekord: ");
                        System.out.println(printToConsole.heading());
                        System.out.format(Locale.GERMAN, "%-25s|%-19s|%-17s| %-13s\n",
                                a.getTitle(), a.getBand(), a.getGenre(), a.getReleaseDate());
                        System.out.println("Wybierz pozycję do zmiany: ");
                        line = scan.nextLine();
                        if (line.equals("Tytuł")) {
                            System.out.println("Podaj nowy tytuł albumu:");
                            String line3 = scan.nextLine();
                            System.out.println("Zmieniono " + a.getTitle() + " na " + line3);
                            a.setTitle(line3);
                        }
                        if (line.equals("Wykonawca")) {
                            System.out.println("Podaj nowego wykonawcę albumu:");
                            String line3 = scan.nextLine();
                            System.out.println("Zmieniono " + a.getBand() + " na " + line3);
                            a.setBand(line3);
                        }
                        if (line.equals("Gatunek")) {
                            System.out.println("Podaj nowy gatunek muzyki na albumie:");
                            String line3 = scan.nextLine();
                            System.out.println("Zmieniono " + a.getGenre() + " na " + line3);
                            a.setGenre(line3);
                        }
                        if (line.equals("Rok Wydania")) {
                            System.out.println("Podaj nowy rok wydania albumu:");
                            number = scan.nextInt();
                            System.out.println("Zmieniono " + a.getReleaseDate() + " na " + number);
                            a.setReleaseDate(number);
                        }
                    } else {
                        isThereAWrongTitleInput = true;
                    }
                }
                if (isThereAWrongTitleInput) {
                    System.out.println("Nie ma takiego albumu lub błąd pisowni");
                }

                System.out.println("Wprowadź 'T/t' aby wyszukać i edytować kolejne albumy lub wciśnij ENTER aby wrócić do MENU: ");
                line = scan.nextLine();
            } while (line.toLowerCase().equals("t"));
        }
    }
}
