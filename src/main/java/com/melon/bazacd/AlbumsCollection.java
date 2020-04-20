package com.melon.bazacd;

import com.melon.bazacd.actions.*;
import com.melon.bazacd.model.Album;
import com.melon.bazacd.utils.StringUtils;

import java.io.File;
import java.util.List;
import java.util.Scanner;

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

    private static final String LOAD = "Wczytaj";
    private static final String LOAD_DB = "Wczytaj bazę";
    private static final String ADD = "Dodaj";
    private static final String ADD_ALBUM = "Dodaj album";
    private static final String PRINT = "Drukuj";
    private static final String PRINT_DB = "Drukuj bazę";
    private static final String EDIT = "Edytuj";
    private static final String EDIT_ELEMENTS = "Edytuj elementy";
    private static final String DELETE = "Usuń";
    private static final String DELETE_FROM_DB = "Usuń z bazy";
    private static final String SAVE = "Zapisz";
    private static final String SAVE_TO_FILE = "Zapisz do pliku";
    private static final String EXIT = "Zakończ";

    public AlbumsCollection(List<Album> albums) {
        initializeActions(albums);
    }

    private void initializeActions(List<Album> albums) {
        this.albums = albums;
        this.loadDb = new LoadDb();
        this.readAlbum = new ReadAlbum();
        this.addRecord = new AddRecord();
        this.printToConsole = new PrintToConsole();
        this.editRecord = new EditRecord();
        this.deleteRecord = new DeleteRecord();
        this.saveDb = new SaveDb();
    }

    public void start() {
        String line = " ";
        try (Scanner scan = new Scanner(System.in)) {
            do {
                welcomMenu();
                line = scan.nextLine().trim();

                if (line.equals(LOAD) || line.equals(LOAD_DB)) {
                    loadDB();
                }
                if (line.equals(ADD) || line.equals(ADD_ALBUM)) {
                    addRecord();
                }
                if (line.equals(PRINT) || line.equals(PRINT_DB)) {
                    printToConsole();
                }
                if (line.equals(EDIT) || line.equals(EDIT_ELEMENTS)) {
                    editRecord();
                }
                if (line.equals(DELETE) || line.equals(DELETE_FROM_DB)) {
                    deleteRecord();
                }
                if (line.equals(SAVE) || line.equals(SAVE_TO_FILE)) {
                    saveDb();
                }
                if (line.equals(EXIT)) {
                    break;
                } else {
                    System.out.println("To nie jest poprawnie wybrana opcja z MENU, wpisz właściwą komendę");
                }
            } while
            (line.isEmpty() || !line.toLowerCase().equals(EXIT));
        }
    }

    private void endMessage() {
        System.out.println("Wybrana operacja została zakończona, wciśnij ENTER aby powrócić do głównego menu");
    }

    private void welcomMenu() {
        System.out.println("---------------------------");
        System.out.println("1. Wczytaj bazę płyt");
        System.out.println("2. Dodaj album do bazy");
        System.out.println("3. Drukuj bazę na konsoli");
        System.out.println("4. Edytuj elementy bazy");
        System.out.println("5. Usuń album z bazy");
        System.out.println("6. Zapisz bazę do pliku");
        System.out.println("7. Zakończ");
        System.out.println("---------------------------");
        System.out.println("Wybierz opcję:");
    }

    private void loadDB() {
        chosenDb = loadDb.loadDb();
        albums = readAlbum.read(chosenDb, StringUtils.countChar(printToConsole.heading(), '\n') + 1);
        endMessage();
        System.out.println(" ");
    }

    private void addRecord() {
        addRecord.addRecord(albums);
        endMessage();
        System.out.println(" ");
    }

    private void printToConsole() {
        printToConsole.printToConsole(albums);
        endMessage();
        System.out.println(" ");
    }

    private void editRecord() {
        editRecord.edit(albums);
    }

    private void deleteRecord() {
        deleteRecord.deleteRecord(albums);
    }

    private void saveDb() {
        saveDb.saveDb(albums);
        endMessage();
        System.out.println(" ");
    }

}
