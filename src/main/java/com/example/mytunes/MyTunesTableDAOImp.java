package com.example.mytunes;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.sql.SQLException;
import java.sql.Statement;

public class MyTunesTableDAOImp implements MyTunesTableDAO{

    private Connection con; // forbindelsen til databasen
    public MyTunesTableDAOImp(){
        try
        {
            // Opretter forbindelse til vores database

            con = DriverManager.getConnection("jdbc:sqlserver://EASV-DB4:1433;database=NyDB;userName=CSe2023t_t_7;password=CSe2023tT7#23;encrypt=false;trustServerCertificate=true");

        } catch (SQLException e){
            System.err.println("can not create connection" + e.getMessage());
        }
        System.out.println("  ");
    }

    @Override
    public List<MyTunesTable> getallsongs() {
        List<MyTunesTable> songs = new ArrayList<>();

        try  {

       PreparedStatement ps = con.prepareStatement("select * from MyTunesTable");

       ResultSet rs = ps.executeQuery();

       MyTunesTable mtt;

       while (rs.next()) {


           String artistname = rs.getString(1);

           String songname = rs.getString(2);

           String duration = rs.getString(3);

           String genre = rs.getString(4);

           mtt = new MyTunesTable(artistname,songname,duration,genre);

           songs.add(mtt);
        }

        }
        catch (SQLException e){

        }
        return songs;
    }
}
