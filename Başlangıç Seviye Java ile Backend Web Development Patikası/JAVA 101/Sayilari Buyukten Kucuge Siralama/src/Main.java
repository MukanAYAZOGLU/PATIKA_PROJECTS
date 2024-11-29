import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Girilen 3 sayıyı "büyükten küçüğe" sıralayan programı yazınız.

        double num1, num2, num3;
        int sort = 1;

        Scanner inp = new Scanner(System.in);

        System.out.print(sort + ". sayıyı giriniz: ");
        num1 = inp.nextInt();


        System.out.print((sort + 1) + ". sayıyı giriniz: ");
        num2 = inp.nextInt();


        System.out.print((sort + 2) + ". sayıyı giriniz: ");
        num3 = inp.nextInt();


        if (num1 > num2 && num1 > num3) {

            if (num2 > num3) {

                System.out.println("Girmiş olduğunuz sayıların büyükten küçüğe sıralanışı şu şekildedir: " + num1 + ">" + num2 + ">" + num3);

            } else System.out.println("Girmiş olduğunuz sayıların büyükten küçüğe sıralanışı şu " +
                    "şekildedir: " + num1 + ">" + num3 + ">" + num2);

        } else if (num2 > num3 && num2 > num1) {

            if (num1 > num3) {

                System.out.println("Girmiş olduğunuz sayıların büyükten küçüğe sıralanışı şu şekildedir: " + num2 + ">" + num1 + ">" + num3);
            } else   System.out.println("Girmiş olduğunuz sayıların büyükten küçüğe sıralanışı şu şekildedir: " + num2 + ">" + num3 + ">" + num1);


        } else {

            if (num1 > num2) {
                System.out.println("Girmiş olduğunuz sayıların büyükten küçüğe sıralanışı şu şekildedir: " + num3 +">" + num1 + ">" + num2);

            } else
                System.out.println("Girmiş olduğunuz sayıların büyükten küçüğe sıralanışı şu şekildedir: " + num3 +">" + num2 + ">" + num1);

        }


    }

}