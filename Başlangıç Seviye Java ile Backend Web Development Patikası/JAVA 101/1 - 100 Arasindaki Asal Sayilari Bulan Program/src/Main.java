public class Main {
    public static void main(String[] args) {


        for (int i = 2; i <=100 ; i++) {

            if (isPrime(i)) {

                System.out.println(i);

            }

        }

    }

    public static boolean isPrime (int num) {

        if (num==2 || num==3 || num==5 || num==7 ) {

            return true;

        }

        else if (num%2!=0 && num%3!=0 && num%5!=0 && num%7!=0) {

            return true;

        }else return false;


    }


}