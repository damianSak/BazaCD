package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;

import java.util.*;

public class DeleteRecord {

    PrintToConsole printToConsole = new PrintToConsole();
    List<Album> albums;

    public DeleteRecord(List<Album> albums) {
        this.albums = albums;
    }

    public void deleteRecord() {
        String line;
        List<Album> albumsToRemove = new LinkedList<>();
        boolean isUserInputCorrect = true;

        try (Scanner scanner = new Scanner(System.in)) {

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
                            line = scanner.nextLine();
                            if (line.toLowerCase().equals("t")) {
                                albumsToRemove.add(a);
                            }
                        } else {
                            isUserInputCorrect=false;
                        }
                    }
                    if (!isUserInputCorrect ) {
                        System.out.println("Nie ma takiego albumu, błąd pisowni lub nie wczytano żadnej listy albumów\n");
                    }
                    albums.removeAll(albumsToRemove);
                    albumsToRemove.clear();
                }
            } while (!line.equals("EXIT"));
            System.out.println("Zakończono usuwanie wybranych rekordów z kolekcji");
        }
    }
}
