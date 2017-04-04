package oose.dea.presentation.model;


import oose.dea.domain.Dienst;
import oose.dea.services.DienstService;

import javax.inject.Inject;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DienstModel {

    @Inject
    private DienstService DienstService;

    public static List<Dienst> dienstList = new ArrayList<>();

    public void findAll() throws SQLException, IOException, ClassNotFoundException {
        dienstList = DienstService.findAll();
    }//get alles

    public void findByTitle(String searchTerm) throws SQLException {
        dienstList = DienstService.findByTitle(searchTerm);
    }


}
