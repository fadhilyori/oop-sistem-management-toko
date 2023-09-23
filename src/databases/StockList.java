package databases;

import models.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StockList {
    private static StockList instance = null;
    private final List<Stock> stockList;

    public StockList() {
        this.stockList = new ArrayList<>();
    }

    public static synchronized StockList getInstance() {
        if (instance == null) instance = new StockList();

        return instance;
    }

    public void add(Stock stock) {
        this.stockList.add(stock);
    }

    public void remove(int i) {
        this.stockList.remove(i);
    }

    public List<Stock> getList() {
        return this.stockList;
    }

    public Stock get(int i) {
        return this.stockList.get(i);
    }

    public Stock get(String name) {
        for (Stock stock : this.stockList) {
            if (stock.getName().equals(name))
                return stock;
        }

        throw new NoSuchElementException("stock couldn't found.");
    }
}
