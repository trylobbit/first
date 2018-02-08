package hello;

/**
 * Created by kasia on 07.02.18.
 */
class Product {

    private long id;
    private String name;
    private double price;
    private String clarity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getClarity(){ return clarity;}

    public void setClarity(String clarity) { this.clarity = clarity;}

    public String getName(){ return name;}

    public void setName(String name) { this.name = name;}
}