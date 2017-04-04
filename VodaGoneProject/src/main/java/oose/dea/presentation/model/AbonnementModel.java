package oose.dea.presentation.model;

import oose.dea.domain.Abonnement;
import oose.dea.services.AbonnementService;

import javax.inject.Inject;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AbonnementModel  {

    @Inject
    private AbonnementService AbonnementService;
    public static List<Abonnement> abonnementList = new ArrayList<>();

    public void getAbonnementen() throws SQLException, IOException, ClassNotFoundException {
        abonnementList = AbonnementService.getAbonnementen();
    }//get alles

    public void getAllAbonnementen(String abonneenaam) throws SQLException, IOException, ClassNotFoundException {
        abonnementList = AbonnementService.getAllAbonnementen(abonneenaam);
    }//get specifiek

    public void delenDienst(String abonneenaam, String abonneeDelenNaam, String dienstNaam) throws SQLException, IOException, ClassNotFoundException {
        AbonnementService.delenDienst(abonneenaam,  abonneeDelenNaam,  dienstNaam);
        getAbonnementen();
    }//delen

    public void opzeggenDienst(String abonneenaam, String dienstnaam) throws SQLException, IOException, ClassNotFoundException {
        AbonnementService.opzeggenDienst(abonneenaam,dienstnaam);
        getAbonnementen();
    }//opzeggen

    public void upgradenAbonnement(String abonneeNaam, String dienstNaam) throws SQLException, IOException, ClassNotFoundException {
        AbonnementService.upgradenDienst(abonneeNaam, dienstNaam);
        getAbonnementen();
    }//upgraden

    public void uitproberenAbonnement(String dienstnaam, String abonneenaam) throws SQLException, IOException, ClassNotFoundException {
        AbonnementService.uitproberenDienst(dienstnaam,abonneenaam);
    }//uitproberen
}
