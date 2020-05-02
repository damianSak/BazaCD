package com.melon.bazacd.actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoadDb {

    protected void loadDBdir(){
        File file;
        file = new File("D:\\java\\Baza danych płyt");
        String[] dirList = file.list();
        System.out.println("Zawartość katalogu baz Płyt:");
        for (int i = 0; i < dirList.length; i++) {
            System.out.println(dirList[i]);
        }
    }
    public File loadDb() {
        File file;
        loadDBdir();
        System.out.println("\n Wybierz bazę do wczytania:");
        try (Scanner scanner = new Scanner(System.in)) {
            do {
                String s = scanner.nextLine();
                file = new File("D:\\java\\Baza danych płyt\\" + s + ".txt");
                if (file.exists()) {
                    try (Scanner scan = new Scanner(file)){
                        while (scan.hasNext()) {
                            System.out.println(scan.nextLine());
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Niepoprawna nazwa pliku do odczytu, podaj właściwą");
                }
            } while (!file.exists());

            return file;
        }
    }
}
