package commonClasses;

import org.testng.annotations.Parameters;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

public class Config {


    private static Properties prop;
    private static File file;
    private static InputStream inputStream;


    public static void initialized(){
        prop = loadProperties();

        for (String key: prop.stringPropertyNames()){
            if (System.getProperties().containsKey(key)){
                prop.setProperty(key, System.getProperty(key));
            }
        }

    }

    public static String getProp(String key){
        return prop.getProperty(key);
    }

    private static Properties loadProperties(){
        try{
            String path = "Test-data/application.properties";
            inputStream = ResourceLoader.getResource(path);
            prop = new Properties();
            prop.load(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        return prop;
    }
}
