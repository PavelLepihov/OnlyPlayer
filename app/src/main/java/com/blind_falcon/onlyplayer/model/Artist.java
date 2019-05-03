package com.blind_falcon.onlyplayer.model;

public class Artist {
    private String name;
    private String image;

    public Artist() {
        //TODO: remove with resources
        this.name = "Unknown artist";
        this.image = "default placeholder";
    }

    public Artist(String name) {
        this.name = name;
        //TODO: remove with resources
        this.image = "default placeholder";
    }

    public Artist(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
