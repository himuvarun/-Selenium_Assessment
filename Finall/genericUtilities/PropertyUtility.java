package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {

    public static String getData(String key) throws IOException {

        FileInputStream fis = new FileInputStream("./src/test/resources/new/orangeHRM.properties");
        Properties p = new Properties();
        p.load(fis);
        fis.close();
        return p.getProperty(key);
    }
}