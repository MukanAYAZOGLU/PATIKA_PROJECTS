package View;

import Model.User;
import Support.*;

import javax.swing.*;
import java.util.Arrays;

public class AddUserGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel panelBottom;
    private JPanel panelTop;
    private JButton buttonLogOut;
    private JTextField textName;
    private JTextField textSurname;
    private JTextField textUserName;
    private JPasswordField textPassword;
    private JPasswordField textAgainPassword;
    private JTextField textMail;
    private JTextField textPhone;
    private JComboBox comboUserType;
    private JButton buttonAdd;
    private JLabel labelAddUser;


    public AddUserGUI(User user) {
        add(mainPanel);
        setTitle(Support.ProjectTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 350);
        setLocation(Support.setLocation("x", 400), Support.setLocation("y", 350));
        setResizable(true);
        setVisible(true);



        buttonLogOut.addActionListener(e -> {
            dispose();

        });

        if (user!=null){

            labelAddUser.setText("KULLANICI GÜNCELLEME PENCERESİ");
            textName.setText(user.getName());
            textSurname.setText(user.getSurname());
            textUserName.setText(user.getUserName());
            textPassword.setText(user.getPassword());
            textAgainPassword .setText(user.getPassword());
            textMail.setText(user.getMail());
            textPhone.setText(user.getPassword());
            comboUserType.setSelectedItem(user.getUserType());
            buttonAdd.setText("GÜNCELLE");

        }



        buttonAdd.addActionListener(e -> {


            if (Support.isAnyOfTheseTextFieldsEmpty(new JTextField[]{ textName, textSurname, textUserName, textMail, textPhone, textPassword})) {

                Support.showMessage("empty");

            } else if (!Arrays.equals(textPassword.getPassword(), textAgainPassword.getPassword())){

                Support.showMessage("Şifreler aynı değil!");



            }else if (!Support.isMailValid(textMail.getText())){

                Support.showMessage("E-Posta adresiniz hatalı!");


            }else {
                String name = textName.getText().trim().toUpperCase();
                String surname = textSurname.getText().trim().toUpperCase();
                String userName = textUserName.getText().trim();
                String mail = textMail.getText().trim();
                String phone = textPhone.getText().trim();
                String password = new String(textPassword.getPassword());
                String type = comboUserType.getSelectedItem().toString();


                if (user==null){

                    if (User.add(name, surname, userName, mail, phone, password, type)) {

                        Support.showMessage("okey");
                        dispose();
                    } else {
                        Support.showMessage("error");
                    }


                }else {

                    if (User.update(user.getId(), name, surname, userName, mail, phone, password, type)) {

                        Support.showMessage("okey");
                        dispose();
                    } else {
                        Support.showMessage("error");
                    }

                }





            }


        });
    }

    public static void main(String[] args) {
        //User user=new User(1,"MUKAN","AYAZOĞLU","mukan","@gmail.com","05443332211","şifre","admin");
        //Support.theme();
        //new AdminAddUserGUI(null);
    }


}