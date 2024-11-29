import java.util.Scanner;

public class Main {


    static int plus(int a, int b) {
        int result =a+b;
        System.out.println("Toplam= "+result);
        return result;
    }

    static int minus(int a, int b) {
        int result =a-b;
        System.out.println("Çıkarma= "+result);
        return result;
    }

    static int times(int a, int b) {
        int result =a*b;
        System.out.println("Çarpma= "+result);
        return result;
    }

    static int diveded(int a, int b) {
        if (b==0) {
            System.out.println("İkinci sayı 0'dan farklı olmalı.");
            return 0;

        }
        int result=a/b;
        System.out.println("Bölme: "+result);
        return result;

    }

    static int mod(int a, int b) {
        int result =a%b;
        System.out.println("Modu= "+result);
        return result;
    }


    static int power(int a, int b) {

        int result =1;

        for (int i = 1; i <=b ; i++) {
            result*=a;
        }

        System.out.println("Üs Hesabı= "+result);
        return result;

    }


    static void calc(int a, int b) {
        System.out.println("Çevresi: "+(2*(a+b)));
        System.out.println("Alanı= "+(a*b));

    }


    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        int select;

            while(true) {

                System.out.print(
                        "1- Toplama İşlemi\n"
                                + "2- Çıkarma İşlemi\n"
                                + "3- Çarpma İşlemi\n"
                                + "4- Bölme işlemi\n"
                                + "5- Üslü Sayı Hesaplama\n"
                                + "6- Mod Alma\n"
                                + "7- Dikdörtgen Alan ve Çevre Hesabı\n"
                                + "0- Çıkış Yap\n");


                System.out.print("Yapmak istediğiniz işlemi belirtiniz: ");
                select=inp.nextInt();

                if (select==0) {
                    System.out.println("Güle güle.");
                    break;

                } else if (select>=1 && select<=7) {



                System.out.print("İlk sayıyı giriniz: ");
                int a=inp.nextInt();
                System.out.print("İkinci sayıyı giriniz: ");
                int b=inp.nextInt();


                switch (select) {

                    case 1:
                        plus(a,b);
                        break;

                    case 2:
                        minus(a,b);
                        break;

                    case 3:
                        times(a,b);
                        break;

                    case 4:
                        diveded(a,b);
                        break;

                    case 5:
                        power(a,b);
                        break;

                    case 6:
                        mod(a,b);
                        break;

                    case 7:
                        calc(a,b);
                        break;

                    default:
                        System.out.println("Tanımlanamayan giriş gerçekleştirdiniz.");

                }

                }else
                    System.out.println("Tanımlanamayan giriş gerçekleştirdiniz.");
                break;


            }





    }
}