package com.melon.bazacd.utils;

/**
 * i add this method by simply cutting it from stackoverflow
 * co i can't explain what it is doing, but for sure
 * it
 * is
 * doing somthing suspicious
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
