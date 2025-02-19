package View;

import Model.Question;
import Model.Quiz;
import Model.User;
import Support.Support;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel panelAll;
    private JTextField textQuestion;
    private JRadioButton buttonA;
    private JRadioButton buttonB;
    private JButton buttonNextQues;
    private JRadioButton buttonC;
    private JRadioButton buttonD;
    private JPanel panelOptions;
    private JButton buttonPreviousQues;
    private ButtonGroup buttonGroup;
    private Question question;
    private int i;


    public QuizGUI(User user, String lessonName, String contentTitle) {

        add(mainPanel);
        setTitle(Support.PROJECT_TITLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 300);
        setLocation(Support.arrangeLocation("x",700), Support.arrangeLocation("y",300));
        setResizable(true);
        setVisible(true);



        buttonPreviousQues.setVisible(false);

        i=1;

        //Question.getQuestionsByUserNameAndLessonNameAndContentName()

        question=Question.getFetchBYID(i);




            textQuestion.setText(question.getQuestion());
            buttonA.setText("A) "+question.getOptionA());
            buttonB.setText("B) "+question.getOptionB());
            buttonC.setText("C) "+question.getOptionC());
            buttonD.setText("D) "+question.getOptionD());



            buttonA.setActionCommand("A");
            buttonB.setActionCommand("B");
            buttonC.setActionCommand("C");
            buttonD.setActionCommand("D");





        //herhangi bir radio button seçilmiş olunmalı, zira get actionCommand talep edildiğinde herhangi biri seçilmemişse boş döndürme hatası veriyor.


        buttonPreviousQues.setVisible(false);



        //ButtonGroup sayesinde bir radio button seçildiğinde önceki seçim ortadan kalkıyor.

        buttonGroup = new ButtonGroup();
        buttonGroup.add(buttonA);
        buttonGroup.add(buttonB);
        buttonGroup.add(buttonC);
        buttonGroup.add(buttonD);


        buttonPreviousQues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buttonNextQues.setText("Sonraki Soru");

                int questionID = question.getId();
                int studentID = user.getId();
                String reply="";
                if (buttonGroup.getSelection()!=null){
                    reply = buttonGroup.getSelection().getActionCommand();

                }
                String trueAnswer = question.getTrueAnswer();

                int k=0;

                if (Quiz.getFetchByStudentID(studentID)!=null) {

                    for (Quiz quiz : Quiz.getFetchByStudentID(studentID)) {

                        if (quiz.getQuestionID() == questionID) {

                            k++;

                            if (Quiz.update(quiz.getId(), reply)) {

                                i--;

                                if (Question.getFetchBYID(i) != null) {

                                    question = Question.getFetchBYID(i);

                                    textQuestion.setText(question.getQuestion());
                                    buttonA.setText("A) " + question.getOptionA());
                                    buttonB.setText("B) " + question.getOptionB());
                                    buttonC.setText("C) " + question.getOptionC());
                                    buttonD.setText("D) " + question.getOptionD());

                                    buttonGroup.clearSelection();


                                    if (Question.getFetchBYID(i - 1) == null) {
                                        buttonPreviousQues.setVisible(false);
                                    }


                                    break;

                                }


                            } else {
                                Support.giveMessage("hata");
                                break;

                            }


                        }

                    }
                }

                if (k==0){

                    if (Quiz.add(questionID,trueAnswer,reply,studentID)){

                        i--;

                        if (Question.getFetchBYID(i)!=null){

                            question=Question.getFetchBYID(i);

                            textQuestion.setText(question.getQuestion());
                            buttonA.setText("A) "+question.getOptionA());
                            buttonB.setText("B) "+question.getOptionB());
                            buttonC.setText("C) "+question.getOptionC());
                            buttonD.setText("D) "+question.getOptionD());

                            buttonGroup.clearSelection();


                            if (Question.getFetchBYID(i-1)==null){
                                buttonPreviousQues.setVisible(false);
                            }



                        }

                    }else {
                        Support.giveMessage("hata");

                    }


                }












                }




        });




        buttonNextQues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buttonPreviousQues.setVisible(true);


                int questionID = question.getId();
                int studentID = user.getId();
                String reply = "";
                if (buttonGroup.getSelection() != null) {
                    reply = buttonGroup.getSelection().getActionCommand();

                }

                String trueAnswer = question.getTrueAnswer();


                int k = 0;

                if (Quiz.getFetchByStudentID(studentID) != null) {

                    for (Quiz quiz : Quiz.getFetchByStudentID(studentID)) {

                        if (quiz.getQuestionID() == questionID) {

                            k++;


                            if (Quiz.update(quiz.getId(), reply)) {


                                i++;

                                if (Question.getFetchBYID(i) != null) {

                                    question = Question.getFetchBYID(i);

                                    textQuestion.setText(question.getQuestion());
                                    buttonA.setText("A) " + question.getOptionA());
                                    buttonB.setText("B) " + question.getOptionB());
                                    buttonC.setText("C) " + question.getOptionC());
                                    buttonD.setText("D) " + question.getOptionD());

                                    buttonGroup.clearSelection();


                                    if (Question.getFetchBYID(i + 1) == null) {
                                        buttonNextQues.setText("Bitir");
                                    }


                                    break;


                                } else {

                                    int correntAnswers=0;
                                    int wrongAnswers=0;

                                    for(Quiz qu :Quiz.getFetchByStudentID(studentID) ) {

                                        if (qu.getTrueAnswer().equals(qu.getReply())){
                                            correntAnswers++;
                                        }else {
                                            wrongAnswers++;
                                        }


                                    }


                                    Support.giveMessage("Sınav Sonucu:" +
                                                    "\nDoğru Sayısı:" + correntAnswers +
                                                    "\nYanlış Sayısı" + wrongAnswers);
                                    dispose();
                                    break;
                                }


                            } else {
                                Support.giveMessage("hata");
                                break;

                            }
                        }


                    }

                }

                if (k == 0) {

                    if (Quiz.add(questionID, trueAnswer, reply, studentID)) {

                        i++;

                        if (Question.getFetchBYID(i) != null) {

                            question = Question.getFetchBYID(i);

                            textQuestion.setText(question.getQuestion());
                            buttonA.setText("A) " + question.getOptionA());
                            buttonB.setText("B) " + question.getOptionB());
                            buttonC.setText("C) " + question.getOptionC());
                            buttonD.setText("D) " + question.getOptionD());

                            buttonGroup.clearSelection();


                            if (Question.getFetchBYID(i + 1) == null) {
                                buttonNextQues.setText("Bitir");

                            }


                        } else {
                            int correntAnswers=0;
                            int wrongAnswers=0;

                            for(Quiz qu :Quiz.getFetchByStudentID(studentID) ) {

                                if (qu.getTrueAnswer().equals(qu.getReply())){
                                    correntAnswers++;
                                }else {
                                    wrongAnswers++;
                                }


                            }


                            Support.giveMessage("Sınav Sonucu:" +
                                    "\nDoğru Sayısı: " + correntAnswers +
                                    "\nYanlış Sayısı: " + wrongAnswers);
                            dispose();

                        }

                    } else {
                        Support.giveMessage("hata");

                    }


                }


            }


        });









    }




    public void loadQuestion(int i, Question quest, JTextField putQuestion, JRadioButton optionA, JRadioButton optionB,JRadioButton optionC,JRadioButton optionD) {


        quest=Question.getFetchBYID(i);

        putQuestion.setText(quest.getQuestion());
        optionA.setText("A) "+quest.getOptionA());
        optionB.setText("B) "+quest.getOptionB());
        optionC.setText("C) "+quest.getOptionC());
        optionD.setText("D) "+quest.getOptionD());




    }









    public static void main(String[] args) {
        Support.theme();
        User user=new User(5,"ERTUĞRUL BERKAY","er","er1234","posta12@yaani.com.tr","STUDENT","");
        //new QuizGUI(user);
    }






}
