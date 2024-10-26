import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /*
        Taksimetre Programı

        Taksimetre KM başına 2.20 TL tutmaktadır.
        Minimum ödenecek tutar 20 TL'dir. 20 TL altında ki ücretlerde yine 20 TL alınacaktır.
        Taksimetre açılış ücreti 10 TL'dir.
         */

        int baslnTutar=10;
        int odncekMinTutar=20;
        double kmBasiTutar=2.20;
        double gidlKm;
        double toplmUcrt;

        Scanner inp= new Scanner(System.in);

        System.out.print("Kaç kilometre gidildi: ");
        gidlKm=inp.nextDouble();

        toplmUcrt= gidlKm*kmBasiTutar+baslnTutar>20 ? baslnTutar+gidlKm*kmBasiTutar : 20;

        System.out.print("Taksimetre tutarı= "+toplmUcrt);







    }
}