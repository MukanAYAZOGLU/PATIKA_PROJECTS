package View;

import Model.User;
import Support.Support;

import javax.swing.*;

public class LoginGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JTextField textUserName;
    private JPasswordField textPassword;
    private JButton buttonLogin;



    public LoginGUI() {
        add(mainPanel);
        setTitle(Support.ProjectTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 600);
        setLocation(Support.setLocation("x",400),Support.setLocation("y",600));
        setResizable(true);
        setVisible(true);



        buttonLogin.addActionListener(e -> {

            String userName=textUserName.getText().trim();
            String password=textPassword.getText();


            if (Support.isTextFieldEmpty(textUserName) || password.isEmpty()) {

                Support.showMessage("empty");

            }else {

                if (!checkLogin(userName,password)) Support.showMessage("Kullanıcı bulunamadı!");


            }
        });









    }



    private boolean checkLogin(String userName,String password) {

            for(User user :User.getUsers() ) {

                if (user.getUserName().equals(userName) && user.getPassword().equals(password) && user.getUserType().equals("admin")) {

                    AdminGUI adminGUI=new AdminGUI(user);
                    adminGUI.setVisible(true);
                    dispose();
                    return true;

                } else if (user.getUserName().equals(userName) && user.getPassword().equals(password) && user.getUserType().equals("personel")) {

                    PersonelGUI personelGUI=new PersonelGUI(user);
                    personelGUI.setVisible(true);
                    dispose();
                    return true;

                }

            }

            return false;


    }



    public static void main(String[] args) {
        Support.theme();
        Support.trOptions();
        new LoginGUI();
    }
}
