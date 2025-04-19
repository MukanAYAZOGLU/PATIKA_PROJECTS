package View;

import Model.*;
import Support.Support;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame {
    private JPanel mainPanel;
    private JLabel labelWelcome;
    private JButton buttonExit;
    private JPanel panelWelcome;
    private JComboBox comboRegis;
    private JButton buttonRegister;
    private JComboBox comboEnterExamLesName;
    private JComboBox comboEnterExamContTitle;
    private JButton buttonEnterExam;
    private JTabbedPane tabbedPane1;
    private JPanel panelRegister;
    private JPanel panelEnterQuiz;
    private JComboBox comboCommentLesName;
    private JComboBox comboCommentContTitle;
    private JComboBox comboCommentStars;
    private JButton buttonComment;
    private JTextArea textComment;
    private JPanel panelComment;
    private JButton buttonShowContents;
    private JTable tableShowContents;
    private JButton buttonDelete;
    private JComboBox comboDeleteShow;
    private JPanel panelRegisteredLessons;
    private JTable tableRegisteredLessons;
    private DefaultTableModel modelContents;
    private DefaultTableModel modelLessons;
    private Object [] rowContens;
    private Object [] rowLessons;



    public StudentGUI(User user) {

        add(mainPanel);
        setTitle(Support.PROJECT_TITLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 500);
        setLocation(Support.arrangeLocation("x",1000),Support.arrangeLocation("y",500));
        setResizable(true);
        setVisible(true);



        labelWelcome.setText("HOŞ GELDİNİZ "+user.getName());



        modelContents = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0){return false;}
                if (column == 1){return false;}
                if (column == 2){return false;}
                return super.isCellEditable(row, column);
            }
        };




        Object [] columnsContents = {"ID", "CONTENT TITLE","LESSON NAME"};
        modelContents.setColumnIdentifiers(columnsContents);
        rowContens= new Object[columnsContents.length];

        loadTableContents(user);


        tableShowContents.setModel(modelContents);



        tableShowContents.getColumnModel().getColumn(0).setMaxWidth(50);


        tableShowContents.getTableHeader().setReorderingAllowed(false);
        tableShowContents.getTableHeader().setResizingAllowed(true);





        modelLessons = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0){return false;}
                if (column == 1){return false;}
                return super.isCellEditable(row, column);
            }
        };

        Object [] columnsLessons={"ID","LESSON NAME"};
        modelLessons.setColumnIdentifiers(columnsLessons);
        rowLessons = new Object[columnsLessons.length];

        loadTableLessons(user);

        tableRegisteredLessons.setModel(modelLessons);
        tableRegisteredLessons.getColumnModel().getColumn(0).setMaxWidth(50);
        tableRegisteredLessons.getTableHeader().setReorderingAllowed(false);
        tableRegisteredLessons.getTableHeader().setResizingAllowed(true);



        loadComboRegisteredLesson();

        loadComboAllLesName(user);

        loadComboExamContentTitle(comboEnterExamLesName.getSelectedItem().toString());

        loadComboCommentContTitle(comboCommentLesName.getSelectedItem().toString());








        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }
        });




        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboRegis.getItemCount()>0){

                    String lessonName = comboRegis.getSelectedItem().toString();

                    for(RegisteredLessons res :RegisteredLessons.getRegisteredLessons() ) {

                        if ((user.getName().equals(res.getStudentName())) && (res.getLessonName().equals(lessonName))){

                            Support.giveMessage("Bu derse kaydınız mevcuttur. Tekrar kayıt yapılamamaktadır.");
                            break;

                        }else {

                            if (RegisteredLessons.add(user.getName(), lessonName)){

                                loadTableLessons(user);

                                loadTableContents(user);

                                addComboAllLesName(lessonName);

                                loadComboExamContentTitle(comboEnterExamLesName.getSelectedItem().toString());

                                loadComboCommentContTitle(comboCommentLesName.getSelectedItem().toString());


                                Support.giveMessage("başarı");

                                break;
                            }else {

                                Support.giveMessage("hata");
                                break;

                            }


                        }


                    }

                }else Support.giveMessage("Kayıt olabileceğiniz herhangi bir ders bulunmamaktadır.");




            }
        });








        buttonShowContents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboDeleteShow.getItemCount()>0){

                    String lessonName= comboDeleteShow.getSelectedItem().toString();

                    loadTableContents(lessonName);

                }else Support.giveMessage("Herhangi bir ders mevcut değil!");





            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (comboDeleteShow.getItemCount()>0){

                    if (Support.confirm("sure")){

                        String lesName= comboDeleteShow.getSelectedItem().toString();

                        if (RegisteredLessons.delete(lesName)){

                            loadTableLessons(user);

                            loadTableContents(user);

                            removeComboAllLesName(lesName);

                            loadComboExamContentTitle(comboEnterExamLesName.getSelectedItem().toString());

                            loadComboCommentContTitle(comboCommentLesName.getSelectedItem().toString());





                            Support.giveMessage("başarı");


                        }else Support.giveMessage("hata");

                    }else Support.giveMessage("iptal");




                }else Support.giveMessage("Herhangi bir ders mevcut değil!");






            }
        });


        comboEnterExamLesName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String lessonName = comboEnterExamLesName.getSelectedItem().toString();

                loadComboExamContentTitle(lessonName);



            }
        });


        comboCommentLesName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String lessonName= comboCommentLesName.getSelectedItem().toString();

                loadComboCommentContTitle(lessonName);




            }
        });
        buttonComment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboCommentLesName.getItemCount()>0 && comboCommentContTitle.getItemCount()>0){

                    String lesName= comboCommentLesName.getSelectedItem().toString();
                    String conTitle= comboCommentContTitle.getSelectedItem().toString();

                    int star=1;
                    star+=comboCommentStars.getSelectedIndex();

                    String comment=textComment.getText().trim();


                    boolean having=StarComment.getFetch(user.getName(), conTitle);
                    if(having){
                        if (Support.confirm("Bu içeriğe ait yorumunuz bulunmaktadır. Tekrar yorumlamak ister misiniz?")){

                            if (StarComment.add(user.getName(),conTitle,lesName,star,comment)){

                                textComment.setText(null);

                                Support.giveMessage("Yorum gönderildi");
                            }else {

                                Support.giveMessage("hata");
                            }

                        }else {

                            Support.giveMessage("iptal");
                        }
                    }else {

                        if (StarComment.add(user.getName(),conTitle,lesName,star,comment)){

                            textComment.setText(null);

                            Support.giveMessage("Yorum gönderildi");
                        }else {

                            Support.giveMessage("hata");
                        }
                    }






                }else if (comboCommentLesName.getItemCount()==0){

                    Support.giveMessage("Ders seçimi gerçekleştiriniz.");

                }else Support.giveMessage("İçerik seçimi gerçekleştiriniz.");








            }
        });
        buttonEnterExam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboEnterExamLesName.getItemCount()>0 && comboEnterExamContTitle.getItemCount()>0){


                    String lesName=comboEnterExamLesName.getSelectedItem().toString();
                    String conTitle=comboEnterExamContTitle.getSelectedItem().toString();


                    Question question=Question.getFetchBYContentTitle(conTitle);

                    if (question!=null){
                        QuizGUI quizGUI= new QuizGUI(user,lesName,conTitle);

                    }else Support.giveMessage("Bu içeriğe ait herhangi bir soru bulunmamaktadır.");


                }else if (comboEnterExamLesName.getItemCount()==0){
                    Support.giveMessage("Ders seçimi gerçekleştiriniz.");
                }else Support.giveMessage("İçerik seçimi gerçekleştiriniz.");



            }
        });
    }





    public void loadTableLessons(User user){

        DefaultTableModel clear= (DefaultTableModel) tableRegisteredLessons.getModel();
        clear.setRowCount(0);

        int i;

        for(RegisteredLessons res :RegisteredLessons.getRegisteredLessons() ) {

            if (user.getName().equals(res.getStudentName())) {
                i = 0;
                rowLessons[i++] = res.getId();
                rowLessons[i++] = res.getLessonName();
                modelLessons.addRow(rowLessons);
            }


        }






    }

    public void loadTableContents(User user) {

        DefaultTableModel clear = (DefaultTableModel) tableShowContents.getModel();
        clear.setRowCount(0);
        int i;

        for(RegisteredLessons res :RegisteredLessons.getRegisteredLessons() ) {

            if (user.getName().equals(res.getStudentName())) {

                for(Content cont : Content.getContents()) {

                    if (res.getLessonName().equals(cont.getLessonName())) {
                        i = 0;

                        rowContens[i++] = cont.getId();
                        rowContens[i++] = cont.getContentTitle();
                        rowContens[i++] = cont.getLessonName();
                        modelContents.addRow(rowContens);
                    }


                }

                break;

            }



        }

}

    public void loadTableContents(String lessonName) {
        DefaultTableModel clear = (DefaultTableModel) tableShowContents.getModel();
        clear.setRowCount(0);
        int i;

        for(Content cont : Content.getContents()) {

            if (cont.getLessonName().equals(lessonName)) {
                i = 0;

                rowContens[i++] = cont.getId();
                rowContens[i++] = cont.getContentTitle();
                rowContens[i++] = cont.getLessonName();
                modelContents.addRow(rowContens);
            }


        }
    }

    public void loadComboRegisteredLesson() {

        comboRegis.removeAllItems();

        for(Lesson les :Lesson.getLessons() ) {

                comboRegis.addItem(les.getLessonName());
            }


    }

    public void loadComboAllLesName(User user) {

        comboEnterExamLesName.removeAllItems();
        comboCommentLesName.removeAllItems();
        comboDeleteShow.removeAllItems();

        for(RegisteredLessons regis : RegisteredLessons.getRegisteredLessons() ) {

            if (regis.getStudentName().equals(user.getName())) {


                comboCommentLesName.addItem(regis.getLessonName());
                comboEnterExamLesName.addItem(regis.getLessonName());
                comboDeleteShow.addItem(regis.getLessonName());

            }

        }
    }

    public void addComboAllLesName(String lessonName) {

        comboEnterExamLesName.addItem(lessonName);
        comboCommentLesName.addItem(lessonName);
        comboDeleteShow.addItem(lessonName);

    }

    public void removeComboAllLesName(String lessonName) {

        comboEnterExamLesName.removeItem(lessonName);
        comboCommentLesName.removeItem(lessonName);
        comboDeleteShow.removeItem(lessonName);

    }

    public void loadComboExamContentTitle (String lessonName) {

        comboEnterExamContTitle.removeAllItems();

        for(Content cont : Content.getContents() ) {
            if (cont.getLessonName().equals(lessonName)) {
                comboEnterExamContTitle.addItem(cont.getContentTitle());
            }

        }

    }

    public void loadComboCommentContTitle(String lessonName) {
        comboCommentContTitle.removeAllItems();

                for(Content cont : Content.getContents() ) {

                 if (cont.getLessonName().equals(lessonName)) {

                       comboCommentContTitle.addItem(cont.getContentTitle());

                 }


        }
    }









    public static void main(String[] args) {
        Support.theme();
        Support.TROptions();
        User user=new User(5,"ERTUĞRUL BERKAY","er","er1234","posta12@yaani.com.tr","STUDENT","");

        new StudentGUI(user);
    }
}
