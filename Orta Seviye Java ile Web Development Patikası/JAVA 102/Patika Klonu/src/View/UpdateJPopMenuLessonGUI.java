package View;

import Model.Lesson;
import Model.Patika;
import Model.User;
import Support.Support;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateJPopMenuLessonGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel panelFull;
    private JTextField textUpdateLessonName;
    private JComboBox comboUpdateLessonEducator;
    private JComboBox comboUpdateLessonPatikaName;
    private JComboBox comboUpdateLessonLanguage;
    private JButton buttonUpdateLesson;
    private JTextField textUpdateLanguage;


    public UpdateJPopMenuLessonGUI(int id, String lessonName,String educatorName,String patikaName,String language) {

        add(mainPanel);
        setTitle(Support.PROJECT_TITLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1160, 150);
        setLocation(Support.arrangeLocation("x",1160), Support.arrangeLocation("y",150));
        setVisible(true);


        loadComboUpdateLessonEducator();

        loadComboUpdateLessonPatikaName();


        textUpdateLessonName.setText(lessonName);
        comboUpdateLessonPatikaName.setSelectedItem(patikaName);
        textUpdateLanguage.setText(language);
        comboUpdateLessonEducator.setSelectedItem(educatorName);


        buttonUpdateLesson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String lessonName = textUpdateLessonName.getText().toUpperCase();
                String educatorName = comboUpdateLessonEducator.getSelectedItem().toString();
                String patikaName = comboUpdateLessonPatikaName.getSelectedItem().toString();
                String language = textUpdateLanguage.getText();


                Lesson theLes=Lesson.getFetchByName(lessonName);

                if (theLes!=null && id!=theLes.getLessonID()){

                    Support.giveMessage("Bu isimde ders mevcuttur. Lütfen başka bir isim tercih ediniz!");
                }else{

                    if (Lesson.updateLesson(id,lessonName,educatorName,patikaName,language)) {
                        Support.giveMessage("başarı");
                        dispose();
                    }else Support.giveMessage("hata");

                }





            }
        });
        comboUpdateLessonPatikaName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String patikaName = comboUpdateLessonPatikaName.getSelectedItem().toString();

                int i=0;
                for(Patika pat :Patika.getPatikaList() ) {

                    if (pat.getName().equals(patikaName)){
                        textUpdateLanguage.setText(pat.getLanguage());
                        i++;
                        break;

                    }

                }

                if (i==0){
                    textUpdateLanguage.setText("");

                }



            }
        });




    }



    public void loadComboUpdateLessonEducator() {

        comboUpdateLessonEducator.addItem("");

        for(User user : User.getUsers() ) {

            if (user.getUserType().equals("EDUCATOR")) {
                comboUpdateLessonEducator.addItem(user.getName());
            }

        }
    }

    public void loadComboUpdateLessonPatikaName(){

        comboUpdateLessonPatikaName.addItem("");

        for(Patika pat :Patika.getPatikaList() ) {

            comboUpdateLessonPatikaName.addItem(pat.getName());

        }



    }



}
