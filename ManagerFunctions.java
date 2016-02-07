import java.util.Map;
import java.util.Scanner;

/**
 * Created by branden on 2/6/16 at 12:54.
 */
public class ManagerFunctions {


    // Set up Vars
    public static Scanner scanner = new Scanner(System.in);



    public static int ShowOptions() {
        System.out.println("Welcome to the worlds first computerized contact manager.");
        System.out.println("Please choose from the option below:");
        System.out.printf("%30s%n", "1. Create a new contact");
        System.out.printf("%26s%n", "2. Delete a contact");
        System.out.printf("%27s%n", "3. List all contacts");
        System.out.printf("%30s%n", "4. Exit Contact Manager");
        return Utils.stringToInt(scanner.nextLine());
    }

    public static void HandleSelection(int selection) throws InterruptedException {
        //check user input
        while (selection < 1 && selection >= 4) {
            System.out.println("you have entered an invalid selection, try again.");
            selection = Utils.stringToInt(scanner.nextLine());
            }
        //handle user selection
        switch (selection) {
            case 1:
                CreateContact();
                break;
            case 2:
                DeleteContact(DisplayAllContacts("delete"));
                break;
            case 3:
                DisplaySingleContact(DisplayAllContacts("view"));
                break;
            case 4:
                ExitManager();
                break;
            default:
                System.out.println("something had gone wrong (debugging message");
                break;
        }

    }

    public static void CreateContact() {
        System.out.printf("%n%n%n");
        //name
        System.out.println("Enter contact's first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter Contact's last name:");
        String lastName = scanner.nextLine();
        String nameArray[] = {firstName, lastName};

        //address
        System.out.println("Enter the contact street address:");
        String streetAddress = scanner.nextLine();
        System.out.println("Enter the contacts zip");
        int zip = Utils.stringToInt(scanner.nextLine());
        System.out.println("Enter the contacts city");
        String city = scanner.nextLine();
        System.out.println("Enter the contacts State");
        String state = scanner.nextLine();

        //phone
        System.out.println("Enter contacts phone: (please enter in format (xxx)xxx-xxxx");
        String phone = scanner.nextLine();

        //relationship
        System.out.println("If this is a personal contact, please enter true"); //clearly a better way to ask this, but this will due for now i think
        boolean isPersonal = Utils.stringToBoolean(scanner.nextLine());

        //assign all these vars!
        int numberOfContacts = ContactManager.contactMap.size();
        ContactManager.contactMap.put(numberOfContacts, new Contact(nameArray, streetAddress, state, city, phone, zip, isPersonal));


    }

    public static int DisplayAllContacts(String style) {

        System.out.println("Please enter the number of the contact you wish to " + style + " :");
        for (Map.Entry<Integer, Contact> entry : ContactManager.contactMap.entrySet()) {
            Integer key = entry.getKey();
            Contact value = entry.getValue();
            System.out.println(key + ". " + value.getFullName()[0] + " " + value.getFullName()[1]);
        }
        return Utils.stringToInt(scanner.nextLine());
    }

    public static void DisplaySingleContact(int viewContact) {

        System.out.println("Displaying the information for " + ContactManager.contactMap.get(viewContact).getFullName()[0] + ":");
        //display the name and phone
        System.out.printf("%s %s %40s %n", ContactManager.contactMap.get(viewContact).getFullName()[0], ContactManager.contactMap.get(viewContact).getFullName()[1], ContactManager.contactMap.get(viewContact).getPhoneNumber());
        //display address
        System.out.printf("%s %s %s %d n%n", ContactManager.contactMap.get(viewContact).getStreetAddress(), ContactManager.contactMap.get(viewContact).getCity(), ContactManager.contactMap.get(viewContact).getState(), ContactManager.contactMap.get(viewContact).getZipCode());
        //display relationship
        if (ContactManager.contactMap.get(viewContact).isPersonal()) {
            System.out.println("This contact is filed as a Personal Contact");
        } else {
            System.out.println("This contact is filed as: Other");
        }

    }

    public static void DeleteContact(int deleteContact) throws InterruptedException {
        System.out.println("Deleting contact: " + ContactManager.contactMap.get(deleteContact).getFullName()[0] + "...");
        ContactManager.contactMap.remove(deleteContact);
        Thread.sleep(1000);
        System.out.println("Contact has been deleted!");

    }

    public static void ExitManager() {
        System.out.println("Exiting");
        System.exit(0);
    }



}