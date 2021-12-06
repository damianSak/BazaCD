package com.melon.bazacd;

import com.melon.bazacd.actions.*;
import com.melon.bazacd.model.Album;
import com.melon.bazacd.utils.ConsoleInputProvider;
import com.melon.bazacd.utils.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class AlbumsCollection {

    private File chosenDb;
    private List<Album> albums;
    private LoadDb loadDb;
    private ReadAlbum readAlbum;
    private AddRecord addRecord;
    private PrintToConsole printToConsole;
    private EditRecord editRecord;
    private DeleteRecord deleteRecord;
    private SaveDb saveDb;

    private static final String LOAD = "1";
    private static final String ADD = "2";
    private static final String PRINT = "3";
    private static final String EDIT = "4";
    private static final String DELETE = "5";
    private static final String SAVE = "6";
    private static final String EXIT = "7";

    public AlbumsCollection() {
        this(new LinkedList<>());
    }

    private AlbumsCollection(List<Album> albums) {
        initializeActions(albums);
    }

    private void initializeActions(List<Album> albums) {
        this.albums = albums;
        this.loadDb = new LoadDb();
        this.readAlbum = new ReadAlbum();
        this.addRecord = new AddRecord(albums);
        this.printToConsole = new PrintToConsole();
        this.editRecord = new EditRecord(albums);
        this.deleteRecord = new DeleteRecord(albums);
        this.saveDb = new SaveDb();
    }

    public void start() {
        String line;

        do {
            welcomeMenu();
            line = ConsoleInputProvider.readStringFromUserHandlingEmptyInput().toLowerCase();

            if (line.equals(LOAD)) {
                loadDB();
            } else if (line.equals(ADD)) {
                addRecord();
            } else if (line.equals(PRINT)) {
                printToConsole();
            } else if (line.equals(EDIT)) {
                editRecord();
            } else if (line.equals(DELETE)) {
                deleteRecord();
            } else if (line.equals(SAVE)) {
                saveDb();
            } else if (line.equals(EXIT)) {
                ConsoleInputProvider.closeScanner();
                break;
            } else {
                System.out.println("To nie jest poprawnie wybrana opcja z MENU, wpisz właściwą komendę: ");
            }
        } while ( !line.equalsIgnoreCase(EXIT));
    }

    private void endMessage() {
       ConsoleInputProvider.waitForEnterClick();
    }

    private void welcomeMenu() {
        System.out.println("---------------------------");
        System.out.println("1. Wczytaj bazę płyt");
        System.out.println("2. Dodaj album do bazy");
        System.out.println("3. Drukuj elementy bazy na konsoli");
        System.out.println("4. Edytuj elementy bazy");
        System.out.println("5. Usuń album z bazy");
        System.out.println("6. Zapisz bazę do pliku tekstowego");
        System.out.println("7. Zakończ");
        System.out.println("---------------------------");
        System.out.println("Wybierz opcję:");
    }

    private void loadDB() {
        try {
            this.chosenDb = loadDb.loadDbFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        albums = readAlbum.readAlbumsDbToList(this.chosenDb, StringUtils.countChar(printToConsole.printHeading(), '\n') + 1);
        endMessage();
    }

    private void addRecord() {
        addRecord.addRecordToDb(albums);
    }

    private void printToConsole() {
        printToConsole.printAlbumsDbOnConsole(albums);
        endMessage();
    }

    private void editRecord() {
        editRecord.editAlbumFields(albums);
    }

    private void deleteRecord() {
        deleteRecord.deleteRecordFromDb(albums);
    }

    private void saveDb() {
        try {
            saveDb.saveDbToFile(albums);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
