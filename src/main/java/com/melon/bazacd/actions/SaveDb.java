package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;
import com.melon.bazacd.utils.ConsoleInputProvider;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;

import static java.lang.String.format;

public class SaveDb {
    List<Album> albums;
    private static final String NEW = "Nowa";
    private static final String NEW_DB = "Nowa baza";
    private static final String ADD = "Dodaj";

    public SaveDb(List<Album> albums) {
        this.albums = albums;
    }

    public void saveDb(List<Album> albums) {
        File file;
        PrintToConsole printToConsole = new PrintToConsole(albums);
        LoadDb loadDbdir = new LoadDb();
        String fileName;
        System.out.println("Wybierz, czy chcesz zapisać aktualną bazę do nowego pliku czy dopisać dane do już istniejącej");
        System.out.println("Nowa baza/ Dodaj do istniejącej bazy");
        String line = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
        if (line.equals(NEW) || line.equals(NEW_DB)) {
            System.out.println("Podaj nazwę pliku do zapisu: ");
            do {
                fileName = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
                file = new File("D:\\java\\Baza danych płyt\\" + fileName + ".txt");
                if (file.exists()) {
                    System.out.println("Plik z podaną nazwa juz istniene, podaj inną nazwę: ");
                } else {
                    System.out.println("Utworzono nową bazę danych o nazwię " + "' " + fileName + " '");
                }
            } while (file.exists());
            try {
                FileWriter writer = new FileWriter("D:\\java\\Baza danych płyt\\" + fileName + ".txt");
                writer.write(printToConsole.heading());
                writer.write("\n");
                for (Album a : albums) {
                    writer.write(format(Locale.GERMAN, "%-25s|%-19s|%-17s| %-13s\n",
                            a.getTitle(), a.getBand(), a.getGenre(), a.getReleaseYear()));
                }
                writer.write(printToConsole.ending());
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (line.equals(ADD)) {
            loadDbdir.loadDBdir();
            System.out.println("Wybierz bazę do której mają być dodane elementy: ");
            do {
                fileName = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
                file = new File("D:\\java\\Baza danych płyt\\" + fileName + ".txt");
                if (file.exists()) {
                    System.out.println("Aktualna baza danych została dodana do " + "' " + fileName + " '");
                } else {
                    System.out.println("Niepoprawna nazwa pliku, podaj właściwą");
                }

            } while (!file.exists());

            try {
                List<String> readedLines = Files.readAllLines(Path.of(file.getPath()));
                List<String> reprintedLines = readedLines.subList(0, readedLines.size() - 1);
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                for (String s : reprintedLines) {
                    bw.write(s + "\n");
                }
                for (Album a : albums) {
                    bw.write(format("%-25s|%-19s|%-17s| %-13s\n",
                            a.getTitle(), a.getBand(), a.getGenre(), a.getReleaseYear()));
                }
                bw.write(printToConsole.ending());
                bw.close();
            } catch (IOException e) {
                System.out.println("Błąd IO" + e);
            }
        }

    }
}

