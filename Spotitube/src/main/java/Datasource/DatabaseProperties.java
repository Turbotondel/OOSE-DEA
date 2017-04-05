package Datasource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by nymtesx on 12-10-2016.
 */
public class DatabaseProperties {
        private InputStream inputStream;
        private Properties prop = new Properties();
        private String propFileName = "database.properties";

        public String getConnectionString() throws IOException {
            loadStream();
            return prop.getProperty("connectionString");
        }

        public String getDriver() throws IOException {
            loadStream();
            return prop.getProperty("driver");
        }

        private void loadStream() throws IOException{
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        }
}
