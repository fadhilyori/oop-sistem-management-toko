package handlers;

import databases.StockList;
import databases.TransactionList;
import models.Stock;
import models.Transaction;
import models.TransactionItem;

import java.util.List;

interface MenuListHandlerInterface {
    void show();
    static void render(MenuListHandlerInterface menuListHandlerInterface) {
        menuListHandlerInterface.show();
    }

    static void printInventory() {
        StockList stockList = StockList.getInstance();
        for (Stock stock : stockList.getList()) {
            System.out.println((stockList.getList().indexOf(stock) + 1) + ". Nama: " + stock.getName() + "\tStok: " + stock.getStock() + "\tHarga: " + stock.getPrice());
        }
    }

    static void printCurrentTransaction(Transaction transaction, Boolean showIDs) {
        for (TransactionItem transactionItem : transaction.getTransactionItemList()) {
            String idPlaceholder = " - ";
            if (showIDs)
                idPlaceholder = transaction.getIndexOf(transactionItem) + ") ";
            System.out.println(idPlaceholder + "Nama: " + transactionItem.getProductName() + "\tJumlah: " + transactionItem.getAmount() + "\tHarga Satuan: " + transactionItem.getProductPrice() + "\tTotal Harga: " + transactionItem.getTotalPrice());
        }

        System.out.println("===================================");
        System.out.println("Total Harga: " + transaction.getTotalPrice());
    }

    static int printCurrentSales() {
        List<Transaction> transactionList = TransactionList.getInstance().getTransactionList();
        int totalSales = 0;

        for (Transaction transaction : transactionList) {
            System.out.println("> Order #" + (transactionList.indexOf(transaction) + 1));
            printCurrentTransaction(transaction, false);
            System.out.println();
            totalSales += transaction.getTotalPrice();
        }

        return totalSales;
    }
}
