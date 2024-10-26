import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
            Çin Zodyağı nedir?

            4000 bin yıldır kullanılan bir astroloji çeşididir Çin astrolojisi ve insanları 12 değişik burç ve sembollerle tanımlar. Çin Zodyağı bu 12 burcun eşit aralıklarla(10 derece genişliğinde) sıralandığı bir hayvan halkasıdır ve yıldızlarla pek bir ilgisi yoktur.

            Çin Zodyağı nasıl hesaplanır?

            Çin zodyağı hesaplanırken kişinin doğum yılının 12 ile bölümünde kalana göre bulunur.

            Doğum Tarihi %12 = 0 ➜ Maymun
            Doğum Tarihi %12 = 1 ➜ Horoz
            Doğum Tarihi %12 = 2 ➜ Köpek
            Doğum Tarihi %12 = 3 ➜ Domuz
            Doğum Tarihi %12 = 4 ➜ Fare
            Doğum Tarihi %12 = 5 ➜ Öküz
            Doğum Tarihi %12 = 6 ➜ Kaplan
            Doğum Tarihi %12 = 7 ➜ Tavşan
            Doğum Tarihi %12 = 8 ➜ Ejderha
            Doğum Tarihi %12 = 9 ➜ Yılan
            Doğum Tarihi %12 = 10 ➜ At
            Doğum Tarihi %12 = 11 ➜ Koyun
         */

            int yearOfBirth;
            int numOfSign;

        Scanner inp = new Scanner(System.in);

        System.out.print("Doğum yılınızı giriniz: ");
        yearOfBirth=inp.nextInt();

        numOfSign=yearOfBirth%12;

        switch (numOfSign) {

            case 0:
                System.out.println("Maymun");
                break;

            case 1:
                System.out.println("Horoz");
                break;

            case 2:
                System.out.println("Köpek");
                break;

            case 3:
                System.out.println("Domuz");
                break;

            case 4:
                System.out.println("Fare");
                break;

            case 5:
                System.out.println("Öküz");
                break;

            case 6:
                System.out.println("Kaplan");
                break;

            case 7:
                System.out.println("Tavşan");
                break;

            case 8:
                System.out.println("Ejderha");
                break;

            case 9:
                System.out.println("Yılan");
                break;

            case 10:
                System.out.println("At");
                break;

            case 11:
                System.out.println("Koyun");
                break;

            default:
                System.out.println("Tanımlanamayan sonuç.");


        }




    }
}