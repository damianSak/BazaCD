package com.melon.bazacd;

import com.melon.bazacd.actions.AlbumsCollection;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        AlbumsCollection albums=new AlbumsCollection(new LinkedList<>());
        albums.start();
    }
}