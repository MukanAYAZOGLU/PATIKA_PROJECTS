package View;

import Model.Content;
import Model.Lesson;
import Model.User;
import Support.Support;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateJPopMenuContentOperatorGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel panelAll;
    private JTextField textID;
    private JTextField textCTitle;
    private JTextField textCDecrip;
    private JTextField textLink;
    private JComboBox comboUpdateLessonName;
    private JComboBox comboUpdatePatikaName;
    private JButton buttonUpdate;
    private JTextField textEducatorName;
    private JLabel labelID;


    public UpdateJPopMenuContentOperatorGUI( int id, String cTitle, String cDescription, String link, String lessonName, String educatorName) {

        add(mainPanel);
        setSize(1210, 100);
        setLocation(Support.arrangeLocation("x",1210), Support.arrangeLocation("y",100));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);


        loadComboLesson();



        textID.setText(String.valueOf(id));
        textCTitle.setText(cTitle);
        textCDecrip.setText(cDescription);
        textLink.setText(link);
        comboUpdateLessonName.setSelectedItem(lessonName);
        textEducatorName.setText(educatorName);


        buttonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String contentTitle = textCTitle.getText().toUpperCase().trim();
                String contentDescription = textCDecrip.getText().toUpperCase().trim();
                String link = textLink.getText().trim();
                String lessonName = comboUpdateLessonName.getSelectedItem().toString();

                Content con=Content.getFetcByCTitle(contentTitle);

                    if (con!=null && con.getId()!=id) {

                        Support.giveMessage("Bu isimde içerik mevcuttur. Lütfen başka bir isim tercih ediniz!");


                    }else {


                        for(Lesson les:Lesson.getLessons() ) {
                            if (les.getLessonName().equals(lessonName)) {
                                textEducatorName.setText(les.getEducatorName());
                                break;
                            }

                        }

                        String educatorName=textEducatorName.getText();

                        if(Content.update(id, contentTitle, contentDescription, link, lessonName, educatorName)){

                            Support.giveMessage("başarı");
                            dispose();

                        }else {
                            Support.giveMessage("hata");

                        }




                    }









            }
        });
        comboUpdateLessonName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String lessonName = comboUpdateLessonName.getSelectedItem().toString();

                int i=0;
                for(Lesson les:Lesson.getLessons() ) {
                    if (les.getLessonName().equals(lessonName)) {
                        textEducatorName.setText(les.getEducatorName());
                        i++;
                        break;
                    }

                }

                if (i==0){
                    textEducatorName.setText("");
                }

            }
        });
    }


    public void loadComboLesson(){

        comboUpdateLessonName.removeAllItems();


        comboUpdateLessonName.addItem("");

        for(Lesson lesson : Lesson.getLessons() ) {

                comboUpdateLessonName.addItem(lesson.getLessonName());

        }



    }



}
