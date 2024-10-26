import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        /*
        Vücut Kitle İndeksi Hesaplama Formülü:

        Kilo (kg) / Boy(m) * Boy(m)
         */
        Scanner inp = new Scanner(System.in);

        System.out.print("Lütfen kilonuzu giriniz: ");
        double kg=inp.nextDouble();

        System.out.print("Lütfen boyunuzu giriniz: ");
        double boy=inp.nextDouble();

        double vki= kg/Math.pow(boy,2);

        System.out.println("Kilonuz= "+kg);
        System.out.println("Boyunuz= "+boy);
        System.out.println("Vücut kitle indeksiniz= "+vki);



    }
}