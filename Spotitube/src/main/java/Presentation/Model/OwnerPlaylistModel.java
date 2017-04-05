package Presentation.Model;

import Domain.Playlist;
import Service.PlaylistService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nymtes on 5-4-2017.
 */
public class OwnerPlaylistModel {
    List<PlaylistModel> playlistModelList;
    PlaylistService playlistService = new PlaylistService();

    public OwnerPlaylistModel(String owner) {
        this.playlistModelList = getPlaylistModelListFromPlaylists(playlistService.getPlaylistByOwner(owner));
    }

    private List<PlaylistModel> getPlaylistModelListFromPlaylists(List<Playlist> playlists) {
        List<PlaylistModel> returnList = new ArrayList<PlaylistModel>();

        for (Playlist playlist : playlists) {
            returnList.add(new PlaylistModel(playlist.getName(),playlist.getOwner()));
        }

        return returnList;
    }

    public List<PlaylistModel> getPlaylistModelList() {
        return playlistModelList;
    }

    public void setPlaylistModelList(List<PlaylistModel> playlistModelList) {
        this.playlistModelList = playlistModelList;
    }

}
