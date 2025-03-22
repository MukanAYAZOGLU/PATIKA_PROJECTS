package View;


import Model.Room;
import Support.Support;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;

public class SearchRoomForReservationGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JButton buttonLogOut;
    private JComboBox comboCity;
    private JComboBox comboRegion;
    private JTextField textEntryDate;
    private JSpinner spinnerNumberAdult;
    private JSpinner spinnerNumberChild;
    private JTextField textReleaseDate;
    private JButton buttonSearchRoom;


    public SearchRoomForReservationGUI() {
        add(mainPanel);
        setTitle(Support.ProjectTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 270);
        setLocation(Support.setLocation("x", 700), Support.setLocation("y", 270));
        setResizable(true);
        setVisible(true);

        buttonLogOut.addActionListener(e -> {
            dispose();
        });

        comboAll();

        comboCity.setSelectedItem(null);
        comboRegion.setSelectedItem(null);

        comboCity.addActionListener(e -> {
            String city = comboCity.getSelectedItem().toString();
            comboRegion(city);
        });

        buttonSearchRoom.addActionListener(e -> {

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date dateEntry;
            Date dateRelease;

            String city = Support.comboReturnStringOrNull(comboCity);
            String region = Support.comboReturnStringOrNull(comboRegion);


            int adult=Integer.parseInt(spinnerNumberAdult.getValue().toString());
            int child=Integer.parseInt(spinnerNumberChild.getValue().toString());

            int persons=adult+child;


            while (true){

                try {
                    dateEntry= Date.valueOf(textEntryDate.getText());
                    dateRelease= Date.valueOf(textReleaseDate.getText());

                } catch (Exception ex) {

                    Support.showMessage("Lütfen tarihleri eksiksiz bir şekilde giriniz!");

                    return;
                }
                break;
            }

                if (dateEntry.equals(dateRelease)) {
                    Support.showMessage("Giriş ve çıkış tarihleri aynı gün olamaz!");


                } else if (!dateEntry.before(dateRelease)) {

                    Support.showMessage("Çıkış tarihi giriş tarihinden önce olamaz!");

                } else {


                    if (persons<=0){
                        Support.showMessage("En az bir birey girilmelidir!");

                    }else {


                        ArrayList<Room> rooms = Room.search(region,city,persons,dateEntry,dateRelease);

                        if (rooms.isEmpty()){

                            Support.showMessage("Aradığınız kriterlerde bir oda bulunamamıştır.");

                        }else {


                        ChoicesOfReservationGUI choicesOfReservationGUI =new ChoicesOfReservationGUI(rooms,dateEntry,dateRelease,adult,child);
                        choicesOfReservationGUI.setVisible(true);
                        dispose();




                        }











                    }



                }








        });







    }


    public void comboAll(){

        comboCity.removeAllItems();
        comboRegion.removeAllItems();


        for(Room room :Room.getRooms() ) {

            if (!Support.isComboBoxContains(comboCity, room.getCity())) {
                comboCity.addItem(room.getCity());
            }

            if (!Support.isComboBoxContains(comboRegion, room.getRegion())) {
                comboRegion.addItem(room.getRegion());
            }



        }

        comboCity.setSelectedItem(null);
        comboRegion.setSelectedItem(null);


    }


    public void comboRegion(String city){

        comboRegion.removeAllItems();

        for(Room room : Room.getRooms() ) {
            if (room.getCity().equals(city) && !Support.isComboBoxContains(comboRegion,room.getRegion())) {
                comboRegion.addItem(room.getRegion());
            }


        }


    }



    public static void main(String[] args) {
        Support.theme();
        new SearchRoomForReservationGUI();
    }

    private void createUIComponents() throws ParseException {
        textEntryDate=new JFormattedTextField(new MaskFormatter("####-##-##"));
        textReleaseDate=new JFormattedTextField(new MaskFormatter("####-##-##"));
    }
}