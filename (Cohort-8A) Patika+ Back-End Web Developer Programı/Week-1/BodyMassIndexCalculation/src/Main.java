import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Scanner object created
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan boy ve kilo değerlerini al
        System.out.print("Lütfen boyunuzu (metre cinsinde) giriniz: ");
        double boy = scanner.nextDouble();

        System.out.print("Lütfen kilonuzu giriniz: ");
        double kilo = scanner.nextDouble();

        // Vücut Kitle İndeksi hesaplama
        double vki = kilo / (boy * boy);

        // Sonucu ekrana yazdırma
        System.out.println("Vücut Kitle İndeksiniz: " + vki);

        // Scanner kapat
        scanner.close();
    }
}
