package com.melon.bazacd.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    private String string;


    @Test
    void countChar_should_returnCorrectCountNumber_when_properStringAndCharAreGiven() {

        //given

        String string = "abcd ABCD";
        char c = 'a';
        int expectedCount = 1;

        //when
        int result = StringUtils.countChar(string,c);
        assertEquals(expectedCount,result);

    }

    @Test
    void countChar_shouldNot_returnCorrectCountNumber_when_properStringAndImproperCharAreGiven() {

        //given

        String string = "abcd ABCD";
        char c = '\n';
        int expectedCount = 0;

        //when
        int result = StringUtils.countChar(string,c);
        assertEquals(expectedCount,result);

    }

}