import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        int piece;

        System.out.print("Ters üçgeninizin kaç basamak olmasını istersiniz: ");
        piece=inp.nextInt();


        for (int i = piece; i >=1; i--) {

            for (int j =2*i; j >1 ; j--) {

                System.out.print("*");

            }



            System.out.println();
        }







    }
}