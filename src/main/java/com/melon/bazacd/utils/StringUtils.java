package com.melon.bazacd.utils;

/**
 * by putting as a 'c = \n' (end of the line) you
 * can count how many rows are for example in heading ended by that way
 */

public class StringUtils {

    public static int countChar(String str, char c)
    {
        int count = 0;

        for(int i=0; i < str.length(); i++)
        {    if(str.charAt(i) == c)
            count++;
        }

        return count;
    }
}
