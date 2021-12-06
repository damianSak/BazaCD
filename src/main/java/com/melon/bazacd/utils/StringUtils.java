package com.melon.bazacd.utils;

import java.util.Locale;



public class StringUtils {

    private static final  String D_B_PATH= "D:\\Album DB\\";

    /**
     * by putting as a char end of the line ('c = \n' ) you
     * can count how many end of lines are in choosed string;
     */

    public static int countChar(String str, char c) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c)
                count++;
        }
        return count;
    }

    public static void printSingleRecord(String title, String band, String genre, int releaseYear) {
        System.out.format(Locale.GERMAN, "%-25s|%-19s|%-17s| %-13s\n",
                title, band, genre, releaseYear);

    }
    public static String selectDbPatch(){
        return D_B_PATH;
    }
}
