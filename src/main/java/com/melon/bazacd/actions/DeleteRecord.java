package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;
import com.melon.bazacd.utils.ConsoleInputProvider;
import com.melon.bazacd.utils.Messages;
import com.melon.bazacd.utils.StringUtils;

import java.util.*;

public class DeleteRecord {

    private List<Album> albums;

    private PrintToConsole printToConsole;

    public DeleteRecord(List<Album> albums) {
        this.albums = albums;
        this.printToConsole = new PrintToConsole();
    }

    private boolean isAlbumInCollectionValidation(List<Album> albums, final String title) {
        return albums.stream().anyMatch(h ->
                h.getTitle().equals(title));
    }

    private List<Album> createListOfAlbumsToDelete(List<Album> albums, String selectedTitle) {
        List<Album> albumsToDelete = new LinkedList<>();
        for (Album album : albums) {
            if (album.getTitle().equals(selectedTitle)) {
                albumsToDelete.add(album);
            }
        }
        return albumsToDelete;
    }

    public void deleteRecordFromDb(List<Album> albums) {
        String albumTitle;
        String userChoice;
        List<Album> albumsToDelete;
        List<Album> albumsToRemove = new LinkedList<>();

        do {
            System.out.println("Wpisz nazwę poszukiwanego albumu: ");
            albumTitle = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
            if (isAlbumInCollectionValidation(albums, albumTitle)) {
                albumsToDelete = createListOfAlbumsToDelete(albums, albumTitle);
                for (Album foundedAlbum : albumsToDelete) {
                    System.out.println("Znaleziona pozycja w liście albumów: \n");
                    System.out.println(printToConsole.printHeading());
                    StringUtils.printSingleRecord(foundedAlbum.getTitle(), foundedAlbum.getBand(), foundedAlbum.getGenre(), foundedAlbum.getReleaseYear());
                    System.out.println("\n" + "Czy na pewno chcesz usunąć ten album z listy ? Wybierz T/t by usunąć lub N/n aby " +
                            "zobaczyć kolejną znalezioną pozycję lub wyjść jeśli nie ma ich więcej: ");
                    userChoice = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
                    if (userChoice.equalsIgnoreCase("t")) {
                        albumsToRemove.add(foundedAlbum);
                    }
                }
                albums.removeAll(albumsToRemove);
                albumsToRemove.clear();
            } else {
                System.out.println("Nie ma takiego albumu, błąd pisowni lub nie wczytano właściwej listy albumów\n");
            }
            Messages.showEndingChooseMessage("spróbować usunąć kolejny album");
            userChoice = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
        } while (userChoice.equalsIgnoreCase("t"));
    }
}
