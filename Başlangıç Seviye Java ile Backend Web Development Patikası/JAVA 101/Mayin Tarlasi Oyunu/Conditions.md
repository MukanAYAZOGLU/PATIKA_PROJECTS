# Mayın Tarlası Oyunu

## Java dilinde Mayın Tarlası oyunu yapmanızı bekliyoruz.

### Oyun Kuralları:

+    Oyun metin tabanlıdır.

+    Proje çift boyutlu diziler kullanılarak yapılmalıdır.

+    MineSweeper sınıfı içerisinde tasarlanmalıdır. Metodlar kullanılarak kod tekrarı önlenmelidir.

+    Matris boyutunu yani satır ve sütun sayısını kullanıcı belirlemelidir. Minimum 2x2 boyutunda matris girişine izin verilmeli, 2x2 den küçük değer girişlerinde kullanıcıya uyarı verilmeli ve tekrar satır, sütun girmesi istenmelidir.

+    Diziye ait eleman sayısının çeyreği (elemanSayisi / 4) kadar rastgele mayın yerleştirilmelidir. Mayın sayısı, eleman sayısı/4'ten az ya da çok olmamalıdır. Örneğin dizi 4x3 boyutunda ise eleman sayısı (satırSayısı * sütunSayısı) formülü ile hesaplanmalı ve boyutu 12 olacaktır. Bu durumda mayın sayısı 12 / 4 = 3 adet olmalıdır. 3'ten az ya da çok olmamalıdır.

+    İpucu: 2 boyutlu diziler string veri türünde olması işinizi kolaylaştıracaktır. Mayınların konumlarını tutacak bir dizi, oyuncuya göstereceğiniz ayrı bir dizi tanımlamalısınız.

+    Oyuncuya gösterilen haritada hiç açılmamış kutucukları "-" sembolü ile göstermelisiniz.

+    Mayınlar "*" sembolü ile gösterilmelidir. Farklı semboller kullanmayınız.

+    Kullanıcı matris üzerinden bir nokta seçmeli, nokta seçimi için satır ve sütun değerlerini girmesi istenilmelidir.

+    Seçilen noktanın dizinin sınırları içerisinde olup olmadığı kontrol edilmeli ve koşul sağlanmazsa konsolda uyarı metni yazdırılıp kullanıcıdan tekrar yeni koordinat istenmelidir.

+    Daha önce girilmiş bir koordinat girildiğinde kullanıcıya "bu koordinat daha önce seçildi, başka bir koordinat girin" şeklinde uyarı gösterilmeli ve yeni giriş yapması sağlanmalıdır.
+    Kullanıcının girdiği noktada mayın var ise oyunu kaybetmelidir. Buna uygun şekilde konsolda mesaj gösterilmelidir.

+    Kullanıcının girdiği noktada mayın yok ise, noktanın etrafındaki tüm komşu konumlara bakılmalı (sağı, solu, yukarısı, aşağısı, sol üst çapraz, sağ üst çapraz, sağ alt çapraz, sol alt çapraz) ve bu komşu noktalardaki mayınların sayısının toplamı kullanıcının girmiş olduğu koordinata yazılmalıdır. Noktaya değen herhangi bir mayın yok ise "0" değeri yazılmalıdır. Farklı değer ve sembol kullanmayın.

+    Kullanıcı hiç bir mayına basmadan tüm noktaları açarsa oyunu kazanmalıdır. Bu durumda da uygun mesaj konsolda gösterilmelidir.