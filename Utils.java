/**
 * Created by branden on 2/6/16 at 14:22.
 */
public class Utils {


// Set up Vars



    //begin utilities

    //i just figured out that these are not really neccesary, I can just do all this on one line.

    public static int stringToInt(String tempNumber) {
        return Integer.valueOf(tempNumber);
    }

    public static double stringToDouble(String tempNumber) {
        return Double.parseDouble(tempNumber);
    }

    public static float stringToFloat(String tempNumber) {
        return Float.parseFloat(tempNumber);
    }

    public  static boolean stringToBoolean(String tempBoolean) {
        return Boolean.parseBoolean(tempBoolean);
    }



    /**
    //This is a listener utility that overrided nextLine()
    public static String nextLine() {
        String lineIn = scanner.nextLine();
        while (lineIn.equalsIgnoreCase("exit")) {
            //put turn off function here
        }
        return lineIn;
    }
     */

}