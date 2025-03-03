import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<String, Double> fiyatListesi = new HashMap<>();

    static {
        fiyatListesi.put("Armut", 2.14);
        fiyatListesi.put("Elma", 3.67);
        fiyatListesi.put("Domates", 1.11);
        fiyatListesi.put("Muz", 0.95);
        fiyatListesi.put("Patlıcan", 5.00);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double toplamTutar = 0.0;

        System.out.println("Lütfen almak istediğiniz ürünlerin kilogram değerlerini giriniz:");

        for (Map.Entry<String, Double> urun : fiyatListesi.entrySet()) {
            toplamTutar += urunFiyatiHesapla(scanner, urun.getKey(), urun.getValue());
        }

        System.out.printf("Toplam Tutar: %.2f TL\n", toplamTutar);
        scanner.close();
    }

    private static double urunFiyatiHesapla(Scanner scanner, String urunAdi, double kgFiyat) {
        double kilo = 0.0;
        while (true) {
            try {
                System.out.printf("%s Kaç Kilo? : ", urunAdi);
                kilo = Double.parseDouble(scanner.nextLine().replace(",", "."));
                if (kilo < 0) {
                    System.out.println("Hata: Kilogram değeri negatif olamaz! Tekrar girin.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Hata: Geçerli bir sayı giriniz!");
            }
        }
        return kilo * kgFiyat;
    }
}
