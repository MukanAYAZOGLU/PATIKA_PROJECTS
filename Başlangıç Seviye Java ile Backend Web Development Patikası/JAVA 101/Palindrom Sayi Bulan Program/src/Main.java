import java.util.Scanner;

public class Main {

    static boolean isPalindrom(int num) {

        int tempNumber=num, reverseNumber=0, lastNumber;

        while (tempNumber!=0) {

            lastNumber=tempNumber%10;
            reverseNumber=(reverseNumber*10)+lastNumber;
            tempNumber/=10;
        }

        if (reverseNumber==num) {

            return true;

        }else
            return false;

    }


    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        int num;

        System.out.print("Lütfen sayınızı giriniz: ");
        num=inp.nextInt();

        if (isPalindrom(num)) {

            System.out.println("Girmiş olduğunuz sayı, bir palindrom sayıdır.");

        }else
            System.out.println("Girmiş olduğunuz sayı, bir palindrom sayı değildir.");


    }
}