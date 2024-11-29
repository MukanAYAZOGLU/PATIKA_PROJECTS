import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Kullanıcı adımız: Patika
        //Kullanıcı e-postamız: patika-java@gmail.com
        //Kullanıcı şifremiz: Java123
        //Kullanıcı şifreyi yenilemek için 3 hakkı var.

        String userName = "Java", userEMail = "patika-java@gmail.com", userPassword = "Java123";
        String userEntrNameEMail;
        String userEntrPassword;
        String newPassword;
        String newPasswordContrl;
        int mistake=0;
        int mistake2 =0;

        char answr;

        Scanner inp = new Scanner(System.in);

        System.out.print("Kullanıcı adınızı veya e-posta adresinizi giriniz: ");
        userEntrNameEMail = inp.next();

            if (userEntrNameEMail.equals(userName) || userEntrNameEMail.equals(userEMail)) {

                System.out.print("Kullanıcı şifrenizi giriniz: ");
                userEntrPassword = inp.next();

                    if (userEntrPassword.equals(userPassword)) {

                        System.out.println("Giriş başarılı.");
                    }

                    else {

                        System.out.print("Şifreniz hatalı. Şifrenizi sıfırlamak ister misiniz (E/h): ");

                        answr=inp.next().charAt(0);

                        switch (answr) {

                            case 'E':

                                System.out.print("Yeni şifrenizi giriniz: ");
                                newPassword=inp.next();

                                while(newPassword.equals(userPassword) && mistake<=3) {

                                    if (mistake<2) {

                                        System.out.println("Şifreniz oluşturulamadı, lütfen başka şifre giriniz.");

                                        System.out.print("Yeni şifrenizi giriniz: ");
                                        newPassword = inp.next();
                                    }

                                    mistake++;

                                    if(mistake==3){

                                            System.out.println("3 kez hatalı giriş gerçekleştirdiniz.Şifre yenileme " +
                                                    "işleminiz iptal edilmiştir.");
                                        }
                                    }

                                if (!(newPassword.equals(userPassword))) {

                                    System.out.print("Yeni şifrenizi tekrar giriniz: ");
                                    newPasswordContrl = inp.next();

                                    if (newPassword.equals(newPasswordContrl)) {

                                        System.out.println("Şifreniz oluşturuldu.");

                                        mistake2=3;

                                    }

                                    while (!(newPassword.equals(newPasswordContrl)) && mistake2<3) {

                                        System.out.print("Şifreler uyuşmamaktadır. Tekrar deneyiniz: ");
                                        newPasswordContrl = inp.next();

                                        mistake2++;

                                    if (mistake2==3) {
                                        System.out.println("3 kez hatalı giriş gerçekleştirdiniz. Şifre yenileme " +
                                                "işleminiz iptal edilmiştir.");
                                    }
                                    }

                                    }

                                break;

                            case 'h':
                                System.out.println("Program sonlandırıldı.");
                                break;

                            default:
                                System.out.println("Hatalı tuşlama yaptınız. Program sonlandırıldı");

                        }

                    }

            } else System.out.println("Kullanıcı adınız veya e-postanız hatalı.");

    }


}