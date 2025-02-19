package View;

import Model.Content;
import Model.User;
import Support.Support;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateJPopMenuContentGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel panelAll;
    private JTextField textID;
    private JTextArea textCTitle;
    private JTextArea textCDecrip;
    private JTextArea textLink;
    private JComboBox comboUpdateLessonName;
    private JComboBox comboUpdatePatikaName;
    private JButton buttonUpdate;
    private JLabel labelID;


    public UpdateJPopMenuContentGUI(User user, int id, String cTitle, String cDescription, String link, String lessonName) {

        add(mainPanel);
        setSize(1100, 130);
        setLocation(Support.arrangeLocation("x",1100), Support.arrangeLocation("y",130));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);


        loadComboLesson(user);



        textID.setText(String.valueOf(id));
        textCTitle.setText(cTitle);
        textCDecrip.setText(cDescription);
        textLink.setText(link);
        comboUpdateLessonName.setSelectedItem(lessonName);


        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String contentTitle = textCTitle.getText().toUpperCase().trim();
                String contentDescription = textCDecrip.getText().toUpperCase().trim();
                String link = textLink.getText().trim();
                String lessonName = comboUpdateLessonName.getSelectedItem().toString();



                Content con=Content.getFetcByCTitle(contentTitle);

                    if (con!=null) {

                        Support.giveMessage("Bu isimde içerik mevcuttur. Lütfen başka bir isim tercih ediniz!");


                    }else {


                        if(Content.update(id, contentTitle, contentDescription, link, lessonName)){

                            Support.giveMessage("başarı");
                            dispose();

                        }else {
                            Support.giveMessage("hata");

                        }




                    }





                



            }
        });
    }


    public void loadComboLesson(User user){

        comboUpdateLessonName.removeAllItems();

        comboUpdateLessonName.addItem("");

        for(Content cont : Content.getContents() ) {

            if (user.getName().equals(cont.getEducatorName())) {
                comboUpdateLessonName.addItem(cont.getLessonName());
            }

        }



    }



}
