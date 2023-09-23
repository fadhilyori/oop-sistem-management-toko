package app;

import app.databases.StockList;
import app.handlers.MenuListHandlerHome;
import app.models.Stock;

public class Main {
    public static void main(String[] args) {
        MenuListHandlerHome menuListHome = new MenuListHandlerHome();
        StockList stockList = StockList.getInstance();

        // Add sample product stock
        stockList.add(new Stock("Milk", 6500, 15));
        stockList.add(new Stock("Coffee", 25000, 15));
        stockList.add(new Stock("Yoghurt", 8500, 15));
        stockList.add(new Stock("Lemon Tea", 4000, 15));

        // Show Home Menu
        menuListHome.show();
    }
}