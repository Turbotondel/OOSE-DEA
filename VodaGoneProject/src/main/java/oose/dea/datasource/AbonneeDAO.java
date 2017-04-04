package oose.dea.datasource;

import oose.dea.domain.Abonnee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nymtesx on 18-10-2016.
 */
public class AbonneeDAO {


    private Connection con;

    public List<Abonnee> findAll() throws SQLException, ClassNotFoundException, IOException {
        con = new DatabaseConnect().getDBConnect();
        List<Abonnee> list = new ArrayList<>();
        ResultSet result = con.prepareStatement("Select * from abonnee").executeQuery();
        while(result.next()) {

            Abonnee abonnee = new Abonnee(result.getString("abonneenaam"),result.getString("emailadres"));
            list.add(abonnee);
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Abonnee getAbonnee(String abonneenaam) throws SQLException {
        con = new DatabaseConnect().getDBConnect();
        Abonnee list = new Abonnee();
        ResultSet result = con.prepareStatement("Select * from abonnee WHERE abonneenaam ='" + abonneenaam + "' OR emailadres = '" + abonneenaam + "';").executeQuery();
        while(result.next()) {

            Abonnee abonnee = new Abonnee(result.getString("abonneenaam"),result.getString("emailadres"));
            list = abonnee;

        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Abonnee getSingleAbonnee(String abonneenaam) throws SQLException {
        con = new DatabaseConnect().getDBConnect();
       Abonnee abonnee = new Abonnee();

        ResultSet result = con.prepareStatement("Select * from abonnee WHERE abonneenaam = '" + abonneenaam + "'").executeQuery();
        while(result.next()) {

            abonnee = new Abonnee(result.getString("abonneenaam"),result.getString("emailadres"));
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return abonnee;


    }




}
