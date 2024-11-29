import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int row, column;

        Scanner inp = new Scanner(System.in);

        System.out.print("Dizinizde kaç satır olmasını istersiniz: ");
        row=inp.nextInt();
        System.out.print("Dizinizde kaç sütun olmasını istersiniz: ");
        column=inp.nextInt();

        int [] [] myArray= new int[row] [column];

        System.out.println("Dizi elemanlarınızı giriniz: ");

        for (int i = 0; i <row ; i++) {

            for(int j = 0; j <myArray[i].length; j++) {

                myArray[i][j]=inp.nextInt();

            }

        }

        System.out.println();

        System.out.println("Dizi elemanlarınız: ");

        for (int [] a  :myArray ) {

                for (int b : a) {

                    System.out.print(b+" ");

                    }
                System.out.println();

        }

        
        //DİZİNİN TRANSPOZU


        int [] [] reflection= new int[column][row];

        for(int i = 0; i < reflection.length ; i++) {

            for(int j = 0; j <reflection[i].length ; j++) {

                reflection[i][j]=myArray[j][i];

            }

        }

        System.out.println();

        System.out.println("Matris Transpozunuz: ");

            for (int [] a  : reflection ) {

                    for (int  b :a ) {

                        System.out.print(b+" ");

                        }

                    System.out.println();

                }








          
        }
    }
