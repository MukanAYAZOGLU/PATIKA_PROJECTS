package View;

import Model.Hotel;
import Model.Room;
import Support.Support;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class AddRoomGUI extends JFrame {
    private JPanel mainPanel;
    private JButton buttonlogOut;
    private JComboBox comboHotelName;
    private JComboBox comboRoomType;
    private JComboBox comboBedroomSet;
    private JCheckBox checkBoxTV;
    private JCheckBox checkBoxProjection;
    private JCheckBox checkBoxMinibar;
    private JCheckBox checkBoxGameConsole;
    private JCheckBox checkBoxSafe;
    private JSpinner spinnerRoomStock;
    private JButton buttonAddRoom;
    private JComboBox comboPensionType;
    private JTextField textRoomPriceForChild;
    private JTextField textRoomPriceForAdult;
    private JSpinner spinnerSpace;
    private JTextField textDateEntry;
    private JTextField textDateRelease;
    private JTextField textPensionPrice;


    public AddRoomGUI(Hotel hotel) {
        add(mainPanel);
        setTitle(Support.ProjectTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 450);
        setLocation(Support.setLocation("x", 650), Support.setLocation("y", 450));
        setResizable(true);
        setVisible(true);

        loadComboHotelNames();

        spinnerSpace.setValue(5);
        spinnerRoomStock.setValue(1);


        if (hotel!=null){
            comboHotelName.setSelectedItem(hotel.getName());

        }




        buttonlogOut.addActionListener(e -> dispose());
        buttonAddRoom.addActionListener(e -> {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dateEntry;
            Date dateRelease;


            while (true){

            try {
                dateEntry= Date.valueOf(textDateEntry.getText());
                dateRelease= Date.valueOf(textDateRelease.getText());

            } catch (Exception ex) {

                Support.showMessage("Lütfen tarihleri eksiksiz bir şekilde giriniz!");
                //throw new RuntimeException(ex);

                return;
            }
            break;
            }


                if (!dateEntry.before(dateRelease)) {
                    Support.showMessage("Lütfen tarih aralığını doğru giriniz!");

                }else {

                    String hotelName=comboHotelName.getSelectedItem().toString();
                    String roomType=comboRoomType.getSelectedItem().toString();
                    int bedroomSet=Integer.parseInt(comboBedroomSet.getSelectedItem().toString());
                    int roomStock=Integer.parseInt(spinnerRoomStock.getValue().toString());
                    String pensionType=comboPensionType.getSelectedItem().toString();
                    String feature="";
                    double priceForChild;
                    double priceForAdult;
                    double pensionPrice;
                    int space=Integer.parseInt(spinnerSpace.getValue().toString());


                    while (true){

                        try{
                            priceForChild=Double.parseDouble(textRoomPriceForChild.getText().trim());
                            priceForAdult=Double.parseDouble(textRoomPriceForAdult.getText().trim());
                            pensionPrice=Double.parseDouble(textPensionPrice.getText().trim());


                        }
                        catch(Exception exc){

                            Support.showMessage("Lütfen tüm fiyatları rakamsal değer giriniz!");
                            return;

                        }

                        break;


                    }


                    JCheckBox [] checkBox={checkBoxMinibar,checkBoxGameConsole,checkBoxProjection,checkBoxTV,checkBoxSafe};

                    for(JCheckBox checkBox1 :checkBox ) {
                        if(checkBox1.isSelected()) {
                            feature+=checkBox1.getText()+" - ";

                        }

                    }

                     if (space<5) {

                        Support.showMessage("Odanın alanı en az 5 m2 olmalıdır!");

                    } else {

                        Hotel hot=Hotel.getHotel(hotelName);


                        if (Room.add(hot.getId(),hotelName, hot.getStar(), roomType,pensionType,pensionPrice,bedroomSet,space,roomStock,feature,hot.getRegion(),hot.getCity(),priceForChild, priceForAdult,dateEntry,dateRelease)) {

                            Support.showMessage("okey");
                            dispose();

                        }else {
                            Support.showMessage("error");
                        }


                    }



                }




        });




    }


    public void loadComboHotelNames() {
        comboHotelName.removeAllItems();
        for(Hotel hotel : Hotel.getAll() ) {
            comboHotelName.addItem(hotel.getName());

        }
    }

    private void createUIComponents() throws ParseException {
        textDateEntry=new JFormattedTextField(new MaskFormatter("####-##-##"));
        textDateRelease=new JFormattedTextField(new MaskFormatter("####-##-##"));

    }
}
