package banco_agenda;

import java.util.Scanner;

public class ScannerFactory {
    private static Scanner scan = new Scanner(System.in);

    public static Scanner getScanner(){
        return scan;
    }

    public static void closeScanner(){
        scan.close();
    }
}
