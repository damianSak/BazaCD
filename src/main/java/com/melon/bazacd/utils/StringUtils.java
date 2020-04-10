package com.melon.bazacd.utils;

/**
 * it's doing somthing suspicious
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
