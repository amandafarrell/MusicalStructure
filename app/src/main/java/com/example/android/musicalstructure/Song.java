package com.example.android.musicalstructure;

public class Song {
    private String songTitle;
    private String artistName;

    public Song(String song, String artist) {
        songTitle = song;
        artistName = artist;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public String getArtistName() {
        return artistName;
    }
}
