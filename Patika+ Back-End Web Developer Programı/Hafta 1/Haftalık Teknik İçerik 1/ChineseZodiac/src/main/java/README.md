### 1. **ZodiacSign Enum (Çin Zodyağı Burçları)**:
```java
enum ZodiacSign {
    MAYMUN, HOROZ, KÖPEK, DOMUZ, FARE, ÖKÜZ, KAPLAN, TAVŞAN, EJDERHA, YILAN, AT, KOYUN;
}
```
Bu enum, 12 Çin Zodyağı burcunu temsil eder. Her burç bir hayvanı simgeler:
- **MAYMUN** (Monkey)
- **HOROZ** (Rooster)
- **KÖPEK** (Dog)
- **DOMUZ** (Pig)
- **FARE** (Rat)
- **ÖKÜZ** (Ox)
- **KAPLAN** (Tiger)
- **TAVŞAN** (Rabbit)
- **EJDERHA** (Dragon)
- **YILAN** (Snake)
- **AT** (Horse)
- **KOYUN** (Sheep)

Bu hayvanlar, Çin Zodyağı'nda her yıl için bir döngü oluştururlar ve her yıl bu hayvanlardan birisi ile ilişkilendirilir.

### 2. **Ana Program (main method)**:
```java
public static void main(String[] args) {
    int birthYear = getUserInput();
    displayResult(fromYear(birthYear));
}
```
Bu ana metodun amacı, kullanıcıdan doğum yılı almak, ardından o yılı Çin Zodyağı'na göre hangi burçla ilişkilendirildiğini hesaplamak ve son olarak bu burcu ekrana yazdırmaktır.

- `getUserInput()`: Kullanıcının doğum yılı bilgisini alır.
- `fromYear(birthYear)`: Kullanıcının doğum yılına göre hangi burçla ilişkilendirildiğini bulur.
- `displayResult(zodiacSign)`: Bulunan burcu ekrana yazdırır.

### 3. **Kullanıcıdan Yıl Alma (getUserInput Method)**:
```java
private static int getUserInput() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Doğum yılınızı giriniz: ");
    int year = scanner.nextInt();
    scanner.close();
    return year;
}
```
Bu metot, kullanıcının doğum yılını alır. `Scanner` sınıfı ile konsol üzerinden kullanıcıdan bir yıl girmesi istenir. Kullanıcı girdikten sonra bu yıl `year` değişkenine atanır ve metot bu değeri döndürür.

### 4. **Burç Hesaplama (fromYear Method)**:
```java
public static ZodiacSign fromYear(int year) {
    return ZodiacSign.values()[year % 12];
}
```
Bu metot, verilen doğum yılına karşılık gelen Çin Zodyağı burcunu hesaplar.

- `ZodiacSign.values()`: `ZodiacSign` enum'undaki tüm burçları bir dizi olarak döndürür. Yani bu, tüm burçları sırasıyla tutan bir dizi olur.
- `year % 12`: Bu, doğum yılı ile 12'nin kalanını hesaplar. Çünkü Çin Zodyağı döngüsü 12 yıldan oluşur ve her yıl bir burç ile ilişkilendirilir. Örneğin, 2000 yılı 12'ye bölündüğünde kalan 0 olacaktır, yani 0. indekse denk gelen burç olan "MAYMUN" burcu gelir.
  
  Örnekler:
  - 2021 yılı için 2021 % 12 = 9, yani 9. indeks olan **"EJDERHA"** burcu gelir.
  - 1990 yılı için 1990 % 12 = 6, yani 6. indeks olan **"ÖKÜZ"** burcu gelir.

### 5. **Sonuçları Ekrana Yazdırma (displayResult Method)**:
```java
private static void displayResult(ZodiacSign zodiacSign) {
    System.out.println("Çin Zodyağı burcunuz: " + zodiacSign);
}
```
Bu metot, hesaplanan burcu ekrana yazdırır. `ZodiacSign` enum'undaki değer otomatik olarak ismiyle yazdırılır, örneğin **"EJDERHA"** veya **"MAYMUN"** gibi.

### Örnek Çalışma:
Diyelim ki kullanıcı 1992 yılını giriyor.

1. Kullanıcıdan yıl alınır: `1992`.
2. `fromYear(1992)` metodu çalışır:
   - 1992 % 12 = 0, yani 0. indeks olan **"MAYMUN"** burcu gelir.
3. Bu burç ekrana yazdırılır: **"Çin Zodyağı burcunuz: MAYMUN"**.

### Özet:
Bu program, kullanıcının doğum yılına dayanarak Çin Zodyağı burcunu hesaplar ve ekrana yazdırır. Burçlar, 12 yıllık bir döngüye göre sıralanmıştır ve her yıl belirli bir burçla ilişkilendirilir.
