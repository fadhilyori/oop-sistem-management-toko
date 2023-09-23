package handlers;

import utils.ScreenUtil;

import java.util.Scanner;

public class MenuListHandler implements MenuListHandlerInterface {
    final Scanner scanner;

    public MenuListHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int getInputInt() {
        return this.scanner.nextInt();
    }

    public String getInputString() {
        return this.scanner.next();
    }

    private void printOptions() {
        //
    }

    @Override
    public void show() {
        ScreenUtil.clearScreen();
        printOptions();
    }
}
