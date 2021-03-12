/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billzonesample;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 *
 */
public class ConfigHelper {

    public static String getConfigValue(String key) {

        Properties properties = new Properties();
        InputStream input = null;
        String result = "";

        try {
            input =   new FileInputStream("config.properties");

            properties.load(input);

            result = properties.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
