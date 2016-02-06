import java.util.Scanner;

/**
 * Created by branden on 2/6/16 at 12:54.
 */
public class ManagerFunctions {


    // Set up Vars
    public static Scanner scanner = new Scanner(System.in);



    public static int showOptions() {
        System.out.println("Welcome to the worlds first computerized contact manager.");
        System.out.println("Please choose from the option below:");
        System.out.printf("%30s%n", "1. Create a new contact");
        System.out.printf("%26s%n", "2. Delete a contact");
        System.out.printf("%27s%n", "3. List all contacts");
        System.out.printf("%30s%n", "4. Exit Contact Manager");
        return Utils.stringToInt(scanner.nextLine());
    }

    public static void handleSelection(int selection) {
        //check user input
        while (selection < 1 && selection >= 4) {
            System.out.println("you have entered an invalid selection, try again.");
            selection = Utils.stringToInt(scanner.nextLine());
            }
        //handle user selection
        switch (selection) {
            case 1:
                createContact();
                break;
            case 2:
               // deleteContact();
                break;
            case 3:
                listContacts();
                break;
            case 4:
                //exitManager();
                break;
            default:
                System.out.println("something had gone wrong (debugging message");
                break;
        }

    }

    public static void createContact() {
        System.out.printf("%n%n%n");
        //name
        System.out.println("Enter contact's first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter Contact's last name:");
        String lastName = scanner.nextLine();
        String fullName = firstName.concat("_");
        fullName = fullName.concat(lastName);
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
        ContactManager.contactMap.put(fullName, new Contact(nameArray, streetAddress, state, city, phone, zip, isPersonal));

       // System.out.println(ContactManager.contactMap.get(fullName).getCity()); Debugging! Remove me later!


    }

    public static void listContacts() {

        for (Contact value : ContactManager.contactMap.values()) {
            String fullName[] = value.getFullName();
            System.out.println(fullName[0]);
            System.out.println(fullName[1]);
            System.out.println(value.getStreetAddress());

        }
    }



}