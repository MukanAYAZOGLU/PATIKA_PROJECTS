package View;

import Model.*;
import Support.*;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;


public class OperatorGUI extends JFrame {
    private JPanel panelMain;
    private JLabel labelWelcome;
    private JButton buttonLogOut;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JTabbedPane tabbedUsers;
    private JPanel panelUsers;
    private JPanel panelPatika;
    private JPanel panelLessons;
    private JTable tableUsers;
    private JTable tablePatika;
    private JTable tableLessons;
    private JScrollPane scrollUsers;
    private JScrollPane scrollPatika;
    private JScrollPane scrollLessons;
    private JPanel panelSearch;
    private JTextField textSearchName;
    private JTextField textSearchUserName;
    private JComboBox comboSearchType;
    private JButton buttonSearch;
    private JLabel fieldUser;
    private JLabel fieldUserName;
    private JLabel fieldType;
    private JTextField textAddName;
    private JTextField textAddUserName;
    private JComboBox comboAddUserType;
    private JComboBox comboAddLanguage;
    private JButton buttonAddUser;
    private JTextField textDeleteUserID;
    private JButton buttonDeleteUser;
    private JPanel panelAddAndDelete;
    private JPanel panelAddPatika;
    private JTextArea textPatikaName;
    private JButton buttonAddPatika;
    private JLabel fieldByPatikaName;
    private JTextArea textAddLessonName;
    private JComboBox comboAddLessonPatikaName;
    private JComboBox comboAddLessonLanguage;
    private JComboBox comboAddLessonEducator;
    private JButton buttonAddLesson;
    private JTextField textDeleteLessonID;
    private JButton buttonDeleteLesson;
    private JLabel labelLessonName;
    private JLabel labelPatikaName;
    private JLabel labelLanguage;
    private JLabel labelEducator;
    private JLabel labelLessonID;
    private JPasswordField textAddPassword;
    private JLabel labelAddPassword;
    private JPanel panelPatikaDelete;
    private JTextArea textSearchPatikaByName;
    private JButton buttonSearchPatika;
    private JComboBox comboSearchLanguage;
    private JComboBox comboAddPatikaLanguage;
    private JComboBox comboDeletePatika;
    private JLabel fieldDeletePatikaName;
    private JLabel fieldSearchPatikaByName;
    private JButton buttonDeletePatika;
    private JComboBox comboSearchPatikaLanguage;
    private JLabel labelSerachPatika;
    private JLabel labelAddPatika;
    private JComboBox comboSearchLessonLanguage;
    private JButton buttonSearchLesson;
    private JTextArea textSearchLessonName;
    private JTextArea textAddEposta;
    private JTextField textSearchEposta;
    private JPanel panelContents;
    private JPanel panelQuestions;
    private JTable tableQuestions;
    private JButton buttonAddQuestion;
    private JTextArea textAddOptionD;
    private JTextArea textAddOptionC;
    private JTextArea textAddOptionB;
    private JTextArea textAddOptionA;
    private JTextArea textAddQuestion;
    private JComboBox comboAddQuestionContentTitle;
    private JComboBox comboAddQuestionLessonName;
    private JComboBox comboAddQuestionTrueAnswer;
    private JTable tableContents;
    private JTextArea textAddContentTitle;
    private JTextArea textAddContentDescription;
    private JComboBox comboAddContEducName;
    private JComboBox comboAddContLesName;
    private JButton buttonAddContent;
    private JTextField textDeleteContID;
    private JButton buttonDeleteContent;
    private JButton buttonSearchCont;
    private JComboBox comboSearchContLesName;
    private JTextArea textSearchContentTitle;
    private JComboBox comboSearchQuesContTitle;
    private JComboBox comboSearchQuesLesName;
    private JButton buttonSearchQuestion;
    private JPanel panelSearchContents;
    private JScrollPane scrol;
    private JTextArea textAddContLink;
    private JTextField textDeleteQuestionID;
    private JButton buttonDeleteQuestion;
    private JTextField textAddQuesEducName;
    private JPanel panelQuestionSearch;
    private JPanel panelAddQuestion;
    private JTextArea textSearchQuestion;
    private DefaultTableModel usersTableModel;
    private DefaultTableModel patikaTableModel;
    private DefaultTableModel lessonsTableModel;
    private Object [] rowsUsers;
    private Object [] rowsPatika;
    private Object [] rowsLessons;
    private JPopupMenu popupMenuUser;
    private JPopupMenu popupMenuPatika;
    private JPopupMenu popupMenuLessons;
    private DefaultTableModel modelContents;
    private DefaultTableModel modelQuestions;
    private Object [] rowsQuestions;
    private Object [] rowsContents;
    private JComboBox comboUserType;
    private JComboBox comboLanguages;
    private JComboBox comboTrueAnswer;
    private JComboBox comboContentTitles;
    private JComboBox comboLessonNames;
    private JPopupMenu popupMenuContents;
    private JPopupMenu popupMenuQuestions;

    public OperatorGUI(User user) {

        add(panelMain);
        setTitle(Support.PROJECT_TITLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1370,730);
        setLocation(Support.arrangeLocation("x",1370), Support.arrangeLocation("y",730));
        setVisible(true);
        setResizable(true);







        comboUserType= new JComboBox<>();
        comboUserType.addItem("EDUCATOR");
        comboUserType.addItem("STUDENT");


        comboLanguages=new JComboBox<>();
        comboLanguages.addItem("C");
        comboLanguages.addItem("C++");
        comboLanguages.addItem("C#");
        comboLanguages.addItem("JAVA");
        comboLanguages.addItem("KOTLIN");
        comboLanguages.addItem("HTML");
        comboLanguages.addItem("JAVASCRIPT");
        comboLanguages.addItem("PYTHON");
        comboLanguages.addItem("PHP");



        comboContentTitles= new JComboBox<>();

        comboLessonNames=new JComboBox<>();




        labelWelcome.setText("HOŞ GELDİNİZ "+user.getName());





        usersTableModel=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {

                if(column==0){ return false; }
                return super.isCellEditable(row, column);
            }
        };

        Object [] columnsUsers= {"ID","NAME","USER NAME","PASSWORD","E-POSTA","USER TYPE","LANGUAGE"};
        usersTableModel.setColumnIdentifiers(columnsUsers);
        rowsUsers=new Object[columnsUsers.length];

        loadTableUsers();

        tableUsers.setModel(usersTableModel);

        tableUsers.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(comboUserType));
        tableUsers.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboLanguages));


        tableUsers.getColumnModel().getColumn(0).setPreferredWidth(40);
        tableUsers.getColumnModel().getColumn(4).setMinWidth(250);
        tableUsers.getColumnModel().getColumn(1).setMinWidth(250);
        tableUsers.getTableHeader().setReorderingAllowed(false);
        tableUsers.getTableHeader().setResizingAllowed(true); //tablo başlıklarının kısaltılıp-uzaltılmamasına izin verme-vermeme durumu.

        popupMenuUser=new JPopupMenu();

        tableUsers.setComponentPopupMenu(popupMenuUser);


        JMenuItem updateItemUser=new JMenuItem("Güncelle");
        JMenuItem deleteItemUser=new JMenuItem("Sil");

        popupMenuUser.add(updateItemUser);
        popupMenuUser.add(deleteItemUser);

        tableUsers.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point =e.getPoint();
                int selectedRow = tableUsers.rowAtPoint(point);
                tableUsers.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });


        deleteItemUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try{

                    if (Support.confirm("sure")) {

                        int id=Integer.parseInt(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0).toString());

                        int a=0;

                        User educ=User.getFetchByIDReturnEducator(id);

                        if (educ!=null){

                            loadComboEducator();

                            Lesson les=Lesson.getFetchByEducatorName(educ.getName());

                            if (les != null) {


                                if (Support.confirm("Bu öğretmene ait derslerin ve bu derslere ait içerik ve sınav sorularının silinmesini ister misiniz?")){


                                    Question ques=Question.getFetchBYLessonName(les.getLessonName());

                                    if (ques!=null){

                                        if (Question.delete(educ.getName())){

                                            a++;

                                            loadTableQuestions();


                                        }else Support.giveMessage("Kullanıcıya ait sınav sorularının silinmesinde hata oluştu.");

                                    }



                                    Content cont=Content.getFetcByLessonName(les.getLessonName());

                                    if (cont!= null){

                                        if (Content.deleteContent(educ.getName())){

                                            a++;

                                            loadTableContent();
                                            loadTableQuestions();
                                            loadComboContentTitles();
                                            loadComboSearchQuesContTitle();

                                            if (comboAddQuestionLessonName.getItemCount()>0){
                                                loadComboAddQuestionContentTitle(comboAddQuestionLessonName.getSelectedItem().toString());

                                            }




                                        }else Support.giveMessage("Kullanıcıya ait içeriklerin silinmesinde hata oluştu.");



                                    }




                                    if (Lesson.deleteByEducatorName(educ.getName())) {

                                        a++;

                                        loadTableLessons();
                                        loadTableContent();
                                        loadTableQuestions();
                                        loadComboLessonNames();
                                        loadComboSearchContLesName();
                                        loadComboQuesLesName();
                                        loadComboAddContLesName();

                                        if (comboAddQuestionLessonName.getItemCount()>0){
                                            loadComboAddQuestionContentTitle(comboAddQuestionLessonName.getSelectedItem().toString());

                                        }

                                        if (comboAddContLesName.getItemCount()>0){
                                            String lessonName=comboAddContLesName.getSelectedItem().toString();

                                            loadComboAddContEducName(lessonName);
                                        }



                                    }else Support.giveMessage("Kullanıcıya ait derslerin silinmesinde hata oluştu.");


                                }



                            }




                        }


                        if (User.deleteUser(id)) {

                            a++;

                            loadTableUsers();
                            loadComboEducator();
                            loadTableLessons();
                            loadTableContent();
                            loadTableQuestions();
                            loadComboEducator();


                            if (comboAddContLesName.getItemCount()>0){
                                String lessonName=comboAddContLesName.getSelectedItem().toString();

                                loadComboAddContEducName(lessonName);
                            }



                            if (a==4){
                                Support.giveMessage("Bu kullanıcıya tüm veriler silindir.");
                            }


                        }else {
                            Support.giveMessage("Kullanıcıyı silme işleminde hata oluştu");
                        }


                    }



                    }
                catch(Exception exc){

                    System.out.println("deleteItemUser hatası: "+exc.getMessage());

                        }



            }
        });

        updateItemUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                   int  selectedId=Integer.parseInt(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0).toString());


                    User user = User.getFetchByUserID(selectedId);


                    UpdateJPopMenuUserGUI frame = new UpdateJPopMenuUserGUI(user);
                    frame.setVisible(true);

                    frame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadTableUsers();
                            loadComboEducator();
                            loadTableLessons();
                            loadTableContent();
                            loadTableQuestions();
                            loadComboEducator();


                            if (comboAddContLesName.getItemCount()>0){
                                String lessonName=comboAddContLesName.getSelectedItem().toString();

                                loadComboAddContEducName(lessonName);
                            }

                        }
                    });


                    }

                catch(Exception exc){

                    System.out.println("updateItemUser hatası: "+exc.getMessage());

                        }



            }
        });

        tableUsers.getModel().addTableModelListener(new TableModelListener() { //tablo üzerinde değişiklik yapma.
            @Override
            public void tableChanged(TableModelEvent e) {

                    if (e.getType() == TableModelEvent.UPDATE) {

                        int userID=Integer.parseInt(tableUsers.getValueAt(tableUsers.getSelectedRow(), 0).toString());
                        String name =tableUsers.getValueAt(tableUsers.getSelectedRow(), 1).toString().toUpperCase();
                        String userName=tableUsers.getValueAt(tableUsers.getSelectedRow(), 2).toString();
                        String password=tableUsers.getValueAt(tableUsers.getSelectedRow(), 3).toString();
                        String eposta =tableUsers.getValueAt(tableUsers.getSelectedRow(), 4).toString().trim();
                        String userType=tableUsers.getValueAt(tableUsers.getSelectedRow(), 5).toString().toUpperCase();
                        String language=tableUsers.getValueAt(tableUsers.getSelectedRow(), 6).toString().toUpperCase();



                        User us=User.getFetchByUserName(userName);

                            if (us!=null && us.getId()!=userID && us.getUserName()==userName){

                                Support.giveMessage("Bu kullanıcı adında kullanıcı mevcuttur. Lütfen başka bir kullanıcı adı tercih ediniz!");

                                loadTableUsers();


                            }else{

                                if (User.updateUser(userID, name, userName, password, eposta, userType, language)) {
                                    Support.giveMessage("başarı");


                                    loadTableUsers();
                                    loadComboEducator();
                                    loadTableLessons();
                                    loadTableContent();
                                    loadTableQuestions();
                                    loadComboEducator();


                                    if (comboAddContLesName.getItemCount()>0){
                                        String lessonName=comboAddContLesName.getSelectedItem().toString();

                                        loadComboAddContEducName(lessonName);
                                    }



                                }else {
                                    loadTableUsers();
                                }



                            }


                        }











            }
        });



        patikaTableModel=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==0){ return false; }
                return super.isCellEditable(row, column);
            }
        };


        Object [] columnsPatika= {"ID","PATIKA NAME","PATIKA LANGUAGE"};
        patikaTableModel.setColumnIdentifiers(columnsPatika);
        rowsPatika=new Object[columnsPatika.length];

        loadTablePatika();

        tablePatika.setModel(patikaTableModel);

        tablePatika.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboLanguages));


        tablePatika.getColumnModel().getColumn(0).setPreferredWidth(40);
        tablePatika.getTableHeader().setResizingAllowed(false);
        tablePatika.getTableHeader().setReorderingAllowed(false);

        popupMenuPatika=new JPopupMenu();

        tablePatika.setComponentPopupMenu(popupMenuPatika);

        tablePatika.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point =e.getPoint();
                int selectedRow = tablePatika.rowAtPoint(point);
                tablePatika.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });



        JMenuItem updateItemPatika=new JMenuItem("Güncelle");
        popupMenuPatika.add(updateItemPatika);
        JMenuItem deleteItemPatika=new JMenuItem("Sil");
        popupMenuPatika.add(deleteItemPatika);


        updateItemPatika.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    int id=Integer.parseInt(tablePatika.getValueAt(tablePatika.getSelectedRow(), 0).toString());

                    String patikaName=tablePatika.getValueAt(tablePatika.getSelectedRow(), 1).toString();
                    String language=tablePatika.getValueAt(tablePatika.getSelectedRow(), 2).toString();

                    UpdateJPopMenuPatikaGUI updateJPopMenuPatikaGUI=new UpdateJPopMenuPatikaGUI(id, patikaName, language);
                    updateJPopMenuPatikaGUI.setVisible(true);

                    updateJPopMenuPatikaGUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {

                            loadTablePatika();
                            loadComboPatika();
                            loadTableLessons();
                        }
                    });





                    }
                catch(Exception exc){

                    System.out.println("updateItemPatika hatası: "+exc.getMessage());

                        }


            }
        });


        deleteItemPatika.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    int id=Integer.parseInt(tablePatika.getValueAt(tablePatika.getSelectedRow(), 0).toString());

                    if (Support.confirm("sure")) {

                        String patikaName=Patika.getFetchByIDReturnPatikaName(id);


                        Lesson lesName=Lesson.getFetchByPatikaName(patikaName);


                        if (lesName!=null){


                        if (Support.confirm("Bu patikaya ait dersler ve bu derslere ait içerik ve sorular silinsin mi?")) {


                            for (Lesson les : Lesson.getLessonsByPatikaName(patikaName)) {

                                Question ques=Question.getFetchBYLessonName(les.getLessonName());

                                if (ques!=null){


                                if (Question.deleteByLessonName(les.getLessonName())) {

                                    loadTableQuestions();

                                } else
                                    Support.giveMessage(les.getLessonName() + " dersine ait soruların silinmesinde hata oluştu!");

                                }

                                Content cont=Content.getFetcByLessonName(les.getLessonName());

                                if (cont!=null){

                                if (Content.deleteByLessonName(les.getLessonName())) {

                                    loadTableContent();
                                    loadTableQuestions();
                                    loadComboContentTitles();
                                    loadComboSearchQuesContTitle();


                                    if (comboAddQuestionLessonName.getItemCount()>0){
                                        loadComboAddQuestionContentTitle(comboAddQuestionLessonName.getSelectedItem().toString());

                                    }


                                } else
                                    Support.giveMessage(les.getLessonName() + " dersine ait içeriklerin silinmesinde hata oluştu!");

                                }

                                if (Lesson.delete(les.getLessonName())) {

                                    loadTableLessons();
                                    loadTableContent();
                                    loadTableQuestions();
                                    loadComboLessonNames();
                                    loadComboSearchContLesName();
                                    loadComboQuesLesName();
                                    loadComboAddContLesName();

                                    if (comboAddQuestionLessonName.getItemCount()>0){
                                        loadComboAddQuestionContentTitle(comboAddQuestionLessonName.getSelectedItem().toString());

                                    }

                                    if (comboAddContLesName.getItemCount()>0){
                                        String lessonName=comboAddContLesName.getSelectedItem().toString();

                                        loadComboAddContEducName(lessonName);
                                    }





                                } else Support.giveMessage("Bu patikaya ait derslerin silinmesinde hata oluştu!");


                            }



                        }else Support.giveMessage("başarı");

                        }




                        if (Patika.deletePatikaByID(id)) {

                            loadTablePatika();
                            loadComboPatika();
                            loadTableLessons();

                            Support.giveMessage("başarı");


                        }else Support.giveMessage("hata");


                    }



                    }
                catch(Exception exc){

                    System.out.println("deleteItemPatika hatası: "+exc.getMessage());

                        }



            }
        });



        tablePatika.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {

                if (e.getType() == TableModelEvent.UPDATE) {

                    try{

                        int patikaID=Integer.parseInt(tablePatika.getValueAt(tablePatika.getSelectedRow(), 0).toString());
                        String patikaName=tablePatika.getValueAt(tablePatika.getSelectedRow(), 1).toString().toUpperCase();
                        String language=tablePatika.getValueAt(tablePatika.getSelectedRow(), 2).toString().toUpperCase();


                        Patika patika=Patika.getFetchByPatikaName(patikaName);

                        if (patika != null && patika.getId() != patikaID) {

                            Support.giveMessage("Bu isimde patika mevcuttur. Lütfen başka bir isim tercih ediniz!");

                            loadTablePatika();

                        }else {
                            if (Patika.updatePatika(patikaID,patikaName,language)) {


                                loadTablePatika();
                                loadComboPatika();
                                loadTableLessons();

                                Support.giveMessage("başarı");


                            }else {

                                loadTablePatika();
                                Support.giveMessage("hata");
                            }


                        }



                        }
                    catch(Exception exc){

                        System.out.println("tableUser.getModel hatası: "+exc.getMessage());

                            }





                        }


                    }




        });



        lessonsTableModel=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column==0){ return false;}
                if(column==4){ return false;}
                return super.isCellEditable(row, column);
            }
        };


        Object [] columnsLessons= {"LESSON ID","LESSON NAME","EDUCATOR NAME","PATIKA NAME","LANGUAGE"};
        lessonsTableModel.setColumnIdentifiers(columnsLessons);
        rowsLessons=new Object[columnsLessons.length];

        loadTableLessons();

        tableLessons.setModel(lessonsTableModel);

        tableLessons.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(comboAddLessonEducator));

        tableLessons.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboAddLessonPatikaName));


        tableLessons.getColumnModel().getColumn(0).setMinWidth(40);
        tableLessons.getColumnModel().getColumn(0).setMaxWidth(40);
        tableLessons.getTableHeader().setResizingAllowed(true);
        tableLessons.getTableHeader().setReorderingAllowed(false);

        popupMenuLessons=new JPopupMenu();
        tableLessons.setComponentPopupMenu(popupMenuLessons);

        tableLessons.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point=e.getPoint();
                int row=tableLessons.rowAtPoint(point);
                tableLessons.setRowSelectionInterval(row,row);
            }
        });


        JMenuItem updateItemLesson=new JMenuItem("Güncelle");
        popupMenuLessons.add(updateItemLesson);

        JMenuItem deleteItemLesson=new JMenuItem("Sil");
        popupMenuLessons.add(deleteItemLesson);


        deleteItemLesson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    int id=Integer.parseInt(tableLessons.getValueAt(tableLessons.getSelectedRow(), 0).toString());


                    if (Support.confirm("sure")){


                        Lesson les=Lesson.getFetchByIDReturnLesson(id);

                        Content cont=Content.getFetcByLessonName(les.getLessonName());

                        if (cont!=null){

                            if (Support.confirm("Bu derse ait içerikler ve bu içeriklere ait sorular silinsin mi?")){


                                Question ques=Question.getFetchBYLessonName(les.getLessonName());

                                if (ques!=null){

                                    if (Question.deleteByLessonName(les.getLessonName())){


                                        loadTableQuestions();

                                    }else Support.giveMessage("Bu derse ait soruları silmede hata oluştu.");


                                }


                                if (Content.deleteByLessonName(les.getLessonName())){


                                    loadTableContent();
                                    loadTableQuestions();
                                    loadComboContentTitles();
                                    loadComboSearchQuesContTitle();

                                    if (comboAddQuestionLessonName.getItemCount()>0){
                                        loadComboAddQuestionContentTitle(comboAddQuestionLessonName.getSelectedItem().toString());

                                    }




                                }else Support.giveMessage("Bu derse ait içerikleri silmede hata oluştu.");


                            }



                        }



                        if (Lesson.deleteLesson(id)){


                            loadTableLessons();
                            loadTableContent();
                            loadTableQuestions();
                            loadComboLessonNames();
                            loadComboSearchContLesName();
                            loadComboQuesLesName();
                            loadComboAddContLesName();

                            if (comboAddQuestionLessonName.getItemCount()>0){
                                loadComboAddQuestionContentTitle(comboAddQuestionLessonName.getSelectedItem().toString());

                            }

                            if (comboAddContLesName.getItemCount()>0){
                                String lessonName=comboAddContLesName.getSelectedItem().toString();

                                loadComboAddContEducName(lessonName);
                            }



                            Support.giveMessage("başarı");





                        }else Support.giveMessage("hata");
                    }


                    }
                catch(Exception exc){

                    System.out.println("deleteItemLesson hatası"+exc.getMessage());

                        }



            }
        });

        updateItemLesson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    int id=Integer.parseInt(tableLessons.getValueAt(tableLessons.getSelectedRow(), 0).toString());
                    String lessonName=tableLessons.getValueAt(tableLessons.getSelectedRow(), 1).toString().toUpperCase();
                    String educatorName=tableLessons.getValueAt(tableLessons.getSelectedRow(), 2).toString().toUpperCase();
                    String patikaName=tableLessons.getValueAt(tableLessons.getSelectedRow(), 3).toString().toUpperCase();
                    String language=tableLessons.getValueAt(tableLessons.getSelectedRow(), 4).toString();

                    UpdateJPopMenuLessonGUI frame=new UpdateJPopMenuLessonGUI(id,lessonName,educatorName,patikaName,language);
                    frame.setVisible(true);

                    frame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadTableLessons();
                            loadTableContent();
                            loadTableQuestions();
                            loadComboLessonNames();
                            loadComboSearchContLesName();
                            loadComboQuesLesName();
                            loadComboAddContLesName();

                            if (comboAddQuestionLessonName.getItemCount()>0){
                                loadComboAddQuestionContentTitle(comboAddQuestionLessonName.getSelectedItem().toString());

                            }

                            if (comboAddContLesName.getItemCount()>0){
                                String lessonName=comboAddContLesName.getSelectedItem().toString();

                                loadComboAddContEducName(lessonName);
                            }


                        }
                    });





                    }
                catch(Exception exc){

                    System.out.println("updateItemLesson hatası"+exc.getMessage());

                        }









            }
        });

        tableLessons.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {

                if (e.getType() == TableModelEvent.UPDATE) {

                    try{

                        int lessonID = Integer.parseInt(tableLessons.getValueAt(tableLessons.getSelectedRow(), 0).toString());
                        String lessonName = tableLessons.getValueAt(tableLessons.getSelectedRow(), 1).toString().toUpperCase();
                        String educatorName = tableLessons.getValueAt(tableLessons.getSelectedRow(), 2).toString();
                        String patikaName = tableLessons.getValueAt(tableLessons.getSelectedRow(), 3).toString();
                        String language="";

                            for (Patika pat : Patika.getPatikaList()) {

                                if (pat.getName().equals(patikaName)) {
                                    language = pat.getLanguage();
                                    System.out.println("giridi");
                                    break;
                                }

                            }


                        Lesson les = Lesson.getFetchByName(lessonName);

                        if (les != null && les.getLessonID() != lessonID) {

                            Support.giveMessage("Bu isimde ders mevcuttur. Lütfen başka bir isim tercih ediniz!");

                            loadTableLessons();

                        } else {

                            if (Lesson.updateLesson(lessonID, lessonName, educatorName, patikaName, language)) {

                                loadTableLessons();
                                loadTableContent();
                                loadTableQuestions();
                                loadComboLessonNames();
                                loadComboSearchContLesName();
                                loadComboQuesLesName();
                                loadComboAddContLesName();


                                if (comboAddQuestionLessonName.getItemCount()>0){
                                    loadComboAddQuestionContentTitle(comboAddQuestionLessonName.getSelectedItem().toString());

                                }


                                if (comboAddContLesName.getItemCount()>0){
                                    String lessName=comboAddContLesName.getSelectedItem().toString();

                                    loadComboAddContEducName(lessName);
                                }




                                Support.giveMessage("başarı");

                            } else {


                                loadTableLessons();
                                Support.giveMessage("hata");
                            }


                        }





                        }
                    catch(Exception exc){

                        System.out.println("tableLessons.getModel() hatası: "+exc.getMessage());

                            }






                }

            }

        });



        modelContents= new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column==0){return false;}
                if (column==5){return false;}
                return super.isCellEditable(row, column);
            }
        };

        Object [] columnsContents = {"ID","CONTENT TITLE","CONTENT DESCRIPTION","LINK", "LESSON NAME","EDUCATOR NAME"};
        modelContents.setColumnIdentifiers(columnsContents);
        rowsContents=new Object[columnsContents.length];

        loadTableContent();

        tableContents.setModel(modelContents);


        tableContents.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboAddContLesName));
        
        tableContents.getColumnModel().getColumn(0).setMinWidth(40);
        tableContents.getColumnModel().getColumn(0).setMaxWidth(40);
        tableContents.getTableHeader().setResizingAllowed(true);
        tableContents.getTableHeader().setReorderingAllowed(false);



        popupMenuContents=new JPopupMenu();

        tableContents.setComponentPopupMenu(popupMenuContents);

        JMenuItem deleteItemContens=new JMenuItem("Sil");
        JMenuItem updateItemContens=new JMenuItem("Güncelle");

        popupMenuContents.add(updateItemContens);
        popupMenuContents.add(deleteItemContens);


        tableContents.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point =e.getPoint();
                int selectedRow = tableContents.rowAtPoint(point);
                tableContents.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });



        deleteItemContens.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Support.confirm("sure")){

                    try{

                        int id=Integer.parseInt(tableContents.getValueAt(tableContents.getSelectedRow(), 0).toString());


                        Content cont=Content.getFetcByID(id);

                        Question ques=Question.getFetchBYContentTitle(cont.getContentTitle());

                        if (ques!=null){

                            if (Support.confirm("Bu içeriğe ait soruları silinsin mi? ")){

                                if (Question.deleteByContentTitle(cont.getContentTitle())){
                                    loadTableQuestions();

                                }else Support.giveMessage("Bu içreğie ait soruları silmede hata oluştu");


                            }

                        }




                        if (Content.deleteContent(id)){
                            loadTableContent();
                            loadTableQuestions();
                            loadComboContentTitles();
                            loadComboSearchQuesContTitle();

                            if (comboAddQuestionLessonName.getItemCount()>0){
                                loadComboAddQuestionContentTitle(comboAddQuestionLessonName.getSelectedItem().toString());

                            }



                            Support.giveMessage("başarı");


                        }else {
                            Support.giveMessage("hata");
                        }










                        }
                    catch(Exception exc){

                        System.out.println("deleteItemContens hatası"+exc.getMessage());

                            }


                }

            }
        });
        updateItemContens.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try{

                    int id=Integer.parseInt(tableContents.getValueAt(tableContents.getSelectedRow(), 0).toString());
                    String contentTitle=tableContents.getValueAt(tableContents.getSelectedRow(), 1).toString().toUpperCase();
                    String contentDescription=tableContents.getValueAt(tableContents.getSelectedRow(), 2).toString();
                    String link=tableContents.getValueAt(tableContents.getSelectedRow(), 3).toString();
                    String lessonName=tableContents.getValueAt(tableContents.getSelectedRow(), 4).toString();
                    String educatorName=tableContents.getValueAt(tableContents.getSelectedRow(), 5).toString();


                    UpdateJPopMenuContentOperatorGUI updateJPopMenuContentGUI=new UpdateJPopMenuContentOperatorGUI(id,contentTitle,contentDescription,link,lessonName,educatorName);
                    updateJPopMenuContentGUI.setVisible(true);


                    updateJPopMenuContentGUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadTableContent();
                            loadTableQuestions();
                            loadComboContentTitles();
                            loadComboSearchQuesContTitle();

                            if (comboAddQuestionLessonName.getItemCount()>0){
                                loadComboAddQuestionContentTitle(comboAddQuestionLessonName.getSelectedItem().toString());

                            }
                        }
                    });




                    }
                catch(Exception exc){

                    System.out.println("updateItemContens hatası"+exc.getMessage());

                        }

            }
        });

        tableContents.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {

                    try{

                        int id = Integer.parseInt(tableContents.getValueAt(tableContents.getSelectedRow(), 0).toString());
                        String contTitle = tableContents.getValueAt(tableContents.getSelectedRow(), 1).toString().toUpperCase().trim();
                        String contentDescription = tableContents.getValueAt(tableContents.getSelectedRow(), 2).toString().toUpperCase().trim();
                        String link = tableContents.getValueAt(tableContents.getSelectedRow(), 3).toString().trim();
                        String lesName = tableContents.getValueAt(tableContents.getSelectedRow(), 4).toString().toUpperCase();

                        String educatorName = "";

                        for (Lesson lessonName : Lesson.getLessons()) {
                            if (lessonName.getLessonName().equals(lesName)) {
                                educatorName = lessonName.getEducatorName();
                                break;
                            }

                        }


                        Content cont = Content.getFetcByCTitle(contTitle);

                        if (cont != null && cont.getId() != id) {

                            Support.giveMessage("Bu isimde içerik mevcuttur. Lütfen başka bir isim tercih ediniz!");

                            loadTableContent();


                        } else {

                            if (Content.update(id, contTitle, contentDescription, link, lesName, educatorName)) {
                                loadTableContent();
                                loadTableQuestions();
                                loadComboContentTitles();
                                loadComboSearchQuesContTitle();

                                if (comboAddQuestionLessonName.getItemCount()>0){
                                    loadComboAddQuestionContentTitle(comboAddQuestionLessonName.getSelectedItem().toString());

                                }

                                Support.giveMessage("başarı");
                            } else {
                                loadTableContent();
                                Support.giveMessage("hata");
                            }

                        }

                        }
                    catch(Exception exc){

                        System.out.println("tablelContents.getModel hatası: "+exc.getMessage());

                            }




                }

            }
        });




        modelQuestions=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column==0){return false;}
                if (column==8){return false;}
                if (column==9){return false;}
                return super.isCellEditable(row, column);
            }
        };


        comboTrueAnswer=new JComboBox<>();
        comboTrueAnswer.addItem("A");
        comboTrueAnswer.addItem("B");
        comboTrueAnswer.addItem("C");
        comboTrueAnswer.addItem("D");



        Object [] columnsQuestions={"ID" ,"QUESTION" ,"OPTION A" , "OPTION B" , "OPTION C" , "OPTION D" , "TRUE ANSWER" , "CONTENT TITLE" , "LESSON NAME", "EDUCATOR NAME"};
        modelQuestions.setColumnIdentifiers(columnsQuestions);
        rowsQuestions=new Object[columnsQuestions.length];

        loadTableQuestions();

        tableQuestions.setModel(modelQuestions);


        tableQuestions.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboTrueAnswer));
        tableQuestions.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(comboContentTitles));

        tableQuestions.getColumnModel().getColumn(0).setMinWidth(40);
        tableQuestions.getColumnModel().getColumn(0).setMaxWidth(40);
        tableQuestions.getTableHeader().setReorderingAllowed(false);
        tableQuestions.getTableHeader().setResizingAllowed(true);


        popupMenuQuestions=new JPopupMenu();

        tableQuestions.setComponentPopupMenu(popupMenuQuestions);

        JMenuItem deleteItemQuestions=new JMenuItem("Sil");
        JMenuItem updateItemQuestions=new JMenuItem("Güncelle");

        popupMenuQuestions.add(updateItemQuestions);
        popupMenuQuestions.add(deleteItemQuestions);


        tableQuestions.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point =e.getPoint();
                int selectedRow = tableQuestions.rowAtPoint(point);
                tableQuestions.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });


        deleteItemQuestions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    if (Support.confirm("sure")){

                        int id = Integer.parseInt(tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 0).toString());

                        if (Question.delete(id)){
                            loadTableQuestions();

                            Support.giveMessage("başarı");

                        }else Support.giveMessage("hata");

                    }
                    }
                catch(Exception exc){

                    System.out.println("deleteItemQuestions hatası"+exc.getMessage());

                        }

            }
        });
        updateItemQuestions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{

                    int id = Integer.parseInt(tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 0).toString());
                    String question = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 1).toString().trim();
                    String optionA = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 2).toString().trim();
                    String optionB = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 3).toString().trim();
                    String optionC = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 4).toString().trim();
                    String optionD = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 5).toString().trim();
                    String trueAnswer = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 6).toString();
                    String contentTitle = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 7).toString();
                    String lesName = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 8).toString();
                    String educatorName = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 9).toString();



                    UpdateJPopMenuQuestionOperatorGUI updateJPopMenuQuestionOperatorGUI=new UpdateJPopMenuQuestionOperatorGUI(id,question,optionA,optionB,optionC,optionD,trueAnswer,contentTitle,lesName,educatorName);

                    updateJPopMenuQuestionOperatorGUI.setVisible(true);

                    updateJPopMenuQuestionOperatorGUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadTableQuestions();
                        }
                    });





                    }
                catch(Exception exc){

                    System.out.println("updateItemQuestions hatası"+exc.getMessage());

                        }

            }
        });




        tableQuestions.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {

                    try{
                        int id = Integer.parseInt(tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 0).toString());
                        String question = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 1).toString().trim();
                        String optionA = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 2).toString().trim();
                        String optionB = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 3).toString().trim();
                        String optionC = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 4).toString().trim();
                        String optionD = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 5).toString().trim();
                        String trueAnswer = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 6).toString().trim();
                        String contentTitle = tableQuestions.getValueAt(tableQuestions.getSelectedRow(), 7).toString().trim();

                        String lesName="";
                        String educatorName="";


                        for(Content cont:Content.getContents() ) {
                            if (cont.getContentTitle().equals(contentTitle)) {
                                lesName = cont.getLessonName();
                                educatorName=cont.getEducatorName();
                                break;
                            }

                        }


                        Question ques=Question.getFetchBYQUestion(question);


                        if (ques != null && ques.getId()!=id && ques.getContentTitle().equals(contentTitle) && ques.getLessonName().equals(lesName)) {

                            Support.giveMessage("Bu soru mevcuttur. Lütfen başka bir soru tercih ediniz!");
                            loadTableQuestions();



                        }else {

                            if (Question.update(id,question,optionA,optionB,optionC,optionD,trueAnswer,contentTitle,lesName,educatorName)){

                                Support.giveMessage("başarı");
                                loadTableQuestions();
                            }else {
                                loadTableQuestions();
                                Support.giveMessage("hata");
                            }



                        }
                        }
                    catch(Exception exc){

                        System.out.println("tableQuestions.getModel hatası: "+exc.getMessage());

                            }









                }
            }
        });

        loadComboPatika();

        loadComboEducator();

        loadTableLessons();

        loadComboAddContLesName();

        loadComboSearchContLesName();

        loadComboQuesLesName();

        loadComboAddQuestionContentTitle(comboAddQuestionLessonName.getSelectedItem().toString());

        loadComboAddContEducName(comboAddContLesName.getSelectedItem().toString());

        loadComboSearchQuesContTitle();

        loadComboContentTitles();

        loadComboLessonNames();



            Lesson les=Lesson.getFetchByName(comboAddQuestionLessonName.getSelectedItem().toString());

            if (les!=null){
                textAddQuesEducName.setText(les.getEducatorName());

            }else {
                textAddQuesEducName.setText(null);
            }





        //Support.TROptions();

        //Support.giveMessage("Herhangi bir öğretmen, ders veya içerik sildiğinizde bu öğretmene bağlı dersler, bu derse bağlı içerikler ve bu ,içeriğe bağlı sorular da otomatikmen silinmektedir. Bu durumu göz önünde bulundurunuz.");





        buttonLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dispose();
            }
        });
        buttonAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Support.isTextFieldEmpty(textAddName) || Support.isTextFieldEmpty(textAddUserName) || Support.isTextFieldEmpty(textAddPassword)) {

                    Support.giveMessage("boş");

                } else {

                    String name = textAddName.getText().toUpperCase().trim();
                    String userName = textAddUserName.getText().toUpperCase().trim();
                    String password = String.valueOf(textAddPassword.getPassword());
                    String eposta = textAddEposta.getText().trim();
                    String userType = comboAddUserType.getSelectedItem().toString();
                    String language = comboAddLanguage.getSelectedItem().toString();


                    User us=User.getFetchByUserName(userName);

                    if (us!=null){

                        Support.giveMessage("Bu kullanıcı adında kullanıcı mevcuttur. Lütfen başka bir kullanıcı adı tercih ediniz!");

                        loadTableUsers();


                    }else {


                        if (User.addUser(name, userName, password, eposta, userType, language)) {

                            textAddName.setText(null);
                            textAddUserName.setText(null);
                            textAddPassword.setText(null);
                            textAddEposta.setText(null);

                            loadTableUsers();
                            loadComboEducator();
                            loadTableLessons();
                            loadTableContent();
                            loadTableQuestions();
                            loadComboEducator();


                        } else {

                            textAddName.setText(null);
                            textAddUserName.setText(null);
                            textAddPassword.setText(null);

                        }

                    }


                }








            }
        });
        buttonDeleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int deleteID;

            while(true){

                try{

                    deleteID= Integer.parseInt(textDeleteUserID.getText());

                    }
                catch(Exception ex){

                    Support.giveMessage("Lütfen yalnızca rakamsal değer giriniz !");
                    textDeleteUserID.setText(null);
                    return;

                        }

                        break;

                        }


                    if (User.getFetchByID(deleteID)) {

                        if (Support.confirm("sure")) {

                            int b=1;

                            User educ=User.getFetchByIDReturnEducator(deleteID);

                            if (educ!=null){

                                loadComboEducator();


                                if (Support.confirm("Bu öğretmene ait derslerin ve bu derslere ait içerik ve sınav sorularının silinmesini ister misiniz?")){


                                    if (Question.delete(educ.getName())){

                                        b++;


                                        loadTableQuestions();



                                    }else Support.giveMessage("Kullanıcıya ait sınav sorularının silinmesinde hata oluştu.");


                                    if (Content.deleteContent(educ.getName())){

                                        b++;

                                        loadTableContent();
                                        loadTableQuestions();
                                        loadComboContentTitles();
                                        loadComboSearchQuesContTitle();


                                    }else Support.giveMessage("Kullanıcıya ait içeriklerin silinmesinde hata oluştu.");




                                    if (Lesson.deleteByEducatorName(educ.getName())) {

                                        b++;

                                        loadTableLessons();
                                        loadTableContent();
                                        loadTableQuestions();
                                        loadComboLessonNames();
                                        loadComboSearchContLesName();
                                        loadComboQuesLesName();
                                        loadComboAddContLesName();


                                    }else Support.giveMessage("Kullanıcıya ait derslerin silinmesinde hata oluştu.");



                                }


                            }

                            if (b==4){
                                Support.giveMessage("Bu kullanıcıya tüm veriler silindi.");
                            }





                            if (User.deleteUser(deleteID)) {

                                textDeleteUserID.setText(null);


                                loadTableUsers();
                                loadComboEducator();
                                loadTableLessons();
                                loadTableContent();
                                loadTableQuestions();
                                loadComboEducator();


                                Support.giveMessage("başarı");

                            }else {

                                textDeleteUserID.setText(null);
                                Support.giveMessage("hata");
                            }


                        }else {
                            textDeleteUserID.setText(null);
                        }

                    }else {
                        textDeleteUserID.setText(null);
                        Support.giveMessage("Kullanıcı Bulunamadı !");
                    }





            }
        });
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name= textSearchName.getText().toUpperCase();
                String userName= textSearchUserName.getText().toUpperCase();
                String eposta=textSearchEposta.getText();
                String type=comboSearchType.getSelectedItem().toString();
                String language= comboSearchLanguage.getSelectedItem().toString();

                String query= User.searchByQuery(name,userName,eposta,type,language);

                ArrayList<User> theUsers=searchByQuery(query);

                loadTableUsers(theUsers);



            }
        });
        buttonAddPatika.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String patikaName=textPatikaName.getText().toUpperCase();
                String language=comboAddPatikaLanguage.getSelectedItem().toString();


                if (Patika.getFetchByName(patikaName)) {


                    Support.giveMessage("Bu isimde patika mevcuttur. Lütfen başka bir isim tercih ediniz!");

                } else {


                    if (Patika.addPatika(patikaName, language)) {
                        textPatikaName.setText(null);
                        loadTablePatika();
                        loadComboPatika();
                        loadTableLessons();

                        Support.giveMessage("başarı");
                    }else {
                        textPatikaName.setText(null);
                        Support.giveMessage("hata");
                    }
                }









            }
        });
        buttonDeletePatika.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboDeletePatika.getItemCount()>0) {


                    String patikaName = comboDeletePatika.getSelectedItem().toString();


                    if (Support.confirm("sure")) {


                        Lesson lesName = Lesson.getFetchByPatikaName(patikaName);


                        if (lesName != null) {


                            if (Support.confirm("Bu patikaya ait dersler ve bu derslere ait içerik ve sorular silinsin mi?")) {


                                for (Lesson les : Lesson.getLessonsByPatikaName(patikaName)) {

                                    Question ques = Question.getFetchBYLessonName(les.getLessonName());

                                    if (ques != null) {


                                        if (Question.deleteByLessonName(les.getLessonName())) {

                                            loadTableQuestions();

                                        } else
                                            Support.giveMessage(les.getLessonName() + " dersine ait soruların silinmesinde hata oluştu!");

                                    }

                                    Content cont = Content.getFetcByLessonName(les.getLessonName());

                                    if (cont != null) {

                                        if (Content.deleteByLessonName(les.getLessonName())) {

                                            loadTableContent();
                                            loadTableQuestions();
                                            loadComboContentTitles();
                                            loadComboSearchQuesContTitle();


                                        } else
                                            Support.giveMessage(les.getLessonName() + " dersine ait içeriklerin silinmesinde hata oluştu!");

                                    }

                                    if (Lesson.delete(les.getLessonName())) {

                                        loadTableLessons();
                                        loadTableContent();
                                        loadTableQuestions();
                                        loadComboLessonNames();
                                        loadComboSearchContLesName();
                                        loadComboQuesLesName();


                                    } else Support.giveMessage("Bu patikaya ait derslerin silinmesinde hata oluştu!");


                                }


                            } else Support.giveMessage("başarı");

                        }


                        if (Patika.deletePatika(patikaName)) {

                            loadTablePatika();
                            loadComboPatika();
                            loadTableLessons();

                            Support.giveMessage("başarı");


                        } else Support.giveMessage("hata");


                    }

                }else Support.giveMessage("Herhangi bir patika mevcut değil!");






            }
        });
        buttonSearchPatika.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name=textSearchPatikaByName.getText().toUpperCase();
                String language= comboSearchPatikaLanguage.getSelectedItem().toString();

                String query=Patika.searchPatika(name,language);
                ArrayList<Patika> thePatikas=Patika.searchPatikaByQuery(query);
                loadTablePatika(thePatikas);






            }
        });
        buttonSearchLesson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                    String lessonName=textSearchLessonName.getText().toUpperCase();
                    String language=comboSearchLessonLanguage.getSelectedItem().toString();

                    ArrayList<Lesson> theLesson=Lesson.searchByQuery(lessonName,language);

                    loadTableLesson(theLesson);

            }
        });
        buttonAddLesson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String lessonName=textAddLessonName.getText().toUpperCase();
                String educatorName=comboAddLessonEducator.getSelectedItem().toString().toUpperCase();
                String patikaName=comboAddLessonPatikaName.getSelectedItem().toString().toUpperCase();
                String language=comboAddLessonLanguage.getSelectedItem().toString().toUpperCase();

                if (Support.isTextFieldEmpty(textAddLessonName)){
                    Support.giveMessage("boş");
                }else {

                    if (Lesson.getFetchByLessonName(lessonName)){

                        Support.giveMessage("Bu ders mevcut !");

                    }else {

                        if (Lesson.addLesson(lessonName, educatorName,patikaName, language)){
                            textAddLessonName.setText(null);

                            loadTableLessons();
                            loadTableContent();
                            loadTableQuestions();
                            loadComboLessonNames();
                            loadComboSearchContLesName();
                            loadComboQuesLesName();
                            loadComboAddContLesName();


                            textAddLessonName.setText(null);
                            comboAddLessonEducator.setSelectedIndex(0);
                            comboAddLessonPatikaName.setSelectedIndex(0);
                            comboAddLessonLanguage.setSelectedIndex(0);

                            Support.giveMessage("başarı");
                        }else {
                            textAddLessonName.setText(null);
                            Support.giveMessage("hata");
                        }
                    }


                }





            }
        });
        buttonDeleteLesson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int deleteID;

                while (true) {

                    try{
                        deleteID=Integer.parseInt(textDeleteLessonID.getText());

                    }
                    catch(Exception ex){

                        textDeleteLessonID.setText(null);

                        Support.giveMessage("Lütfen yalnızca rakamsal değer giriniz !");
                        return;


                    }

                    break;

                }

                    if (Lesson.getFetchByLessonID(deleteID)){


                        if (Support.confirm("sure")){


                            Lesson les=Lesson.getFetchByIDReturnLesson(deleteID);


                            Content con=Content.getFetcByLessonName(les.getLessonName());

                            if (con!=null){


                            if (Support.confirm("Bu derse ait içerikler ve bu içeriklere ait sorular silinsin mi?")){


                                Question ques=Question.getFetchBYLessonName(les.getLessonName());

                                if (ques!=null){


                                if (Question.deleteByLessonName(les.getLessonName())){


                                    loadTableQuestions();

                                }else Support.giveMessage("Bu derse ait soruları silmede hata oluştu.");

                                }


                                if (Content.deleteByLessonName(les.getLessonName())){


                                    loadTableContent();
                                    loadTableQuestions();
                                    loadComboContentTitles();
                                    loadComboSearchQuesContTitle();

                                }else Support.giveMessage("Bu derse ait içerikleri silmede hata oluştu.");


                            }

                            }

                            if (Lesson.deleteLesson(deleteID)){

                                textDeleteLessonID.setText(null);


                                loadTableLessons();
                                loadTableContent();
                                loadTableQuestions();
                                loadComboLessonNames();
                                loadComboSearchContLesName();
                                loadComboQuesLesName();
                                loadComboAddContLesName();


                                Support.giveMessage("başarı");



                            }else Support.giveMessage("hata");









                        }




                    }else {
                        Support.giveMessage("Bu ID'ye tanımlı ders bulunmamaktadır !");
                    }






            }
        });
        comboAddQuestionLessonName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboAddQuestionLessonName.getItemCount()>0){

                    String lessonName=comboAddQuestionLessonName.getSelectedItem().toString();
                    loadComboAddQuestionContentTitle(lessonName);

                    Lesson les=Lesson.getFetchByName(lessonName);

                    if (les!=null){
                        textAddQuesEducName.setText(les.getEducatorName());

                    }else {
                        textAddQuesEducName.setText(null);
                    }
                }




            }
        });
        comboAddContLesName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (comboAddContLesName.getItemCount()>0){
                    String lessonName=comboAddContLesName.getSelectedItem().toString();

                    loadComboAddContEducName(lessonName);
                }



            }
        });
        buttonSearchCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String contTitle=textSearchContentTitle.getText().trim();
                String lesName=comboSearchContLesName.getSelectedItem().toString();

                ArrayList<Content> cont=Content.searchByQuery(contTitle,lesName);

                loadTableContent(cont);



            }
        });
        buttonSearchQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String question=textSearchQuestion.getText().trim();
                String conTitle=comboSearchQuesContTitle.getSelectedItem().toString();
                String lesName=comboSearchQuesLesName.getSelectedItem().toString();

                ArrayList<Question> questions=Question.searchLike(question,conTitle,lesName);

                loadTableQuestions(questions);

            }
        });
        buttonAddContent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String contTitle=textAddContentTitle.getText().trim().toUpperCase();
                String contDesc=textAddContentDescription.getText().trim().toUpperCase();
                String contLink=textAddContLink.getText().trim();
                String lesName=comboAddContLesName.getSelectedItem().toString();
                String educName=comboAddContEducName.getSelectedItem().toString();

                if (Support.isTextFieldEmpty(textAddContentTitle) || Support.isTextFieldEmpty(textAddContentDescription) || Support.isTextFieldEmpty(textAddContLink)){

                    Support.giveMessage("boş");


                }else {

                    Content cont = Content.getFetcByCTitle(contTitle);

                    if (cont != null ) {

                        Support.giveMessage("Bu isimde içerik mevcuttur. Lütfen başka bir isim tercih ediniz!");


                    } else {

                        if (Content.addContent(contTitle, contDesc, contLink, lesName, educName)) {
                            loadTableContent();
                            loadTableQuestions();
                            loadComboContentTitles();
                            loadComboSearchQuesContTitle();

                            if (comboAddQuestionLessonName.getItemCount()>0){
                                loadComboAddQuestionContentTitle(comboAddQuestionLessonName.getSelectedItem().toString());

                            }

                            textAddContentTitle.setText(null);
                            textAddContentDescription.setText(null);
                            textAddContLink.setText(null);
                            comboAddContLesName.setSelectedIndex(0);
                            comboAddContEducName.setSelectedIndex(0);




                            Support.giveMessage("başarı");
                        } else {
                            loadTableContent();
                            Support.giveMessage("hata");
                        }

                    }

                }


            }
        });
        buttonDeleteContent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




                    try{
                        int id=Integer.parseInt(textDeleteContID.getText());



                        int i=0;

                        String  conttTitle="";

                        for(Content content :Content.getContents() ) {

                            if (id==content.getId()){
                                i++;
                                conttTitle=content.getContentTitle();
                                break;
                            }

                        }

                        if (i>0){

                            if (Support.confirm("sure")){

                            Question ques=Question.getFetchBYContentTitle(conttTitle);

                            if (ques!=null){

                                if (Support.confirm("Bu içeriğe bağlı soruların da silinmesini ister misiniz?")){


                                    if (Question.deleteByContentTİtle(conttTitle)){

                                        loadTableQuestions();

                                        Support.giveMessage("Bu içeriğe bağlı sorular silindi.");

                                    }else {

                                        Support.giveMessage("Bu içeriğe bağlı soruları silme sırasında bir hata oluştu.");
                                    }


                                }




                            }





                            if (Content.deleteContent(id)){
                                textDeleteContID.setText(null);

                                loadTableContent();
                                loadTableQuestions();
                                loadComboContentTitles();
                                loadComboSearchQuesContTitle();



                                if (comboAddQuestionLessonName.getItemCount()>0){
                                    loadComboAddQuestionContentTitle(comboAddQuestionLessonName.getSelectedItem().toString());

                                }

                                Support.giveMessage("başarı");


                            }else Support.giveMessage("hata");


                            }else Support.giveMessage("iptal");


                        }else Support.giveMessage("Bu ID'ye tanımlı içerik mevcur değildir !");




                    }
                    catch(Exception exc){

                        Support.giveMessage("Lütfen yalnızca rakamsal değer giriniz !");

                    }












            }
        });
        buttonAddQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String lessonName= comboAddQuestionLessonName.getSelectedItem().toString();
                String contentTitle=comboAddQuestionContentTitle.getSelectedItem().toString();
                String educatorName=textAddQuesEducName.getText();
                String question=textAddQuestion.getText().trim();
                String optionA=textAddOptionA.getText().trim();
                String optionB=textAddOptionB.getText().trim();
                String optionC=textAddOptionC.getText().trim();
                String optionD=textAddOptionD.getText().trim();
                String trueAnswer=comboAddQuestionTrueAnswer.getSelectedItem().toString();

                if (question.isEmpty() || optionA.isEmpty() || optionB.isEmpty() || optionC.isEmpty() || optionD.isEmpty()){

                    Support.giveMessage("boş");

                }else {

                    int i=0;

                    for (Question q : Question.getQuestions()) {

                        if (Objects.equals(q.getQuestion(), question)) {

                            i++;

                            if (Support.confirm("Bu soru halihazırda mevcuttur. Yine de devam etmek ister misiniz ?")) {


                                if (Question.update(q.getId(),question, optionA, optionB, optionC, optionD, trueAnswer, contentTitle, lessonName,educatorName)) {


                                    comboAddQuestionLessonName.setSelectedIndex(0);
                                    comboAddQuestionContentTitle.setSelectedIndex(0);
                                    textAddQuestion.setText(null);
                                    textAddOptionA.setText(null);
                                    textAddOptionB.setText(null);
                                    textAddOptionC.setText(null);
                                    textAddOptionD.setText(null);
                                    comboAddQuestionTrueAnswer.setSelectedIndex(0);

                                    Lesson les=Lesson.getFetchByName(comboAddQuestionLessonName.getSelectedItem().toString());

                                    if (les!=null){
                                        textAddQuesEducName.setText(les.getEducatorName());

                                    }else {
                                        textAddQuesEducName.setText(null);
                                    }

                                    loadTableQuestions();



                                    Support.giveMessage("başarı");
                                    break;

                                } else {
                                    Support.giveMessage("hata");
                                    break;
                                }


                            } else {
                                Support.giveMessage("iptal");
                                break;

                            }
                        }


                    }

                    if (i==0){

                        if (Question.addQuestion(question, optionA, optionB, optionC, optionD, trueAnswer, contentTitle, lessonName,educatorName)) {


                            comboAddQuestionLessonName.setSelectedIndex(0);
                            comboAddQuestionContentTitle.setSelectedIndex(0);
                            textAddQuestion.setText(null);
                            textAddOptionA.setText(null);
                            textAddOptionB.setText(null);
                            textAddOptionC.setText(null);
                            textAddOptionD.setText(null);
                            comboAddQuestionTrueAnswer.setSelectedIndex(0);

                            Lesson les=Lesson.getFetchByName(comboAddQuestionLessonName.getSelectedItem().toString());


                            if (les!=null){
                                textAddQuesEducName.setText(les.getEducatorName());

                            }else {
                                textAddQuesEducName.setText(null);
                            }


                            loadTableQuestions();


                            Support.giveMessage("başarı");

                        } else {
                            Support.giveMessage("hata");

                        }



                    }








                }

            }
        });
        buttonDeleteQuestion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id;
                try{
                    id=Integer.parseInt(textDeleteQuestionID.getText());


                    }
                catch(Exception exc){

                    Support.giveMessage("Lütfen yalnızca rakamsal değer giriniz !");

                    return;


                        }

                if (Question.getFetchBYID(id)!=null){

                    if (Question.delete(id)){
                        loadTableQuestions();
                        textDeleteQuestionID.setText(null);
                        Support.giveMessage("başarı");

                    }else Support.giveMessage("hata");


                }else {
                    Support.giveMessage("Bu ID'ye tanımlı soru mevcut değildir.");
                }



            }
        });




    }


    public ArrayList<User> searchByQuery(String query){

        ArrayList<User> users= new ArrayList<>();

        User theUser=null;

        try {
            Statement statement= DBConnector.getConnection().createStatement();

            ResultSet resultSet= statement.executeQuery(query);
            while (resultSet.next()) {

                int userID= resultSet.getInt("id");
                String name= resultSet.getString("name");
                String userName= resultSet.getString("userName");
                String password= resultSet.getString("password");
                String eposta= resultSet.getString("eposta");
                String userType= resultSet.getString("userType");
                String language= resultSet.getString("language");

                theUser=new User(userID,name,userName,password,eposta,userType,language);
                users.add(theUser);



            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;


    }

    public void loadTableUsers(ArrayList<User> users){
        DefaultTableModel clear= (DefaultTableModel) tableUsers.getModel();
        clear.setRowCount(0);

        int i;
        for(User user :users ) {

            i=0;

            rowsUsers[i++]=user.getId();
            rowsUsers[i++]=user.getName();
            rowsUsers[i++]=user.getUserName();
            rowsUsers[i++]=user.getPassword();
            rowsUsers[i++]=user.geteposta();
            rowsUsers[i++]=user.getUserType();
            rowsUsers[i]=user.getLanguage();
            usersTableModel.addRow(rowsUsers);


        }
    }

    public void loadTableUsers() {

        DefaultTableModel clearTable= (DefaultTableModel) tableUsers.getModel();
        clearTable.setRowCount(0);

        int i;

        for(User u :User.getUsers() ) {

            i=0;

            rowsUsers[i++]= u.getId();
            rowsUsers[i++]= u.getName();
            rowsUsers[i++]= u.getUserName();
            rowsUsers[i++]= u.getPassword();
            rowsUsers[i++]= u.geteposta();
            rowsUsers[i++]= u.getUserType();
            rowsUsers[i]= u.getLanguage();
            usersTableModel.addRow(rowsUsers);



        }





    }

    public void loadTablePatika() {
        DefaultTableModel clearTable= (DefaultTableModel) tablePatika.getModel();
        clearTable.setRowCount(0);

        int i;

        for(Patika patika : Patika.getPatikaList() ) {
            i=0;
            rowsPatika[i++]= patika.getId();
            rowsPatika[i++]= patika.getName();
            rowsPatika[i]=patika.getLanguage();
            patikaTableModel.addRow(rowsPatika);

        }



    }

    public void loadTableLessons() {
        DefaultTableModel clearTable= (DefaultTableModel) tableLessons.getModel();
        clearTable.setRowCount(0);

        int i;

        for(Lesson lesson : Lesson.getLessons()) {
            i=0;
            rowsLessons[i++]=lesson.getLessonID();
            rowsLessons[i++]=lesson.getLessonName();
            rowsLessons[i++]=lesson.getEducatorName();
            rowsLessons[i++]=lesson.getPatikaName();
            rowsLessons[i++]=lesson.getLanguage();
            lessonsTableModel.addRow(rowsLessons);

        }



    }

    public void loadComboPatika(){

        comboAddLessonPatikaName.removeAllItems();
        comboDeletePatika.removeAllItems();

        comboAddLessonPatikaName.addItem("");


        for(Patika patika : Patika.getPatikaList() ) {

            comboAddLessonPatikaName.addItem(patika.getName());
            comboDeletePatika.addItem(patika.getName());

        }



    }

    public void loadComboEducator() {
        comboAddLessonEducator.removeAllItems();

        comboAddLessonEducator.addItem("");

        for(User user : User.getUsers() ) {

            if (user.getUserType().equals("EDUCATOR")) {

                comboAddLessonEducator.addItem(user.getName());

            }

        }
    }

    public void loadTablePatika(ArrayList<Patika> patikaList) {

        DefaultTableModel clearTable= (DefaultTableModel) tablePatika.getModel();
        clearTable.setRowCount(0);
        int i;
        for(Patika patika : patikaList ) {
            i=0;
            rowsPatika[i++]= patika.getId();
            rowsPatika[i++]= patika.getName();
            rowsPatika[i]=patika.getLanguage();
            patikaTableModel.addRow(rowsPatika);
        }


    }

    public void loadTableLesson(ArrayList<Lesson> lessonList) {
        DefaultTableModel clearTable= (DefaultTableModel) tableLessons.getModel();
        clearTable.setRowCount(0);
        int i;
        for(Lesson lesson : lessonList ) {
            i=0;
            rowsLessons[i++]=lesson.getLessonID();
            rowsLessons[i++]=lesson.getLessonName();
            rowsLessons[i++]=lesson.getEducatorName();
            rowsLessons[i++]=lesson.getPatikaName();
            rowsLessons[i++]=lesson.getLanguage();
            lessonsTableModel.addRow(rowsLessons);

        }
    }

    public void loadTableContent(){
        DefaultTableModel clear = (DefaultTableModel) tableContents.getModel();
        clear.setRowCount(0);

        int i;


        for(Content content : Content.getContents() ) {

            i=0;

            rowsContents[i++]=content.getId();
            rowsContents[i++]=content.getContentTitle();
            rowsContents[i++]=content.getContentDescription();
            rowsContents[i++]=content.getLink();
            rowsContents[i++]=content.getLessonName();
            rowsContents[i++]=content.getEducatorName();
            modelContents.addRow(rowsContents);



        }


    }

    public void loadTableContent(ArrayList<Content> contentList) {
        DefaultTableModel clear = (DefaultTableModel) tableContents.getModel();
        clear.setRowCount(0);

        int i;


        for(Content content : contentList ) {

            i=0;

            rowsContents[i++]=content.getId();
            rowsContents[i++]=content.getContentTitle();
            rowsContents[i++]=content.getContentDescription();
            rowsContents[i++]=content.getLink();
            rowsContents[i++]=content.getLessonName();
            rowsContents[i++]=content.getEducatorName();
            modelContents.addRow(rowsContents);



        }


    }

    public void loadComboAddContLesName(){

        comboAddContLesName.removeAllItems();

        comboAddContLesName.addItem("");


        for(Lesson lesson : Lesson.getLessons() ) {

            comboAddContLesName.addItem(lesson.getLessonName());

        }

    }

    public void loadComboSearchContLesName(){

        comboSearchContLesName.removeAllItems();

        comboSearchContLesName.addItem("");


        for(Lesson lesson : Lesson.getLessons() ) {

            comboSearchContLesName.addItem(lesson.getLessonName());

        }


    }

    public void loadComboAddQuestionContentTitle(String lessonName){
        comboAddQuestionContentTitle.removeAllItems();

        comboAddQuestionContentTitle.addItem("");

        for(Content cont : Content.getContents() ) {
            if (cont.getLessonName().equals(lessonName)) {
                comboAddQuestionContentTitle.addItem(cont.getContentTitle());
            }

        }


    }

    public void loadComboAddContEducName(String lessonName){

        comboAddContEducName.removeAllItems();

        comboAddContEducName.addItem("");

        for(Lesson lesson : Lesson.getLessons() ) {
            if (lesson.getLessonName().equals(lessonName)) {
                comboAddContEducName.addItem(lesson.getEducatorName());
            }

        }
    }

    public void loadComboSearchQuesContTitle(){

        comboSearchQuesContTitle.removeAllItems();
        comboSearchQuesContTitle.addItem("");

        for(Content content : Content.getContents() ) {

            comboSearchQuesContTitle.addItem(content.getContentTitle());

        }


    }
    
    public void loadComboQuesLesName(){

        comboAddQuestionLessonName.removeAllItems();
        comboSearchQuesLesName.removeAllItems();

        comboSearchQuesLesName.addItem("");
        comboAddQuestionLessonName.addItem("");


        for(Lesson lesson : Lesson.getLessons() ) {

            comboSearchQuesLesName.addItem(lesson.getLessonName());
            comboAddQuestionLessonName.addItem(lesson.getLessonName());

        }


    }

    public void loadTableQuestions() {
        DefaultTableModel clear = (DefaultTableModel) tableQuestions.getModel();
        clear.setRowCount(0);
        int i;
        for (Question obj : Question.getQuestions()) {
            i = 0;
            rowsQuestions[i++] = obj.getId();
            rowsQuestions[i++] = obj.getQuestion();
            rowsQuestions[i++] = obj.getOptionA();
            rowsQuestions[i++] = obj.getOptionB();
            rowsQuestions[i++] = obj.getOptionC();
            rowsQuestions[i++] = obj.getOptionD();
            rowsQuestions[i++] = obj.getTrueAnswer();
            rowsQuestions[i++] = obj.getContentTitle();
            rowsQuestions[i++] = obj.getLessonName();
            rowsQuestions[i++] = obj.getEducatorName();
            modelQuestions.addRow(rowsQuestions);
        }





    }

    public void loadTableQuestions(ArrayList<Question> questionList) {
        DefaultTableModel clear = (DefaultTableModel) tableQuestions.getModel();
        clear.setRowCount(0);
        int i;
        for (Question obj : questionList) {
            i = 0;
            rowsQuestions[i++] = obj.getId();
            rowsQuestions[i++] = obj.getQuestion();
            rowsQuestions[i++] = obj.getOptionA();
            rowsQuestions[i++] = obj.getOptionB();
            rowsQuestions[i++] = obj.getOptionC();
            rowsQuestions[i++] = obj.getOptionD();
            rowsQuestions[i++] = obj.getTrueAnswer();
            rowsQuestions[i++] = obj.getContentTitle();
            rowsQuestions[i++] = obj.getLessonName();
            rowsQuestions[i++] = obj.getEducatorName();
            modelQuestions.addRow(rowsQuestions);
        }





    }

    public void loadComboContentTitles(){
        comboContentTitles.removeAllItems();

        comboContentTitles.addItem("");
        for(Content content : Content.getContents() ) {
            comboContentTitles.addItem(content.getContentTitle());

        }
    }

    public void loadComboLessonNames(){
        comboLessonNames.removeAllItems();

        for(Lesson lesson : Lesson.getLessons() ) {
            comboLessonNames.addItem(lesson.getLessonName());
        }
    }





    public static void main(String[] args) {
        Support.theme();
        User user= new User(5,"Ordu","ordu","2353534,","@yaani.com","OPERATOR","");
        OperatorGUI operatorGUI = new OperatorGUI(user);
    }


}
