package View;

import Model.Room;
import Support.Support;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class UpdateRoomGUI extends JFrame {
    private JPanel mainPanel;
    private JButton buttonlogOut;
    private JComboBox comboRoomType;
    private JComboBox comboBedroomSet;
    private JCheckBox checkBoxTV;
    private JCheckBox checkBoxProjection;
    private JCheckBox checkBoxMinibar;
    private JCheckBox checkBoxGameConsole;
    private JCheckBox checkBoxSafe;
    private JSpinner spinnerRoomStock;
    private JButton buttonUpdateRoom;
    private JTextField textHotelName;
    private JComboBox comboPensionType;
    private JTextField textRoomPriceForChild;
    private JTextField textRoomPriceForAdult;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JSpinner spinnerSpace;
    private JTextField textDateEntry;
    private JTextField textDateRelease;
    private JTextField textPensionPrice;


    public UpdateRoomGUI(Room room) {
        add(mainPanel);
        setTitle(Support.ProjectTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 450);
        setLocation(Support.setLocation("x", 650), Support.setLocation("y", 450));
        setResizable(true);
        setVisible(true);



            textHotelName.setText(room.getHotelName());
            comboRoomType.setSelectedItem(room.getRoomType());
            comboBedroomSet.setSelectedIndex(room.getBedroomSet()-1);
            spinnerRoomStock.setValue(room.getRoomStock());
            spinnerSpace.setValue(room.getSpace());
            textRoomPriceForChild.setText(String.valueOf(room.getPriceForChild()));
            textRoomPriceForAdult.setText(String.valueOf(room.getPriceForAdult()));
            textDateEntry.setText(String.valueOf(room.getEntryDate()));
            textDateRelease.setText(String.valueOf(room.getReleaseDate()));
            textPensionPrice.setText(room.getPensionPrice().toString());

            if (room.getFeature().contains("Televizyon")){
                checkBoxTV.setSelected(true);
            }

            if (room.getFeature().contains("Minibar")){
                checkBoxMinibar.setSelected(true);
            }
            if (room.getFeature().contains("Oyun Konsolu")){
                checkBoxGameConsole.setSelected(true);
            }
            if (room.getFeature().contains("Kasa")){
                checkBoxSafe.setSelected(true);
            }
            if (room.getFeature().contains("Projeksiyon")){
                checkBoxProjection.setSelected(true);
            }





        buttonlogOut.addActionListener(e -> dispose());
        buttonUpdateRoom.addActionListener(e -> {

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

                    String roomType=comboRoomType.getSelectedItem().toString();
                    int bedroomSet=Integer.parseInt(comboBedroomSet.getSelectedItem().toString());
                    int roomStock=Integer.parseInt(spinnerRoomStock.getValue().toString());
                    double pensionPrice;
                    String pensionType=comboPensionType.getSelectedItem().toString();
                    String feature="";
                    double priceForChild;
                    double priceForAdult;
                    int space=Integer.parseInt(spinnerSpace.getValue().toString());



                    JCheckBox [] checkBox={checkBoxMinibar,checkBoxGameConsole,checkBoxProjection,checkBoxTV,checkBoxSafe};

                    for(JCheckBox checkBox1 :checkBox ) {
                        if(checkBox1.isSelected()) {
                            feature+=checkBox1.getText()+" - ";

                        }

                    }


                    while (true){

                        try{
                            priceForChild=Double.parseDouble(textRoomPriceForChild.getText().trim());
                            priceForAdult=Double.parseDouble(textRoomPriceForAdult.getText().trim());
                            pensionPrice=Double.parseDouble(textPensionPrice.getText().trim());

                        }
                        catch(Exception exc){

                            Support.showMessage("Lütfen tarih aralığını doğru giriniz!");
                            return;

                        }

                        break;


                    }


                    if (space<5) {

                        Support.showMessage("Odanın alanı en az 5 m2 olmalıdır!");

                    } else {

                        if (Room.update(room.getId(),roomType,pensionType,pensionPrice,bedroomSet,space,roomStock,feature,priceForChild,priceForAdult, dateEntry, dateRelease)) {

                            Support.showMessage("okey");
                            dispose();

                        }else {
                            Support.showMessage("error");
                        }




                    }
                }







        });



    }


    private void createUIComponents() throws ParseException {
        textDateEntry=new JFormattedTextField(new MaskFormatter("####-##-##"));
        textDateRelease=new JFormattedTextField(new MaskFormatter("####-##-##"));

    }



}
