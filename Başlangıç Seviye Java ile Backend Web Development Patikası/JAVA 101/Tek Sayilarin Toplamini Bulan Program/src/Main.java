import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    //Negatif bir değer girilene kadar kullanıcıdan girişleri kabul eden ve girilen değerlerden tek sayıları toplayıp ekrana basan programı yazıyoruz.

        int num, num2;
        int howMany=0;
        int total=0;

        int howMany2=0;
        int total2=0;


        Scanner inp = new Scanner(System.in);

        do{
            System.out.print("Lütfen sayınızı giriniz: ");
            num=inp.nextInt();

            if (num%2==1) {

                System.out.println("Tek sayı: "+num);

                total+=num;
                howMany++;
            }

            else System.out.println("Çift sayı: "+num);

        }while(num>=0);

        System.out.println("Toplamda "+howMany+" adet tek sayı girdiniz.");
        System.out.println("Girmiş olduğunuz tek sayıların toplamı= "+total);
        System.out.println("Tek sayıların toplamını bulan program sonlandı.");


        /*
          Tek bir sayı girilene kadar kullanıcıdan girişleri kabul eden ve girilen değerlerden çift ve 4'ün katları olan sayıları toplayıp ekrana basan programı yazıyoruz.
        */

        System.out.println("-------------------");


        do{

            System.out.print("Lütfen sayınızı giriniz: ");
            num2=inp.nextInt();

            if ((num2%2==0) && (num2%4==0)) {

                System.out.println("2 ve 4'ün katı olan rakam: "+num2);
                total2+=num2;

                howMany2++;

            }

        }while(num2%2==0);

        System.out.println("2 ve 4'ün katı olan toplamda "+howMany2+" adet sayı girdiniz.");
        System.out.println("2 ve 4'ün katı olan rakamlarınızın toplamı= "+total2);
        System.out.println("2 ve 4'ün katları olan sayıların toplamını bulan program sonlandı.");




    }
}