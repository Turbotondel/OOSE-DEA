package Service.rest;

import Datasource.TrackDAO;
import Domain.Playlist;
import Service.TrackService;

import java.util.List;

/**
 * Created by timde on 6-4-2017.
 */
public class TrackRESTService implements TrackService {
    TrackDAO trackDAO = new TrackDAO();


    public List<Playlist> insertvideo(String name) {
        return null;
    }
}
