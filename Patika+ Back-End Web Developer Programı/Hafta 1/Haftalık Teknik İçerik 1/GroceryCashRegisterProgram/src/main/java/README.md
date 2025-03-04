---

## **Kodun Detaylı Açıklaması**
Bu Java programı, bir manavdan alışveriş yapmak isteyen kullanıcıdan her bir ürün için kaç kilogram almak istediğini sorar, ürünlerin fiyatlarıyla çarpar ve toplam alışveriş tutarını hesaplar.

---

## **1. Ürün Fiyat Listesinin Tanımlanması**
```java
private static final Map<String, Double> fiyatListesi = new HashMap<>();
```
- **`Map<String, Double>` veri yapısı**, ürün isimlerini (String) ve kilogram fiyatlarını (Double) saklamak için kullanılıyor.
- **`static {}` bloğu**, program başladığında fiyat listesinin otomatik olarak doldurulmasını sağlıyor.
- **`final` anahtar kelimesi**, listenin değiştirilmesini engelliyor (yeni ürün eklenemez veya fiyatlar değiştirilemez).

```java
static {
    fiyatListesi.put("Armut", 2.14);
    fiyatListesi.put("Elma", 3.67);
    fiyatListesi.put("Domates", 1.11);
    fiyatListesi.put("Muz", 0.95);
    fiyatListesi.put("Patlıcan", 5.00);
}
```
Bu kısım, **beş farklı ürünün kilogram fiyatlarını** `fiyatListesi` adlı `HashMap` içine ekler.

---

## **2. Kullanıcıdan Ürün Miktarı Alma ve Toplam Tutarı Hesaplama**
```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double toplamTutar = 0.0;
```
- **`Scanner scanner = new Scanner(System.in);`**  
  - Kullanıcıdan veri almak için `Scanner` nesnesi oluşturuluyor.  
- **`double toplamTutar = 0.0;`**  
  - Kullanıcının aldığı tüm ürünlerin toplam tutarını hesaplamak için bir değişken başlatılıyor.

```java
System.out.println("Lütfen almak istediğiniz ürünlerin kilogram değerlerini giriniz:");
```
- **Bilgilendirici mesaj** ekrana yazdırılıyor.

```java
for (Map.Entry<String, Double> urun : fiyatListesi.entrySet()) {
    toplamTutar += urunFiyatiHesapla(scanner, urun.getKey(), urun.getValue());
}
```
- **`fiyatListesi.entrySet()`** ile `Map` içindeki tüm ürünler döngüye sokuluyor.
- Her ürün için:
  - Kullanıcıdan kilogram miktarı alınıyor.
  - **`urunFiyatiHesapla()`** metodu çağrılarak ürün fiyatı hesaplanıyor.
  - Hesaplanan fiyat **`toplamTutar`** değişkenine ekleniyor.

```java
System.out.printf("Toplam Tutar: %.2f TL\n", toplamTutar);
scanner.close();
```
- **Sonuç olarak, toplam tutar iki ondalık basamaklı olarak ekrana yazdırılıyor.**
- **`scanner.close();`** ile `Scanner` kapatılıyor.

---

## **3. Kullanıcıdan Ürün Miktarını Alma ve Ürün Fiyatını Hesaplama**
```java
private static double urunFiyatiHesapla(Scanner scanner, String urunAdi, double kgFiyat) {
```
- **Bu metodun görevi**, kullanıcıdan bir ürün için kilogram miktarını almak ve fiyatını hesaplamaktır.
- **Parametreler:**
  - `Scanner scanner`: Kullanıcıdan veri almak için.
  - `String urunAdi`: Ürünün ismi.
  - `double kgFiyat`: Ürünün kilogram fiyatı.

```java
double kilo = 0.0;
while (true) {
    try {
        System.out.printf("%s Kaç Kilo? : ", urunAdi);
        kilo = Double.parseDouble(scanner.nextLine().replace(",", "."));
```
- **Sonsuz döngü (`while (true)`)** ile kullanıcıdan geçerli bir giriş alana kadar devam eder.
- **Kullanıcının girdiği metin**, `Double.parseDouble()` metodu ile sayıya çevrilir.
  - `replace(",", ".")`: Kullanıcı virgül (`2,5`) kullanırsa onu noktaya (`2.5`) çevirerek sayıya çevrilebilir olmasını sağlar.

```java
if (kilo < 0) {
    System.out.println("Hata: Kilogram değeri negatif olamaz! Tekrar girin.");
    continue;
}
```
- Eğer kullanıcı negatif bir değer girerse, hata mesajı yazdırılır ve tekrar giriş istenir.

```java
break;
```
- Kullanıcı geçerli bir değer girdiyse, döngüden çıkılır.

```java
} catch (NumberFormatException e) {
    System.out.println("Hata: Geçerli bir sayı giriniz!");
}
```
- Eğer kullanıcı harf veya geçersiz bir karakter girerse (`abc`, `2x` gibi), hata mesajı gösterilir ve tekrar giriş istenir.

```java
return kilo * kgFiyat;
```
- **Girilen kilogram değeri, ürünün fiyatıyla çarpılarak toplam fiyat döndürülür.**

---

## **Kodun Çalışma Mantığı Özetlenirse:**
1. **Ürün fiyatları bir `HashMap` içine kaydedilir.**
2. **Kullanıcıdan her ürün için kilogram değeri istenir.**
   - Negatif sayı veya hatalı giriş olup olmadığı kontrol edilir.
3. **Her ürün için toplam fiyat hesaplanır ve genel toplam eklenir.**
4. **Son olarak, toplam tutar ekrana yazdırılır.**

---

## **Örnek Kullanıcı Girişi ve Çıktısı**
### **Örnek 1 – Geçerli Girişler**
#### Kullanıcının girdileri:
```
Lütfen almak istediğiniz ürünlerin kilogram değerlerini giriniz:
Armut Kaç Kilo? : 2
Elma Kaç Kilo? : 1,5
Domates Kaç Kilo? : 3
Muz Kaç Kilo? : 2.2
Patlıcan Kaç Kilo? : 1
```
#### Programın çıktısı:
```
Toplam Tutar: 22.26 TL
```
(Hesap: \( 2 \times 2.14 + 1.5 \times 3.67 + 3 \times 1.11 + 2.2 \times 0.95 + 1 \times 5.00 \))

---

### **Örnek 2 – Hatalı Girişler**
#### Kullanıcının girdileri:
```
Lütfen almak istediğiniz ürünlerin kilogram değerlerini giriniz:
Armut Kaç Kilo? : -2
Hata: Kilogram değeri negatif olamaz! Tekrar girin.
Armut Kaç Kilo? : abc
Hata: Geçerli bir sayı giriniz!
Armut Kaç Kilo? : 2
```
#### Programın çıktısı:
```
Hata: Kilogram değeri negatif olamaz! Tekrar girin.
Hata: Geçerli bir sayı giriniz!
```
Ve kullanıcı tekrar geçerli bir giriş yapmak zorunda kalır.

---

## **Kodun Güçlü Yönleri**
✅ **Kullanıcı dostu:** Kullanıcının hatalı giriş yapmasını engelleyen kontroller var.  
✅ **Esneklik:** Kullanıcı virgül (`2,5`) veya nokta (`2.5`) kullanabilir.  
✅ **Hata yönetimi:** Kullanıcı harf veya yanlış giriş yaparsa uyarı verip tekrar denemesini sağlıyor.  
✅ **Temiz ve düzenli kod:** Mantıksal bölmelere ayrılmış ve kolay okunur.

---

Bu detaylı açıklamayla birlikte artık kodun mantığını ve işleyişini çok daha iyi anlayabilirsin! 🎯🚀
