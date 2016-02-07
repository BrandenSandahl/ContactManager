import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by branden on 2/5/16 at 15:45.
 */
public class ContactManager {

    public static ArrayList<Contact> contactList = new ArrayList<>();

    public static void main (String[] args) throws InterruptedException {

        while (true) {
            int userSelection = ManagerFunctions.ShowOptions();
            ManagerFunctions.HandleSelection(userSelection);
        }



    }


}