import java.util.ArrayList;
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
        System.out.printf("%30s%n", "1. Create a new contact");  //backslash t \t like that!!!
        System.out.printf("%26s%n", "2. Delete a contact");
        System.out.printf("%25s%n", "3. List a contacts");
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
        ContactManager.contactList.add(new Contact(nameArray, streetAddress, state, city, phone, zip, isPersonal));


    }


    public static int DisplayAllContacts(String style) {

        System.out.println("Please enter the number of the contact you wish to " + style + " :");
        for (int i = 0; i < ContactManager.contactList.size(); i++) {
            Contact currentContact = ContactManager.contactList.get(i);
            System.out.println((i + 1) + ". " + currentContact.getFullName()[0] + " " + currentContact.getFullName()[1]);
        }

        return Utils.stringToInt(scanner.nextLine());
    }

    public static void DisplaySingleContact(int viewContact) {
        viewContact--;

        Contact currentContact = ContactManager.contactList.get(viewContact);  //local var to hold the start of this big location
        System.out.println("Displaying the information for " + currentContact.getFullName()[0] + ":");
        //display the name and phone
        System.out.printf("%s %s %40s %n", currentContact.getFullName()[0], currentContact.getFullName()[1], currentContact.getPhoneNumber());
        //display address
        System.out.printf("%s %s %s %d n%n", currentContact.getStreetAddress(), currentContact.getCity(), currentContact.getState(), currentContact.getZipCode());
        //display relationship
        if (currentContact.isPersonal()) {
            System.out.println("This contact is filed as a Personal Contact");
        } else {
            System.out.println("This contact is filed as: Other");
        }

    }

    public static void DeleteContact(int deleteContact) throws InterruptedException {
        deleteContact--;
        System.out.println("Deleting contact: " + ContactManager.contactList.get(deleteContact).getFullName()[0] + "...");
        ContactManager.contactList.remove(deleteContact);
        Thread.sleep(1000);
        System.out.println("Contact has been deleted!");

    }

    public static void ExitManager() {
        System.out.println("Exiting");
        System.exit(0);
    }



}