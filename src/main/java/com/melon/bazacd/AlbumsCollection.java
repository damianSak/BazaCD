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

    public AlbumsCollection(List<Album> albums) {
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
        Scanner scan = new Scanner(System.in);

        do {
            welcomMenu();
            line = scan.nextLine().trim();

            if (line.equals("Wczytaj") || line.equals("Wczytaj bazę")) {
                chosenDb = loadDb.loadDb();
                albums = readAlbum.read(chosenDb, StringUtils.countChar(printToConsole.heading(), '\n') + 1);
                endMessage();
                line = scan.nextLine();
            }

            if (line.equals("Dodaj") || line.equals("Dodaj album")) {
                addRecord.addRecord(albums);

                endMessage();
                line = scan.nextLine();

            }
            if (line.equals("Drukuj") || line.equals("Drukuj bazę")) {
                printToConsole.printToConsole(albums);

                endMessage();
                line = scan.nextLine();

            }

            if (line.equals("Edytuj") || line.equals("Edytuj elementy")) {
                editRecord.edit(albums);
            }

            if (line.equals("Usuń") || line.equals("Usuń z bazy")) {
                deleteRecord.deleteRecord(albums);
            }

            if (line.equals("Zapisz") || line.equals("Zapisz do pliku")) {
                saveDb.saveDb(albums);

                endMessage();
                line = scan.nextLine();


            }
            if (line.equals("Zakończ")) {
                break;
            } else {
                System.out.println("To nie jest poprawnie wybrana opcja z menu, wpisz właściwą komendę");
            }
        } while
        (line.isEmpty()||!line.toLowerCase().equals("zakończ"));
        scan.close();
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

}
