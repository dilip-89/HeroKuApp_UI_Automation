package util;

import java.io.*;
import java.util.Properties;

public class PropertyReader {
    private Properties properties;
    private final String propertyFilePath= System.getProperty("user.dir")+"\\src\\main\\resources\\application.properties";

    public PropertyReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

}
