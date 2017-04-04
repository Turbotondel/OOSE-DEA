package Domain;

/**
 * Created by nymtes on 4-4-2017.
 */
public class Availability {

    private boolean offlineAvailable;

    public Availability(boolean offlineAvailable) {
        this.offlineAvailable = offlineAvailable;
    }

    public void toggle(){};

    public boolean isOfflineAvailable(){
        return true;
    };

}
