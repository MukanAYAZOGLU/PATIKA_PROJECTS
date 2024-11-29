import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        double sayi1, sayi2;
        int grs;
        char cvp;


        do {

        Scanner inp= new Scanner(System.in);

        System.out.print("İlk sayınızı giriniz: ");
        sayi1=inp.nextDouble();

        System.out.print("İkinci sayınızı giriniz: ");
        sayi2=inp.nextDouble();


        System.out.println("Lütfen Yapmak istediğiniz işlemin rakamını giriniz: ");
        System.out.println(
                "1 - Toplama İşlemi\n" +
                "2 - Çıkarma İşlemi\n" +
                "3 - Çarpma İşlemi\n" +
                "4 - Bölme İşlemi\n" +
                "5 - Mod Alma İşlemi");

        grs=inp.nextInt();


        switch (grs) {

            case 1:
                System.out.println("Girmiş olduğunuz sayıların toplam sonucu: "+
                        new DecimalFormat("##.##").format(sayi1+sayi2));
                break;

            case 2:
                System.out.println("Girmiş olduğunuz sayıların çıkarma sonucu: "+
                        new DecimalFormat("##.##").format(sayi1-sayi2));
                break;

            case 3:
                System.out.println("Girmiş olduğunuz sayıların çarpım sonucu: "+
                        new DecimalFormat("##.##").format(sayi1*sayi2));
                break;

            case 4:
                if (sayi2!=0)
                System.out.println("Girmiş olduğunuz sayıların bölme sonucu: "+
                        new DecimalFormat("##.##").format(sayi1/sayi2));
                else System.out.println("Bölen sayı 0 olamaz.");
                break;

            case 5:
                System.out.println("Girmiş olduğunuz sayıların mod alma sonucu: "+
                        new DecimalFormat("##.##").format(sayi1%sayi2));
                break;

            default: System.out.println("Tanımlanamayan giriş gerçekleştirdiniz." +
                    "Program sonlanmıştır.");

        }

        System.out.println("Yeni bir işlem yapmak istiyor musunuz: E/h");

        cvp=inp.next().charAt(0);

        }
        while (cvp=='E');

        if (cvp=='h')

        System.out.println("Program sonlanmıştır.");

        else
            System.out.println("Hatalı giriş yaptınız. Program sonlanmıştır.");









    }
}