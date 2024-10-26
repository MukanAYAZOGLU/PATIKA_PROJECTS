import java.util.Scanner;

public class Main {

    /*
    Kural : Girilen sayı 0 veya negatif olduğu yere kadar girilen sayıdan 5 rakamını çıkarın. Her çıkarma işlemi sırasında ekrana son değeri yazdırın. Sayı negatif veya 0 olduktan sonra tekrar 5 ekleyin. Yine her ekleme işleminde sayının son değerini ekrana yazdırın.
     */


static void pattern (int n, int tempN) {

    n-=5;

    System.out.print(n+" ");

    if (n<1) {

        do{

            n+=5;
            System.out.print(n+" ");


        }while(n!=tempN);


    } else pattern(n, tempN);


}


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Rakamınızı giriniz: ");
        int n = scan.nextInt();

        int tempN=n;

        System.out.println("Sayı: "+n);

        System.out.print("Çıktısı: "+n+" ");

        pattern(n,tempN);










    }
}