import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
            Sıcaklık 5'dan küçük ise "Kayak" yapmayı öner.
            Sıcaklık 5 ve 15 arasında ise "Sinema" etkinliğini öner.
            Sıcaklık 10 ve 25 arasında ise "Piknik" etkinliğini öner.
            Sıcaklık 25'ten büyük ise "Yüzme" etkinliğini öner.

         */

        Scanner inp = new Scanner(System.in);

        System.out.print("Haca sıcaklığı değerini giriniz: ");
        double heat = inp.nextDouble();


        if (heat < 5) {
            System.out.println("Kayak yapmayı tercih edebilirsiniz.");


        } else if (heat <= 25) {
            if (heat<=15) System.out.println("Sinemaya gitmeyi tercih edebilirsiniz.");
            else System.out.println("Piknik yapmayı tercih edebilirsiniz.");

        } else System.out.println("Yüzme etkinliğini tercih edebilirsiniz.");

    }


    }
