package com.melon.bazacd.model;

public class Album {

    private String band;
    private String title;
    private String genre;
    private String releaseDate;

    public Album(String band, String title, String genre, String releaseDate) {
        this.band = band;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
