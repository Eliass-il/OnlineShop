import java.io.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws Exception {
        Customer customer1 = new Customer("Ilya", "Matusevich", "+48792529513", "eliassmat.il@gmail.com", new Address("Grzybowska 9", "00-132"));
        Customer customer2 = new Customer("John", "Smith", "+48795539523", "johnsmith@gmail.com", new Address("Grzybowska 15", "00-132"));
        System.out.println(customer1);
        System.out.println(customer2);
        customer1.setPhoneNumber("+48793453586");
        System.out.println(customer1);
        customer1.setStreet("Sarmacka 16");






        var out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\do4en\\IdeaProjects\\OnlineShop\\customerExtent.ser"));
        Customer.writeExtent(out);
        out.close();

        var in = new ObjectInputStream(new FileInputStream("C:\\Users\\do4en\\IdeaProjects\\OnlineShop\\customerExtent.ser"));
        Customer.readExtent(in);
        in.close();
        Customer.showExtent();
    }
}
