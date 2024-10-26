public class Main {

    //Dizideki Tekrar Eden ve Çift Olan Sayilari Bulan Program


    static boolean isFind(int [] arr, int value) {

            for (int i :arr ) {

                if (i==value) {

                    return true;

                }

                }

            return false;

    }


    public static void main(String[] args) {

        int [] myArray= {0,3,3,12,12,5,5,4,4,17,15,19, 5, 0, 17};
        int [] duplicate= new int[myArray.length];
        int [] duplicate2= new int[myArray.length];

        int startIndex=0;
        int startIndex2=0;


        for(int i = 0; i < myArray.length; i++) {

            for(int j = 0; j <myArray.length ; j++) {

                if ((i!=j)  && (myArray[i]==myArray[j])) {

                    if (!isFind(duplicate, myArray[i]) ) {

                        duplicate[startIndex++] = myArray[i];

                    }

                    if (!isFind(duplicate2, myArray[i]) && myArray[i]%2==0) {

                            duplicate2[startIndex2++]= myArray[i];

                    }

                    break;

                }

            }

        }

        System.out.print("Dizide tekrar eden rakamlar: ");


        for(int i = 0; i < startIndex+1; i++) {

            System.out.print(duplicate[i]+ " ");

        }

        System.out.println();


        System.out.print("Dizide tekrar eden ve çift olan rakamlar: ");

        for(int i = 0; i < startIndex2+1; i++) {

            System.out.print(duplicate2[i]+ " ");

        }

    }
}