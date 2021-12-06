package com.melon.bazacd.actions;

import com.melon.bazacd.utils.ConsoleInputProvider;
import com.melon.bazacd.utils.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoadDb {

    private String dbPath = StringUtils.selectDbPatch();
    private PrintToConsole printToConsole = new PrintToConsole();

    void createDBFolder(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    void createEmptyDB(File dbName) throws IOException {

        try(FileWriter writer = new FileWriter(dbName)) {

            writer.write(printToConsole.printHeading());
            writer.write("\n");
            writer.write(printToConsole.printEnding());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void loadDBDir() throws IOException {
        File file = new File(dbPath);
        createDBFolder(file);
        String[] dirList = file.list();
        if (dirList.length == 0) {
            File newFile = new File(dbPath + "\\EmptyInitList.txt");
            createEmptyDB(newFile);
            dirList = file.list();
        }
        for (int i = 0; i < dirList.length; i++) {
            System.out.println(dirList[i]);
        }
    }

    private void dbReader(File dbFile) {
        try (Scanner scan = new Scanner(dbFile)) {
            while (scan.hasNext()) {
                System.out.println(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public File loadDbFromFile() throws IOException {
        File file;
        System.out.println("\nZawartość katalogu z Bazami Płyt:\n");
        loadDBDir();
        System.out.println("\nWybierz bazę do wczytania:");

        do {
            String dbName = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
            file = new File(dbPath + "\\" + dbName + ".txt");
            if (file.exists()) {
                dbReader(file);
            } else {
                System.out.println("Niepoprawna nazwa pliku do odczytu, podaj właściwą nazwę:");
            }
        } while (!file.exists());

        return file;
    }
}

