package com.example.mytunes;

import javafx.collections.ObservableList;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.sql.SQLException;

public class MyTunesTableDAOImp implements MyTunesTableDAO{

    private Connection con; // forbindelsen til databasen
    public MyTunesTableDAOImp(){
        try
        {
            // Opretter forbindelse til vores database

            con = DriverManager.getConnection("jdbc:sqlserver://10.176.111.34:1433;database=NyDB;userName=CSe2023t_t_7;password=CSe2023tT7#23;encrypt=false;trustServerCertificate=true");

        } catch (SQLException e){
            System.err.println("Kan ikke skabe forbindelse: " + e.getMessage());
        }
        System.out.println("  ");
    }

    public void getallsongs(ObservableList<Song> SongTableData) {
        List<Song> songs = new ArrayList<>();
        SongTableData.clear();

        try  {
        Statement db = con.createStatement();
        String sql = "select * from MyTunesTable";

       ResultSet rs = db.executeQuery(sql);

        System.out.println("Sql ok");

       while (rs.next()) {
            System.out.println("fundet rk");

           String artistname = rs.getString("artist");

           String songname = rs.getString("Songname");

           String duration = rs.getString("duration");

           String genre = rs.getString("genre");

           Song song = new Song (artistname,songname,duration); //,genre);

           System.out.println("rk:" + song.toString());

           SongTableData.add(song);
        }

        }
        catch (SQLException e){

        }

    }


    }

