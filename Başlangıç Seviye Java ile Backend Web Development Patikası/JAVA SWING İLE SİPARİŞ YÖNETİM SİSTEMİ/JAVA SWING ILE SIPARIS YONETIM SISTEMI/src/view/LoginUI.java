package view;

import core.Helper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame{
    private JPanel container;
    private JPanel panel_top;
    private JLabel lbl_title;
    private JPanel panel_bottom;
    private JTextField text_e_mail;
    private JButton button_login;
    private JLabel lbl_e_mail;
    private JLabel lbl_password;
    private JPasswordField text_password;


    public LoginUI() {

        this.add(container);
        this.setTitle("Müşteri Yönetim Sistemi");
        this.setSize(400,400);

        int x= (Toolkit.getDefaultToolkit().getScreenSize().width-this.getSize().width)/2;
        int y= (Toolkit.getDefaultToolkit().getScreenSize().height-this.getSize().height)/2;

        this.setLocation(x,y);
        this.setVisible(true);

        this.button_login.addActionListener(e ->{

            JTextField [] checkList={this.text_e_mail,this.text_password};

            if (!Helper.isEMailValid(this.text_e_mail.getText())){

                Helper.showMessage("Geçerli bir e-posta adresi giriniz.");
            }
            if (Helper.isFieldListEmty(checkList)) {

                Helper.showMessage("fill");

            }else Helper.showMessage("done");




        } );
    }





}
