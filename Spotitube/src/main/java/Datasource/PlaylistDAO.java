package Datasource;

import Domain.Playlist;
import Domain.Track;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by nymtes on 4-4-2017.
 */
public class PlaylistDAO {

    private Connection con;
    private TrackDAO trackDao = new TrackDAO();


    public List<Playlist> getAllPlaylist() {    //getallplaylist
        con = new DatabaseConnect().getDBConnect();
        List<Playlist> list = new ArrayList<Playlist>();
        ResultSet result = null;
        try {
            result = con.prepareStatement("SELECT * FROM playlist").executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (result.next()) {

                Playlist playlist = new Playlist(result.getString("owner"), result.getString("name"));
                list.add(playlist);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }



    public List<Playlist> findByOwner(String owner) { //zoek op owner
        con = new DatabaseConnect().getDBConnect();
        List<Playlist> list = new ArrayList<Playlist>();
        ResultSet result = null;
        try {
            result = con.prepareStatement("SELECT * FROM playlist WHERE owner LIKE '%" + owner + "%'").executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (result.next()) {

                Playlist playlist = new Playlist(result.getString("owner"), result.getString("name"));
                list.add(playlist);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public List<Playlist> findByName(String name) { //zoek op name
        con = new DatabaseConnect().getDBConnect();
        List<Playlist> list = new ArrayList<Playlist>();
        ResultSet result = null;
        try {
            result = con.prepareStatement("SELECT * FROM playlist WHERE name LIKE '%" + name + "%'").executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (result.next()) {

                Playlist playlist = new Playlist(result.getString("owner"), result.getString("name"));
                list.add(playlist);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }


    public void addTrackToPlaylist(Track track, Playlist playlist) {    //add

        con = new DatabaseConnect().getDBConnect();

        try {
            con.prepareStatement("INSERT INTO TrackinPlaylist VALUES('" + track.getPerformer()+ "', '" + track.getTitle() + "', '" + playlist.getOwner() + "', " + playlist.getName() + ")" );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteTrackFromPlaylist(Track track, Playlist playlist) {   //delete

        con = new DatabaseConnect().getDBConnect();

        try {
            con.prepareStatement("DELETE FROM TrackinPlaylist VALUES('" + track.getPerformer()+ "', '" + track.getTitle() + "', '" + playlist.getOwner() + "', " + playlist.getName() + ")" );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void save(Playlist playlist){

    }


}
