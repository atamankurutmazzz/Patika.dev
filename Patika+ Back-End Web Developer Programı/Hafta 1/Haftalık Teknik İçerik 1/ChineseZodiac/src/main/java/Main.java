import java.util.Scanner;

public class Main {
    enum ZodiacSign {
        MAYMUN, HOROZ, KÖPEK, DOMUZ, FARE, ÖKÜZ, KAPLAN, TAVŞAN, EJDERHA, YILAN, AT, KOYUN;
    }

    public static void main(String[] args) {
        int birthYear = getUserInput();
        displayResult(fromYear(birthYear));
    }

    private static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Doğum yılınızı giriniz: ");
        int year = scanner.nextInt();
        scanner.close();
        return year;
    }

    public static ZodiacSign fromYear(int year) {
        return ZodiacSign.values()[year % 12];
    }

    private static void displayResult(ZodiacSign zodiacSign) {
        System.out.println("Çin Zodyağı burcunuz: " + zodiacSign);
    }
}
