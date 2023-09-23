package app.models;

public class Stock extends Product {

    private int stock;

    /**
     * @param name Product name
     * @param price Product price
     * @param stock Product stock
     */
    public Stock(String name, int price, int stock) {
        super(name, price);
        this.setStock(stock);
    }

    /**
     * Get current product stock
     * @return int Product stock
     */
    public int getStock() {
        return this.stock;
    }

    /**
     * Set Product stock by the amount
     *
     * @param amount New amount of product stock
     */
    public void setStock(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.stock = amount;
    }

    /**
     * Increase the stock by the amount
     *
     * @param amount New amount to add to product stock
     */
    public void increaseStock(int amount) {
        this.setStock(this.stock + amount);
    }
}
