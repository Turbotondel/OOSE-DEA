package Service.local;


import Datasource.PlaylistDAO;
import Datasource.TrackDAO;
import Domain.Playlist;
import Domain.Track;
import Service.PlaylistService;

import java.util.List;

/**
 * Created by nymtes on 4-4-2017.
 */
public class LocalPlaylistService implements PlaylistService{
    private PlaylistDAO playlistDAO = new PlaylistDAO();
    private TrackDAO trackDAO = new TrackDAO();

    public List<Playlist> getAllPlayLists() {
        return playlistDAO.getAllPlaylist();
    }

    public List<Playlist> findByOwner(String owner) {
        return playlistDAO.findByOwner(owner);
    }

    public List<Playlist> findByName(String name) {
        return playlistDAO.findByName(name);
    }

    public List<Track> getAllTracksInPlayList(String playlistNaam, String owner) {
        Playlist playlist = playlistDAO.findPlaylist(owner, playlistNaam);
        return playlistDAO.getAllTracksInPlaylist(playlist);
    }

    public void addTrackToPlaylist(String trackPerformer, String title, String playlistNaam, String owner) {
        Playlist playlist = playlistDAO.findPlaylist(owner, playlistNaam);
        Track track = trackDAO.findTrack(trackPerformer, title);
        playlistDAO.addTrackToPlaylist(track, playlist);
    }

    public void deleteTracksFromPlaylist(String trackPerformer, String title, String playlistNaam, String owner) {
        Playlist playlist = playlistDAO.findPlaylist(owner, playlistNaam);
        Track track = playlistDAO.getTrackFromPlaylist(playlist, trackPerformer, title);
        playlistDAO.deleteTrackFromPlaylist(track, playlist);
    }

    public void deletePlaylist(String playlistNaam, String owner) {
        Playlist playlist = playlistDAO.findPlaylist(owner, playlistNaam);
        playlistDAO.deletePlaylist(playlist);
    }
}
