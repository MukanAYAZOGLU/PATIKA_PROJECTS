import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    double result=0;
    int num;

        Scanner inp = new Scanner(System.in);

        System.out.print("Lütfens ayınızı giriniz: ");
        num=inp.nextInt();

        for (double i = 1; i <=num ; i++) {

            result+=(1/i);

        }

        System.out.println("Girilen rakam: "+num);
        System.out.println("Harmonik Serisinin Sonucu= "+result);





    }
}