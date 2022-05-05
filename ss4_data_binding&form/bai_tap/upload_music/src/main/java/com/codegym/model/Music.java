package com.codegym.model;

public class Music {
    private String nameSong;
    private String artist;
    private String type;
    private String link;

    public Music() {
    }

    public Music(String nameSong, String artist, String type, String link) {
        this.nameSong = nameSong;
        this.artist = artist;
        this.type = type;
        this.link = link;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
