package com.example.mytunes;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class MediaManager {

    private MediaPlayer currentPlayer;

    private void playSong(Song song) {
        if (currentPlayer != null) {
            currentPlayer.stop();
        }
        try {
            Media media = new Media(new File(song.getFilePath()).toURI().toString());
            currentPlayer = new MediaPlayer(media);
            currentPlayer.play();
        } catch (Exception e) {
            System.err.println("Sangen kan ikke afspilles: " + e.getMessage());
            e.printStackTrace();
            // Håndter fejl her
        }

    }
}