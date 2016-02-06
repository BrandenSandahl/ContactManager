import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by branden on 2/5/16 at 15:45.
 */
public class ContactManager {

    public static HashMap<String, Contact> contactMap = new HashMap<>();

    public static void main (String[] args) {

        while (true) {
            int userSelection = ManagerFunctions.showOptions();
            ManagerFunctions.handleSelection(userSelection);
        }



    }


}