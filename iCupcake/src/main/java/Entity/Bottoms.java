package Entity;

public class Bottoms {

    private int bottomsID;
    private String name;
    private int price;

    public Bottoms(int bottomsID, String name, int price) {
        this.bottomsID = bottomsID;
        this.name = name;
        this.price = price;
    }

    public int getBottomsID() {
        return bottomsID;
    }

  

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

}
