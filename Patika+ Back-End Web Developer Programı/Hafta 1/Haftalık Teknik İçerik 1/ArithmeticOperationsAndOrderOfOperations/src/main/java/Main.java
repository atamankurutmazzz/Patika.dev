import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int a = getInput(scanner, "a sayısını girin: ");
            int b = getInput(scanner, "b sayısını girin: ");
            int c = getInput(scanner, "c sayısını girin: ");

            int result = calculateResult(a, b, c);

            System.out.println("Sonuç: " + result);
        }
    }
    private static int getInput(Scanner scanner, String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Lütfen geçerli bir sayı girin!");
            scanner.next();
            System.out.print(message);
        }
        return scanner.nextInt();
    }

    private static int calculateResult(int a, int b, int c) {
        return ((a + b) * c) - b;
    }
}