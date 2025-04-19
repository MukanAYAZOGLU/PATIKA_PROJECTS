package View;

import Model.User;
import Support.Support;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JLabel larblIconPatika;
    private JTextArea textUserNameOrEposta;
    private JPasswordField textPassword;
    private JButton girişYapButton;
    private JButton buttonSignUp;

    public LogInGUI() {


        add(mainPanel);
        setTitle(Support.PROJECT_TITLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocation(Support.arrangeLocation("x",500), Support.arrangeLocation("y",500));
        setResizable(false);
        setVisible(true);





        girişYapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String userNameOrEposta = textUserNameOrEposta.getText();
                String password = new String(textPassword.getPassword());


                if (userNameOrEposta.isEmpty() || password.isEmpty()) {
                    Support.giveMessage("boş");

                }else {

                    User name=User.getFetchByUserNameAndPassword(userNameOrEposta,password);
                    User eposta=User.getFetchByEPostaAndPassword(userNameOrEposta,password);

                    if(name!=null){

                        switch (name.getUserType()){

                            case "OPERATOR": OperatorGUI operatorGUI = new OperatorGUI(name);
                            dispose();
                            break;

                            case "EDUCATOR": EducatorGUI educatorGUI = new EducatorGUI(name);
                            dispose();
                            break;

                            case "STUDENT": StudentGUI studentGUI = new StudentGUI(name);
                            dispose();
                            break;

                            default: dispose();




                        }
                    }else if (eposta!=null){

                        switch (eposta.getUserType()){

                            case "OPERATOR": OperatorGUI operatorGUI = new OperatorGUI(eposta);
                                dispose();
                                break;

                            case "EDUCATOR": EducatorGUI educatorGUI = new EducatorGUI(eposta);
                                dispose();
                                break;

                            case "STUDENT": StudentGUI studentGUI = new StudentGUI(eposta);
                                dispose();
                                break;

                            default: dispose();




                        }


                    }else {

                        textPassword.setText(null);
                        Support.giveMessage("Kullanıcı adı / e-posta veya şifre hatalı !");
                    }





                }








            }
        });
        buttonSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SignUpGUI signUpGUI = new SignUpGUI();
                dispose();

            }
        });
    }

    public static void main(String[] args) {
        Support.theme();
        LogInGUI logInGUI = new LogInGUI();
    }


}
