import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private final int idOrder;
    private final Customer customer;
    private final List<Product> products;
    private final List<Item> items;
    private Date date;
    private static List<Order> ordersExtent = new ArrayList<>();  //Class extent

    public Order(Customer customer, Date date){
        idOrder = (int)(Math.random() * (999999999 - 1000 + 1) - 1000);
        this.date = date;
        this.customer = customer;
        this.products = new ArrayList<Product>();
        this.items = new ArrayList<Item>();
        addOrder(this);
    }

    @Override
    public String toString(){
        return "Order{" +
                "idOrder=" + idOrder +
                ", Customer='" + customer + '\'' +
                ", Date='" + date + '\'' +
                ", Products='" + products + '\'' +
                ", Items='" + items + '\'' +
                '}';
    }

    //getters
    public Customer getCustomer(){
        return customer;
    }
    public List<Product> getProduct(){
        return products;
    }
    public Date getDate() {
        return date;
    }
    public List<Item> getItem(){
        return items;
    }

    //setters
    public void setDate(Date date) {
        this.date = date;
    }


    //Serialization
    public static void writeExtent(ObjectOutputStream streamOut){
        try {

            streamOut.writeObject(ordersExtent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readExtent(ObjectInputStream streamIn){
        try {
            ordersExtent = (ArrayList<Order>)streamIn.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //extent
    private static void addOrder(Order order){
        try {
            if (order == null){
                throw new NullPointerException("Can not add null to extent");
            }else {
                ordersExtent.add(order);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void removeOrder(Order order){
        try {
            if (order == null){
                throw new NullPointerException("Can not add null to extent");
            }else {
                ordersExtent.remove(order);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Order.class.getName());
        for (Order order : ordersExtent) {
            System.out.println(order);
        }
    }
}
