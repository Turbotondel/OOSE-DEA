package oose.dea.services.local;

import oose.dea.datasource.AbonneeDAO;
import oose.dea.datasource.AbonnementDAO;
import oose.dea.domain.Abonnee;
import oose.dea.domain.Abonnement;
import oose.dea.services.AbonnementService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class LocalAbonnementService implements AbonnementService {


    private AbonnementDAO abonnementDAO = new AbonnementDAO();

    public List<Abonnement> getAllAbonnementen(String abonneeNaam) throws SQLException {
        return abonnementDAO.findByAbonnee(abonneeNaam);
    }

    public List<Abonnement> getAbonnementen() throws SQLException, IOException, ClassNotFoundException {
        return abonnementDAO.findAll();
    }

    public void opzeggenDienst(String abonneeNaam, String dienstNaam) throws SQLException, IOException, ClassNotFoundException {
        Abonnement abonnement = this.abonnementDAO.getAbonnement(abonneeNaam, dienstNaam);
        abonnement.zegOp();
        this.abonnementDAO.wijzigAbonnement(abonnement);
    }

    public void upgradenDienst(String abonneeNaam, String dienstNaam) throws SQLException, IOException, ClassNotFoundException {
        Abonnement abonnement = this.abonnementDAO.getAbonnement(abonneeNaam, dienstNaam);
        abonnement.setVerdubbel();
        this.abonnementDAO.wijzigAbonnement(abonnement);
    }

    public void delenDienst(String abonneeNaam, String abonneeDelenNaam, String dienstNaam) throws SQLException, IOException, ClassNotFoundException {
        Abonnement abonnement = this.abonnementDAO.getAbonnement(abonneeNaam, dienstNaam);
        Abonnee abonnee = new AbonneeDAO().getAbonnee(abonneeDelenNaam);
        abonnement.deelMet(abonnee);
        this.abonnementDAO.wijzigAbonnement(abonnement);
    }

    public void uitproberenDienst(String dienstnaam, String abonneenaam) throws SQLException {
        abonnementDAO.uitproberenDienst(dienstnaam,abonneenaam);
    }

}
