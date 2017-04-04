package oose.dea.datasource;

import oose.dea.domain.Dienst;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nymtesx on 18-10-2016.
 */
public class DienstDAO {
    private Connection con;

    public List<Dienst> findAll() throws SQLException, ClassNotFoundException, IOException {
        con = new DatabaseConnect().getDBConnect();
        List<Dienst> list = new ArrayList<>();
        ResultSet result = con.prepareStatement("Select * from dienst").executeQuery();
        while(result.next()) {

            Dienst dienst = new Dienst(result.getString("bedrijf"),result.getString("dienstnaam"),result.getString("beschrijving"),result.getInt("maandprijs"),
                    result.getInt("halfjaarprijs"),result.getInt("jaarprijs"),result.getBoolean("verdubbelbaar"),result.getBoolean("deelbaar"));
            list.add(dienst);
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Dienst> findByTitle(String searchterm) throws SQLException {
        con = new DatabaseConnect().getDBConnect();
        List<Dienst> list = new ArrayList<>();
        ResultSet result = con.prepareStatement("Select * from dienst WHERE dienstnaam LIKE '%" + searchterm + "%' OR bedrijf LIKE '%" + searchterm + "%'").executeQuery();
        while(result.next()) {

            Dienst dienst = new Dienst(result.getString("bedrijf"),result.getString("dienstnaam"),result.getString("beschrijving"),result.getInt("maandprijs"),
                    result.getInt("halfjaarprijs"),result.getInt("jaarprijs"),result.getBoolean("verdubbelbaar"),result.getBoolean("deelbaar"));
            list.add(dienst);

        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public Dienst getSingleDienst(String dienstnaam) throws SQLException {
        con = new DatabaseConnect().getDBConnect();
        Dienst dienst = new Dienst();

        ResultSet result = con.prepareStatement("Select * from dienst WHERE dienstnaam = '" + dienstnaam + "'").executeQuery();
        while(result.next()) {

            dienst = new Dienst(result.getString("bedrijf"),result.getString("dienstnaam"),result.getString("beschrijving"),result.getInt("maandprijs"),
                    result.getInt("halfjaarprijs"),result.getInt("jaarprijs"),result.getBoolean("verdubbelbaar"),result.getBoolean("deelbaar"));
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dienst;


    }
}
