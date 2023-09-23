package app.handlers;

import app.databases.StockList;
import app.models.Stock;
import app.utils.ScreenUtil;

public class MenuListHandlerInventory extends MenuListHandler {
    private void printOptions() {
        System.out.println("\n======= Menu Inventaris Barang =======");
        System.out.println("1. Lihat Stok Produk");
        System.out.println("2. Tambah Stok Produk");
        System.out.println("3. Hapus Stok Produk");
        System.out.println("0. Batalkan");
        System.out.println("===================================\n");
    }

    private void showAllProduct() {
        System.out.println("\n======= Daftar Stok Produk =======");
        MenuListHandlerInterface.printInventory();
        System.out.println("===================================");
    }

    private void showAddStock() {
        System.out.println("\n======= Tambah Stok Baru =======");
        System.out.print("Nama Produk: ");
        String productName = this.getInputString();
        System.out.print("Harga Produk: ");
        int productPrice = this.getInputInt();
        System.out.print("Stok Produk: ");
        int productStock = this.getInputInt();
        System.out.println("===================================");
        StockList.getInstance().add(new Stock(productName, productPrice, productStock));
        System.out.println("Message: Produk telah ditambahkan.");
    }

    private void showRemoveStock() {
        System.out.println("\n======= Daftar Stok Produk =======");
        MenuListHandlerInterface.printInventory();
        System.out.println("===================================");
        System.out.print("Pilih ID Produk untuk dihapus: ");
        int productID = this.getInputInt() - 1;
        try {
            StockList.getInstance().remove(productID);
            System.out.println("Message: Produk berhasil dihapus.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Message: Produk tidak ditemukan. Coba lagi nanti.");
        }
    }

    @Override
    public void show() {
        ScreenUtil.clearScreen();
        printOptions();

        System.out.print("Masukkan pilihan: ");
        int choice = this.getInputInt();

        switch (choice) {
            case 0:
                return;
            case 1:
                showAllProduct();
                break;
            case 2:
                showAddStock();
                break;
            case 3:
                showRemoveStock();
                break;
        }

        this.show();
    }
}
