package View;

import Model.Hotel;
import Model.Room;
import Support.Support;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ChoicesOfReservationGUI extends JFrame {

    private JPanel mainPanel;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JButton buttonBack;
    private JLabel labelHotelName;
    private JLabel labelStar;
    private JLabel labelCity;
    private JLabel labelRegion;
    private JLabel labelAddress;
    private JLabel labelPhone;
    private JLabel labelMail;
    private JPanel panelFirstInfo;
    private JPanel panelSecondInfo;
    private JLabel labelHotelFeature;
    private JLabel labelFeatures;
    private JPanel panelThirdInfo;
    private JLabel labelRoomType;
    private JLabel labeNumAdult;
    private JLabel labeNumChild;
    private JLabel labelDateRelase;
    private JLabel labelRoomInfo;
    private JLabel labelRoomAllInfo;
    private JButton buttonAddReservation;
    private JLabel labelEntryRelase;
    private JButton buttonNext;
    private JLabel labelReserInfo;
    private JLabel labelTotalPrice;
    int i=0;
    int days;




    public ChoicesOfReservationGUI(ArrayList<Room> rooms, Date dateEntry, Date dateRelease, int adult, int child) {
        add(mainPanel);
        setTitle(Support.ProjectTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 500);
        setLocation(Support.setLocation("x", 750), Support.setLocation("y", 500));
        setResizable(true);
        setVisible(true);


        //STABLE-------


        labelHotelName.setForeground(Color.blue);
        labelStar.setForeground(Color.blue);
        labelHotelFeature.setForeground(Color.blue);
        labelRoomType.setForeground(Color.blue);
        labelRoomInfo.setForeground(Color.blue);
        labelRoomType.setForeground(Color.blue);
        labelReserInfo.setForeground(Color.blue);

        panelFirstInfo.setBackground(Color.WHITE);
        panelSecondInfo.setBackground(Color.WHITE);
        panelThirdInfo.setBackground(Color.WHITE);

        //----------

        buttonBack.setText("ÇIKIŞ YAP");

        if (rooms.size() == 1) {buttonNext.setVisible(false);}





        loadHotelsRoom(rooms.get(i), dateEntry, dateRelease, adult, child);


        buttonBack.addActionListener(e -> {

            i--;

            if (i<0){
                dispose();


            }else {
                loadHotelsRoom(rooms.get(i), dateEntry, dateRelease, adult, child);

                if (i-1<0) buttonBack.setText("ÇIKIŞ YAP");

                buttonNext.setVisible(true);

                buttonNext.setText("SONRAKİ");



            }


        });

        buttonNext.addActionListener(e -> {

            i++;

            if ((i+1==rooms.size())){

                buttonNext.setVisible(false);

            }


                loadHotelsRoom(rooms.get(i),dateEntry, dateRelease, adult, child);

                buttonBack.setText("ÖNCEKİ");






        });

        buttonAddReservation.addActionListener(e -> {

            int roomID=rooms.get(i).getId();
            int hotelID=rooms.get(i).getHotelID();
            String  hotelName=rooms.get(i).getHotelName();

            Room room=rooms.get(i);

            long days=dateRelease.getTime()-dateEntry.getTime();

            long allDays=TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);

            double price=(room.getPensionPrice()+(room.getPriceForChild()*child)+(room.getPriceForAdult()*adult))*allDays;


            MakeReservationGUI makeReservationGUI=new MakeReservationGUI(adult+child,roomID,hotelID,hotelName,dateEntry,dateRelease,price);
            makeReservationGUI.setVisible(true);
            dispose();
        });










    }


    public void loadHotelsRoom (Room room, Date dateEntry, Date dateRelease, int adult, int child){

        Hotel hotel=Hotel.getHotel(room.getHotelID());

        String [] features=hotel.getFeature().split(" - ");
        String [] roomFeatures= room.getFeature().split(" - ");


        labelHotelName.setText(room.getHotelName());
        labelStar.setText(hotel.getStar()+" Yıldız");
        labelAddress.setText(hotel.getAddress());
        labelCity.setText(hotel.getCity());
        labelRegion.setText(hotel.getRegion());
        labelPhone.setText(hotel.getPhone());
        labelMail.setText(hotel.getMail());


        for(String feature :features ) {

            labelFeatures.setText("*"+feature+"    ");
        }


        labelRoomType.setText(room.getRoomType());


        for(String feature :roomFeatures ) {

            labelRoomAllInfo.setText("*"+feature+"    ");
        }



        labelEntryRelase.setText(dateEntry.toString());
        labelDateRelase.setText(dateRelease.toString());
        labeNumAdult.setText(String.valueOf(adult));
        labeNumChild.setText(String.valueOf(child));


        long days=dateRelease.getTime()-dateEntry.getTime();

        long allDays=TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);

        double price=(room.getPensionPrice()+(room.getPriceForChild()*child)+(room.getPriceForAdult()*adult))*allDays;



        labelTotalPrice.setText(price+" TL");





    }



    public static void main(String[] args) {
        Support.theme();
        new ChoicesOfReservationGUI(Room.getRooms(),Date.valueOf("2010-10-02"),Date.valueOf("2010-11-12"),5,3);
    }








}


