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
    private TrackDAO trackDAO = new TrackDAO();

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

    public Playlist findPlaylist(String owner, String name) { //MAG MAAR 1 RECORD OPLEVEREN
        con = new DatabaseConnect().getDBConnect();
        ResultSet result = null;
        try {
            result = con.prepareStatement("SELECT * FROM playlist WHERE owner = '" + owner + "' AND naam = '" + name + "'").executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Playlist playlist = null;
        try {
            playlist = new Playlist(result.getString("owner"), result.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return playlist;
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



    public Track getTrackFromPlaylist(Playlist playlist, String owner, String name) { //MAG MAAR 1 RECORD OPLEVEREN
        con = new DatabaseConnect().getDBConnect();
        ResultSet result = null;
        try {
            result = con.prepareStatement("SELECT * FROM playlist WHERE owner LIKE '%" + owner + "%' AND naam LIKE '%" + name + "%'").executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            playlist = new Playlist(result.getString("owner"), result.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return track;

    }


    public List<Track> getAllTracksInPlaylist(Playlist playlist) { //laat inhoud van playlist zien
        con = new DatabaseConnect().getDBConnect();
        List<Track> list = new ArrayList<Track>();
        ResultSet result = null;
        try {
            result = con.prepareStatement("SELECT TP.performer, TP.title, T.url, T.duration FROM TrackinPlaylist TP INNER JOIN Track T ON TP.performer  = T.performer AND TP.title = T.title WHERE name LIKE '%" + playlist.getName() + "%' AND owner LIKE '%"+ playlist.getOwner() + "%'").executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (result.next()) {

                Track track = new Track(result.getString("performer"), result.getString("title"), result.getString("url"), result.getFloat("duration"));
                list.add(track);

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
            con.prepareStatement("DELETE FROM TrackinPlaylist WHERE performer = '" +track.getPerformer()+ "' AND title = '" +track.getTitle()+ "' AND owner = '" + playlist.getOwner() + "' AND name = '" + playlist.getName() + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void deletePlaylist(Playlist playlist) {   //delete complete playlist

        con = new DatabaseConnect().getDBConnect();

        try {
            con.prepareStatement("DELETE FROM Playlist WHERE name = '" +playlist.getName()+ "' AND owner = '" +playlist.getOwner()+ "'" );
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
