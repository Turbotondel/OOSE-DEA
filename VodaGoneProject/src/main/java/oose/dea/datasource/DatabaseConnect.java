package oose.dea.datasource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by nymtesx on 19-10-2016.
 */
public class DatabaseConnect {

    private Connection con;

    public Connection getDBConnect(){

        DatabaseProperties databaseProperties = new DatabaseProperties();
        //connection
        try {
            Class.forName(databaseProperties.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(databaseProperties.getConnectionString());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return con;
    }

}
