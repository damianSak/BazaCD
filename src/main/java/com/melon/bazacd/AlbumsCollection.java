package com.melon.bazacd;

import com.melon.bazacd.actions.*;
import com.melon.bazacd.model.Album;
import com.melon.bazacd.utils.ConsoleInputProvider;
import com.melon.bazacd.utils.StringUtils;

import java.io.File;
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

    private static final String LOAD = "wczytaj";
    private static final String LOAD_DB = "wczytaj bazę";
    private static final String ADD = "dodaj";
    private static final String ADD_ALBUM = "dodaj album";
    private static final String PRINT = "drukuj";
    private static final String PRINT_DB = "drukuj bazę";
    private static final String EDIT = "edytuj";
    private static final String EDIT_ELEMENTS = "edytuj elementy";
    private static final String DELETE = "usuń";
    private static final String DELETE_FROM_DB = "usuń z bazy";
    private static final String SAVE = "zapisz";
    private static final String SAVE_TO_FILE = "zapisz do pliku";
    private static final String EXIT = "zakończ";

    public AlbumsCollection() {
        this(new LinkedList<>());
    }

    public AlbumsCollection(List<Album> albums) {
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
            welcomMenu();
            line = ConsoleInputProvider.readStringFromUserHandlingEmptyInput().toLowerCase();

            if (line.equals(LOAD) || line.equals(LOAD_DB)) {
                loadDB();
            } else if (line.equals(ADD) || line.equals(ADD_ALBUM)) {
                addRecord();
            } else if (line.equals(PRINT) || line.equals(PRINT_DB)) {
                printToConsole();
            } else if (line.equals(EDIT) || line.equals(EDIT_ELEMENTS)) {
                editRecord();
            } else if (line.equals(DELETE) || line.equals(DELETE_FROM_DB)) {
                deleteRecord();
            } else if (line.equals(SAVE) || line.equals(SAVE_TO_FILE)) {
                saveDb();
            } else if (line.equals(EXIT)) {
                ConsoleInputProvider.closeScanner();
                break;
            } else {
                System.out.println("To nie jest poprawnie wybrana opcja z MENU, wpisz właściwą komendę: ");
            }
        } while ( !line.toLowerCase().equals(EXIT));
    }


    private void endMessage() {

       ConsoleInputProvider.waitForPresedEnter();
    }

    private void welcomMenu() {
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
        chosenDb = loadDb.loadDbInterface();
        albums = readAlbum.readAlbumsDb(chosenDb, StringUtils.countChar(printToConsole.printHeading(), '\n') + 1);
        endMessage();
    }

    private void addRecord() {
        addRecord.addRecordToDbInterface(albums);
    }

    private void printToConsole() {
        printToConsole.printToConsole(albums);
        endMessage();
    }

    private void editRecord() {
        editRecord.editAlbumFieldsInterface(albums);
    }

    private void deleteRecord() {
        deleteRecord.deleteRecordInterface(albums);
    }

    private void saveDb() {
        saveDb.saveDbInterface(albums);

    }

}
