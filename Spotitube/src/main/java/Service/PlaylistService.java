package Service;

import Domain.Playlist;
import Domain.Track;

import java.util.List;

/**
 * Created by timde on 5-4-2017.
 */
public interface PlaylistService {
    List<Playlist> getAllPlayLists();

    List<Playlist> findByOwner(String owner);

    List<Playlist> findByName(String name);

    List<Track> getAllTracksInPlayList(String playlistNaam, String owner);

    void addTrackToPlaylist(String trackPerformer, String title, String playlistNaam, String owner);

    void deleteTracksFromPlaylist(String trackPerformer, String title, String playlistNaam, String owner);

    void deletePlaylist(String playlistNaam, String owner);
}
