package com.example.mytunes;

public class MyTunesTable {
    private String artistname;
    private String songname;
    private String duration;
    private String genre;

    public MyTunesTable(String artistname, String songname, String duration, String genre) {
        this.artistname = artistname;
        this.songname = songname;
        this.duration = duration;
        this.genre = genre;
    }

    public String getArtistname() {
        return artistname;
    }

    public String getSongname() {
        return songname;
    }

    public String getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "MyTunesTable{" +
                "artistname='" + artistname + '\'' +
                ", songname='" + songname + '\'' +
                ", duration='" + duration + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }




}
