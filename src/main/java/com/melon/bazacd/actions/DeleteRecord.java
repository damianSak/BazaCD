package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;

import java.util.*;

public class DeleteRecord {

    PrintToConsole printToConsole = new PrintToConsole();

    public void deleteRecord(List<Album> albums) {
        String line = " ";
        Scanner scanner = new Scanner(System.in);
        List<Album> albumsToRemove = new LinkedList<>();
        List<Album> wrongAlbums = new LinkedList<>();
        do {
            System.out.println(" Wpisz nazwę poszukiwanego albumu lub 'EXIT' aby wrócić do MENU: " + "\n");
            line = scanner.nextLine();

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
                        if (line2.toLowerCase().equals("t")) {
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
    }
}
