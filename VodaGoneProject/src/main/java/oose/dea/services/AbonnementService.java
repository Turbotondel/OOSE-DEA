package oose.dea.services;

import oose.dea.domain.Abonnement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by nymtesx on 5-12-2016.
 */
public interface AbonnementService {

    public List<Abonnement> getAllAbonnementen(String abonneeNaam) throws SQLException;

    public List<Abonnement> getAbonnementen() throws SQLException, IOException, ClassNotFoundException;

    public void opzeggenDienst(String abonneeNaam, String dienstNaam) throws SQLException, IOException, ClassNotFoundException;

    public void upgradenDienst(String abonneeNaam, String dienstNaam) throws SQLException, IOException, ClassNotFoundException;

    public void delenDienst(String abonneeNaam, String abonneeDelenNaam, String dienstNaam) throws SQLException, IOException, ClassNotFoundException;

    public void uitproberenDienst(String dienstnaam, String abonneenaam) throws SQLException;
}
