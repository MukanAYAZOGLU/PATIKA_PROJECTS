public class MathematicalOperations {

    long result;

    public long sum (long a, long b){
        return a+b;
    }

    public long subtract (long a, long b) {
        return a-b;
    }

    public long multiply (long a, long b){
        return a*b;
    }

    //bölme
    public long divide (long a, long b) {
        return a/b;
    }


    //üs alma
    public long pow (long a, double b) {

        result=a;

        for (int i = 1; i <b ; i++) {

            result*=a;

        }

        return result;
    }
/*
    public long squareRoot(long a){

    //couldn't find the algorithm


    }

 */

    public long derivative(long a, long n, long x){

        // Türev formülü: n * a * x^(n-1)
        result= n * a * pow(x, n - 1);
        return result;

    }



    public long integral(long a, long n, long x) {
        // İntegral formülü: (a/(n+1)) * x^(n+1)
         result = (a / (n + 1)) * pow(x, n + 1);
        return result;
    }


    public long factorial (long a) {
         result=1;

        for (int i = 1; i <=a ; i++) {

            result*=i;

        }

        return result;

    }

    public long mod (long a, long b) {
        return a%b;
    }


    public long absoluteValue (long a) {
        if(a<0) {
            return a*=-1;
        }else return a;
    }


}
