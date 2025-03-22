package View;

import Model.Hotel;
import Model.Price;
import Support.Support;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PriceHotelGUI extends JFrame {
    private JPanel mainPanel;
    private JButton buttonLogOut;
    private JTextField textPriceUltraAll;
    private JTextField textPriceAllThings;
    private JTextField textPriceRoomBreakfast;
    private JTextField textPriceFullBoard;
    private JTextField textPriceHalfBoard;
    private JTextField textPriceOnylBed;
    private JTextField textPriceFullCreditExcpAlcohol;
    private JButton buttonPricePensionTypes;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JComboBox comboPriceHotelName;
    private JLabel labelHotelName;
    private JPanel panelMiddle;


    public PriceHotelGUI(Hotel hotel) {
        add(mainPanel);
        setTitle(Support.ProjectTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 550);
        setLocation(Support.setLocation("x", 500), Support.setLocation("y", 550));
        setResizable(true);
        setVisible(true);


        buttonLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        Price price;



        if (hotel!=null){
            labelHotelName.setText(hotel.getName());
            buttonPricePensionTypes.setText("FİYATLARI GÜNCELLE");
            comboPriceHotelName.setVisible(false);
            price=Price.getPrice(hotel.getId());

            if (price!=null){
                textPriceUltraAll.setText(String.valueOf(price.getUltraAll()));
                textPriceAllThings.setText(String.valueOf(price.getAllThings()));
                textPriceRoomBreakfast.setText(String.valueOf(price.getRoomBreakfast()));
                textPriceFullBoard.setText(String.valueOf(price.getFullBoard()));
                textPriceHalfBoard.setText(String.valueOf(price.getHalfBoard()));
                textPriceOnylBed.setText(String.valueOf(price.getOnlyBed()));
                textPriceFullCreditExcpAlcohol.setText(String.valueOf(price.getFullCreditExcpAlcohol()));
            }




        }else {
            price = null;
            labelHotelName.setVisible(false);
            loadCombos();

        }



        buttonPricePensionTypes.addActionListener(e -> {

            int hotelID;
            double ultraAll;
            double allThings;
            double roomBreakfast;
            double fullBoard;
            double halfBoard;
            double onlyBed;
            double fullCreditExcpAlcohol;


            if (Support.isAnyOfTheseTextFieldsEmpty(new JTextField[]{textPriceUltraAll ,textPriceAllThings, textPriceRoomBreakfast, textPriceFullBoard, textPriceHalfBoard ,textPriceOnylBed, textPriceFullCreditExcpAlcohol})){

                Support.showMessage("Lütfen tüm boşlukları doldurunuz!");

            }else {


                while (true){

                    try{

                        ultraAll=Double.parseDouble(textPriceUltraAll.getText().trim());
                        allThings=Double.parseDouble(textPriceAllThings.getText().trim());
                        roomBreakfast=Double.parseDouble(textPriceRoomBreakfast.getText().trim());
                        fullBoard=Double.parseDouble(textPriceFullBoard.getText().trim());
                        halfBoard=Double.parseDouble(textPriceHalfBoard.getText().trim());
                        onlyBed=Double.parseDouble(textPriceOnylBed.getText().trim());
                        fullCreditExcpAlcohol=Double.parseDouble(textPriceFullCreditExcpAlcohol.getText().trim());


                    }
                    catch(Exception exc){

                        Support.showMessage("Lütfen tüm değerleri rakam giriniz!");
                        return;

                    }
                    break;
                }





                if (price!=null){
                    hotelID = hotel.getId();

                    if (Price.update(hotelID,ultraAll, allThings, roomBreakfast, fullBoard, halfBoard, onlyBed ,fullCreditExcpAlcohol)){

                        Support.showMessage("okey");
                        dispose();


                    }else {
                        Support.showMessage("error");
                    }


                }else {

                    hotelID=Hotel.getHotel(Support.getComboString(comboPriceHotelName)).getId();


                    if (Price.add(hotelID,ultraAll, allThings, roomBreakfast, fullBoard, halfBoard, onlyBed ,fullCreditExcpAlcohol)){

                        Support.showMessage("okey");
                        dispose();


                    }else {
                        Support.showMessage("error");
                    }

                }











            }














        });
    }

    public void loadCombos(){
        comboPriceHotelName.removeAllItems();


        for(Hotel hotel :Hotel.getAll() ) {
            comboPriceHotelName.addItem(hotel.getName());

        }


    }





}