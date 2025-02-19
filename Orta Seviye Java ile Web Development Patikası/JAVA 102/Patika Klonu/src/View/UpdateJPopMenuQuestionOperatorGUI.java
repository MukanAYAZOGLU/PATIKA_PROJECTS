package View;

import Model.Content;
import Model.Question;
import Support.Support;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateJPopMenuQuestionOperatorGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel panelUpdateQuestion;
    private JButton buttonUpdateQuestion;
    private JTextArea textUpdateOptionD;
    private JTextArea textUpdateOptionC;
    private JTextArea textUpdateOptionB;
    private JTextArea textUpdateOptionA;
    private JTextArea textUpdateQuestion;
    private JTextField textLessonName;
    private JComboBox comboUpdateQuestionTrueAnswer;
    private JComboBox comboUpdateQuestionContentTitle;
    private JTextField textEducatorName;


    public UpdateJPopMenuQuestionOperatorGUI(int id, String question, String optionA, String optionB, String optionC, String optionD, String trueAnswer, String contentTitle, String lessonName, String educatorName) {
        add(mainPanel);
        setTitle(Support.PROJECT_TITLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600,600);
        setLocation(Support.arrangeLocation("x",600),Support.arrangeLocation("y",600));
        setResizable(true);
        setVisible(true);



        loadComboQuestionContentTitle();


        textUpdateQuestion.setText(question);
        textUpdateOptionA.setText(optionA);
        textUpdateOptionB.setText(optionB);
        textUpdateOptionC.setText(optionC);
        textUpdateOptionD.setText(optionD);
        comboUpdateQuestionTrueAnswer.setSelectedItem(trueAnswer);
        comboUpdateQuestionContentTitle.setSelectedItem(contentTitle);
        textLessonName.setText(lessonName);
        textEducatorName.setText(educatorName);





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



                for(Content cont :Content.getContents() ) {
                    if (cont.getContentTitle().equals(contentTitle)) {
                        textLessonName.setText(cont.getLessonName());
                        textEducatorName.setText(cont.getEducatorName());

                        break;
                    }

                }




                String  LessonName=textLessonName.getText();
                String  educatorName=textEducatorName.getText();


                Question ques=Question.getFetchBYQUestion(question);

                if (ques!=null && ques.getId()!=id && ques.getContentTitle().equals(contentTitle)){

                    Support.giveMessage("Bu soru halihazırda mevcuttur.");


                }else {

                    if (Question.update(id,question,optionA,optionB,optionC,optionD,trueAnswer,contentTitle,LessonName, educatorName)){
                        Support.giveMessage("başarı");
                        dispose();

                    }else {
                        Support.giveMessage("hata");

                    }

                }


            }







        });


        comboUpdateQuestionContentTitle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String  contentTitle=comboUpdateQuestionContentTitle.getSelectedItem().toString();

                int i=0;

                for(Content cont :Content.getContents() ) {
                    if (cont.getContentTitle().equals(contentTitle)) {
                        textLessonName.setText(cont.getLessonName());
                        textEducatorName.setText(cont.getEducatorName());
                        i++;
                        break;
                    }

                }

                if (i==0){
                    textLessonName.setText("");
                    textEducatorName.setText("");

                }



            }
        });
    }



    public void loadComboQuestionContentTitle() {
        comboUpdateQuestionContentTitle.removeAllItems();

        comboUpdateQuestionContentTitle.addItem("");

        for(Content content : Content.getContents() ) {

                comboUpdateQuestionContentTitle.addItem(content.getContentTitle());

        }
    }




}
