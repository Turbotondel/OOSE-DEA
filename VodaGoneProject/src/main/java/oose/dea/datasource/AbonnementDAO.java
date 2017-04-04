package oose.dea.datasource;

import oose.dea.domain.Abonnement;
import oose.dea.domain.AbonnementSoort;
import oose.dea.domain.AbonnementStatus;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AbonnementDAO {



    private Connection con;
    private AbonneeDAO abonneeDAO = new AbonneeDAO();
    private DienstDAO dienstDAO = new DienstDAO();

    public List<Abonnement> findAll() throws SQLException, ClassNotFoundException, IOException {
        con = new DatabaseConnect().getDBConnect();
        List<Abonnement> list = new ArrayList<>();
        ResultSet result = con.prepareStatement("Select * from abonnement").executeQuery();


        while (result.next()) {

            Abonnement abonnement = new Abonnement(result.getDate("startdatum"), result.getBoolean("verdubbeld"),
                    abonneeDAO.getSingleAbonnee(result.getString("abonneenaam")),abonneeDAO.getSingleAbonnee(result.getString("abonneedelen1")),
                    abonneeDAO.getSingleAbonnee(result.getString("abonneedelen2")),dienstDAO.getSingleDienst(result.getString("dienstnaam")), AbonnementSoort.valueOf(result.getString("abonnementsoort")), AbonnementStatus.valueOf(result.getString("abonnementstatus")));
            list.add(abonnement);
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public List<Abonnement> findByAbonnee(String abonneeNaam) throws SQLException {
        con = new DatabaseConnect().getDBConnect();
        List<Abonnement> list = new ArrayList<>();
        ResultSet result = con.prepareStatement("Select * from abonnement WHERE abonneenaam LIKE  '%" + abonneeNaam + "%'").executeQuery();


        while (result.next()) {

            Abonnement abonnement = new Abonnement(result.getDate("startdatum"), result.getBoolean("verdubbeld"),
                    abonneeDAO.getSingleAbonnee(result.getString("abonneenaam")),abonneeDAO.getSingleAbonnee(result.getString("abonneedelen1")),
                    abonneeDAO.getSingleAbonnee(result.getString("abonneedelen2")),dienstDAO.getSingleDienst(result.getString("dienstnaam")), AbonnementSoort.valueOf(result.getString("abonnementsoort")), AbonnementStatus.valueOf(result.getString("abonnementstatus")));
            list.add(abonnement);
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }


    public Abonnement getAbonnement(String abonneeNaam, String dienstNaam) throws SQLException {
        con = new DatabaseConnect().getDBConnect();
        Abonnement list = new Abonnement();
        ResultSet result =  con.prepareStatement("Select * from abonnement WHERE dienstnaam = '" + dienstNaam + "' AND abonneenaam = '" + abonneeNaam + "'").executeQuery();


        while (result.next()) {

            Abonnement abonnement = new Abonnement(result.getDate("startdatum"), result.getBoolean("verdubbeld"),
                    abonneeDAO.getSingleAbonnee(result.getString("abonneenaam")),abonneeDAO.getSingleAbonnee(result.getString("abonneedelen1")),
                    abonneeDAO.getSingleAbonnee(result.getString("abonneedelen2")),dienstDAO.getSingleDienst(result.getString("dienstnaam")),
                    AbonnementSoort.valueOf(result.getString("abonnementsoort")), AbonnementStatus.valueOf(result.getString("abonnementstatus")));
            list = abonnement;
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }


    public void wijzigAbonnement(Abonnement abonnement) throws SQLException {
        con = new DatabaseConnect().getDBConnect();
        InitSQLBug initSQLBug = new InitSQLBug(abonnement).invoke();
        String abonnee1 = initSQLBug.getAbonnee1();
        String abonnee2 = initSQLBug.getAbonnee2();
        String abonnee = initSQLBug.getAbonnee();

        con.prepareStatement("UPDATE abonnement SET abonnementsoort = '" + abonnement.getAbonnementSoort() +
                "', abonnementstatus = '" + abonnement.getAbonnementStatus() + "', verdubbeld =  "+ abonnement.isVerdubbeld() +
                ", abonneedelen1 =  "+ abonnee1 + ", abonneedelen2 =  "+ abonnee2 +
                " WHERE abonneenaam =  "+ abonnee + " AND dienstnaam = '" + abonnement.getDienst().getNaam()+ "';").executeUpdate();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void uitproberenDienst(String dienstnaam, String abonneenaam) throws SQLException {
        con = new DatabaseConnect().getDBConnect();
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);



        con.prepareStatement("INSERT INTO abonnement (abonneenaam, dienstnaam, abonneedelen1, abonneedelen2, startdatum, verdubbeld, abonnementsoort, abonnementstatus)" +
                "VALUES ('" + abonneenaam + "', '" + dienstnaam + "', null, null, '" + currentTime + "', FALSE, 'MAAND' ,'PROEF');").executeUpdate();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class InitSQLBug {
        private Abonnement abonnement;
        private String abonnee;
        private String abonnee1;
        private String abonnee2;

        public InitSQLBug(Abonnement abonnement) {
            this.abonnement = abonnement;
        }

        public String getAbonnee() {
            return abonnee;
        }

        public String getAbonnee1() {
            return abonnee1;
        }

        public String getAbonnee2() {
            return abonnee2;
        }

        public InitSQLBug invoke() {

            if(abonnement.getAbonneeHouder().getAbonneenaam() == null){
                abonnee = null;
            } else {
                abonnee = "'" + abonnement.getAbonneeHouder().getAbonneenaam() + "'";
            }
            if(abonnement.getAbonneeDelen1().getAbonneenaam() == null){
                abonnee1 = null;
            } else {
                abonnee1 = "'" + abonnement.getAbonneeDelen1().getAbonneenaam() + "'";
            }
            if(abonnement.getAbonneeDelen2().getAbonneenaam() == null) {
                abonnee2 = null;
            } else {
                abonnee2 = "'" + abonnement.getAbonneeDelen2().getAbonneenaam() + "'";
            }
            return this;
        }
    }
}
