package oose.dea.services.local;


import oose.dea.datasource.DienstDAO;
import oose.dea.domain.Dienst;
import oose.dea.services.DienstService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class LocalDienstService implements DienstService {


    DienstDAO dienstDAO = new DienstDAO();

    public List<Dienst> findByTitle(String searchTerm) throws SQLException {
        return dienstDAO.findByTitle(searchTerm);
    }

    public List<Dienst> findAll() throws SQLException, IOException, ClassNotFoundException {
        return dienstDAO.findAll();
    }



}
