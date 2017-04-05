package Datasource;

import Domain.Playlist;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nymtes on 4-4-2017.
 */
public class TrackDAO {

    private Connection con;
    private PlaylistDAO playlistDAO = new PlaylistDAO();

    public List<Playlist> insertVideo(String name, String) {
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

    public List list(){
        return null;
    }

    public List findByTitle(){
        return null;
    }


}
