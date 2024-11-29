import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner inp= new Scanner(System.in);

        System.out.print("Lütfen fiyatı giriniz: ");
        double fiyat=inp.nextDouble();


        double kdvOrani= (fiyat>1000) ? 00.8 : 0.18;
        double kdvFiyat= (fiyat>1000) ? fiyat*kdvOrani : fiyat*kdvOrani;

        System.out.println("KDV'siz Fiyat= "+fiyat);
        System.out.println("KDV Oranı= "+ kdvOrani);
        System.out.println("KDV Tutarı= "+ kdvFiyat);
        System.out.println("KDV'li Fiyat= "+(kdvFiyat+fiyat));




    }
}