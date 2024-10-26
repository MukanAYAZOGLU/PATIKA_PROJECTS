import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        int numberOfElements;
        int order=1;


        System.out.print("Dizinizde kaç eleman olmasını istersiniz: ");
        numberOfElements=inp.nextInt();

        int [] myArray= new int[numberOfElements];


        System.out.println("Dizi elemanlarınızı giriniz: ");

        for (int i = 0; i <numberOfElements ; i++) {

            myArray[i]=inp.nextInt();
        }

        System.out.println("Dizi boyutunuz: "+numberOfElements);

        System.out.println("Dizi elemanlarınız: ");

        for (int a :myArray ) {
            System.out.println(order+". Eleman:\t"+a+" ");
            order++;
        }

        order=1;

        System.out.println();

        Arrays.sort(myArray);

        System.out.println("Dizi elemanlarınızın küçükten büyüğe sıralanmış hali: ");


        for (int a :myArray ) {
            System.out.println(order+". Eleman:\t"+a+" ");
            order++;

        }



    }
}