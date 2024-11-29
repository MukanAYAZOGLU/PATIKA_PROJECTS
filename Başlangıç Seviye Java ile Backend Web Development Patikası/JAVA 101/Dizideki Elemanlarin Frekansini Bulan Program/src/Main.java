import java.util.Scanner;

public class Main {


    static boolean isThere(int [] arr, int value) {

        for (int i :arr ) {

            if (i==value) {

                return true;

            }

        }

        return false;

    }


    public static void main(String[] args) {

        int numberOfElements;
        int piece=0;
        int times=0;

        Scanner inp = new Scanner(System.in);

        System.out.print("Dizinizde kaç eleman olmasını istersiniz: ");
        numberOfElements=inp.nextInt();

        int [] myArray= new int[numberOfElements];

        System.out.println("Dizi elemanlarınızı giriniz (bir ya da birkaçını tekraren giriniz): ");

        for (int i = 0; i <numberOfElements ; i++) {

            myArray[i]=inp.nextInt();
        }


        int [] dublicate= new int[myArray.length];


        System.out.print("Dizi elemanlarınız: ");

        for (int a :myArray ) {
            System.out.print(a+" ");

        }

        System.out.println();

        for(int i = 0; i <myArray.length ; i++) {

            for(int j = 1; j < myArray.length; j++) {

                if (i!=j && myArray[i]==myArray[j]) {

                    if (!isThere(dublicate,myArray[i])) {

                        dublicate[piece++]=myArray[i];

                    }


                }

            }


        }

        for(int i = 0; i <piece ; i++) {

            for(int j = 0; j < myArray.length ; j++) {

                if (dublicate[i]==myArray[j]) {

                    times++;

                }

            }

            System.out.println(dublicate[i]+" rakamı, dizide "+times+" defa bulunmaktadır.");
            times=0;

        }


    }
}