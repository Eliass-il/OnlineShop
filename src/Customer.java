import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer implements Serializable {
    private final UUID idCustomer;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private final Address address;
    private static List<Customer> customersExtent = new ArrayList<>();  //Class extent
    //overlapping


    public Customer (String firstName, String lastName, String phoneNumber, String email, Address address){
        idCustomer = UUID.randomUUID();
        this.firstName = firstName;
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        this.address = address;
        addCustomer(this);
    }

    public Customer (String lastName, String phoneNumber, String email, Address address){
        idCustomer = UUID.randomUUID();
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        this.address = address;
        addCustomer(this);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer=" + idCustomer +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    //extent
    private static void addCustomer(Customer customer){
        try {
            if (customer == null){
                throw new NullPointerException("Can not add null to extent");
            }else {
                customersExtent.add(customer);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void removeCustomer(Customer customer){
        try {
            if (customer == null){
                throw new NullPointerException("Can not add null to extent");
            }else {
                customersExtent.remove(customer);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Customer.class.getName());
        for (Customer customer : customersExtent) {
            System.out.println(customer);
        }
    }

    //getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getEmail(){
        return email;
    }
    public String getStreet() {
        return address.getStreet();
    }
    public String getZipcode(){
        return address.getZipcode();
    }


    //setters
    public void setFirstName(String firstName){
        try {
            if (checkFirstName(firstName)){
                this.firstName = firstName;
            }else {
                throw new Exception("First name is not provided correctly!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setLastName(String lastName){
        try {
            if (lastName == null){
                throw new NullPointerException("Provide the last name.");
            }else if (checkLastName(lastName)){
                this.lastName = lastName;
            }else {
                throw new Exception("Last name is provided incorrectly!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setPhoneNumber(String phoneNumber) {
        try {
            if (phoneNumber == null) {
                throw new NullPointerException("Provide the phone number.");
            } else if (checkPhoneNumber(phoneNumber)) {
                this.phoneNumber = phoneNumber;
            } else {
                throw new Exception("Phone number is provided incorrectly!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setEmail(String email) {
        try {
            if (email == null) {
                throw new NullPointerException("Provide email.");
            } else if (checkEmail(email)) {
                this.email = email;
            } else {
                throw new Exception("Email is provided incorrectly");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setStreet(String street){
        address.setStreet(street);
    }
    public void setZipcode(String zipcode){
        address.setZipcode(zipcode);
    }

    //checkers
    private boolean checkFirstName(String firstName){
        String regex = "^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }
    private boolean checkLastName(String lastName){
        String regex = "^[A-Z](?=.{1,29}$)[A-Za-z]*(?:\\h+[A-Z][A-Za-z]*)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }
    private boolean checkPhoneNumber(String phoneNumber){
        String regex = "(?<!\\w)(\\(?(\\+|00)?48\\)?)?[ -]?\\d{3}[ -]?\\d{3}[ -]?\\d{3}(?!\\w)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    private boolean checkEmail(String email){
        String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //Serialization
    public static void writeExtent(ObjectOutputStream streamOut){
        try {

            streamOut.writeObject(customersExtent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readExtent(ObjectInputStream streamIn){
        try {
            customersExtent = (ArrayList<Customer>)streamIn.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

