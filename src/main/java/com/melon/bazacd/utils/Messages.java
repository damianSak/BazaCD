package com.melon.bazacd.utils;

import java.util.Locale;

public class Messages {
    public static void showEndingChooseMessage(String specificAction) {
        System.out.println("Wprowadź 'T/t' aby " + specificAction + " lub 'N/n' i wciśnij ENTER aby wrócić do MENU: ");
    }

    public static void showMessageEndOfFieldEdit(String oldName, String newName) {
        System.out.println("Zmieniono '" + oldName + "' na '" + newName + "'\nwprowadź nazwę kolejnego pola do edycji lub wprowadź 'NEXT/next' " +
                "aby przejść do kolejnego znalezionego rekordu lub wyjść:");
    }
    public static void printSingleRecord(String title, String band, String genre, int releaseYear){
        System.out.format(Locale.GERMAN, "%-25s|%-19s|%-17s| %-13s\n",
                title, band, genre, releaseYear);
    }
}
