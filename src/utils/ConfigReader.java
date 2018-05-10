package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static ConfigReader instance = null;
    private Properties properties;


    protected ConfigReader() throws IOException {
        properties = new Properties();
        FileInputStream propertiesFile = new FileInputStream("resources/config.properties");
        properties.load(propertiesFile);
        propertiesFile.close();
    }

    public static ConfigReader getInstance() {
        if(instance == null) {
            try {
                instance = new ConfigReader();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return instance;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }

}
