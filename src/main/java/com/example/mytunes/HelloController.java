package com.example.mytunes;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button NewOnPlaylist;
    @FXML
    private Button EditOnPlaylist, DeleteOnPlaylist, NewSongOnPlaylist, EditSongOnPlaylist, DeleteSongsOnPlaylist, CloseAppOnPlaylist;
    @FXML
    protected void onHelloButtonClick() {

        List<MyTunesTable> newSongs = mtd.getallsongs();

        for (MyTunesTable mt: newSongs) {
            System.out.println(mt.toString());

        }


    }

    MyTunesTableDAO mtd = new MyTunesTableDAOImp();

}