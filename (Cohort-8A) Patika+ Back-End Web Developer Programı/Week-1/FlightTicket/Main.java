import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Kullanıcıdan alınacak değişkenler (Variables to be taken from the user)
        int distance, age, tripType;
        double price, normalPrice, ageDiscount = 0, roundTripDiscount = 0;

        // Kullanıcıdan giriş almak için Scanner sınıfı (Scanner object to get user input)
        Scanner input = new Scanner(System.in);

        System.out.print("Mesafeyi km türünden giriniz: ");
        distance = input.nextInt();

        System.out.print("Yaşınızı giriniz: ");
        age = input.nextInt();

        System.out.print("Yolculuk tipini giriniz (1 => Tek Yön, 2 => Gidiş Dönüş): ");
        tripType = input.nextInt();

        // Geçerli bir mesafe ve yolculuk türü kontrolü (Check for valid distance and trip type)
        if (distance > 0 && (tripType == 1 || tripType == 2)) {
            // Normal bilet ücreti hesaplanır (Normal ticket price calculation)
            normalPrice = distance * 0.10; // 1 km = 0.10 TL

            // Yaşa bağlı indirim hesaplanır (Age-based discount calculation)
            if (age < 12) {
                ageDiscount = normalPrice * 0.5; // %50 indirim (50% discount)
            } else if (age >= 12 && age < 24) {
                ageDiscount = normalPrice * 0.1; // %10 indirim (10% discount)
            } else if (age > 65) {
                ageDiscount = normalPrice * 0.3; // %30 indirim (30% discount)
            }

            // Yaş indirimi sonrası ücret (Price after age discount)
            double discountedPrice = normalPrice - ageDiscount;

            // Gidiş-Dönüş indirimi hesaplanır (Calculate round-trip discount if applicable)
            if (tripType == 2) {
                roundTripDiscount = discountedPrice * 0.2; // %20 indirim (20% discount)
                price = (discountedPrice - roundTripDiscount) * 2; // Gidiş dönüş için *2 (Multiply by 2 for round-trip)
            } else {
                price = discountedPrice;
            }

            // Çıktılar ekrana yazdırılır (Print the final ticket price details)
            System.out.println("\n---------- Bilet Fiyatı Detayları ----------");
            System.out.println("Normal Tutar: " + normalPrice + " TL");
            System.out.println("Yaş İndirimi: -" + ageDiscount + " TL");
            System.out.println("Gidiş-Dönüş İndirimi: -" + roundTripDiscount + " TL");
            System.out.println("-------------------------------------------");
            System.out.println("Toplam Tutar: " + price + " TL");
        } else {
            System.out.println("Hatalı Veri Girdiniz! Lütfen mesafeyi pozitif girin ve yolculuk türünü 1 veya 2 olarak seçin.");
        }

        // Scanner'ı kapat (Close the Scanner object)
        input.close();
    }
}
