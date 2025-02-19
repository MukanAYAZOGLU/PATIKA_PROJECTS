package View;

import Model.User;
import Support.Support;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel panelAll;
    private JPanel panelBottomLeft;
    private JPanel panelBottomRight;
    private JPanel panelBottom;
    private JTextArea textName;
    private JTextArea textSurname;
    private JTextArea textEPosta;
    private JButton buttonRegister;
    private JTextArea textUserName;
    private JTextArea textPassword;
    private JTextArea textPasswordAgain;


    public SignUpGUI() {

        add(mainPanel);
        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,500);
        setLocation(Support.arrangeLocation("x",500),Support.arrangeLocation("y",500));
        setResizable(false);
        setVisible(true);


        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = textName.getText().toUpperCase().trim();
                String surname = textSurname.getText().toUpperCase().trim();
                String username = textUserName.getText().trim();
                String ePosta = textEPosta.getText().trim();
                String password = textPassword.getText();
                String passwordAgain = textPasswordAgain.getText();

                String fullName=name+" "+surname;


                if (Support.isTextFieldEmpty(textName) || Support.isTextFieldEmpty(textSurname) || Support.isTextFieldEmpty(textUserName) || Support.isTextFieldEmpty(textPassword) || Support.isTextFieldEmpty(textPasswordAgain) ||Support.isTextFieldEmpty(textEPosta)) {


                    Support.giveMessage("boş");


                }else {

                    if (User.getFetchByUserName(username) != null) {

                        Support.giveMessage("Bu kullanıcı adı mevcuttur. Farklı bir kullanıcı adı deneyiniz.");
                    }else {

                        if (!passwordAgain.equals(password)) {
                            Support.giveMessage("Şifreler uyuşmamaktadır !");
                        }else {

                            if (!ePosta.contains("@") || !ePosta.endsWith(".com") || !(ePosta.length()>7)) {

                                Support.giveMessage("E-Postanızı hatalı girdiniz.");


                            }else {

                                 User.addUser(fullName,username,password,ePosta,"STUDENT","");


                            }





                        }
                    }





                }




            }
        });
    }


    public static void main(String[] args) {
        new SignUpGUI();
    }








}
