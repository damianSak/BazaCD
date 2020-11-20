package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;
import com.melon.bazacd.utils.ConsoleInputProvider;
import com.melon.bazacd.utils.Messages;

import java.util.List;

public class EditRecord {
    List<Album> albums;


    public EditRecord(List<Album> albums) {
        this.albums = albums;
    }

    public void edit(List<Album> albums) {

        PrintToConsole printToConsole = new PrintToConsole(albums);
        String selectedAlbum;
        String userChoice;
        int albumSize = albums.size();

        do {
            int albumValidation = albumSize;
            System.out.println("Wpisz tytuł albumu, którego elementy chciałbyś edytować: ");
            selectedAlbum = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
            for (Album album : albums) {
                if (selectedAlbum.equals(album.getTitle())) {
                    System.out.println("Wyszukano rekord: ");
                    System.out.println(printToConsole.heading());
                    Messages.printSingleRecord(album.getTitle(), album.getBand(), album.getGenre(), album.getReleaseYear());
                    System.out.println(printToConsole.ending());
                    System.out.println("Wybierz pozycję do zmiany: ");
                    userChoice = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
                    do {
                        switch (userChoice) {
                            case "Tytuł":
                                System.out.println("Podaj nowy tytuł albumu:");
                                String oldTitle = album.getTitle();
                                String newAlbumTitle = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
                                album.setTitle(newAlbumTitle);
                                Messages.showMessageEndOfFieldEdit(oldTitle, newAlbumTitle);
                                break;

                            case "Wykonawca":
                                System.out.println("Podaj nowego wykonawcę albumu:");
                                String oldBandName = album.getBand();
                                String newBandName = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
                                album.setBand(newBandName);
                                Messages.showMessageEndOfFieldEdit(oldBandName, newBandName);
                                break;

                            case "Gatunek":
                                System.out.println("Podaj nowy gatunek muzyki na albumie:");
                                String oldGenre = album.getGenre();
                                String newGenreName = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
                                album.setGenre(newGenreName);
                                Messages.showMessageEndOfFieldEdit(oldGenre, newGenreName);
                                break;

                            case "Rok Wydania":
                                System.out.println("Podaj nowy rok wydania albumu:");
                                int oldReleaseYear = album.getReleaseYear();
                                int newReleaseYear = ConsoleInputProvider.readIntFromUserHandlingEmptyInput();
                                album.setReleaseYear(newReleaseYear);
                                Messages.showMessageEndOfFieldEdit(String.valueOf(oldReleaseYear), String.valueOf(newReleaseYear));
                                break;

                            default:
                                System.out.println("Nazwa pozycji do zmiany nie była poprawna, podaj właściwą nazwę lub wprowadź " +
                                        "'NEXT/next' aby przejść do kolejnego rekordu lub wyjść jeśli nie będzie ich wiecej: ");
                                break;
                        }
                        userChoice = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
                    } while (!userChoice.toLowerCase().equals("next"));

                } else {
                    albumValidation--;
                }
            }
            if (albumValidation == 0) {
                System.out.println("Nie ma takiego albumu lub błąd pisowni");
            }

            Messages.showEndingChooseMessage("aby wyszukać i edytować kolejne albumy");
            userChoice = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
        } while (userChoice.toLowerCase().equals("t"));

    }
}
