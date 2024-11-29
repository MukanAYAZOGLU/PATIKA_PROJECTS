import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
            Armstrong Sayı Nedir ?

            N haneli bir sayının basamaklarının n’inci üstlerinin toplamı, sayının kendisine eşitse, böyle sayılara Armstrong sayı denir.

            Örneğin 407 sayısını ele alalım. (4^3)+ (0^3)+(7^3) = 64+0+343 = 407 sonucunu verir. Bu da 407 sayısının armstrong bir sayı olduğunu gösterir.
        */
        
        int num, tempNum, digit, digitOfNumber=0;
        int result=0;
        int a=1;

        Scanner scan= new Scanner(System.in);

        System.out.print("O ile "+Integer.MAX_VALUE+" rakamları arasında bir değer giriniz: ");
        num=scan.nextInt();

        tempNum=num;

            do{
               tempNum=tempNum/10;

               digitOfNumber++;
            }while(tempNum>0);


            tempNum=num;

            do{
                digit=tempNum%10;

                for (int i = 1; i<=digitOfNumber ; i++) {

                    a*=digit;

                }

                result+=a;
                a=1;
                tempNum/=10;


            }while(tempNum>0);

        if (result==num) {
            System.out.println(num+" sayısı, bir Armstrog sayısıdır.");

        } else
        {
            System.out.println(num+" sayısı, bir Armstrog sayısı değildir.");
        }


        //Üç basamaklı Armstrog sayıları bulan program.

            int result2 = 0;
            int digitOfNumber2 = 0;
            int digit2, tempNum2;
            int a2 = 1;


        for (int b = 100; b <=999 ; b++) {

            tempNum2 = b;

            do {
                tempNum2 /= 10;

                digitOfNumber2++;
            } while (tempNum2 > 0);

            tempNum2 = b;

            do {
                digit2 = tempNum2 % 10;

                for (int i = 1; i <= digitOfNumber2; i++) {

                    a2 *= digit2;

                }

                result2 += a2;
                a2 = 1;
                tempNum2 /= 10;

            } while (tempNum2 > 0);

            if (result2 == b) {
                System.out.println(b + " sayısı, bir Armstrog sayısıdır.");

            } else {
                System.out.println(b + " sayısı, bir Armstrog sayısı değildir.");
            }

        }


        //Üç basamaklı sayının basamak sayılarının toplamını hesaplayan program.

        int inptNum, tempInptNum;
        int totalOfDigits=0;

        System.out.print("3 basamaklı bir sayı giriniz: ");
        inptNum=scan.nextInt();

        if ((inptNum>=100) && (inptNum<=999)) {

        tempInptNum=inptNum;

        do{
            totalOfDigits+=tempInptNum%10;

           tempInptNum/=10;

        }while(tempInptNum>0);

        System.out.println("Girmiş olduğunuz sayı: "+inptNum);
        System.out.println("Basamaklarındaki rakamların toplamı= "+totalOfDigits);

        }else {
            System.out.println("Belirtilen aralık dışında bir sayı değeri girdiniz. Program sonlandırıldı.");
        }




    }
}