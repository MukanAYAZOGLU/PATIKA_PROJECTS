package View;

import Model.User;
import Support.Support;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateJPopMenuUserGUI extends JFrame {
    private JPanel mainMenu;
    private JPanel panelAll;
    private JTextField textUpdateName;
    private JTextField textUpdateUserName;
    private JTextField textUpdatePassword;
    private JComboBox comboUpdateType;
    private JComboBox combocomboUpdateLanguage;
    private JButton buttonUpdate;
    private JLabel fieldHeadLıne;
    private JTextField textUpdateEposta;


    UpdateJPopMenuUserGUI(User user) {

        add(mainMenu);
        setTitle(Support.PROJECT_TITLE);
        setSize(700,220);
        setLocation(Support.arrangeLocation("x",700),Support.arrangeLocation("y",220));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        textUpdateName.setText(user.getName());
        textUpdateUserName.setText(user.getUserName());
        textUpdatePassword.setText(user.getPassword());
        textUpdateEposta.setText(user.geteposta());
        comboUpdateType.setSelectedItem(user.getUserType());
        combocomboUpdateLanguage.setSelectedItem(user.getLanguage());


        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id=user.getId();
                String name=textUpdateName.getText().toUpperCase().trim();
                String userName=textUpdateUserName.getText().toUpperCase().trim();
                String password=textUpdatePassword.getText();
                String eposta=textUpdateEposta.getText().trim();
                String type=comboUpdateType.getSelectedItem().toString();
                String language=combocomboUpdateLanguage.getSelectedItem().toString();


                if (Support.isTextFieldEmpty(textUpdateName) || Support.isTextFieldEmpty(textUpdateUserName) || Support.isTextFieldEmpty(textUpdateEposta)|| Support.isTextFieldEmpty(textUpdatePassword) ){

                    Support.giveMessage("boş");

                } else {

                    if (User.updateUser(id,name,userName,password,eposta,type,language)) {



                        Support.giveMessage("başarı");
                        dispose();

                    }else {
                        Support.giveMessage("hata");
                    }
                }



            }
        });
    }



}
