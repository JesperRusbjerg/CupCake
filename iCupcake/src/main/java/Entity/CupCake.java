package Entity;

public class CupCake {

    private final String bottom;
    private final String top;
    private final int price;
    private int quantity;

    public CupCake(String bottom, String top, int price, int amount) {
        this.bottom = bottom;
        this.top = top;
        this.price = price;
        this.quantity = amount;
    }

    public String getBottom() {
        return bottom;
    }

    public String getTop() {
        return top;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
