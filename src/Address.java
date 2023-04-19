import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Address implements Serializable {
    private String street;
    private String zipcode;
    public Address (String street, String zipcode){
        setStreet(street);
        setZipcode(zipcode);
    }

    @Override
    public String toString(){
        return "Address:[ " + getStreet() + '\'' +
                ", " + getZipcode() + '\'' +
                " ]";
    }


    //getters
    public String getStreet(){
        return street;
    }

    public String getZipcode(){
        return zipcode;
    }

    //setters
    public void setStreet(String street){
        try {
            if (street == null){
                throw new NullPointerException("Provide the street.");
            }else if (checkStreet(street)){
                this.street = street;
            }else {
                throw new Exception("Street is provided incorrectly.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setZipcode(String zipcode){
        try {
            if (zipcode == null){
                throw new NullPointerException("Provide the zipcode.");
            }else if (checkZipcode(zipcode)){
                this.zipcode = zipcode;
            }else {
                throw new Exception("Zipcode is provided incorrectly.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //checkers
    private boolean checkStreet(String street){
        String regex = "[a-zA-Z]+\\s+\\d+|[a-zA-Z]+\\s[a-zA-Z]+\\s+\\d";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(street);
        return matcher.matches();
    }
    private boolean checkZipcode(String zipcode){
        String regex = "^[0-9]{2}-[0-9]{3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(zipcode);
        return matcher.matches();
    }

}
