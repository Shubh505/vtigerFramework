package GenericUtilities;

import java.util.Random;

public class JavaUtility {

    public  int randint(){

        Random ran= new Random();
        int randInt= ran.nextInt(1000);
        return randInt;
    }


}
