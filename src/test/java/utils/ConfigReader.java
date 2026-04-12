package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            properties = new Properties();

            FileInputStream file = new FileInputStream(
                    System.getProperty("user.dir") + "/src/test/resources/config.properties"
            );

            properties.load(file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}