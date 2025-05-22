# PSQL

    PSQL, PostgreSQL ile birlikte gelen terminal tabanlı bir kullanıcı arayüzüdür. PSQL sayesinde komut satırında sorgular yazıp, sonuçlarını görebiliriz. Aşağıda temel PSQL komutlarının ilk bölümünü bulabilirsiniz.

### PSQL ile PostgreSQL'e bağlanmak.

    psql -U <kullanıcı_adı>

### Kullanıcıya ait şifreyi girdikten sonra varsayılan veritabanı postgres'e bağlanıyor.

    postgres=#

### Bulunan veritabanlarını listelemek için:

    \l veya \list

### Bizim örneğimizde dvdrental veritabanına bağlanacağız.

    \c dvdrental veya \connect dvdrental

### Bağlanılan dvdrental veritabanında bulunan tabloları listelemek için:

    \dt

### Herhangi bir tablonun sütunlarını ve tablo detaylarını görmek için:

    \d <tablo_adı>

## Örnek Sorgu Senaryoları

### customer tablosunda bulunan first_name değeri ve last_name değeri 'A' karakteri ile başlayan verileri sıralayınız.

    SELECT * FROM customer
    WHERE first_name LIKE 'A%' AND last_name LIKE 'A%';

### film tablosunda bulunan ve uzunluğu 80 ile 120 arasında bulunan ve aynı zamanda rental_rate değeri 0.99 veya 2.99 olan verileri sıralayınız.

    SELECT * FROM film
    WHERE (length BETWEEN 80 AND 120) AND (rental_rate IN (0.99, 2.99));

PSQL terminal ekranından çıkmak için:

    \q
