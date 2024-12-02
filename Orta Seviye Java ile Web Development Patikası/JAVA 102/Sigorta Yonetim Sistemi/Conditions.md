# Sigorta Yönetim Sistemi

Sigorta firması için bir yazılım yaptığınızı düşünün. Sigorta firmasının "Bireysel" (Account.Individual) ve "Kurumsal" (Account.Enterprise) olmak üzere iki tip müşteri profili bulunmaktadır. Müşteri profili için "Account.Account" isminde soyut sınıf (abstract class) tasarlayınız. Account.Account sınıfı müşterinin sisteme giriş sonrasında tüm bilgilerinin tutulduğu hesap bilgisidir. "Account.Account" sınıfı içinde "Account.User" tipinde bir nesne referansı bulunur. (Aggeration ilişkisi olarak)


"Account.User" sınıfı müşterinin kişi bilgilerini ifade eder. "Account.User" sınıfında müşterinin;

+ isim (String),
+ soyisim (String),
+ email (String),
+ şifre (String),
+ meslek (String),
+ yaş (int),
+ adres listesi  (ArrayList <Address>)
+ sisteme son giriş tarihi (Date)


bilgileri bulunur. Ayrıca, "Account.User" sınıfında ArrayList tipinde adreslerinin tutulduğu bir liste vardır. Adres bilgisi iki tiptir. Ev adresi ("HomeAddress") ve İş adresi ("BusinessAddress") olmak üzere iki tane sınıf tasarlayınız. Bu adres sınıfları "Address" isimli bir interface'den kalıtım alacaktır. Fakat, bu interface'de hangi fonksiyonların olması gerektiğine siz karar vereceksiniz.


Müşteri adreslerinin ekleyip çıkarılma sorumluluğunu üstlenmiş olan "AddressManager" isminde bir sınıf tasarlayınız. Bu sınıfın içinde "Account.User" nesnesinin adres listesine eleman ekleme-çıkarma yapabilen iki tane static fonksiyon tanımlayınız. Bu fonksiyon isimlerini siz belirleyiniz.


"Account.Account" sınıfında müşteri bilgilerini ekrana yazdıran "final" tipinde, değer döndürmeyen ve ismi "showUserInfo" bir fonksiyon tanımlayınız.


"Account.Account" sınıfında müşterilerin yaptırdıkları sigortaları liste halinde saklayınız. Sigortayı temsil eden "Insurance.Insurance" isminde bir soyut sınıf tasarlayınız. Bu soyut sınıf içinde;

+ sigortanın ismi (String),
+ sigortanın ücreti (double)
+ sigortanın başlangıç-bitiş tarihi (Date)


gibi değişkenlere sahip olacaktır. Ayrıca "calculate" isminde soyut bir fonksiyon tanımlanacaktır. Bu soyut fonksiyon aşağıda kalıtım alınan sınıflarda doldurulacaktır.


Bu soyut sınıftan türeyen;

+ "Insurance.Insurance.HealthInsurance" (özel sağlık sigortasu),
+ "Insurance.Insurance.ResidenceInsurance" (konut sigortası),
+ "Insurance.Insurance.TravelInsurance" (seyahat sigortası),
+ "Insurance.CarInsurance" (otomobil sigortası)


4 tane alt sınıf tasarlayınız. Her alt sınıf "calculate" isimli soyut fonksiyonu override ederek, sigorta ücretini kendine göre hesaplayacaktır.


Yukarıdaki tanımları dikkate aldığımızda soyut sınıf olan "Account.Account" sınıfında aşağıdakiler yer almalıdır.

kullanıcının login olma durumu (AuthenticationStatus)

kullanıcı nesnesi (Account.User)

kullanıcının yaptırmış olduğu sigortaların listesi (ArrayList)

AuthenticationStatus tipinde bir enum tanımlayınız. Enum içinde SUCCESS ve FAIL isminde iki tane sabit tanımlayın. SUCCESS login işlemi başarılı ise kullanılacaktır. FAIL ise login olmamışsa kullanılacaktır.

kullanıcının hesabına login olabilmesi için bir fonksiyon tanımlanacaktır. Bu fonksiyon email ve şifre bilgisi alacak ve gelen email şifre bilgisini Account.User sınıfındaki email ve şifre ile kıyaslayacaktır. Eğer girilen bilgiler doğruysa giriş işlemi başarılı olacaktır. Ve kullanıcının login olma durumu SUCCESS'e çekilecektir. Giriş işlemi başarısız ise "InvalidAuthenticationException" tipinde bir hata fırlatacaktır. Bu hata sınıfını Exception isimli Java sınıfından kalıtım alarak sizin yazmanız gerekecektir.

kullanıcının adreslerine ekleme yapabileceği bir soyut olmayan fonksiyon tanımlanacaktır. kullanıcının adreslerinden çıkartma yapabileceği bir soyut olmayan fonksiyon tanımlanacaktır. kullanıcının login olma durumunu veren değer döndüren fonksiyon tanımlanacaktır.

kullanıcının sigorta poliçesi ekleyebilmesi için soyut (abstract) bir fonksiyon tanımlanacaktır. Bu soyut sınıf "Account.Individual" ve "Account.Enterprise" isimli alt sınıflarda override edilerek doldurulacaktır. Çünkü, bireysel ve kurumsal müşterilerin ekledikleri paketlerin fiyatlarına uygulanan kar marjı farklı olacaktır.


"Account.Individual" ve "Account.Enterprise" sınıfları "Account.Account" sınıfından kalıtım alacaktır.


Account.AccountManager isminde bir sınıf tasarlayınız. Bu sınıf içinde TreeSet tipinde bir veri listesi tutsun. Oluşturduğunuz bireysel ve kurumsal hesapları bu listede saklayınız. bu sınıf içinde login isminde bir fonksiyon tanımlayınız. Bu fonksiyon dışarıdan verilen email ve şifre bilgisini alıp Account.Account listesi üzerinde dolaşıp uygun bir giriş işlemi bulursa Account.Account nesnesini çağrıldığı yere dönecektir. Bu fonksiyon Account.Account nesnesi üzerindeki "login" olma fonksiyonunu çağıracaktır. Unutmayın bu fonksiyon "InvalidAuthenticationException" tipinde hata fırlatabiliyordu. Bu nedenle burada try-catch mekanizması kurmayı unutmayınız.

"Account.Account" sınıfından nesneleri TreeSet içinde tutacağımız için "Comparable" interface'den kalıtım almış olmasına dikkat edin. Ayrıca, "Account.Account" sınıfının "hashCode" ve "equals" fonksiyonlarını doldurmayı unutmayın.

Klavyeden email ve şifre bilgisini alan bir sınıf tasarlayınız. Klavyeden alınan email ve şifre bilgisi ile Account.AccountManager sınıfındaki "login" fonksiyonunu çağırın. Eğer geçerli bir kullanıcı ile giriş yapmışsanız bu fonksiyon size Account.Account tipinde bir nesne dönecektir.