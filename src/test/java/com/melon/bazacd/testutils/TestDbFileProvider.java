package com.melon.bazacd.testutils;

import java.io.File;
import java.net.URL;

public class TestDbFileProvider {

    public static File getCorrectDb(){
        URL url = Thread.currentThread().getContextClassLoader().getResource("testdb.txt");
        return new File(url.getPath());
    }
}
