import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    /*
    Koç Burcu : 21 Mart - 20 Nisan
    Boğa Burcu : 21 Nisan - 21 Mayıs
    İkizler Burcu : 22 Mayıs - 22 Haziran
    Yengeç Burcu : 23 Haziran - 22 Temmuz
    Aslan Burcu : 23 Temmuz - 22 Ağustos
    Başak Burcu : 23 Ağustos - 22 Eylül
    Terazi Burcu : 23 Eylül - 22 Ekim
    Akrep Burcu : 23 Ekim - 21 Kasım
    Yay Burcu : 22 Kasım - 21 Aralık
    Oğlak Burcu : 22 Aralık - 21 Ocak
    Kova Burcu : 22 Ocak - 19 Şubat
    Balık Burcu : 20 Şubat - 20 Mart
    */

        int day, month;

        Scanner inp = new Scanner(System.in);

        System.out.print("Doğduğunuz ayı rakamsal olarak giriniz: ");
        month=inp.nextInt();

        if (month>=1 && month<=12) {

            System.out.print("Doğduğunuz günü rakamsal olarak giriniz: ");
            day=inp.nextInt();

            if (day>=1 && day <=31) {

                switch (month) {

                    case 1:
                        if (day<=21) {

                            System.out.println("Oğlak Burcu");

                        }else System.out.println("Kova Burcu");
                        break;


                    case 2:
                        if (day<=19) {

                            System.out.println("Kova Burcu");

                        }else System.out.println("Balık Burcu");
                        break;

                    case 3:
                        if (day<=20) {

                            System.out.println("Balık Burcu");

                        }else System.out.println("Koç Burcu");
                        break;

                    case 4:
                        if (day<=20) {

                            System.out.println("Koç Burcu");

                        }else System.out.println("Boğa Burcu");
                        break;

                    case 5:
                        if (day<=21) {

                            System.out.println("Boğa Burcu");

                        }else System.out.println("İkizler Burcu");
                        break;

                    case 6:
                        if (day<=22) {

                            System.out.println("İkizler Burcu");

                        }else System.out.println("Yengeç Burcu");
                        break;


                    case 7:
                        if (day<=22) {

                            System.out.println("Yengeç Burcu");

                        }else System.out.println("Aslan Burcu");
                        break;

                    case 8:
                        if (day<=22) {

                            System.out.println("Aslan Burcu");

                        }else System.out.println("Başak Burcu");
                        break;


                    case 9:
                        if (day<=23) {

                            System.out.println("Başak Burcu");

                        }else System.out.println("Terazi Burcu");
                        break;

                    case 10:

                        if (day<=22) {

                            System.out.println("Terazi Burcu");

                        }else System.out.println("Akrep Burcu");
                        break;

                    case 11:

                        if (day<=21) {

                            System.out.println("Akrep Burcu");

                        }else System.out.println("Yay Burcu");
                        break;

                    case 12:

                        if (day<=21) {

                            System.out.println("Yay Burcu");

                        }else System.out.println("Oğlak Burcu");
                        break;

                    default:

                }


            } else
                System.out.println("Hatalı giriş yaptınız. Program sonlandı.");


        } else System.out.println("Hatalı giriş yaptınız. Program sonlandı.");








    }
}