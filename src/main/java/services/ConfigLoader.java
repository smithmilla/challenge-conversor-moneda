package main.java.services;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    public static String GetApiKey(){
        Properties prop  = new Properties();

        try(InputStream input = ConfigLoader
                .class
                .getClassLoader()
                .getResourceAsStream("config.properties")
        ) {
            if(input == null){
                throw new RuntimeException("No se encontro config.properties en el classpath.");
            }

            prop.load(input);
            return prop.getProperty("api.key");
        }catch (Exception e){
            throw new RuntimeException("Error al leer config.properties ",e);
        }
    }
}
