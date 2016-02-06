import java.util.ArrayList;

/**
 * Created by branden on 2/5/16 at 15:56.
 */
public class Contact {
    private String[] fullName = new String[2];
    private String name, streetAddress, state, city, phoneNumber;
    private int  zipCode;
    private boolean isPersonal;




// Constructors if used


    public Contact(String[] fullName, String streetAddress, String state, String city, String phoneNumber, int zipCode, boolean isPersonal) {
        setFullName(fullName);
        setStreetAddress(streetAddress);
        setState(state);
        setCity(city);
        setPhoneNumber(phoneNumber);
        setZipCode(zipCode);
        setPersonal(isPersonal);
    }

    /** Start Getters and Setters */
    //full nam
    public String[] getFullName() { return fullName; }
    public void setFullName(String[] fullName) { this.fullName = fullName;  }


    //name
    public String getName() { return name;  }
    public void setName(String name) { this.name = name; }

    //streetAddress
    public String getStreetAddress() {  return streetAddress;  }
    public void setStreetAddress(String streetAddress) {  this.streetAddress = streetAddress;  }

    //state
    public String getState() { return state; }
    public void setState(String state) {  this.state = state;  }

    //city
    public String getCity() {  return city;   }
    public void setCity(String city) {  this.city = city;    }

    //phoneNumber
    public String getPhoneNumber() {  return phoneNumber;  }
    public void setPhoneNumber(String phoneNumber) {  this.phoneNumber = phoneNumber;  }

    //zipCode
    public int getZipCode() {  return zipCode; }
    public void setZipCode(int zipCode) { this.zipCode = zipCode;  }

    //isPersonal
    public boolean isPersonal() {  return isPersonal; }
    public void setPersonal(boolean personal) {   isPersonal = personal;  }
/** End of Getters and Setters */

}