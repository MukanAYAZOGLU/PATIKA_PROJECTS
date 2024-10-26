import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inp= new Scanner(System.in);


        System.out.print("1. kenarı giriniz: ");
        int a=inp.nextInt();
        System.out.print("2. kenarı giriniz: ");
        int b=inp.nextInt();

        double c=Math.sqrt((a*a)+(b*b));

        double cvrUcgn= a+b+c;
        double yrmCvrUcgn=cvrUcgn/2;
        double alnUcgen=Math.sqrt(yrmCvrUcgn*(yrmCvrUcgn-a)*(yrmCvrUcgn-b)*(yrmCvrUcgn-c));

        System.out.println("Üçgenin hipotenüsü/3. kenarı=  " +c);
        System.out.println("Üçgenin çevresi= "+cvrUcgn);
        System.out.println("Üçgenin alanı= "+alnUcgen);


    }
}