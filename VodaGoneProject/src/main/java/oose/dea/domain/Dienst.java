package oose.dea.domain;

/**
 * Created by nymtesx on 18-10-2016.
 */
public class Dienst {

    private String bedrijf;
    private String dienstnaam;
    private String beschrijving;
    private int maandPrijs;
    private int halfJaarPrijs;
    private int jaarPrijs;
    private boolean verdubbelbaar;
    private boolean deelbaar;



    public Dienst(){}

    public Dienst(String bedrijf, String dienstnaam, String beschrijving, int maandPrijs, int halfJaarPrijs, int jaarPrijs, boolean verdubbelbaar, boolean deelbaar) {
        this.bedrijf = bedrijf;
        this.dienstnaam = dienstnaam;
        this.beschrijving = beschrijving;
        this.maandPrijs = maandPrijs;
        this.halfJaarPrijs = halfJaarPrijs;
        this.jaarPrijs = jaarPrijs;
        this.verdubbelbaar = verdubbelbaar;
        this.deelbaar = deelbaar;
    }


    public String getBedrijf() {
        return bedrijf;
    }

    public String getNaam() {
        return dienstnaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public int getMaandPrijs() {
        return maandPrijs;
    }

    public int getHalfJaarPrijs() {
        return halfJaarPrijs;
    }

    public int getJaarPrijs() {
        return jaarPrijs;
    }

    public boolean isVerdubbelbaar() {
        return verdubbelbaar;
    }

    public boolean isDeelbaar() {
        return deelbaar;
    }

    public void setBedrijf(String bedrijf) {
        this.bedrijf = bedrijf;
    }

    public void setNaam(String naam) {
        this.dienstnaam = dienstnaam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public void setMaandPrijs(int maandPrijs) {
        this.maandPrijs = maandPrijs;
    }

    public void setHalfJaarPrijs(int halfJaarPrijs) {
        this.halfJaarPrijs = halfJaarPrijs;
    }

    public void setJaarPrijs(int jaarPrijs) {
        this.jaarPrijs = jaarPrijs;
    }

    public void setVerdubbelbaar(boolean verdubbelbaar) {
        this.verdubbelbaar = verdubbelbaar;
    }

    public void setDeelbaar(boolean deelbaar) {
        this.deelbaar = deelbaar;
    }

    @Override
    public String toString() {
        return "Dienst{" +
                "bedrijf='" + bedrijf + '\'' +
                ", dienstnaam='" + dienstnaam + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", maandPrijs=" + maandPrijs +
                ", halfJaarPrijs=" + halfJaarPrijs +
                ", jaarPrijs=" + jaarPrijs +
                ", verdubbelbaar=" + verdubbelbaar +
                ", deelbaar=" + deelbaar +
                '}';
    }
}
