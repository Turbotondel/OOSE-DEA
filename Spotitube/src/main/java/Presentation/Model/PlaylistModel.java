package Presentation.Model;

import Domain.Playlist;
import Domain.Track;
import Service.PlaylistService;

import java.util.List;

/**
 * Created by nymtes on 4-4-2017.
 */
public class PlaylistModel {

    PlaylistService playlistService = new PlaylistService();

   private String naam;
   private String owner;
   private float duration;
   private List<Track> tracks;


    public PlaylistModel(String naam, String owner) {
        this.naam = naam;
        this.owner = owner;
        this.duration = playlistService.getTotalDuration(naam,owner);
    }


    public void fetch(){
        this.tracks = playlistService.getTracks(naam,owner);
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }


}
