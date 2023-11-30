package com.example.mytunes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        List<MyTunesTable> newSongs = mtd.getallsongs();

        for (MyTunesTable mt: newSongs) {
            System.out.println(mt.toString());

        }


    }

    MyTunesTableDAO mtd = new MyTunesTableDAOImp();

}