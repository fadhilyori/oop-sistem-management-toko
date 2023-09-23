package app.models;

public class Product {
    private String name;
    private int price;

    /**
     * @param name Product name
     * @param price Product price
     */
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * @return String Product name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name Product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int Product price
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * @param price Product price
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
