package View;

import Model.Content;
import Model.Lesson;
import Model.Question;
import Model.User;
import Support.Support;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EducatorGUI extends  JFrame{
    private JPanel mainPanel;
    private JLabel labelWelcomeMessage;
    private JButton buttonExit;
    private JTextArea textSearchLessonName;
    private JTextArea textSearchContent;
    private JButton buttonSearch;
    private JPanel panelAdd;
    private JTextArea textAddContentTitle;
    private JTextArea textAddContentDescription;
    private JTextArea textAddLink;
    private JComboBox comboAddLessonName;
    private JButton buttonAddContent;
    private JTextField textAddQuestion;
    private JPanel panelTop;
    private JPanel panelSearch;
    private JTable tableContent;
    private JPanel panelDelete;
    private JButton buttonDelete;
    private JTabbedPane tabbedPane1;
    private JTable tableLessons;
    private JPanel panelBottom;
    private JPanel panelLessons;
    private JPanel panelContents;
    private JComboBox comboDeleteContentID;
    private JButton buttonAddQuestion;
    private JTable tableQuestion;
    private JTextField textAddOptionD;
    private JTextField textAddOptionC;
    private JTextField textAddOptionB;
    private JTextField textAddOptionA;
    private JComboBox comboAddQuestionContentTitle;
    private JComboBox comboAddQuestionLessonName;
    private JScrollPane panelQuestions;
    private JPanel panelAddQuestion;
    private JButton buttonSearchQuestion;
    private JTextField textSearchQuestion;
    private JButton buttonDeleteQuestion;
    private JComboBox comboDeleteQuestion;
    private JComboBox comboAddQuestionTrueAnswer;
    private JPanel panelDeleteQuestion;
    private JComboBox comboSearchLessonName;
    private DefaultTableModel modelContent;
    private Object [] rowsContents;
    private Object [] rowsLessons;
    private DefaultTableModel modelLessons;
    private JPopupMenu popupMenuContent;
    private DefaultTableModel modelQuestion;
    private Object [] rowsQuestion;
    private JPopupMenu popupMenuQuestion;
    private JComboBox contentTitles;
    private JComboBox trueAnswers;




    public EducatorGUI(User user){

        add(mainPanel);
        setTitle(Support.PROJECT_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1250,600);
        setLocation(Support.arrangeLocation("x",1250),Support.arrangeLocation("y",600));
        setResizable(true);
        setVisible(true);



        contentTitles=new JComboBox();
        trueAnswers=new JComboBox();

        trueAnswers.addItem("A");
        trueAnswers.addItem("B");
        trueAnswers.addItem("C");
        trueAnswers.addItem("D");

        labelWelcomeMessage.setText("HOŞ GELDİNİZ "+user.getName());


        modelLessons = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0){return false;}
                if (column==1){return false;}
                if (column==2){return false;}
                return super.isCellEditable(row, column);
            }
        };



        Object [] columnsLessons = {"ID","LESSON NAME","PATIKA NAME"};
        rowsLessons= new Object[columnsLessons.length];
        modelLessons.setColumnIdentifiers(columnsLessons);

        loadLessonsTable(user);


        tableLessons.setModel(modelLessons);
        tableLessons.getColumnModel().getColumn(0).setMinWidth(40);
        tableLessons.getColumnModel().getColumn(0).setMaxWidth(40);
        //reordinig ve resizable komutlarından önce yazılması gerekir.
        tableLessons.getTableHeader().setReorderingAllowed(false);
        tableLessons.getTableHeader().setResizingAllowed(true);



        modelContent= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column==0){return false;}
                return super.isCellEditable(row, column);
            }
        };


        Object [] columnsContents={"ID","CONTENT TITLE","CONTENT DESCRIPTION","LINK", "LESSON NAME"};


        modelContent.setColumnIdentifiers(columnsContents);
        rowsContents = new Object[columnsContents.length];

        loadContentTable();


        tableContent.setModel(modelContent);


        loadComboLessons(user);
        loadComboContentID(user);




        //Tabloya comboBox ekleme yöntemi.

        tableContent.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboAddLessonName));



        tableContent.getColumnModel().getColumn(0).setMinWidth(40);
        tableContent.getColumnModel().getColumn(0).setMaxWidth(40);
        tableContent.getTableHeader().setReorderingAllowed(false);
        tableContent.getTableHeader().setResizingAllowed(true);



        popupMenuContent= new JPopupMenu();

        tableContent.setComponentPopupMenu(popupMenuContent);

        JMenuItem update= new JMenuItem("Güncelle");
        JMenuItem delete= new JMenuItem("Sil");

        popupMenuContent.add(update);
        popupMenuContent.add(delete);


        tableContent.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int row = tableContent.rowAtPoint(point);
                tableContent.setRowSelectionInterval(row, row);

            }
        });

        tableContent.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {


                if (e.getType() == TableModelEvent.UPDATE) {

                        int  cID=Integer.parseInt(tableContent.getModel().getValueAt(tableContent.getSelectedRow(), 0).toString());
                        String cTitle=tableContent.getModel().getValueAt(tableContent.getSelectedRow(), 1).toString().toUpperCase().trim();
                        String cCDescription=tableContent.getModel().getValueAt(tableContent.getSelectedRow(), 2).toString().toUpperCase().trim();
                        String cLink=tableContent.getModel().getValueAt(tableContent.getSelectedRow(), 3).toString().trim();
                        String lName=tableContent.getModel().getValueAt(tableContent.getSelectedRow(), 4).toString().toUpperCase().trim();


                        Content cont =Content.getFetcByCTitle(cTitle);


                        if (cont!=null  && cont.getId()!=cID){

                            Support.giveMessage("Bu isimde içerik mevcuttur. Lütfen başka bir isim tercih ediniz!");
                            loadContentTable();

                        }else {

                            if (Content.update(cID,cTitle,cCDescription,cLink,lName)){
                                loadContentTable();
                                loadQuestionTable();


                                Support.giveMessage("başarı");

                            }else Support.giveMessage("hata");
                        }


















                }



            }
        });


        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    int id=Integer.parseInt(tableContent.getValueAt(tableContent.getSelectedRow(), 0).toString());
                    String cTitle=tableContent.getValueAt(tableContent.getSelectedRow(), 1).toString();
                    String cDescription=tableContent.getValueAt(tableContent.getSelectedRow(), 2).toString();
                    String link=tableContent.getValueAt(tableContent.getSelectedRow(), 3).toString();
                    String lessonName=tableContent.getValueAt(tableContent.getSelectedRow(), 4).toString();

                    UpdateJPopMenuContentGUI update= new UpdateJPopMenuContentGUI(user,id,cTitle,cDescription,link,lessonName);

                    update.setVisible(true);

                    update.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadContentTable();
                            loadQuestionTable();


                        }
                    });


                }
                catch(Exception exc){

                    Support.giveMessage("Güncellemek istediğiniz satırı seçiniz !");

                        }

                            }
                        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    try {

                        int id = Integer.parseInt(tableContent.getValueAt(tableContent.getSelectedRow(), 0).toString());

                        if (Support.confirm("sure")){


                            Content cont=Content.getFetcByID(id);

                            Question ques=Question.getFetchBYContentTitle(cont.getContentTitle());

                            if (ques!=null){

                                if (Support.confirm("Bu içeriğe bağlı soruların da silinmesini ister misiniz?")){

                                    if (Question.deleteByContentTitle(cont.getContentTitle())){

                                        loadQuestionTable();

                                    }else {
                                        Support.giveMessage("Bu içeriğe bağlı soruları silme sırasında bir hata oluştu.");
                                    }


                                }
                            }



                        if (Content.deleteContent(id)) {

                            loadContentTable();
                            loadComboContentID(user);
                            loadQuestionTable();




                            Support.giveMessage("başarı");


                        } else Support.giveMessage("hata");


                    }
                        }
                    catch(Exception exc){

                        Support.giveMessage("Silmek istediğiniz satırı seçiniz !");

                            }





            }
        });









        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String searchContent = textSearchContent.getText();
                String searchLessonName = comboSearchLessonName.getSelectedItem().toString();

                ArrayList<Content> cont=Content.searchByQuery(searchContent, searchLessonName);

                loadContentTable(cont);




            }
        });
        buttonAddContent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String contentTitle= textAddContentTitle.getText().toUpperCase().trim();
                String contentDescription= textAddContentDescription.getText().toUpperCase().trim();
                String link= textAddLink.getText().toLowerCase().trim();
                String lessonName= comboAddLessonName.getSelectedItem().toString();

                if (!contentTitle.isEmpty() && !contentDescription.isEmpty() && !link.isEmpty()){

                    Content cont = Content.getFetcByCTitle(contentTitle);

                    if (cont!=null) {

                        Support.giveMessage("Bu isimde içerik mevcuttur. Lütfen başka bir isim tercih ediniz!");

                    }else{

                        if (Content.addContent(contentTitle,contentDescription,link,lessonName, user.getName())){

                            textAddContentTitle.setText(null);
                            textAddContentDescription.setText(null);
                            textAddLink.setText(null);
                            comboAddLessonName.setSelectedIndex(0);


                            loadComboContentID(user);
                            loadContentTable();
                            loadComboAddQuestionContentTitle();
                            loadContentTitles(user);
                            loadQuestionTable();




                            Support.giveMessage("başarı");

                        }else Support.giveMessage("hata");


                    }


                }else Support.giveMessage("boş");





            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (comboDeleteContentID.getItemCount()>0){


                    int id=Integer.parseInt(comboDeleteContentID.getSelectedItem().toString());

                    if(Support.confirm("sure")){

                        Content cont=Content.getFetcByID(id);

                        Question ques=Question.getFetchBYContentTitle(cont.getContentTitle());

                        if (ques!=null){


                            if (Support.confirm("Bu içeriğe bağlı soruların da silinmesini ister misiniz?")){

                                if (Question.deleteByContentTİtle(cont.getContentTitle())){

                                    loadQuestionTable();

                                }else {
                                    Support.giveMessage("Bu içeriğe bağlı soruları silme sırasında bir hata oluştu.");
                                }

                            }


                        }


                        if (Content.deleteContent(id)) {

                            loadContentTable();
                            loadComboContentID(user);
                            loadQuestionTable();


                            Support.giveMessage("başarı");

                        }else Support.giveMessage("hata");

                    }


                }else{

                    Support.giveMessage("Herhangi bir içerik mevcut değil!");
                }






            }
        });








        modelQuestion= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column==0){return false;}
                if (column==8){return false;}
                return super.isCellEditable(row, column);
            }
        };



        Object [] columnsQuestion={"ID","QUESTION","OPTION A", "OPTION B", "OPTION C", "OPTION D", "TRUE ANSWER", "CONTENT TITLE", "LESSON NAME"};
        modelQuestion.setColumnIdentifiers(columnsQuestion);
        rowsQuestion=new Object[columnsQuestion.length];

        loadQuestionTable();
        loadComboAddQuestionContentTitle();
        loadComboDeleteQuestionID();


        tableQuestion.setModel(modelQuestion);

        loadContentTitles(user);

        tableQuestion.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(trueAnswers));
        tableQuestion.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(contentTitles));



        tableQuestion.getColumnModel().getColumn(0).setMinWidth(40);
        tableQuestion.getColumnModel().getColumn(1).setMinWidth(150);
        tableQuestion.getColumnModel().getColumn(2).setMinWidth(150);
        tableQuestion.getColumnModel().getColumn(3).setMinWidth(150);
        tableQuestion.getColumnModel().getColumn(4).setMinWidth(150);
        tableQuestion.getColumnModel().getColumn(5).setMinWidth(150);

        tableQuestion.getColumnModel().getColumn(0).setMaxWidth(40);

        tableQuestion.getTableHeader().setReorderingAllowed(false);
        tableQuestion.getTableHeader().setResizingAllowed(true);



        tableQuestion.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {


                    int id=Integer.parseInt(tableQuestion.getValueAt(e.getFirstRow(), 0).toString());
                    String  question=tableQuestion.getValueAt(e.getFirstRow(), 1).toString();
                    String  optionA=tableQuestion.getValueAt(e.getFirstRow(), 2).toString();
                    String  optionB=tableQuestion.getValueAt(e.getFirstRow(), 3).toString();
                    String  optionC=tableQuestion.getValueAt(e.getFirstRow(), 4).toString();
                    String  optionD=tableQuestion.getValueAt(e.getFirstRow(), 5).toString();
                    String  trueAnswer=tableQuestion.getValueAt(e.getFirstRow(), 6).toString();
                    String  contentTitle=tableQuestion.getValueAt(e.getFirstRow(), 7).toString();
                    String  lessonName="";

                    for(Content cont :Content.getContents() ) {
                        if (cont.getContentTitle().equals(contentTitle)) {
                            lessonName=cont.getLessonName();
                            break;
                        }

                    }

                    Question ques=Question.getFetchBYQUestion(question);

                    if (ques!=null && ques.getId()!=id){

                        if (Support.confirm("Bu soru halihazırda mevcuttur. Yine de devam etmek ister misiniz ?")){


                            if (Question.update(id,question,optionA,optionB,optionC,optionD,trueAnswer,contentTitle,lessonName, user.getName())){


                                loadQuestionTable();
                                Support.giveMessage("başarı");


                            }else Support.giveMessage("hata");




                        }else{

                            loadQuestionTable();
                            Support.giveMessage("iptal");
                        }




                    }else {


                        if (Question.update(id,question,optionA,optionB,optionC,optionD,trueAnswer,contentTitle,lessonName, user.getName())){


                            loadQuestionTable();
                            Support.giveMessage("başarı");


                        }else Support.giveMessage("hata");
                    }





                }
            }
        });




        popupMenuQuestion=new JPopupMenu();

        JMenuItem updateQuestion = new JMenuItem("Güncelle");
        JMenuItem deleteQuestion = new JMenuItem("Sil");

        popupMenuQuestion.add(updateQuestion);
        popupMenuQuestion.add(deleteQuestion);


        tableQuestion.setComponentPopupMenu(popupMenuQuestion);

        tableQuestion.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point p=e.getPoint();
                int row=tableQuestion.rowAtPoint(p);
                tableQuestion.setRowSelectionInterval(row,row);
            }
        });


        deleteQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try{

                    int id=Integer.parseInt(tableQuestion.getModel().getValueAt(tableQuestion.getSelectedRow(), 0).toString());


                    if (Support.confirm("sure")){

                        if (Question.delete(id)){
                            loadQuestionTable();
                            Support.giveMessage("başarı");
                        }else Support.giveMessage("hata");
                    }


                }
                catch(Exception exc){

                    System.out.println(exc.getMessage());

                }




            }
        });

        updateQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    int id=Integer.parseInt(tableQuestion.getModel().getValueAt(tableQuestion.getSelectedRow(), 0).toString());
                    String  question=tableQuestion.getModel().getValueAt(tableQuestion.getSelectedRow(),1).toString();
                    String  optionA=tableQuestion.getModel().getValueAt(tableQuestion.getSelectedRow(),2).toString();
                    String  optionB=tableQuestion.getModel().getValueAt(tableQuestion.getSelectedRow(),3).toString();
                    String  optionC=tableQuestion.getModel().getValueAt(tableQuestion.getSelectedRow(),4).toString();
                    String  optionD=tableQuestion.getModel().getValueAt(tableQuestion.getSelectedRow(),5).toString();
                    String  trueAnswer=tableQuestion.getModel().getValueAt(tableQuestion.getSelectedRow(),6).toString();
                    String  contentTitle=tableQuestion.getModel().getValueAt(tableQuestion.getSelectedRow(),7).toString();
                    String  lessonName=tableQuestion.getModel().getValueAt(tableQuestion.getSelectedRow(),8).toString();


                    UpdateJPopMenuQuestionGUI updateJPopMenuQuestionGUI=new UpdateJPopMenuQuestionGUI(id,question,optionA,optionB,optionC,optionD,trueAnswer,contentTitle,lessonName,user);

                    updateJPopMenuQuestionGUI.setVisible(true);

                    updateJPopMenuQuestionGUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadQuestionTable();
                        }
                    });

                    }
                catch(Exception exc){

                    System.out.println(exc.getMessage());

                        }





            }
        });





/*

        comboDeleteContentID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textDeleteCTitle.setText(Content.getFetchByIDReturnCTitle(Integer.parseInt(comboDeleteContentID.getSelectedItem().toString())));

            }
        });
        comboAddQuestionContentID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                textAddQuestionCTitle.setText(Content.getFetchByIDReturnCTitle(Integer.parseInt(comboAddQuestionContentID.getSelectedItem().toString())));

            }
        });

 */


        buttonSearchQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String question=textSearchQuestion.getText().trim();
                ArrayList<Question> questions=Question.searchByQuestion(question);
                loadQuestionTable(questions);

            }
        });
        buttonAddQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String lessonName= comboAddQuestionLessonName.getSelectedItem().toString();
                String contentTitle=comboAddQuestionContentTitle.getSelectedItem().toString();
                String question=textAddQuestion.getText().trim();
                String optionA=textAddOptionA.getText().trim();
                String optionB=textAddOptionB.getText().trim();
                String optionC=textAddOptionC.getText().trim();
                String optionD=textAddOptionD.getText().trim();
                String trueAnswer=comboAddQuestionTrueAnswer.getSelectedItem().toString();

                if (question.isEmpty() || optionA.isEmpty() || optionB.isEmpty() || optionC.isEmpty() || optionD.isEmpty()){

                    Support.giveMessage("boş");

                }else {

                    Question ques=Question.getFetchBYQUestion(question);


                        if (ques!=null) {


                            if (Support.confirm("Bu soru halihazırda mevcuttur. Yine de devam etmek ister misiniz ?")) {


                                if (Question.addQuestion( question, optionA, optionB, optionC, optionD, trueAnswer, contentTitle, lessonName,user.getName())) {


                                    comboAddQuestionLessonName.setSelectedIndex(0);
                                    comboAddQuestionContentTitle.setSelectedIndex(0);
                                    textAddQuestion.setText(null);
                                    textAddOptionA.setText(null);
                                    textAddOptionB.setText(null);
                                    textAddOptionC.setText(null);
                                    textAddOptionD.setText(null);
                                    comboAddQuestionTrueAnswer.setSelectedIndex(0);

                                    loadQuestionTable();
                                    loadComboDeleteQuestionID();


                                    Support.giveMessage("başarı");

                                } else {
                                    Support.giveMessage("hata");
                                }


                            } else {
                                Support.giveMessage("iptal");

                            }
                        }else {


                            if (Question.addQuestion(question, optionA, optionB, optionC, optionD, trueAnswer, contentTitle, lessonName,user.getName())) {


                                comboAddQuestionLessonName.setSelectedIndex(0);
                                comboAddQuestionContentTitle.setSelectedIndex(0);
                                textAddQuestion.setText(null);
                                textAddOptionA.setText(null);
                                textAddOptionB.setText(null);
                                textAddOptionC.setText(null);
                                textAddOptionD.setText(null);
                                comboAddQuestionTrueAnswer.setSelectedIndex(0);

                                loadQuestionTable();
                                loadComboDeleteQuestionID();



                                Support.giveMessage("başarı");

                            } else {
                                Support.giveMessage("hata");

                            }

                        }









                }


            }
        });
        comboAddQuestionLessonName.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                comboAddQuestionContentTitle.removeAllItems();

                comboAddQuestionContentTitle.addItem("");

                for(Content cont:Content.getContents() ) {

                    if (comboAddQuestionLessonName.getSelectedItem().toString().equals(cont.getLessonName())) {
                        comboAddQuestionContentTitle.addItem(cont.getContentTitle());
                    }

                }



            }
        });
        buttonDeleteQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (comboDeleteQuestion.getItemCount()>0){

                    int id=Integer.parseInt(comboDeleteQuestion.getSelectedItem().toString());

                    if (Support.confirm("sure")){

                        if (Question.delete(id)){
                            loadQuestionTable();
                            loadComboDeleteQuestionID();
                            Support.giveMessage("başarı");
                        }else Support.giveMessage("hata");
                    }


                }else Support.giveMessage("Herhangi bir soru mevcut değil!");




            }
        });




    }







    public void loadContentTable(){
        DefaultTableModel clear = (DefaultTableModel) tableContent.getModel();
        clear.setRowCount(0);

        int i;


        for(Content content : Content.getContents() ) {

            i=0;

            rowsContents[i++]=content.getId();
            rowsContents[i++]=content.getContentTitle();
            rowsContents[i++]=content.getContentDescription();
            rowsContents[i++]=content.getLink();
            rowsContents[i++]=content.getLessonName();
            modelContent.addRow(rowsContents);



        }


    }

    public void loadLessonsTable(User user){
        DefaultTableModel clear = (DefaultTableModel) tableLessons.getModel();
        clear.setRowCount(0);
        int i;
        for(Lesson lesson :Lesson.getLessons() ) {
            i=0;

            if (user.getName().equals(lesson.getEducatorName())) {

                rowsLessons[i++]=lesson.getLessonID();
                rowsLessons[i++]=lesson.getLessonName();
                rowsLessons[i]=lesson.getPatikaName();
                modelLessons.addRow(rowsLessons);


            }



        }
    }

    public void loadContentTable(ArrayList<Content> contents){
        DefaultTableModel clear = (DefaultTableModel) tableContent.getModel();
        clear.setRowCount(0);
        int i;

        for(Content content : contents) {
            i=0;

            rowsContents[i++]=content.getId();
            rowsContents[i++]=content.getContentTitle();
            rowsContents[i++]=content.getContentDescription();
            rowsContents[i++]=content.getLink();
            rowsContents[i]=content.getLessonName();
            modelContent.addRow(rowsContents);
        }
    }

    public void loadQuestionTable(){
        DefaultTableModel clear = (DefaultTableModel) tableQuestion.getModel();
        clear.setRowCount(0);
        int i;
        for(Question obj : Question.getQuestions()) {
            i=0;
            rowsQuestion[i++]=obj.getId();
            rowsQuestion[i++]=obj.getQuestion();
            rowsQuestion[i++]=obj.getOptionA();
            rowsQuestion[i++]=obj.getOptionB();
            rowsQuestion[i++]=obj.getOptionC();
            rowsQuestion[i++]=obj.getOptionD();
            rowsQuestion[i++]=obj.getTrueAnswer();
            rowsQuestion[i++]=obj.getContentTitle();

            for(Content cont :Content.getContents() ) {

                if (cont.getContentTitle().equals(obj.getContentTitle())) {
                    rowsQuestion[i++]=cont.getLessonName();

                }

            }
            modelQuestion.addRow(rowsQuestion);



        }
    }

    public void loadQuestionTable(ArrayList<Question> questions){
        DefaultTableModel clear = (DefaultTableModel) tableQuestion.getModel();
        clear.setRowCount(0);
        int i;
        for(Question obj : questions) {
            i=0;
            rowsQuestion[i++]=obj.getId();
            rowsQuestion[i++]=obj.getQuestion();
            rowsQuestion[i++]=obj.getOptionA();
            rowsQuestion[i++]=obj.getOptionB();
            rowsQuestion[i++]=obj.getOptionC();
            rowsQuestion[i++]=obj.getOptionD();
            rowsQuestion[i++]=obj.getTrueAnswer();
            rowsQuestion[i++]=obj.getContentTitle();
            rowsQuestion[i++]=obj.getLessonName();
            modelQuestion.addRow(rowsQuestion);
        }
    }

    public void loadComboLessons(User user){

        comboAddQuestionLessonName.removeAllItems();
        comboAddLessonName.removeAllItems();
        comboSearchLessonName.removeAllItems();

        comboAddQuestionLessonName.addItem("");
        comboAddLessonName.addItem("");
        comboSearchLessonName.addItem("");

        for(Lesson lesson : Lesson.getLessons() ) {

            if (lesson.getEducatorName().equals(user.getName())) {
                comboAddLessonName.addItem(lesson.getLessonName());
                comboAddQuestionLessonName.addItem(lesson.getLessonName());
                comboSearchLessonName.addItem(lesson.getLessonName());

            }

        }
    }

    public void loadComboAddQuestionContentTitle() {
        comboAddQuestionContentTitle.removeAllItems();

        comboAddQuestionContentTitle.addItem("");

        for(Content cont:Content.getContents() ) {

            if (comboAddQuestionLessonName.getSelectedItem().toString().equals(cont.getLessonName())) {
                comboAddQuestionContentTitle.addItem(cont.getContentTitle());
            }

        }

    }

    public void loadComboContentID(User user) {

        comboDeleteContentID.removeAllItems();

        for(Content cont : Content.getContents() ) {

            if (cont.getEducatorName().equals(user.getName())) {
                comboDeleteContentID.addItem(cont.getId());
            }


        }


    }

    public void loadComboDeleteQuestionID() {
        comboDeleteQuestion.removeAllItems();
        for(Question obj : Question.getQuestions()) {
            comboDeleteQuestion.addItem(obj.getId());
        }
    }

    public void loadContentTitles(User user){

        contentTitles.removeAllItems();

        contentTitles.addItem("");


        for(Content con :Content.getContents() ) {
            if (con.getEducatorName().equals(user.getName())){

                contentTitles.addItem(con.getContentTitle());
            }

        }


    }







    public static void main(String[] args) {
        Support.theme();

        User user = new User(1,"MUKAN AYAZOĞLU","MUKAN","12345","@yaani.com","EDUCATOR","PHP");


        EducatorGUI edu= new EducatorGUI(user);
    }


}
