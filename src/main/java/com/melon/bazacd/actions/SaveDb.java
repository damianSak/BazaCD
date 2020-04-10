package com.melon.bazacd.actions;

import com.melon.bazacd.model.Album;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.String.format;

public class SaveDb {

    public void saveDb(List<Album> albums) {
        File file;
        PrintToConsole printToConsole = new PrintToConsole();
        LoadDb loadDbdir = new LoadDb();
        String nazwaPliku;
        Scanner scan = new Scanner(System.in);

        System.out.println("Wybierz, czy chcesz zapisać aktualną bazę do nowego pliku czy dopisać dane do już istniejącej");
        System.out.println("Nowa baza/ Dodaj do istniejącej bazy");
        String line = scan.nextLine();
        if (line.equals("Nowa baza") || line.equals("Nowa")) {
            System.out.println("Podaj nazwę pliku do zapisu: ");

            do {
                nazwaPliku = scan.nextLine();
                file = new File("D:\\java\\Baza danych płyt\\" + nazwaPliku + ".txt");
                if (file.exists()) {
                    System.out.println("Plik z podaną nazwa juz istniene, podaj inną nazwę: ");
                } else {
                    System.out.println("Utworzono nową bazę danych o nazwię " + "' " + nazwaPliku + " '");
                }
            } while (file.exists());
            try {
                FileWriter writer = new FileWriter("D:\\java\\Baza danych płyt\\" + nazwaPliku + ".txt");

                writer.write(printToConsole.heading());
                writer.write("\n");
                for (Album a : albums) {
                    writer.write(format(Locale.GERMAN, "%-25s|%-19s|%-17s| %-13s\n",
                            a.getTitle(), a.getBand(), a.getGenre(), a.getReleaseDate()));
                }
                writer.write(printToConsole.ending());
                writer.close();
            } catch (IOException e) {
                System.out.println("Łapiem coronawirusa" + e);
            }
        }
        if (line.equals("Dodaj do istniejącej bazy") || line.equals("Dodaj")) {
            loadDbdir.loadDBdir();
            System.out.println("Wybierz bazę do której mają być dodane elementy: ");
            do {
                nazwaPliku = scan.nextLine();
                file = new File("D:\\java\\Baza danych płyt\\" + nazwaPliku + ".txt");
                if (file.exists()) {
                    System.out.println("Aktualna baza danych została dodana do " + "' " + nazwaPliku + " '");
                } else {
                    System.out.println("Niepoprawna nazwa pliku, podaj właściwą");
                }
            } while (!file.exists());
            try {
                List<String> readedLines = Files.readAllLines(Path.of(file.getPath()));
                List<String> reprintedLines=readedLines.subList(0,readedLines.size()-1);
                BufferedWriter bw=new BufferedWriter(new FileWriter(file));
                for(String s:reprintedLines){
                    bw.write(s+"\n");
                }
                for (Album a : albums) {
                    bw.write(String.format("%-25s|%-19s|%-17s| %-13s\n",
                            a.getTitle(), a.getBand(), a.getGenre(), a.getReleaseDate()));
                }
                bw.write(printToConsole.ending());
                bw.close();
                } catch (IOException e) {
                    System.out.println("Błąd IO" + e);
            }
        }
    }
}
