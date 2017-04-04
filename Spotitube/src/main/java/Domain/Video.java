package Domain;

import java.util.Calendar;

/**
 * Created by nymtes on 4-4-2017.
 */
public class Video extends Track{

    private int playCount;
    private Calendar publicationDate;
    private String description;

    public Video(String performer, String title, String url, long duration) {
        super(performer, title, url, duration);
    }


    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public Calendar getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
