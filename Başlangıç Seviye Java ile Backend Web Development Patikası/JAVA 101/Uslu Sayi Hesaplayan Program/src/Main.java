import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num, powOfNum, result=1;
        int increasingNumber=1;


        Scanner inp= new Scanner(System.in);

        System.out.print("Üssü alınacak sayıyı giriniz: ");
        num=inp.nextInt();

        System.out.print("Üs olacak sayıyı giriniz: ");
        powOfNum=inp.nextInt();

        while(increasingNumber<=powOfNum) {

            result*=num;

        increasingNumber++;
        }

        System.out.println("Sonuç= "+result);

        //For Döngüsü kullanılarak:

        /*
        System.out.print("Üssü alınacak sayıyı giriniz: ");
        num=inp.nextInt();

        System.out.print("Üs olacak sayıyı giriniz: ");
        powOfNum=inp.nextInt();

        for (int i = 1; i <=powOfNum ; i++) {

            result*=num;
        }

        System.out.println("Sonuç= "+result);

        */

        //Math Sınıfı kullanılarak:

        /*

        System.out.print("Üssü alınacak sayıyı giriniz: ");
        num=inp.nextInt();

        System.out.print("Üs olacak sayıyı giriniz: ");
        powOfNum=inp.nextInt();

        result= (int)(Math.pow(num,powOfNum));

        System.out.println("Sonuç= "+result);

*/

    }
}