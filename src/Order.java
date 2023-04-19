import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private final int idOrder;
    private final Customer customer;
    private List<Product> products = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private Date date;

    public Order(Customer customer, List<Product> products, List<Item> items ,Date date){
        idOrder = (int)(Math.random() * (999999999 - 1000 + 1) - 1000);
        this.customer = customer;
        this.products = products;
    }
}
