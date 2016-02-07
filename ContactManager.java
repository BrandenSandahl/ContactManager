import java.util.HashMap;

/**
 * Created by branden on 2/5/16 at 15:45.
 */
public class ContactManager {

    public static HashMap<Integer, Contact> contactMap = new HashMap<>();

    public static void main (String[] args) throws InterruptedException {

        while (true) {
            int userSelection = ManagerFunctions.ShowOptions();
            ManagerFunctions.HandleSelection(userSelection);
        }



    }


}