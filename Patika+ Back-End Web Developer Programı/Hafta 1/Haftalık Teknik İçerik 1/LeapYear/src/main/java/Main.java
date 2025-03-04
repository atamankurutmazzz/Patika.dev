import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int year = getUserInput();
        boolean isLeap = isLeapYear(year);
        displayResult(year, isLeap);
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Yıl Giriniz: ");
        int year = scanner.nextInt();
        scanner.close();
        return year;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static void displayResult(int year, boolean isLeap) {
        if (isLeap) {
            System.out.println(year + " bir artık yıldır!");
        } else {
            System.out.println(year + " bir artık yıl değildir!");
        }
    }
}
