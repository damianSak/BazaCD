package com.melon.bazacd.utils;

public class Messages {

    public static void showEndingChooseMessage(String specificAction) {
        System.out.println("Wprowadź 'T/t' aby " + specificAction + " lub 'N/n' i wciśnij ENTER aby wrócić do MENU: ");
    }

    public static void showMessageEndOfFieldEdit(String oldString, String newString) {
        System.out.println("Zmieniono '" + oldString + "' na '" + newString + "'\nwprowadź nazwę kolejnego pola do edycji lub wprowadź 'NEXT/next' " +
                "aby przejść do kolejnego znalezionego rekordu lub wyjść:");
    }

}
