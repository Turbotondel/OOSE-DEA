package oose.dea.services;

import oose.dea.domain.Dienst;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public interface DienstService {

    public List<Dienst> findByTitle(String searchTerm) throws SQLException;

    public List<Dienst> findAll() throws SQLException, IOException, ClassNotFoundException;

}
