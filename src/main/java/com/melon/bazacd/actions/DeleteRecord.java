package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;
import com.melon.bazacd.utils.ConsoleInputProvider;
import com.melon.bazacd.utils.Messages;

import java.util.*;

public class DeleteRecord {
    
    List<Album> albums;

    PrintToConsole printToConsole;

    public DeleteRecord(List<Album> albums) {
        this.albums = albums;
        this.printToConsole = new PrintToConsole(albums);
    }
    
    public void deleteRecord(List<Album> albums) {
        String albumTitle;
        String userChoice;
        List<Album> albumsToRemove = new LinkedList<>();
        boolean  isUserInputCorrect = true;

        do {
            System.out.println(" Wpisz nazwę poszukiwanego albumu: ");
            albumTitle = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();

            System.out.println("Znalezione pozycje w liście albumów: \n");
            for (Album a : albums) {
                if (a.getTitle().equals(albumTitle)) {
                    System.out.println(printToConsole.heading());
                    Messages.printSingleRecord(a.getTitle(), a.getBand(), a.getGenre(), a.getReleaseYear());
                    System.out.println("\n" + "Czy na pewno chcesz usunąć ten album z listy ? Wybierz T/t by usunąć lub N/n aby " +
                            "zobaczyć kolejną znalezioną pozycję ");
                    userChoice = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
                    if (userChoice.toLowerCase().equals("t")) {
                        albumsToRemove.add(a);
                    }
                } else {
                    isUserInputCorrect = false;
                }
            }
            if (!isUserInputCorrect) {
                System.out.println("Nie ma takiego albumu, błąd pisowni lub nie wczytano właściwej listy albumów\n");
            }
            albums.removeAll(albumsToRemove);
            albumsToRemove.clear();

            Messages.showEndingChooseMessage("spróbować usunąć kolejny album");
            userChoice = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
        } while (userChoice.toLowerCase().equals("t"));

    }
}
