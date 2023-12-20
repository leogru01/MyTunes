package com.example.mytunes;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import java.io.File;
import java.util.Optional;




public class BlueTunesController {







    @FXML
    public void NewOnPlaylistP(ActionEvent event) {


            Dialog<ButtonType> playlistDialog = new Dialog<>();
            playlistDialog.setHeaderText("Indtast en ny sang");
            playlistDialog.setTitle("Sang");
            playlistDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
            TextField felt1 = new TextField();
            VBox box = new VBox(felt1);
            playlistDialog.getDialogPane().setContent(box);

        Optional<ButtonType> Knap = playlistDialog.showAndWait();
        if (Knap.get() == ButtonType.OK)
            System.out.println("SangTitel = " + felt1.getText());
        SongTableData.add(new Song(felt1.getText(), "",""));
    }

    @FXML
    private Button editButton;

    // ... resten af din controller-klasse

    @FXML
    private void handleEditAction() {
        Song selectedSong = BlueTable.getSelectionModel().getSelectedItem();
        if (selectedSong != null) {
            // Opret en dialog til redigering
            Dialog<ButtonType> editDialog = new Dialog<>();
            editDialog.setTitle("Rediger Sang");
            editDialog.setHeaderText("Rediger detaljer for sangen");

            // Opret tekstfelter til redigering
            TextField artistNameField = new TextField(selectedSong.getArtistname());
            TextField songNameField = new TextField(selectedSong.getSongname());
            TextField durationField = new TextField(selectedSong.getDuration());

            VBox dialogPaneContent = new VBox(artistNameField, songNameField, durationField);
            editDialog.getDialogPane().setContent(dialogPaneContent);

            editDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

            editDialog.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    // Opdater sangens information
                    selectedSong.setArtistname(artistNameField.getText());
                    selectedSong.setSongname(songNameField.getText());
                    selectedSong.setDuration(durationField.getText());
                    // Opdater TableView
                    BlueTable.refresh();
                }
            });
        } else {
            // Vis en advarsel, hvis ingen sang er valgt
            // ...
        }
    }


    @FXML
    private void handleDeleteAction() {
        Song selectedSong = BlueTable.getSelectionModel().getSelectedItem();
        if (selectedSong != null) {
            Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
            confirmAlert.setTitle("Bekræft sletning");
            confirmAlert.setHeaderText("Er du sikker på, at du vil slette denne sang: " + selectedSong.getSongname() + "?");
            Optional<ButtonType> result = confirmAlert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {

                // Fjerner sangen fra TableView og databasen
                BlueTable.getItems().remove(selectedSong);

            }
        } else {
            // Vis en advarsel, hvis ingen sang er valgt
            Alert warningAlert = new Alert(Alert.AlertType.WARNING);
            warningAlert.setTitle("Fejlmelding");
            warningAlert.setHeaderText("Vælg venligst en sang at slette.");
            warningAlert.showAndWait();
        }
    }






    @FXML
    private TableView<Song> BlueTable;

    @FXML
    private TableColumn<Song,String > OnTable = new TableColumn<Song, String>();

    @FXML
    private TableColumn<Song, String > PlaylistTable = new TableColumn<Song, String>();

    @FXML
    private TableColumn<Song, String> SongsTable = new TableColumn<Song, String>();

    private MyTunesTableDAO mtd;

    private final ObservableList<Song> SongTableData = FXCollections.observableArrayList();

    public void initialize() {
        mtd = new MyTunesTableDAOImp();

        BlueTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        OnTable.setCellValueFactory(new PropertyValueFactory<Song, String>("artistname"));
        PlaylistTable.setCellValueFactory(new PropertyValueFactory<Song, String>("songname"));
        SongsTable.setCellValueFactory(new PropertyValueFactory<Song, String>("duration"));

        BlueTable.setItems(SongTableData);

        mtd.getallsongs(SongTableData);

        for (Song s: SongTableData)
            System.out.println("song:"+s.toString());

    }



}