package app.handlers;

import app.databases.StockList;
import app.databases.TransactionList;
import app.models.Stock;
import app.models.Transaction;
import app.utils.ScreenUtil;

import java.util.NoSuchElementException;

public class MenuListHandlerOrder extends MenuListHandler {

    private final Transaction transaction = new Transaction();

    private void printOptions() {
        System.out.println("\n======= Daftar Stok Produk =======");
        MenuListHandlerInterface.printInventory();
        System.out.println();
        System.out.println("0. Batalkan");
        System.out.println("97. Edit");
        System.out.println("98. Hapus");
        System.out.println("99. Simpan");
        System.out.println("===================================\n");
    }

    @Override
    public void show() {
        ScreenUtil.clearScreen();

        showChart(false);
        printOptions();

        System.out.print("Pilih barang yang anda beli: ");
        int choice = this.getInputInt();

        switch (choice) {
            case 0:
                return;
            case 97:
                editMenu();
                this.show();
                break;
            case 98:
                hapusMenu();
                this.show();
                break;
            case 99:
                simpanMenu();
                return;
            default:
                orderMenu(choice);
                this.show();
        }
    }

    public void showChart(Boolean showIDs) {
        System.out.println("============== Chart ==============");
        MenuListHandlerInterface.printCurrentTransaction(this.transaction, showIDs);
        System.out.println("===================================\n");
    }

    private void editMenu() {
        showChart(true);
        System.out.print("ID barang yang ingin di edit: ");
        int productID = this.getInputInt();
        System.out.print("Jumlah baru: ");
        int newAmount = this.getInputInt();
        try {
            if (newAmount < 0) {
                throw new IllegalArgumentException("jumlah tidak dapat bernilai nol atau negatif");
            }
            if (newAmount == 0) {
                this.transaction.remove(productID);
            } else {
                this.transaction.edit(productID, newAmount);
            }
            System.out.println("Message: Keranjang telah diperbarui.");
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.println("Message: " + e.getMessage());
        }
    }

    private void hapusMenu() {
        showChart(true);
        System.out.print("ID barang pada keranjang yang ingin dihapus: ");
        int productID = this.getInputInt();
        this.transaction.remove(productID);
    }

    private void simpanMenu() {
        TransactionList.getInstance().add(this.transaction);
        System.out.println("Message: Transaksi telah disimpan.");
        System.out.println("\n============= Receipt =============");
        MenuListHandlerInterface.printCurrentTransaction(this.transaction, false);
        System.out.println("===================================\n");
    }

    private void orderMenu(int choice) {
        System.out.print("Jumlah: ");
        int amount = this.getInputInt();

        try {
            if (amount < 0) {
                throw new IllegalArgumentException("jumlah tidak dapat bernilai nol atau negatif");
            }
            Stock stock = StockList.getInstance().get(choice - 1);
            this.transaction.add(stock, amount);
            System.out.println("Message: Produk berhasil ditambahkan.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Message: Produk yang anda pilih tidak valid.");
        } catch (RuntimeException e) {
            System.out.println("Message: " + e.getMessage());
        }
    }
}
