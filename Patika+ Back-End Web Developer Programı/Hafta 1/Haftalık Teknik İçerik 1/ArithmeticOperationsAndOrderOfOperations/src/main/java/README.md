
# Java Program Açıklaması

Bu Java programı, kullanıcıdan üç tam sayı alarak belirli bir matematiksel işlemi gerçekleştiren bir programdır. Şimdi kodu adım adım açıklayalım:



## **1. Scanner Kullanımı ve Giriş Alma**
```java
try (Scanner scanner = new Scanner(System.in)) {
```
- `Scanner` sınıfı, kullanıcıdan giriş almak için kullanılır.
- `try` bloğu içinde tanımlandığı için, `scanner` otomatik olarak kapanacaktır (`try-with-resources` kullanımı).

```java
int a = getInput(scanner, "a sayısını girin: ");
int b = getInput(scanner, "b sayısını girin: ");
int c = getInput(scanner, "c sayısını girin: ");
```
- `getInput` metodunu kullanarak, kullanıcıdan `a`, `b` ve `c` değişkenleri için giriş alınır.

---

## **2. Kullanıcıdan Güvenli Giriş Alma (getInput Metodu)**
```java
private static int getInput(Scanner scanner, String message) {
    System.out.print(message);
    while (!scanner.hasNextInt()) { 
        System.out.println("Lütfen geçerli bir sayı girin!");
        scanner.next(); 
        System.out.print(message);
    }
    return scanner.nextInt();
}
```
Bu metod, kullanıcıdan **geçerli bir tam sayı girilmesini** sağlar:
- `System.out.print(message);` → Kullanıcıdan giriş istenir.
- `while (!scanner.hasNextInt())` → Eğer kullanıcı geçerli bir tam sayı girmezse:
  - `"Lütfen geçerli bir sayı girin!"` mesajı gösterilir.
  - `scanner.next();` ile hatalı giriş temizlenir.
  - Kullanıcıdan tekrar giriş yapması istenir.
- `scanner.nextInt();` ile doğru giriş alındığında geri döndürülür.

---

## **3. Matematiksel Hesaplama**
```java
private static int calculateResult(int a, int b, int c) {
    return ((a + b) * c) - b;
}
```
- `(a + b) * c - b` işlemini yaparak sonucu döndürür.

---

## **4. Sonucu Ekrana Yazdırma**
```java
int result = calculateResult(a, b, c);
System.out.println("Sonuç: " + result);
```
- Kullanıcının girdiği değerlere göre hesaplanan sonuç ekrana yazdırılır.

---

## **Örnek Çalışma**
### **Giriş:**
```
a sayısını girin: 3
b sayısını girin: 2
c sayısını girin: 4
```
### **Hesaplama:**
```
((3 + 2) * 4) - 2
= (5 * 4) - 2
= 20 - 2
= 18
```
### **Çıktı:**
```
Sonuç: 18
```

Bu program, kullanıcıdan güvenli bir şekilde giriş alıp işlemi yaptıktan sonra sonucu ekrana yazdırır. 🚀
```
