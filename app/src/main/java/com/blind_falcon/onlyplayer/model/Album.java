package com.blind_falcon.onlyplayer.model;

public class Album {
    private String title;
    private String cover;
    private int yearOfRelease;

    public Album(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }
}
