package app.models;

public class TransactionItem {
    private final String productName;
    private final int productPrice;
    private int amount;
    private int totalPrice;

    /**
     * @param stock Product stock
     * @param amount Amount of product stock to use
     */
    public TransactionItem(Stock stock, int amount) {
        this.amount = amount;
        this.productPrice = stock.getPrice();
        this.productName = stock.getName();
        updateTotalPrice();
    }

    /**
     * @return Amount of current used stock in this transaction
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * @param amount Amount of product stock to use in this transaction
     */
    public void setAmount(int amount) {
        this.amount = amount;
        this.updateTotalPrice();
    }

    public void updateTotalPrice() {
        this.totalPrice = this.amount * this.productPrice;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getProductPrice() {
        return this.productPrice;
    }
}
