package Entity;

public class CupCake {

    private Bottoms bottom;
    private Toppings topping;
    private int price;
    private int quantity;

    public CupCake(Bottoms bottom, Toppings topping, int price, int quantity) {
        this.bottom = bottom;
        this.topping = topping;
        this.price = price;
        this.quantity = quantity;
    }

    public Bottoms getBottom() {
        return bottom;
    }

    public Toppings getTopping() {
        return topping;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
