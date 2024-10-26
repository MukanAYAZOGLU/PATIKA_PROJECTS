import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int num;

        Scanner inp= new Scanner(System.in);

        System.out.print("Yıldızlardan oluşmasını istediğiniz üçgenin kaç satırlık olamasını arzu edersiniz: ");
        num=inp.nextInt();


        for (int i = 1; i <=num ; i++) {

            for (int k = 1; k <=(num-i) ; k++) {

                System.out.print(" ");
            }

            for (int j = 1; j <=(2*i)-1 ; j++) {

                System.out.print("*");

            }

            System.out.println();

        }

        System.out.println("---------");

        //Döngüler kullanarak yıldızlar ile elmas yapma

        int t=1;

        for (int i = 1; i <=num ; i++) {

            for (int j = 1; j <=num-(num-i) ; j++) {

                System.out.print(" ");
                
            }

            for (int j = 1; j <=(2*num)-t; j++) {
                System.out.print("*");

            }

            t+=2;

            System.out.println();
            
            
        }



        
    }
}