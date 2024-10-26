import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    /*
    Kullanıcıların manavdan almış oldukları ürünlerin kilogram değerlerine göre toplam tutarını ekrana yazdıran program.

    Meyveler ve KG Fiyatları:

    Armut : 2,14 TL
    Elma : 3,67 TL
    Domates : 1,11 TL
    Muz: 0,95 TL
    Patlıcan : 5,00 TL
     */


        double armtKgFiyt=2.14;
        double elmaKgFiyt=3.67;
        double domatsKgFiyt=1.11;
        double muzKgFiyt=0.95;
        double patlcnKgFiyt=5;

        Scanner inp= new Scanner(System.in);

        System.out.print("Kaç kg armut alındı: ");
        double kgArmt=inp.nextDouble();
        System.out.print("Kaç kg elma alındı: ");
        double kgElma=inp.nextDouble();
        System.out.print("Kaç kg domates alındı: ");
        double kgDomats=inp.nextDouble();
        System.out.print("Kaç kg muz alındı: ");
        double kgMuz=inp.nextDouble();
        System.out.print("Kaç kg patlıcan alındı: ");
        double kgPatlcn=inp.nextDouble();


        System.out.println("Armut için ödenmesi gereken tutar: "+ new DecimalFormat("##.##").format(armtKgFiyt*kgArmt)+"tl");
        System.out.println("Elma için ödenmesi gereken tutar: "+ new DecimalFormat("##.##").format(elmaKgFiyt*kgElma)+"tl");
        System.out.println("Domates için ödenmesi gereken tutar: "+ new DecimalFormat("##.##").format(domatsKgFiyt*kgDomats)+"tl");
        System.out.println("Muz için ödenmesi gereken tutar: "+ new DecimalFormat("##.##").format(muzKgFiyt*kgMuz)+"tl");
        System.out.println("Patlıcan için ödenmesi gereken tutar: "+ new DecimalFormat("##.##").format(patlcnKgFiyt*kgPatlcn)+"tl");

        double tplmTutar=
                armtKgFiyt*kgArmt+elmaKgFiyt*kgElma+domatsKgFiyt*kgDomats+muzKgFiyt*kgMuz+patlcnKgFiyt*kgPatlcn;

        System.out.print("Toplam ödenmesi gereken tutar: "+ new DecimalFormat("##.##").format(tplmTutar)+"tl");







    }
}