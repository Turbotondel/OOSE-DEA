package Domain;

/**
 * Created by nymtes on 4-4-2017.
 */
public class Playlist {

    private String owner;
    private String name;

    public Playlist(String owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    public void addTrack(Track track){


    };

    public void changeName(String name){


    };

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
