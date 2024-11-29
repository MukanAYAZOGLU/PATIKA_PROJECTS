import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int ebob=1, ekok;
        int n1, n2;

        Scanner input = new Scanner(System.in);

        System.out.print("İlk sayınızı giriniz: ");
        n1= input.nextInt();

        System.out.print("İkinci sayınızı giriniz: ");
        n2= input.nextInt();


        //EBOB BULMA

        if (n2<n1) {

            for (int i = n2; i >0 ; i--) {

                if (n1%i==0 && n2%i==0) {
                    ebob=i;
                    break;
                }

            }

        }else {
            for (int i = n1; i >0 ; i--) {

                if (n1%i==0 && n2%i==0) {
                    ebob=i;
                    break;
                }

            }

        }

        //For Döngüsü ile EKOK BULMA
/*

        for (int i = 1; i <=n1*n2 ; i++) {

            if (i%n1==0 && i%n2==0) {

                ekok=i;
                break;


            }
        }
*/


        System.out.println("EBOB= "+ebob);
        ekok=(n1*n2)/ebob;

        System.out.println("EKOK= "+ekok);



        //While Döngüsü İle EBOB - EKOK Bulma

        /*


        //EBOB Bulma

        System.out.print("İlk sayınızı giriniz: ");
        n1= input.nextInt();

        System.out.print("İkinci sayınızı giriniz: ");
        n2= input.nextInt();


        int j;

        if (n2<n1) {

            j=n2;

            do {

                if ((n1%j==0) && (n2%j==0)){

                    ebob=j;
                    break;
                }

                j--;
            } while (j>0);

        } else  {

            j=n1;

                do {

                    if ((n1%j==0) && (n2%j==0)){

                        ebob=j;
                        break;
                    }

                    j--;
                } while (j>0);

        }


        System.out.println("EBOB= "+ebob);



        //EKOK Bulma
        j=1;

        do{

            if (j%n1==0 && j%n2==0) {

                ekok=j;
                break;

            }

            j++;
        }while(j<=n1*n2);

        System.out.println("EKOK= "+ekok);

         */



    }
}