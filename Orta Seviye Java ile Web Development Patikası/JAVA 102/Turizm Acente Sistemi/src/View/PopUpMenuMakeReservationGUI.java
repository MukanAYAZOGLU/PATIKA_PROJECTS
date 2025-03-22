package View;

import Model.Room;
import Support.Support;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PopUpMenuMakeReservationGUI extends JFrame{
    private JPanel mainPanel;
    private JPanel panelTop;
    private JButton buttonLogOut;
    private JPanel panelBottom;
    private JTextField textEntryDate;
    private JTextField textReleaseDate;
    private JSpinner spinnerNumberAdult;
    private JSpinner spinnerNumberChild;
    private JButton buttonSearchRoom;
    private JLabel labelPeriods;


    public PopUpMenuMakeReservationGUI(Room room, Date entryDate, Date releaseDate) {
        add(mainPanel);
        setTitle(Support.ProjectTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 250);
        setLocation(Support.setLocation("x", 700), Support.setLocation("y", 250));
        setResizable(true);
        setVisible(true);



        buttonLogOut.addActionListener(e -> {
            dispose();
        });

        labelPeriods.setText(room.getEntryDate().toString() + " - " + room.getReleaseDate().toString());

        textEntryDate.setText(String.valueOf(entryDate));
        textReleaseDate.setText(String.valueOf(releaseDate));


        buttonSearchRoom.addActionListener(e -> {

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date dateEntry;
            Date dateRelease;


            int adult = Integer.parseInt(spinnerNumberAdult.getValue().toString());
            int child = Integer.parseInt(spinnerNumberChild.getValue().toString());

            int persons = adult + child;


            while (true) {

                try {
                    dateEntry = Date.valueOf(textEntryDate.getText());
                    dateRelease = Date.valueOf(textReleaseDate.getText());

                } catch (Exception ex) {

                    Support.showMessage("Lütfen tarihleri eksiksiz bir şekilde giriniz!");

                    return;
                }
                break;
            }

            if (dateEntry.before(entryDate)) {

                Support.showMessage("Giriş tarihi, odanın giriş döneminden önce olamaz!");


            }else if (dateRelease.after(releaseDate)){

                Support.showMessage("Çıkış tarihi, odanın çıkış döneminden sonra olamaz!");


            }else if (dateEntry.equals(dateRelease)) {
                Support.showMessage("Giriş ve çıkış tarihleri aynı gün olamaz!");


            } else if (!dateEntry.before(dateRelease)) {

                Support.showMessage("Çıkış tarihi giriş tarihinden önce olamaz!");

            } else {


                if (persons<=0){
                    Support.showMessage("En az bir birey girilmelidir!");

                }else if (persons>room.getBedroomSet()){


                    Support.showMessage("Kişi sayısı oda yatak kapasitesini aşamaz. Yatak kapasitesi: "+room.getBedroomSet());

                    }else {
                        ArrayList<Room> rooms = new ArrayList<>();
                        rooms.add(room);


                        ChoicesOfReservationGUI choicesOfReservationGUI = new ChoicesOfReservationGUI(rooms, dateEntry, dateRelease, adult, child);
                        choicesOfReservationGUI.setVisible(true);
                        dispose();


                    }

                }












        });









        
    }



    private void createUIComponents() throws ParseException {
        textEntryDate=new JFormattedTextField(new MaskFormatter("####-##-##"));
        textReleaseDate=new JFormattedTextField(new MaskFormatter("####-##-##"));
    }
    
    
    
    
}
