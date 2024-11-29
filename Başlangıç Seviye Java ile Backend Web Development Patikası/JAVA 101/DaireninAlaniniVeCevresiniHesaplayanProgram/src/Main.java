import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        1.Pratik
        r= yarı çap
        π= pi (3.14)

        Dairenin Çevre Formülü : 2 * π * r;
        Dairenin Alan Formülü : π * r * r;


        2.Pratik
        Yarıçapı r, merkez açısının ölçüsü a olan daire diliminin alanı bulan programı yazınız.

        Formül : (𝜋 * (r*r) * a) / 360
         */

        Scanner inp= new Scanner(System.in);

        System.out.print("Dairenin yarı çapını giriniz: ");
        double r=inp.nextInt();

        System.out.print("Merkez açısının değerini giriniz: ");
        double aci=inp.nextInt();


        double pi=3.14;
        double cvr=2*pi*r;
        double aln=pi*Math.pow(r,2);
        double dlmALan=(pi*Math.pow(r,2))*aci/360;

        System.out.println("Dairenin yarı çapı= "+r);
        System.out.println("Dairenin çevresi= "+cvr);
        System.out.println("Dairenin alanı= "+aln);
        System.out.println(aci+" açılı daire diliminin alanı= "+dlmALan);








    }
}