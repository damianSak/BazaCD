package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DeleteRecord {

    private String line = " ";
    private List<Album> albumsToRemove = new LinkedList<>();

    Scanner scanner = new Scanner(System.in);
    PrintToConsole printToConsole = new PrintToConsole();

    public List<Album> deleteRecord(List<Album> albums) {
        do {
            System.out.println(" Wpisz nazwę poszukiwanego albumu lub 'EXIT' aby wrócić do MENU: " + "\n");
            line = scanner.nextLine();
            List<Album> wrongAlbums = new LinkedList<>();
            if (!line.equals("EXIT")) {
                System.out.println("Znalezione pozycja w liście albumów: \n");
                for (Album a : albums) {
                    if (a.getTitle().equals(line)) {
                        System.out.println(printToConsole.heading());
                        System.out.format(Locale.GERMAN, "%-25s|%-19s|%-17s| %-13s\n",
                                a.getTitle(), a.getBand(), a.getGenre(), a.getReleaseDate());
                        System.out.println("\n" + "Czy na pewno chcesz usunąć ten album z listy ? Wybierz T/t by usunąć lub N/n aby " +
                                "zobaczyć kolejną znalezioną pozycję lub powrócić do wyszukiwania ");
                        String line2 = scanner.nextLine();
                        if (line2.equals("T") || line2.equals("t")) {
                            albumsToRemove.add(a);
                        }
                    } else {
                        wrongAlbums.add(a);
                    }
                }
                if (wrongAlbums.size() == albums.size()) {
                    System.out.println("Nie ma takiego albumu, błąd pisowni lub nie wczytano żadnej listy albumów\n");
                }
                albums.removeAll(albumsToRemove);
            }
        } while (!line.equals("EXIT"));
        System.out.println("Zakończono usuwanie wybranych rekordów z kolekcji");
        return albums;
    }
}
