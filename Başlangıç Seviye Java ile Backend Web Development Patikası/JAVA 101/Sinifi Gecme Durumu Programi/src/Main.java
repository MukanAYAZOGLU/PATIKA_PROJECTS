import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        Dersler : Matematik, Fizik, Türkçe, Kimya, Müzik

        Geçme Notu : 55

        Eğer girilen ders notları 0 veya 100 arasında değil ise ortalamaya katılmasın.

         */



        double muzik, matematik, fizik, kimya, turkce;

        double avarege;
        int avarageMembers=0;
        double total=0;

        Scanner inp= new Scanner(System.in);

        System.out.println("Muzik ders notunuzu giriniz: ");
        muzik=inp.nextByte();

        System.out.println("Matematik ders notunuzu giriniz: ");
        matematik=inp.nextByte();


        System.out.println("Fizik ders notunuzu giriniz: ");
        fizik=inp.nextByte();

        System.out.println("Kimya ders notunuzu giriniz: ");
        kimya=inp.nextByte();

        System.out.println("Türkçe ders notunuzu giriniz: ");
        turkce=inp.nextByte();

        if (turkce>0 && turkce<=100) {
            avarageMembers++;
            total+=turkce;
            }

        if (matematik>0 && matematik<=100) {
            avarageMembers++;
            total+=matematik;

        }

        if (fizik>0 && fizik<=100) {
            avarageMembers++;
            total+=fizik;

        }

        if (kimya>0 && kimya<=100) {
            avarageMembers++;
            total+=kimya;

        }
        if (muzik>0 && muzik<=100) {
            avarageMembers++;
            total+=muzik;

        }


        avarege= total/avarageMembers;

        if (avarege >=55) {

            System.out.println("Geçme notu: 55");
            System.out.println("Not ortalamanız: "+avarege+ "Geçtiniz.");

        } else {

            System.out.println("Geçme notu: 55");
            System.out.println("Not ortalamanız: " + avarege + " Kaldınız.");

        }



    }
}