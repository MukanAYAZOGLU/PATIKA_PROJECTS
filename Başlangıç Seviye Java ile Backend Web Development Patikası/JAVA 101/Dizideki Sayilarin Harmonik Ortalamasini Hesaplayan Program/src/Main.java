import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int numberOfElements;
        double harmonicSeries=0;

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


        //1+(1/2)+(1/3)+(1/4)+(1/5)...+(1/N)

        for (int i = 1; i <= myArray.length ; i++) {

            harmonicSeries+= (double) 1 /i;
            
        }

        System.out.println();

        System.out.println("Dizi elemanlarınızın harmonik ortalaması = "+new DecimalFormat("##.##").format(((double) myArray.length)/harmonicSeries));





    }
}