package com.blind_falcon.onlyplayer.model;

public class Artist {
    private final String name;
    private final String image;

    public Artist(String name, String image) {
        //TODO: remove with resources
        this.name = name != null ? name : "Unknown artist";
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
