package com.blind_falcon.onlyplayer.model;

public class Song {
    private String title;
    private Artist artist;
    private Album album;
    private int bitrate;
    private long playTime;
    private int fileSize;
    private String filePath;

    private Song(Builder builder) {
        this.title = builder.title;
        this.artist = builder.artist;
        this.album = builder.album;
        this.bitrate = builder.bitrate;
        this.playTime = builder.playTime;
        this.fileSize = builder.fileSize;
        this.filePath = builder.filePath;
    }

    public String getTitle() {
        return title;
    }

    public Artist getArtist() {
        return artist;
    }

    public Album getAlbum() {
        return album;
    }

    public int getBitrate() {
        return bitrate;
    }

    public long getPlayTime() {
        return playTime;
    }

    public int getFileSize() {
        return fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public static class Builder {
        private String title;
        private Artist artist;
        private Album album;
        private int bitrate;
        private long playTime;
        private int fileSize;
        private String filePath;

        public Builder(String title) {
            this.title = title;
        }

        public Builder setArtist(Artist artist) {
            this.artist = artist;
            return this;
        }

        public Builder setAlbum(Album album) {
            this.album = album;
            return this;
        }

        public Builder setBitrate(int bitrate) {
            this.bitrate = bitrate;
            return this;
        }

        public Builder setPlayTime(long playTime) {
            this.playTime = playTime;
            return this;
        }

        public Builder setFilesize(int fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        public Builder setFilePath(String filePath) {
            this.filePath = filePath;
            return this;
        }

        public Song build() {
            return new Song(this);
        }
    }
}
