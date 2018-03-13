package Entity;

public class CupCake {

    private int bottomsID;
    private int toppingsID;
    private final int price;
    private int quantity;

    public CupCake(int bottomsID, int toppingsID, int price, int quantity) {
        this.bottomsID = bottomsID;
        this.toppingsID = toppingsID;
        this.price = price;
        this.quantity = quantity;
    }

    public int getBottomsID() {
        return bottomsID;
    }

    public int getToppingsID() {
        return toppingsID;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
