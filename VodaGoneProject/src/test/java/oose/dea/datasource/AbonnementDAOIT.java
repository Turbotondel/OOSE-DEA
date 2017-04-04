package oose.dea.datasource;


import oose.dea.IntegrationTest;
import oose.dea.domain.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@PrepareForTest(AbonnementDAO.class)
@Category(IntegrationTest.class)
public class AbonnementDAOIT {

    public static final String ERROR = "Error";
    private static Connection con;
    private Abonnement abonnement = new Abonnement(new Date(), false, new Abonnee("Eeg","eeg@test.test"),new Abonnee("Jollug","jollug@test.test"),new Abonnee("Joldy","joldy@test.test"), new Dienst("Ziggo", "500 belminuten", "beschrijving", 50,200,400,true,true), AbonnementSoort.HALFJAAR, AbonnementStatus.ACTIEF );

    @BeforeClass
    public static void prepare() throws SQLException {
        con = new DatabaseConnect().getDBConnect();
        Statement statement = con.createStatement();

        String sql = "CREATE TABLE IF NOT EXISTS abonnement (" +
                "   abonneenaam  varchar(255) not null," +
                "  dienstnaam  varchar(255) not null," +
                "  abonneedelen1  varchar(255)  null," +
                "  abonneedelen2  varchar(255)  null," +
                "  startdatum  date not null," +
                "   verdubbeld   boolean  not null," +
                "  abonnementsoort varchar(20) null check (abonnementsoort in ('MAAND', 'HALFJAAR','JAAR'))," +
                "  abonnementstatus varchar(20) null check (abonnementstatus in ('PROEF', 'ACTIEF','OPGEZEGD'))," +
                "  primary key (abonneenaam, dienstnaam)" +
                ")";

        statement.executeUpdate(sql);
        statement.close();
        con.close();
    }

    @Test
    public void whenTableIsEmptyListIsAlsoEmtpy()
    {
        AbonnementDAO abonnementDAO = new AbonnementDAO();
        try {
            assertEquals(0,abonnementDAO.findAll().size());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
