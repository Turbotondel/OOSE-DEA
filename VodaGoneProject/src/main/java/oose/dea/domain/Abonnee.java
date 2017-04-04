package oose.dea.domain;

/**
 * Created by nymtesx on 18-10-2016.
 */
public class Abonnee {

    private String abonneenaam;
    private String emailadres;


    public Abonnee(){}

    public Abonnee(String abonneenaam, String emailadres) {
        this.abonneenaam = abonneenaam;
        this.emailadres = emailadres;
    }

    public String getAbonneenaam() {
        return abonneenaam;
    }

    public void setAbonneenaam(String abonneenaam) {
        this.abonneenaam = abonneenaam;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    @Override
    public String toString() {
        return "Abonnee{" +
                "abonneenaam='" + abonneenaam + '\'' +
                ", emailadres='" + emailadres + '\'' +
                '}';
    }
}
