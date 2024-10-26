import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numberOfElements;
        int max, min, closestMin = 0, closestMax=0;
        int number;

        Scanner inp = new Scanner(System.in);


        System.out.print("Dizinizde kaç eleman olmasını istersiniz: ");
        numberOfElements=inp.nextInt();

        int [] myArray= new int[numberOfElements];


        System.out.println("Dizi elemanlarınızı giriniz: ");

        for (int i = 0; i <numberOfElements ; i++) {

            myArray[i]=inp.nextInt();
        }

        System.out.print("Dizi elemanlarınız: ");

        for (int a :myArray ) {
            System.out.print(a+" ");

        }


        Arrays.sort(myArray);

        min=myArray[0];
        max=myArray[0];

            for (int i :myArray ) {

                if (i>max) {

                    max=i;

                }

                if (i<min) {

                    min=i;

                }


                }
            System.out.println();

            System.out.println("Dizideki en küçük rakam: "+min);
            System.out.println("Dizideki en büyükrakam: "+max);


            //Dizideki elemanların girilen sayıdan küçük en yakın sayıyı ve en büyük en yakın sayıyı bulan program


            System.out.print("Dizideki rakamlar için kıstas alınmasını istediğiniz sayıyı giriniz: ");
            number=inp.nextInt();



                for (int j :myArray ) {

                    if (j>number) {

                        closestMax=j;
                        break;

                    }

                    }

                for(int i = myArray.length-1; i >=0 ; i--) {

                    if (myArray[i]<number) {
                        closestMin=myArray[i];
                        break;

                    }

                }

                System.out.println();

                System.out.println("Girmiş oluğunuz rakama en yakın küçük sayı: "+closestMin);
                System.out.println("Girmiş oluğunuz rakama en yakın büyük sayı: "+closestMax);




    }
}