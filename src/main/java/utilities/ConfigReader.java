package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /**
     * For security reasons do not make the properties public
     */
    private Properties properties;

    /**
     * This method is used to load the properties from config.properties file
     * @return it returns Properties prop object
     */
    public Properties init_prop(){
        properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/test/resources/config/config.properties");
        properties.load(inputStream);

        } catch (IOException e) {
            System.out.println("config.properties File Could Not Be Found or Accessed.");
        }
        return properties;
    }

}
