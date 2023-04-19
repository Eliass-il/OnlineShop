public class Item extends Product{
    private Order order;
    private int quantity;

    public Item(String productName, float price, String description, int quantity) {
        super(productName, price, description);
        setQuantity(quantity);
    }

    //getters
    public int getQuantity(){
        return quantity;
    }

    //setters
    public void setQuantity(int quantity){
        try {
            if (quantity < 1){
                throw new Exception("Quantity can not be less than 1.");
            }else {
                this.quantity = quantity;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
