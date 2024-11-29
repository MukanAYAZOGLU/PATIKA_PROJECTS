import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num;
        int control = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Lütfen pozitif değerde bir sayı giriniz: ");
        num = input.nextInt();

        if (num < 1) {

            System.out.println("Geçersiz giriş.");
            return;

        } else {
            for (int i = 1; i < num; i++) {

                if (num % i == 0) {

                    control += i;

                }

            }

        }


        if (control==num) {

            System.out.println("Girmiş olduğunuz sayı mükemmel sayıdır.");


        } else
            System.out.println("Girmiş olduğunuz sayı mükemmel sayı değildir.");






    }
}