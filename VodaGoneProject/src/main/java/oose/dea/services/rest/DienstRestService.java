package oose.dea.services.rest;

import oose.dea.datasource.DienstDAO;
import oose.dea.domain.Dienst;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@Path("/diensten")
public class DienstRestService /*implements DienstService*/ {


    DienstDAO dienstDAO = new DienstDAO();

    @GET
    @Path("/getdienst/{x}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dienst> findByTitle(@PathParam("x") String searchTerm) throws SQLException {
        return dienstDAO.findByTitle(searchTerm);
    }


    @GET
    @Path("/getalldienst")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Dienst> findAll() throws SQLException, IOException, ClassNotFoundException {
        return dienstDAO.findAll();
    }

}
