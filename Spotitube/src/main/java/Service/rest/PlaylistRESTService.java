package Service.rest;

import Datasource.PlaylistDAO;
import Datasource.TrackDAO;
import Domain.Playlist;
import Domain.Track;
import Service.PlaylistService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by timde on 5-4-2017.
 */

@Path("/Playlists")
public class PlaylistRESTService implements PlaylistService{
    private PlaylistDAO playlistDAO = new PlaylistDAO();
    private TrackDAO trackDAO = new TrackDAO();

    @GET
    @Path("/getPlaylists/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlist> getAllPlayLists() {
        return playlistDAO.getAllPlaylist();
    }

    @GET
    @Path("/getPlaylistsByOwner/{x}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlist> findByOwner(@PathParam("x")String owner) {
        return playlistDAO.findByOwner(owner);
    }

    @GET
    @Path("/getPlayListsByName/{x}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Playlist> findByName(@PathParam("x") String name) {
        return playlistDAO.findByName(name);
    }

    @GET
    @Path("/getPlayListsByName/{x}/{y}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Track> getAllTracksInPlayList(@PathParam("x")String playlistNaam, @PathParam("y") String owner) {
        Playlist playlist = playlistDAO.findPlaylist(owner, playlistNaam);
        return playlistDAO.getAllTracksInPlaylist(playlist);
    }

    @GET
    @Path("/getPlayListsByName/{w}/{x}/{y}/{z}")
    @Produces(MediaType.APPLICATION_JSON)
    public void addTrackToPlaylist(@PathParam("w")String trackPerformer, @PathParam("x")String title, @PathParam("y")String playlistNaam, @PathParam("z")String owner) {
        Playlist playlist = playlistDAO.findPlaylist(owner, playlistNaam);
        Track track = trackDAO.findTrack(trackPerformer, title);
        playlistDAO.addTrackToPlaylist(track, playlist);
    }

    @GET
    @Path("/getPlayListsByName/{w}/{x}/{y}/{z}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteTracksFromPlaylist(@PathParam("w")String trackPerformer, @PathParam("x")String title, @PathParam("y")String playlistNaam, @PathParam("z")String owner) {
        Playlist playlist = playlistDAO.findPlaylist(owner, playlistNaam);
        Track track = playlistDAO.getTrackFromPlaylist(playlist, trackPerformer, title);
        playlistDAO.deleteTrackFromPlaylist(track, playlist);
    }

    @GET
    @Path("/getPlayListsByName/{x}/{y}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deletePlaylist(@PathParam("x")String playlistNaam, @PathParam("y") String owner) {
        Playlist playlist = playlistDAO.findPlaylist(owner, playlistNaam);
        playlistDAO.deletePlaylist(playlist);
    }
}
