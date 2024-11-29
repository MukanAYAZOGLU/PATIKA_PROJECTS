import java.util.Scanner;

public class Main {

    static int pow(int a, int b) {

        if (b==0) {
        return 1;

        }

        return a * pow(a,b-1);

    }

    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);

        System.out.print("Taban değerini giriniz: ");
        int a=inp.nextInt();

        System.out.print("Üs değerini giriniz: ");
        int b=inp.nextInt();


        System.out.println("Sonuç= "+pow(a,b));


    }
}