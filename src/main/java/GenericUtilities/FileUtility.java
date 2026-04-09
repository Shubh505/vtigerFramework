package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

    public String readDatafromPropertyfile(String key) throws IOException {
        FileInputStream fis= new FileInputStream("src/test/resources/testdata/commondata.properties");
        Properties pobj= new Properties();
        pobj.load(fis);
        String value=pobj.getProperty(key);
        return value;


    }
}
