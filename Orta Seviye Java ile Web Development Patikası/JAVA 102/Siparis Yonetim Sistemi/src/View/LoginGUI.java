package View;

import Model.User;
import Support.Support;

import javax.swing.*;

public class LoginGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField textEPosta;
    private JPasswordField textPassword;
    private JButton buttonLogin;


    public LoginGUI() {

        add(mainPanel);
        setTitle("Sigorta Yönetim Sistemi Giriş Ekranı");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400,400);
        setLocation(Support.locateScreen("x",400),Support.locateScreen("y",400));
        setResizable(true);
        setVisible(true);



        buttonLogin.addActionListener(e -> {

        if (Support.isEPostaValid(textEPosta.getText())) {
            Support.giveMessage("Lütfen geçerli bir e-posta adresi giriniz!");

            }else if (Support.isAnyOfTextFieldEmpty(new JTextField[]{textEPosta,textPassword})){

                Support.giveMessage("boş");

            }else {

            User user=User.getUser(textEPosta.getText(),textPassword.getText());

            if (user!=null){

                dispose();
                DashboardGUI dashboardGUI=new DashboardGUI(user);


            }else Support.giveMessage("Kullanıcı bulunamadı!");


            }



        });






    }

    public static void main(String[] args) {
        Support.theme();
        Support.TROptions();
        new LoginGUI();
    }
}
