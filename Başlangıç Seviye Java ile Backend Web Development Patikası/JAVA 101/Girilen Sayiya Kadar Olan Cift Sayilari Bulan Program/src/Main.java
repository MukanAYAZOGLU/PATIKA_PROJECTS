import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Kullanıcının girdiği sayıya kadar çift olan sayıları bulan program.

        int num;
        int total=0, total2=0;
        int relatedNumbers=0;
        double average;


        Scanner inp = new Scanner(System.in);

        System.out.print("0 ile "+Integer.MAX_VALUE+" sayısı arasında bir değer giriniz: ");
        num=inp.nextInt();

        System.out.println("0'dan "+num+" rakamı arasında bulunan çift sayılar: ");

        for (int i= 0;  i<=num; i++ ) {

            if (i%2==0) {

                System.out.println(i);
                total++;
            }

        }

        System.out.println("Toplamda "+total+" adet çift sayı vardır.");



        //0'dan girilen sayıya kadar olan sayılardan 3 ve 4'e tam bölünen sayıların ortalamasını hesaplayan programı yazınız.



        System.out.println("0 ile "+num+" rakamı arasında bulunup 3 ve 4'e bölünebilen sayılar: ");


        for (int a = 0; a <=num ; a++) {

            if (a%3==0 && a%4==0) {

                System.out.println(a);

                total2++;
                relatedNumbers+=a;

            }

        }

        average= (double) relatedNumbers /total2;

        System.out.print("0 ile "+num+" rakamı arasında bulunup 3 ve 4'e bölünebilen sayıların ortalaması= "+ average);








    }
}