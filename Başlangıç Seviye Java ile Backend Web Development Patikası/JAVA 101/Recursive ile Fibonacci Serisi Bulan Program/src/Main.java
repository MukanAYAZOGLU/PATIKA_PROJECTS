public class Main {

    static int fib(int num) {

        if (num==1 || num==2) {
            return 1;

        }
        return fib(num-1) + fib(num-2);


    }


    public static void main(String[] args) {

        System.out.println(fib(5));







    }
}