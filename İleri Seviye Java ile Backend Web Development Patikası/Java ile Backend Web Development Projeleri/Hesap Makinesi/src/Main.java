import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    MathematicalOperations math=new MathematicalOperations();
    Scanner scan= new Scanner(System.in);

    long a,b,c;
    int i;
    boolean answer=true;

        System.out.println("Bilimsel Hesaplama Makinesine Hoş Geldiniz\n" +
                "Yapmak istediğiniz işlemi seçiniz!");

        System.out.println ("""
                1- Toplama
                2- Çıkarma
                3- Çarpma
                4- Bölme
                5- Üs Alma
                6- Karekök Alma
                7- Türev Alma
                8- İntegral Alma
                9- Faktöriyel Hesaplama
                10- Mod Alma
                11- Mutlak Değer Hesaplama
                """);

        if (scan.hasNextInt()) {

            i=scan.nextInt();
            scan.nextLine();

           switch (i){

            case 1:
                System.out.print ("Toplama işlemi için rakamları giriniz: ");
                a=scan.nextLong();
                b=scan.nextLong();
                System.out.println ("İşlem sonucu: "+math.sum(a,b));
                break;
            case 2:
                System.out.print ("Çıkarma işlemi için rakamları giriniz: ");
                a=scan.nextLong();
                b=scan.nextLong();
                System.out.println ("İşlem sonucu: "+math.subtract(a,b));;
                break;
            case 3:
                System.out.print ("Çarpma işlemi için rakamları giriniz: ");
                a=scan.nextLong();
                b=scan.nextLong();
                System.out.println ("İşlem sonucu: "+math.multiply(a,b));;
                break;
            case 4:
                System.out.print ("Bölme işlemi için rakamları giriniz: ");
                a=scan.nextLong();
                b=scan.nextLong();
                System.out.println ("İşlem sonucu: "+math.divide(a,b));;
                break;
            case 5:
                System.out.print ("Üs alma işlemi için rakamları giriniz: ");
                a=scan.nextLong();
                b=scan.nextLong();
                System.out.println ("İşlem sonucu: "+math.pow(a,b));;
                break;
            case 6:
                System.out.print ("Karekök işlemi için rakamı giriniz: ");
                a=scan.nextLong();
                //System.out.println ("İşlem sonucu: "+math.squareRoot(a));
                System.out.println ("Couldn't find the algorithm. Sorry!");
                break;
            case 7:
                System.out.print ("Türev işlemi için rakamları giriniz: ");
                a=scan.nextLong();
                b=scan.nextLong();
                c=scan.nextLong();
                System.out.println ("İşlem sonucu: "+math.derivative(a,b,c));;
                break;
            case 8:
                System.out.println ("İntegral işlemi için rakamları giriniz: ");
                a=scan.nextLong();
                b=scan.nextLong();
                c=scan.nextLong();
                System.out.println ("İşlem sonucu: "+math.integral(a,b,c));;
                break;
            case 9:
                System.out.print ("Faktöriyel işlemi için rakamı giriniz: ");
                a=scan.nextLong();
                System.out.println ("İşlem sonucu: "+math.factorial(a));;
                break;
            case 10:
                System.out.print ("Mod işlemi için rakamları giriniz: ");
                a=scan.nextLong();
                b=scan.nextLong();
                System.out.println ("İşlem sonucu: "+math.mod(a,b));;
                break;
            case 11:
                System.out.print ("Mutlak değer alma işlemi için rakamı giriniz: ");
                a=scan.nextLong();
                System.out.println ("İşlem sonucu: "+math.absoluteValue(a));;
                break;
            default: System.out.println ("Seçenek dışı tercih gerçekleştirdiniz. Program sonlandırıldı!");

        }

        }else {
            System.out.println ("Tanımlanamayan giriş gerçekleştirdiniz. Program sonlandırıldı!");
        }







    }
}