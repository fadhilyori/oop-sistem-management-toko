package app.utils;

import java.io.IOException;

public class ScreenUtil {
    /**
     * Try to clear screen
     */
    public static void clearScreen() {
        try {
            Runtime.getRuntime().exec("clear");
        } catch (IOException e) {
            System.out.println();
        }
    }
}
