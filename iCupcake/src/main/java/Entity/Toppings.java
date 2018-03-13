package Entity;

public class Toppings {
    
    private int toppingsID;
    private String name;
    private int price;

    public Toppings(int toppingsID, String name, int price) {
        this.toppingsID = toppingsID;
        this.name = name;
        this.price = price;
    }

    public int getToppingsID() {
        return toppingsID;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
