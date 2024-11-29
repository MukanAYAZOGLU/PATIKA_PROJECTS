import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /*Klavyeden girilen N tane sayma sayısından en büyük ve en küçük sayıları bulan ve bu sayıları ekrana yazan program.

         */

        int piece;
        int taken;

        Scanner scan= new Scanner(System.in);

        int largestNymber=Integer.MIN_VALUE;
        int smallestNumber=Integer.MAX_VALUE;


        System.out.print("Kaç adet sayı gireceksiniz: ");
        piece=scan.nextInt();


        for (int i = 1; i <=piece ; i++) {

            System.out.print(i+". sayınızı giriniz: ");
            taken=scan.nextInt();

            if (taken>largestNymber) {

                largestNymber=taken;

            }

            if (taken<smallestNumber) {

                smallestNumber=taken;
            }

        }


        System.out.println("Girmiş olduğunuz rakamların en küçüğü: "+smallestNumber);
        System.out.println("Girmiş olduğunuz rakamların en büyüğü: "+largestNymber);







    }
}