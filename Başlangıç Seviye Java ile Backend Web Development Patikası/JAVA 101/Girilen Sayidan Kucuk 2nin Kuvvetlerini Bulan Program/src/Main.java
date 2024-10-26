import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Girilen sayıya kadar olan 2'nin kuvvetlerini ekrana yazdıran programı yazıyoruz.

        int num, num2;
        int a=1;

        Scanner scan= new Scanner(System.in);
        
        System.out.print("O ile "+Integer.MAX_VALUE+" değeri arasında bir tam sayı geğeri giriniz: ");
        num=scan.nextInt();

        if (num<0) {

            System.out.println("Belirtilen aralık dışında bir sayı değeri girdiniz. Program sonlandı.");
        }else {

            if (num==0) {

                System.out.println("Girmiş olduğunuz sayıya dek 2'in kuvveti yoktur.");
            }

         else if (num==1) {

            System.out.println("Girmiş olduğunuz sayıya dek olan 2'nin kuvvetleri: "+num);
        }

        else {

            do{

                System.out.println("Girmiş olduğunuz sayıya dek olan 2'nin kuvvetleri: "+a);


            }while((a*=2)<num);

        }
        }

        System.out.println("Girilen sayıya kadar olan 2'nin kuvvetlerini ekrana yazdıran program sonlandı.");


        //Girilen sayıya kadar olan 4 ve 5'in kuvvetlerini ekrana yazdıran programı yazıyoruz.


        System.out.print("O ile "+Integer.MAX_VALUE+" değeri arasında bir tam sayı geğeri giriniz: ");
        num2=scan.nextInt();


        if (num2<0 ) {

            System.out.println("Belirtilen aralık dışında bir sayı değeri girdiniz. Program sonlandı.");
        }

        else if(num2==1) System.out.println("Girmiş olduğunuz sayıya dek olan 4 ve 5'nin kuvvetleri: "+num2);

        else {
            for (int i =4; i < num2;  i*=4) {


                    System.out.println("Girmiş olduğunuz sayıya dek olan 4'ün kuvvetleri: " +i);

            }

            for (int d=5; d<num2; d*=5) {

                System.out.println("Girmiş olduğunuz sayıya dek olan 5'nin kuvvetleri: " +d);

            }


        }

        System.out.println("Girilen sayıya kadar olan 4 ve 5'in kuvvetlerini ekrana yazdıran program sonlandı");


    }
}