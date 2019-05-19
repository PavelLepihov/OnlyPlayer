package com.blind_falcon.onlyplayer.model;

public class Album {
    private String title;
    private String cover;
    private String yearOfRelease;

    public Album(String title, String cover, String yearOfRelease) {
        //TODO: remove with resources
        this.title = title != null ? title : "Unknown album";
        this.cover = cover;
        this.yearOfRelease = yearOfRelease != null ? yearOfRelease : "";
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }
}
