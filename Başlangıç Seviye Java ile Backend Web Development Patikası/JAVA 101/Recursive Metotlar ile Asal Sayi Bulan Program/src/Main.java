import java.util.Scanner;

public class Main {


    static boolean isPrime(int number, int divisor) {

        if (number >= 2) {

            if (divisor > 1) {

                if (number % divisor != 0) {

                    return isPrime(number, divisor - 1);

                } else return false;

            }


            return true;

        }

         return false;

    }



    public static void main(String[] args) {


        Scanner inp = new Scanner(System.in);

        System.out.print("Lütfen sayınızı giriniz: ");
        int number=inp.nextInt();

        if (isPrime(number,number-1)) {

            System.out.println(number+", asal sayıdır.");
        }
        else
            System.out.println(number+", asal sayı değildir.");


    }
}