import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static boolean isTrue (int randomNumber, int userNumber) {

        return randomNumber == userNumber;

    }


    public static void main(String[] args) {

        // 5 DEFA TAHMMİN ETME HAKKINA SAHİP OLUNAN SAYI OYUNU.

        int rightOfGuess=5;

        Scanner scan = new Scanner(System.in);
        int userNumber;

        Random rdm= new Random();
        int randomNumber= rdm.nextInt(1,100);

        int [] userGuesses= new int[5];
        int index=0;



        System.out.println("Gizli sayıyı tahmin etme oyununa hoş geldiniz.");

        do{

            System.out.println();

            System.out.print("1 ile 100 arasında tam bir sayı giriniz: ");
            userNumber=scan.nextInt();

            userGuesses[index++]=userNumber;

            if (userNumber<1 || userNumber>100) {

                --rightOfGuess;
                System.out.println("Belirtilen aralık dışında bir sayı girdiniz.\nKalan hakkınız: "+rightOfGuess);

            }else  if (!isTrue(randomNumber,userNumber)){

                --rightOfGuess;
                System.out.println("Yanlış tahmin.\nKalan hakkınız: "+rightOfGuess);

                if (userNumber>randomNumber) {

                    System.out.println("Gizli sayı, "+userNumber+" sayısından küçüktür.");

                }else System.out.println("Gizli sayı, "+userNumber+" sayısından büyüktür.");

            } else System.out.println("Tebrikler doğru tahmin. Tahmin edilen sayı: "+randomNumber);


        }while(userNumber!=randomNumber && rightOfGuess>0);


        System.out.println();

        if (rightOfGuess==0) {

            System.out.println("5 hakkınızı da yitirdiniz. Gizli sayı: "+randomNumber);
            System.out.println("Sizlerin verdiği cevaplar: "+ Arrays.toString(userGuesses));


        }







    }
}