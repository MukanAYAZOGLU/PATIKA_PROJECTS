import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner inp = new Scanner(System.in);

    System.out.print("Fibonacci serinizin eleman sayısını giriniz: ");
    int num=inp.nextInt();




    int firsNumber=0, secondNumber=1, cacheNumber;

        for (int i = 0; i <=num ; i++) {

            System.out.print(firsNumber+" ");

            cacheNumber= firsNumber+secondNumber;
            firsNumber=secondNumber;
            secondNumber=cacheNumber;


        }




        }

    }
