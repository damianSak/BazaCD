package com.melon.bazacd.actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadDb {

    private Scanner scanner = new Scanner(System.in);
    private File file;

    protected void loadDBdir(){
        file = new File("D:\\java\\Baza danych płyt");
        String[] dirList = file.list();
        System.out.println("Zawartość katalogu baz Płyt:");
        for (int i = 0; i < dirList.length; i++) {
            System.out.println(dirList[i]);
        }
    }
    public File loadDb() {
      loadDBdir();
        System.out.println("\n Wybierz bazę do wczytania:");
        String s;

        do {
            s = scanner.nextLine();
            file = new File("D:\\java\\Baza danych płyt\\" + s+".txt");

            if (file.exists()) {
                try {
                    Scanner scan = new Scanner(file);
                    while (scan.hasNext()) {
                        System.out.println(scan.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("Niepoprawna nazwa pliku do odczytu, podaj właściwą");
            }
        } while (!file.exists());

        return file;
    }
}
