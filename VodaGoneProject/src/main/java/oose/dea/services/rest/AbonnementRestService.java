package oose.dea.services.rest;

import oose.dea.datasource.AbonneeDAO;
import oose.dea.datasource.AbonnementDAO;
import oose.dea.domain.Abonnee;
import oose.dea.domain.Abonnement;
import oose.dea.services.AbonnementService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Path("/abonnementen")
public class AbonnementRestService implements AbonnementService {


    private AbonnementDAO abonnementDAO = new AbonnementDAO();


    @GET
    @Path("/getabonnement/{x}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Abonnement> getAllAbonnementen(@PathParam("x") String abonneeNaam) throws SQLException {
        return abonnementDAO.findByAbonnee(abonneeNaam);
    }

    @GET
    @Path("/getallabonnement")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Abonnement> getAbonnementen() throws SQLException, IOException, ClassNotFoundException {
        return abonnementDAO.findAll();
    }

    @POST
    @Path("/opzeggendienst/{x}/{y}")
    @Produces(MediaType.APPLICATION_JSON)
    public void opzeggenDienst(@PathParam("x") String abonneeNaam, @PathParam("y")String dienstNaam) throws SQLException, IOException, ClassNotFoundException {
        Abonnement abonnement = this.abonnementDAO.getAbonnement(abonneeNaam, dienstNaam);
        abonnement.zegOp();
        this.abonnementDAO.wijzigAbonnement(abonnement);
    }

    @POST
    @Path("/upgradendienst/{x}/{y}")
    @Produces(MediaType.APPLICATION_JSON)
    public void upgradenDienst(@PathParam("x") String abonneeNaam, @PathParam("y")String dienstNaam) throws SQLException, IOException, ClassNotFoundException {
        Abonnement abonnement = this.abonnementDAO.getAbonnement(abonneeNaam, dienstNaam);
        abonnement.setVerdubbel();
        this.abonnementDAO.wijzigAbonnement(abonnement);
    }

    @POST
    @Path("/delendienst/{x}/{y}/{z}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delenDienst(@PathParam("x")String abonneeNaam, @PathParam("y")String abonneeDelenNaam, @PathParam("z")String dienstNaam) throws SQLException, IOException, ClassNotFoundException {
        Abonnement abonnement = this.abonnementDAO.getAbonnement(abonneeNaam, dienstNaam);
        Abonnee abonnee = new AbonneeDAO().getAbonnee(abonneeDelenNaam);
        abonnement.deelMet(abonnee);
        this.abonnementDAO.wijzigAbonnement(abonnement);
    }


    @POST
    @Path("/uitproberendienst/{x}/{y}")
    @Produces(MediaType.APPLICATION_JSON)
    public void uitproberenDienst(@PathParam("y")String dienstnaam, @PathParam("x")String abonneenaam) throws SQLException {
        abonnementDAO.uitproberenDienst(dienstnaam,abonneenaam);
    }

}
