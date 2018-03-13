package Entity;

public class CupCake {

    private int bottomid;
    private int toppingid;
    private final int price;
    private int quantity;

    public CupCake(int bottomid, int toppingid, int price, int quantity) {
        this.bottomid = bottomid;
        this.toppingid = toppingid;
        this.price = price;
        this.quantity = quantity;
    }

    public int getBottomid() {
        return bottomid;
    }

    public int getToppingid() {
        return toppingid;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
