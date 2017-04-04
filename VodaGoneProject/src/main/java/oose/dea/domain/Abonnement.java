package oose.dea.domain;

import java.util.Date;


public class Abonnement {

    private Date startDatum;
    private boolean verdubbeld;
    private Abonnee abonneeHouder;
    private Abonnee abonneeDelen1;
    private Abonnee abonneeDelen2;
    private Dienst dienst;
    private AbonnementSoort abonnementSoort;
    private AbonnementStatus abonnementStatus;

    public Abonnement(){};

    public Abonnement(Date startDatum, boolean verdubbeld, Abonnee abonneeHouder, Abonnee abonneeDelen1, Abonnee abonneeDelen2, Dienst dienst, AbonnementSoort abonnementSoort, AbonnementStatus abonnementsStatus) {
        this.startDatum = startDatum;
        this.verdubbeld = verdubbeld;
        this.abonneeHouder = abonneeHouder;
        this.abonneeDelen1 = abonneeDelen1;
        this.abonneeDelen2 = abonneeDelen2;
        this.dienst = dienst;
        this.abonnementSoort = abonnementSoort;
        this.abonnementStatus = abonnementsStatus;
    }

    public Date getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(Date startDatum) {
        this.startDatum = startDatum;
    }

    public boolean isVerdubbeld() {
        return verdubbeld;
    }

    public void setVerdubbeld(boolean verdubbeld) {
        this.verdubbeld = verdubbeld;
    }

    public Abonnee getAbonneeHouder() {
        return abonneeHouder;
    }

    public void setAbonneeHouder(Abonnee abonneeHouder) {
        this.abonneeHouder = abonneeHouder;
    }

    public Abonnee getAbonneeDelen1() {
        return abonneeDelen1;
    }

    public void setAbonneeDelen1(Abonnee abonneeDelen1) {
        this.abonneeDelen1 = abonneeDelen1;
    }

    public Abonnee getAbonneeDelen2() {
        return abonneeDelen2;
    }

    public void setAbonneeDelen2(Abonnee abonneeDelen2) {
        this.abonneeDelen2 = abonneeDelen2;
    }

    public Dienst getDienst() {
        return dienst;
    }

    public void setDienst(Dienst dienst) {
        this.dienst = dienst;
    }

    public AbonnementSoort getAbonnementSoort() {
        return abonnementSoort;
    }

    public void setAbonnementSoort(AbonnementSoort abonnementSoort) {
        this.abonnementSoort = abonnementSoort;
    }

    public AbonnementStatus getAbonnementStatus() {
        return abonnementStatus;
    }

    public void setAbonnementStatus(AbonnementStatus abonnementStatus) {
        this.abonnementStatus = abonnementStatus;
    }



    public void setVerdubbel() {
        if(dienst.isVerdubbelbaar() && verdubbeld != true) {
            verdubbeld = true;
        }

    }
    public void deelMet(Abonnee abonnee){
            if(abonneeDelen1.getAbonneenaam() == null) {
                abonneeDelen1 = abonnee;
            } else if(abonneeDelen2.getAbonneenaam() == null) {
                abonneeDelen2 = abonnee;
            }
    }

    public void verleng(AbonnementSoort periode){
            abonnementSoort = periode;
    }

    public void zegOp(){
        abonnementStatus = AbonnementStatus.OPGEZEGD;
    }

    public float berekenMaandPrijs(){
        if(getAbonnementStatus() == getAbonnementStatus().OPGEZEGD) {
            return 0;
        } else{
            switch(getAbonnementSoort()){
                case MAAND:
                    return dienst.getMaandPrijs();
                case HALFJAAR:
                    return dienst.getHalfJaarPrijs()/6;
                case JAAR:
                    return dienst.getJaarPrijs()/12;
            }
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Abonnement{" +
                "startDatum=" + startDatum +
                ", verdubbeld=" + verdubbeld +
                ", abonneeHouder=" + abonneeHouder +
                ", abonneeDelen1=" + abonneeDelen1 +
                ", abonneeDelen2=" + abonneeDelen2 +
                ", dienst=" + dienst +
                ", abonnementsSoort=" + abonnementSoort +
                ", abonnementsStatus=" + abonnementStatus +
                '}';
    }


}
