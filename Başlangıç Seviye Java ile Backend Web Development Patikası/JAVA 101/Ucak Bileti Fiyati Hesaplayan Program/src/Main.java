import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    /*
    Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgilerini alın. Mesafe başına ücret 0,10 TL / km olarak alın. İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki indirimleri uygulayın ;

    Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır. Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

    Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
    Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
    Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
    Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.

 */

        double km;
        double priceOfPerKm=0.10;
        double amount;
        int age;
        byte direction;


        Scanner inp = new Scanner(System.in);

        System.out.print("Yaşınızı giriniz: ");
        age=inp.nextInt();

        if (!(age<0)) {

            System.out.print("Mesafeyi km cinsinden giriniz: ");
            km=inp.nextInt();

            if (!(km<=0)) {

                System.out.println("Yolculuk tipini  giriniz:"+
                        "\n1 - Tek Yön" +
                        "\n2- Çift Yön");
                direction=inp.nextByte();

                amount=km*priceOfPerKm;

                    switch (direction) {

                        case 1:

                            if (age < 12) {

                                amount-=amount * 0.50;

                            } else if (age <= 24) {
                                amount-=amount * 0.10;

                            } else if (age > 65) {

                                amount-=amount * 0.30;
                            }

                            System.out.println("Toplam tutar= " + amount);

                         break;


                        case 2:

                            if (age < 12) {

                                amount-=amount * 0.50;
                                amount-=amount*0.20;
                                amount*=2; //Passanger bought two ways, so we multiply the amount bye 2

                        } else if (age <= 24) {
                                amount-=amount * 0.10;
                                amount-=amount*0.20;
                                amount*=2; //Passanger bought two ways, so we multiply the amount bye 2

                        } else if (age > 65) {

                                amount-=amount * 0.30;
                                amount-=amount*0.20;
                                amount*=2; //Passanger bought two ways, so we multiply the amount bye 2

                        }

                        System.out.println("Toplam tutar= " + amount);
                        break;

                    default:
                        System.out.println("Hatalı giriş yaptınız.");

                }

                }else System.out.println("Hatalı veri girdiniz.");


            } else System.out.println("Hatalı veri girdiniz.");








    }
}

