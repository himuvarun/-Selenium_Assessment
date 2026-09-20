package Day_12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
    public static String getData(String key) throws IOException {
        FileInputStream fis=new FileInputStream("./src/test/resources/new/common_data.properties");
        Properties p=new Properties();
        p.load(fis);
        String data=p.getProperty(key);
        fis.close();
        return data;
    }
}
