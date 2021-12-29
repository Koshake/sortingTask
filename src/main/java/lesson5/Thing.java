package lesson5;

public class Thing {

    double price;
    double weight;
    String name;

    public Thing( String name, int price, int weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "{ " + name + " price " + price + " weight " + weight + " }";
    }
}
