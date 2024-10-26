
import java.util.Scanner;

public class NotOrtalamasiHesaplayanProgram {

    public static void main(String[] args) {


        Scanner inp= new Scanner(System.in);


        int matNot, fizikNot, cogfNot, turkceNot,bedenNot, kimyaNot, geoNot;

        System.out.print("Lütfen matematik ders notunu giriniz: ");
        matNot=inp.nextInt();

        System.out.print("Lütfen fizik ders notunu giriniz: ");
        fizikNot=inp.nextInt();

        System.out.print("Lütfen coğrafya ders notunu giriniz: ");
        cogfNot=inp.nextInt();

        System.out.print("Lütfen Türkçe ders notunu giriniz: ");
        turkceNot=inp.nextInt();

        System.out.print("Lütfen beden eğitimi ders notunu giriniz: ");
        bedenNot=inp.nextInt();

        System.out.print("Lütfen kimya ders notunu giriniz: ");
        kimyaNot=inp.nextInt();

        System.out.print("Lütfen geometri ders notunu giriniz: ");
        geoNot=inp.nextInt();

        int toplam=(matNot+geoNot+turkceNot+fizikNot+bedenNot+cogfNot+kimyaNot);

        double ort=toplam/7;

        System.out.println("Derslerinizin ortalaması= "+ort);

        String gecKal=ort>=65 ? "Öğrenci durumu: Başarılı." : "Öğrenci durumu: Başarısız.";

        System.out.println(gecKal);


    }
}






