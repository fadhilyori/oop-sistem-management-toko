package handlers;

import utils.ScreenUtil;

public class MenuListHandlerHome extends MenuListHandler {

    private void printOptions() {
        System.out.println("\nMenu:");
        System.out.println("1. Inventaris Stok Produk");
        System.out.println("2. Buat Transaksi");
        System.out.println("3. Melihat Penjualan");
        System.out.println("0. Keluar");
    }

    @Override
    public void show() {
        ScreenUtil.clearScreen();
        printOptions();

        System.out.print("Pilih opsi: ");
        int choice = this.getInputInt();

        switch (choice) {
            case 0:
                return;
            case 1:
                MenuListHandlerInterface.render(new MenuListHandlerInventory());
                break;
            case 2:
                MenuListHandlerInterface.render(new MenuListHandlerOrder());
                break;
            case 3:
                MenuListHandlerInterface.render(new MenuListHandlerSale());
                break;
            default:
                System.out.println("Message: Invalid menu number.");
        }

        this.show();
    }
}
