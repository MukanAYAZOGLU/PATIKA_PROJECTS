package View;

import Model.Content;
import Model.Lesson;
import Model.Question;
import Model.User;
import Support.Support;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateJPopMenuQuestionGUI extends JFrame {
    private JPanel mainPanel;
    private JButton buttonUpdateQuestion;
    private JTextArea textUpdateOptionD;
    private JTextArea textUpdateOptionC;
    private JTextArea textUpdateOptionB;
    private JTextArea textUpdateOptionA;
    private JTextArea textUpdateQuestion;
    private JComboBox comboUpdateQuestionContentTitle;
    private JComboBox comboUpdateQuestionLessonName;
    private JComboBox comboUpdateQuestionTrueAnswer;
    private JPanel panelAddQuestion;


    public UpdateJPopMenuQuestionGUI(int id, String question, String optionA, String optionB, String optionC, String optionD, String trueAnswer, String contentTitle, String lessonName, User user) {
        add(mainPanel);
        setTitle(Support.PROJECT_TITLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600,600);
        setLocation(Support.arrangeLocation("x",600),Support.arrangeLocation("y",600));
        setResizable(true);
        setVisible(true);





        comboUpdateQuestionLessonName.setSelectedItem(lessonName);
        comboUpdateQuestionContentTitle.setSelectedItem(contentTitle);
        textUpdateQuestion.setText(question);
        textUpdateOptionA.setText(optionA);
        textUpdateOptionB.setText(optionB);
        textUpdateOptionC.setText(optionC);
        textUpdateOptionD.setText(optionD);
        comboUpdateQuestionTrueAnswer.setSelectedItem(trueAnswer);

        loadComboQuestionLessonName(user);
        loadComboQuestionContentTitle(lessonName);



        comboUpdateQuestionLessonName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                comboUpdateQuestionContentTitle.removeAllItems();

                String lessonName =comboUpdateQuestionLessonName.getSelectedItem().toString();


                for(Content cont :Content.getContents() ) {

                    if (cont.getLessonName().equals(lessonName)) {
                        comboUpdateQuestionContentTitle.addItem(cont.getContentTitle());
                        break;
                    }


                }

            }
        });


        buttonUpdateQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String  question=textUpdateQuestion.getText().trim();
                String  optionA=textUpdateOptionA.getText().trim();
                String  optionB=textUpdateOptionB.getText().trim();
                String  optionC=textUpdateOptionC.getText().trim();
                String  optionD=textUpdateOptionD.getText().trim();
                String  trueAnswer=comboUpdateQuestionTrueAnswer.getSelectedItem().toString();
                String  contentTitle=comboUpdateQuestionContentTitle.getSelectedItem().toString();
                String  LessonName=comboUpdateQuestionLessonName.getSelectedItem().toString();

                Question ques=Question.getFetchBYQUestion(question);


                    if (ques!=null && ques.getId()!=id) {

                        if (Support.confirm("Bu soru halihazırda mevcuttur. Yine de devam etmek ister misiniz ?")){

                            if (Question.update(id,question,optionA,optionB,optionC,optionD,trueAnswer,contentTitle,LessonName, user.getName())){
                                Support.giveMessage("başarı");
                                dispose();
                            }else {
                                Support.giveMessage("hata");
                            }

                        } else {
                        }


                    }else {

                            if (Question.update(id,question,optionA,optionB,optionC,optionD,trueAnswer,contentTitle,LessonName, user.getName())){
                                Support.giveMessage("başarı");
                                dispose();
                            }else {
                                Support.giveMessage("hata");
                            }

                        }






                }







        });
    }




    public void loadComboQuestionLessonName(User User) {

        comboUpdateQuestionLessonName.removeAllItems();

        for(Lesson les : Lesson.getLessons()) {

            if (les.getEducatorName().equals(User.getName())) {
                comboUpdateQuestionLessonName.addItem(les.getLessonName());
            }

        }


    }

    public void loadComboQuestionContentTitle(String lesName) {
        comboUpdateQuestionContentTitle.removeAllItems();

        for(Content cont :Content.getContents() ) {

            if (cont.getLessonName().equals(lesName)) {
                comboUpdateQuestionContentTitle.addItem(cont.getContentTitle());
                break;
            }


        }
    }




}
