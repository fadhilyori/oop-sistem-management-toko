package handlers;

import utils.ScreenUtil;

public class MenuListHandlerSale extends MenuListHandler {

    private void printOptions() {
        System.out.println("\n======= List Penjualan =======");
        int totalSales = MenuListHandlerInterface.printCurrentSales();
        System.out.println("===================================");
        System.out.println("Total Penjualan: " + totalSales);
    }

    @Override
    public void show() {
        ScreenUtil.clearScreen();
        printOptions();
    }
}
