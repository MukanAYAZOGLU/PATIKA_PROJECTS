import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String userName;
        String password;
        int right = 3;
        int balance = 1500;
        int choice;
        int amount;

        Scanner input = new Scanner(System.in);


        do {

            System.out.print("Kullancı adınız: ");
            userName = input.nextLine();

            System.out.print("Parolanız: ");
            password = input.nextLine();

            if (userName.equals("Patika") && password.equals("Java101")) {

                System.out.println("Merhaba Efendim, Patika Bankasına hoş geldiniz.");

                    do {

                        System.out.println(
                                        "1 - Para yatırma\n" +
                                        "2 - Para çekme\n" +
                                        "3 - Bakiye sorgulama\n" +
                                        "4 - Çıkış yap");


                        System.out.print("Lütfen yapmak istediğini işlemi belirtiniz: ");
                        choice = input.nextInt();

                        if (choice == 1) {

                            System.out.print("Para miktarı: ");
                            amount = input.nextInt();
                            balance += amount;

                        } else if (choice == 2) {

                            System.out.print("Para miktarı: ");
                            amount = input.nextInt();
                            if (amount <= balance) {
                                balance -= amount;

                            } else System.out.println("Bakiye yetersiz.");

                        } else if (choice == 3) {
                            System.out.println("Bakiyeniz: " + balance);

                        }

                    } while (choice != 4);

                    System.out.println("Tekrar görüşmek üzere.");
                    break;



            }else{
                    right--;
                    if (right > 0) {
                        System.out.println("Kullanıcı adı veya parola yanlış. Tekrar deneyiniz.");
                        System.out.println(right + " giriş hakkınız kaldı.");

                    } else {
                        System.out.println("Kullanıcı adı veya parola yanlış.");
                        System.out.println("Hesabınız bloke olmuştur. Lütfen banka ile iletişime geçiniz.");
                    }
                }

            } while (right > 0) ;



            // Switch - Case ile Yapılmış Hali:

/*

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String userName;
        String password;
        int right=3;
        int balance = 1500;
        int choice;
        int amount;

        Scanner input = new Scanner(System.in);


        do{

            System.out.print("Kullancı adınız: ");
            userName= input.nextLine();

            System.out.print("Parolanız: ");
            password= input.nextLine();

            if (userName.equals("Patika") && password.equals("Java101")) {

                System.out.println("Merhaba Efendim, Patika Bankasına hoş geldiniz.");



                do{

                System.out.println(
                                "1 - Para yatırma\n"+
                                "2 - Para çekme\n"+
                                "3 - Bakiye sorgulama\n"+
                                "4 - Çıkış yap");


                System.out.print("Lütfen yapmak istediğini işlemi belirtiniz: ");
                choice=input.nextInt();

                switch (choice) {

                    case 1:
                        System.out.print("Para miktarı: ");
                        amount=input.nextInt();
                        balance+=amount;

                        break;

                    case 2:
                        System.out.print("Para miktarı: ");
                        amount=input.nextInt();
                        if (amount<=balance) {
                            balance-=amount;

                        }
                        else System.out.println("Bakiye yetersiz.");

                        break;

                    case 3:

                        System.out.println("Bakiyeniz: "+balance);

                        break;

                    case 4:
                        System.out.println("Tekrar görüşmek üzere.");
                        right=0;
                        break;

                    default:
                        System.out.println("Hatalı giriş yaptınız.");

                }
                    }while(choice!=4);


            }else {
                       right--;
                       if (right>0) {
                        System.out.println("Kullanıcı adı veya parola yanlış. Tekrar deneyiniz.");
                        System.out.println(right+" giriş hakkınız kaldı.");

                } else {
                        System.out.println("Kullanıcı adı veya parola yanlış.");
                    System.out.println("Hesabınız bloke olmuştur. Lütfen banka ile iletişime geçiniz.");
                }
                        }

                        }while (right>0);


 */

    }

}