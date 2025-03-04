### 1️⃣ **Değişkenlerin Tanımlanması**
Kodun başında, bilet fiyatını hesaplamak için gereken değişkenler tanımlanıyor:

```java
int distance, age, tripType;
double price, normalPrice, ageDiscount = 0, roundTripDiscount = 0;
```

- `distance`: Kullanıcının girdiği mesafe (km).
- `age`: Kullanıcının yaşı.
- `tripType`: Yolculuk tipi (1 = Tek Yön, 2 = Gidiş-Dönüş).
- `price`: Son hesaplanan bilet fiyatı.
- `normalPrice`: Mesafeye bağlı olarak hesaplanan normal bilet fiyatı.
- `ageDiscount`: Yaşa bağlı olarak hesaplanan indirim miktarı.
- `roundTripDiscount`: Gidiş-dönüş indirim miktarı.

---

### 2️⃣ **Kullanıcıdan Veri Alınması**
Kullanıcıdan veri almak için `Scanner` sınıfı kullanılıyor:

```java
Scanner input = new Scanner(System.in);
```

Bu sayede kullanıcıdan giriş almak için aşağıdaki kodlar kullanılıyor:

```java
System.out.print("Mesafeyi km türünden giriniz: ");
distance = input.nextInt();

System.out.print("Yaşınızı giriniz: ");
age = input.nextInt();

System.out.print("Yolculuk tipini giriniz (1 => Tek Yön, 2 => Gidiş Dönüş): ");
tripType = input.nextInt();
```

- `distance`: Kullanıcıdan mesafeyi alır.
- `age`: Kullanıcının yaşını alır.
- `tripType`: Kullanıcının yolculuk tipini alır (Tek Yön veya Gidiş-Dönüş).

---

### 3️⃣ **Geçerli Veri Kontrolü**
Girilen mesafe 0'dan büyük olmalı ve yolculuk tipi 1 veya 2 olmalıdır. Bu kontrol şu şekilde yapılıyor:

```java
if (distance > 0 && (tripType == 1 || tripType == 2)) {
```

Eğer kullanıcı hatalı bir giriş yaparsa (örneğin, negatif mesafe girerse veya yolculuk tipi olarak 3 gibi geçersiz bir sayı girerse), program şu mesajı yazdırır:

```java
System.out.println("Hatalı Veri Girdiniz! Lütfen mesafeyi pozitif girin ve yolculuk türünü 1 veya 2 olarak seçin.");
```

---

### 4️⃣ **Normal Bilet Ücretinin Hesaplanması**
Eğer kullanıcı geçerli bir giriş yapmışsa, önce normal bilet fiyatı hesaplanır:

```java
normalPrice = distance * 0.10; // 1 km başına 0.10 TL
```

---

### 5️⃣ **Yaşa Bağlı İndirim Hesaplaması**
Kullanıcının yaşına göre indirim uygulanır:

```java
if (age < 12) {
    ageDiscount = normalPrice * 0.5; // %50 indirim
} else if (age >= 12 && age < 24) {
    ageDiscount = normalPrice * 0.1; // %10 indirim
} else if (age > 65) {
    ageDiscount = normalPrice * 0.3; // %30 indirim
}
```

- **12 yaş altı**: %50 indirim
- **12-24 yaş arası**: %10 indirim
- **65 yaş üstü**: %30 indirim
- **Diğer yaşlar**: İndirim yok.

Hesaplanan indirim, `ageDiscount` değişkenine atanır.

---

### 6️⃣ **İndirimli Fiyatın Hesaplanması**
Yaş indirimi uygulandıktan sonra yeni fiyat hesaplanır:

```java
double discountedPrice = normalPrice - ageDiscount;
```

---

### 7️⃣ **Gidiş-Dönüş İndirimi**
Eğer yolculuk tipi "Gidiş-Dönüş" ise ek olarak %20 indirim uygulanır:

```java
if (tripType == 2) {
    roundTripDiscount = discountedPrice * 0.2; // %20 indirim
    price = (discountedPrice - roundTripDiscount) * 2; // Gidiş dönüş bileti olduğu için fiyat 2 ile çarpılır
} else {
    price = discountedPrice;
}
```

Eğer tek yönse, sadece yaş indirimi uygulanmış fiyat kullanılır.

---

### 8️⃣ **Sonuçların Yazdırılması**
Son olarak hesaplanan bilet fiyatı detaylı bir şekilde ekrana yazdırılır:

```java
System.out.println("\n---------- Bilet Fiyatı Detayları ----------");
System.out.println("Normal Tutar: " + normalPrice + " TL");
System.out.println("Yaş İndirimi: -" + ageDiscount + " TL");
System.out.println("Gidiş-Dönüş İndirimi: -" + roundTripDiscount + " TL");
System.out.println("-------------------------------------------");
System.out.println("Toplam Tutar: " + price + " TL");
```

Bu çıktı, kullanıcının bilet fiyatını anlamasını sağlar.

---

### 9️⃣ **Scanner Nesnesinin Kapatılması**
Kodun sonunda şu satır bulunuyor:

```java
input.close();
```

Bu, `Scanner` nesnesini kapatarak gereksiz kaynak kullanımını önler.

---

## **Örnek Kullanım ve Çıktılar**

### **Örnek 1**: 20 yaşında bir yolcu, 500 km tek yön bilet almak istiyor.
**Girdi:**
```
Mesafeyi km türünden giriniz: 500
Yaşınızı giriniz: 20
Yolculuk tipini giriniz (1 => Tek Yön, 2 => Gidiş Dönüş): 1
```

**Hesaplama:**
- Normal fiyat: `500 * 0.10 = 50 TL`
- Yaş indirimi: `50 * 0.10 = 5 TL`
- Gidiş-Dönüş indirimi: `0 TL`
- Toplam fiyat: `50 - 5 = 45 TL`

**Çıktı:**
```
---------- Bilet Fiyatı Detayları ----------
Normal Tutar: 50.0 TL
Yaş İndirimi: -5.0 TL
Gidiş-Dönüş İndirimi: -0.0 TL
-------------------------------------------
Toplam Tutar: 45.0 TL
```

---

### **Örnek 2**: 10 yaşında bir yolcu, 300 km gidiş-dönüş bileti almak istiyor.
**Girdi:**
```
Mesafeyi km türünden giriniz: 300
Yaşınızı giriniz: 10
Yolculuk tipini giriniz (1 => Tek Yön, 2 => Gidiş Dönüş): 2
```

**Hesaplama:**
- Normal fiyat: `300 * 0.10 = 30 TL`
- Yaş indirimi: `30 * 0.50 = 15 TL`
- İndirimli fiyat: `30 - 15 = 15 TL`
- Gidiş-Dönüş indirimi: `15 * 0.20 = 3 TL`
- Toplam fiyat: `(15 - 3) * 2 = 24 TL`

**Çıktı:**
```
---------- Bilet Fiyatı Detayları ----------
Normal Tutar: 30.0 TL
Yaş İndirimi: -15.0 TL
Gidiş-Dönüş İndirimi: -3.0 TL
-------------------------------------------
Toplam Tutar: 24.0 TL
```

---

## **Sonuç**
Bu program, girilen mesafe, yaş ve yolculuk tipine göre bilet fiyatını hesaplayan basit ama etkili bir sistemdir. Kullanıcı hatalı giriş yaparsa uyarı verir ve doğru hesaplama yapabilmesi için gerekli kontrolleri içerir.
