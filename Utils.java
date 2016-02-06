/**
 * Created by branden on 2/6/16 at 14:22.
 */
public class Utils {


// Set up Vars



    //begin utilities
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

}