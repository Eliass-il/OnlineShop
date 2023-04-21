import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {
    private final int idProduct;
    private String productName;
    private float price;
    private String description;
    private final List<Order> orders;
    private static List<Product> productsExtent = new ArrayList<>();  //Class extent


    public Product(String productName, float price, String description){
        idProduct = (int)(Math.random() * (9999999 - 1 + 1)) + 1;
        setProductName(productName);
        setPrice(price);
        setDescription(description);
        this.orders = new ArrayList<Order>();
    }

    @Override
    public String toString(){
        return "Product{" +
                "product name=" + productName +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    //getters
    public String getProductName(){
        return productName;
    }
    public float getPrice(){
        return price;
    }
    public String getDescription(){
        return description;
    }
    public int getIdProduct() {
        return idProduct;
    }

    //setters
    public void setProductName(String productName){
        try{
            if (productName == null){
                throw new Exception("Provide product name.");
            }else {
                this.productName = productName;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setPrice(float price){
        try {
            if (price <= 0){
                throw new Exception("Price can not be 0 or less.");
            }else {
                this.price = price;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void setDescription(String description){
        this.description = description;
    }

    //Serialization
    public static void writeExtent(ObjectOutputStream streamOut){
        try {

            streamOut.writeObject(productsExtent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readExtent(ObjectInputStream streamIn){
        try {
            productsExtent = (ArrayList<Product>)streamIn.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //extent
    private static void addProduct(Product product){
        try {
            if (product == null){
                throw new NullPointerException("Can not add null to extent");
            }else {
                productsExtent.add(product);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void removeProduct(Product product){
        try {
            if (product == null){
                throw new NullPointerException("Can not add null to extent");
            }else {
                productsExtent.remove(product);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void showExtent() {
        System.out.println("Extent of the class: " + Product.class.getName());
        for (Product product : productsExtent) {
            System.out.println(product);
        }
    }
}
