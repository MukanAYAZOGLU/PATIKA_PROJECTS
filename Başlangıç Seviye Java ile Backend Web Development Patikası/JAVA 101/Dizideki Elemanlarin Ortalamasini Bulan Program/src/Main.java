import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numberOfElements;
        int total=0;

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


        for (int j : myArray) {

            total += j;

        }

        System.out.println();

        System.out.println("Dizi elemanlarınızın ortalaması = "+ total/myArray.length);


    }
}