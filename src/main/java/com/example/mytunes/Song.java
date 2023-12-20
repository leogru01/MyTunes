package com.example.mytunes;

import javafx.beans.property.SimpleStringProperty;

public class Song {
    private SimpleStringProperty artistname;
    private SimpleStringProperty songname;
    private SimpleStringProperty duration;
    private String filePath;

    public String getFilePath() {
        return filePath;
    }

    public Song (String artistname, String songname, String duration) { //, String genre) {
        this.artistname = new SimpleStringProperty("");
        this.songname = new SimpleStringProperty("");
        this.duration = new SimpleStringProperty(artistname +"/" + songname+ "/" + duration);
        //this.genre = new SimpleStringProperty(genre);
    }

    public String getArtistname() {return artistname.get();}

    public String getSongname() {return songname.get();}

    public String getDuration() {return duration.get();}

    //public String getGenre() {return genre.get();}

    public void setArtistname(String s) {artistname.set(s);}

    public void setSongname(String s) {songname.set(s);}

    public void setDuration(String s) {duration.set(s);}

    //public void setGenre(String s) {genre.set(s);}

    @Override
    public String toString() {
        return "MyTunesTable{" +
                "artistname='" + artistname.get() + '\'' +
                ", songname='" + songname.get() + '\'' +
                ", duration='" + duration.get() + '\'' +
               // ", genre='" + genre.get() + '\'' +
                '}';
    }




}
