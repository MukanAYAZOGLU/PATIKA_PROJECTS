import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int year;

        Scanner inp= new Scanner(System.in);

        System.out.print("Yıl giriniz: ");
        year=inp.nextInt();


        if (year>0) {

            if ((year % 100 == 0) && (year % 400 == 0)) {

                System.out.println(year + " bir artık yıldır.");

            } else if (year % 4 == 0) {

                System.out.println(year + " artık bir yıldır.");

            } else System.out.println(year + " artık bir yıl değildir.");


        }else System.out.println("Hatalı yıl girişi gerçekleştirdiniz.");







    }
}