import java.util.ArrayList;
import java.util.List;

public class Product {
    private final int idProduct;
    private String productName;
    private float price;
    private String description;
    private List<Order> orders = new ArrayList<>();

    public Product(String productName, float price, String description){
        idProduct = (int)(Math.random() * (9999999 - 1 + 1)) + 1;
        setProductName(productName);
        setPrice(price);
        setDescription(description);
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
}
