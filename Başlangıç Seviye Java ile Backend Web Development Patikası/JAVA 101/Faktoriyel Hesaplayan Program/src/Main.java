import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int firsNum;
        int fakOfNum=1;

        Scanner inp = new Scanner(System.in);

        System.out.print("Tam sayınızı giriniz: ");
        firsNum=inp.nextInt();

        for (int i = 1; i<=firsNum; i++) {

            fakOfNum*=i;

        }

        System.out.println("Girmiş olduğunuz "+firsNum+" sayının faktöriyeli= "+fakOfNum);

        /*
           Kombinasyon hesaplayan program yazınız.

           N elemanlı bir kümenin elemanları ile oluşturulacak r elemanlı farklı grupların sayısı n’in r’li kombinasyonu olarak adlandırılır. N’in r’li kombinasyonu C(n,r) şeklinde gösterilir.

            Kombinasyon formülü

            C(n,r) = n! / (r! * (n-r)!)

        */

        System.out.print("İlk kümenin eleman sayısını giriniz: ");
        int nNum= inp.nextInt();

        System.out.print("İlk kümenin elemanları ile oluşturulacak grupların eleman adedini giriniz: ");
        int rNum= inp.nextInt();

        int fakOfN=1, fakOfR=1, fakOfBothNumbers=1;

        //n'nin faktöriyelinin hesabı:

        for (int i = 1; i<=nNum; i++) {

            fakOfN*=i;

        }

        //r'nin faktöriyelinin hesabı:

        for (int b = 1; b<=rNum ; b++) {

            fakOfR*=b;

        }

        //(n-r)'nin faktöriyelinin hesasabı:

        for (int c = 1; c <=(nNum-rNum) ; c++) {

            fakOfBothNumbers*=c;

        }

        //C(n,r) = n! / (r! * (n-r)!) =

        int kombinasyon=fakOfN/(fakOfR*fakOfBothNumbers);

        System.out.println("N'nin r'li kombinasyonu: C(n,r)= "+kombinasyon);




    }
}