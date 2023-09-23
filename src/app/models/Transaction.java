package app.models;

import app.databases.StockList;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private final List<TransactionItem> transactionItemList;
    private int totalPrice;

    /**
     *
     */
    public Transaction() {
        this.transactionItemList = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void add(Stock stock, int amount) {
        try {
            stock.increaseStock(-amount);

            for (TransactionItem item : this.transactionItemList) {
                if (item.getProductName().equals(stock.getName())) {
                    item.setAmount(item.getAmount() + amount);
                    return;
                }
            }

            this.transactionItemList.add(new TransactionItem(stock, amount));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("insufficient stock for " + stock.getName());
        } finally {
            this.updateTotalPrice();
        }
    }

    public void updateTotalPrice() {
        int total = 0;
        for (TransactionItem t : this.transactionItemList) {
            total += t.getTotalPrice();
        }

        this.totalPrice = total;
    }

    public void edit(Stock stock, int amount) {
        for (TransactionItem transactionItem : this.transactionItemList) {
            if (!transactionItem.getProductName().equals(stock.getName())) {
                continue;
            }

            stock.increaseStock(transactionItem.getAmount() - amount);
            transactionItem.setAmount(amount);
            this.updateTotalPrice();
            break;
        }
    }

    public void edit(int i, int amount) {
        TransactionItem transactionItem = this.transactionItemList.get(i);
        Stock stock = StockList.getInstance().get(transactionItem.getProductName());

        stock.increaseStock(transactionItem.getAmount() - amount);
        transactionItem.setAmount(amount);

        this.updateTotalPrice();
    }

    public void remove(Stock stock) {
        for (TransactionItem transactionItem : this.transactionItemList) {
            if (transactionItem.getProductName().equals(stock.getName())) {
                stock.increaseStock(transactionItem.getAmount());
                this.transactionItemList.remove(transactionItem);
                this.updateTotalPrice();
                return;
            }
        }
    }

    public void remove(int id) {
        TransactionItem transactionItem = this.transactionItemList.get(id);
        Stock stock = StockList.getInstance().get(transactionItem.getProductName());

        stock.increaseStock(transactionItem.getAmount());
        this.transactionItemList.remove(id);

        this.updateTotalPrice();
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public List<TransactionItem> getTransactionItemList() {
        return this.transactionItemList;
    }

    public int getIndexOf(TransactionItem transactionItem) {
        return this.transactionItemList.indexOf(transactionItem);
    }
}
