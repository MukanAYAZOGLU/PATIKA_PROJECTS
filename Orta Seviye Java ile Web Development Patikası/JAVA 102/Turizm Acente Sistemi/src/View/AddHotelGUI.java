package View;

import Model.Hotel;
import Support.Support;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;


public class AddHotelGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JButton buttonCancel;
    private JTextField textAddHotelName;
    private JCheckBox checkBoxAddHotelFreePark;
    private JCheckBox checkBoxAddHotelFitness;
    private JCheckBox checkBoxAddHotelSwimmingPool;
    private JCheckBox checkBoxAddHotelFreeWifi;
    private JCheckBox checkBoxAddHotelConcierge;
    private JCheckBox checkBoxAddHotelSPA;
    private JCheckBox checkBoxAddHotel24HoursRoomService;
    private JComboBox comboAddHotelStars;
    private JTextField textAddtextAddHotelPhone;
    private JTextField textAddHotelMail;
    private JTextField textAddHotelCity;
    private JTextField textAddHotelRegion;
    private JTextArea textAddHotelAddress;
    private JButton buttonAddHotel;
    private JCheckBox checkUltraAll;
    private JCheckBox checkAll;
    private JCheckBox checkRoomBreakfast;
    private JCheckBox checkFullBoard;
    private JCheckBox checkHalfBoard;
    private JCheckBox checkOnlyBed;
    private JCheckBox checkFullCreditExcpAlcohol;
    private JLabel labelHotelAddWindow;


    public AddHotelGUI(Hotel hotel) {
        add(mainPanel);
        setTitle(Support.ProjectTitle );
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1350, 400);
        setLocation(Support.setLocation("x",1350), Support.setLocation("y", 400));
        setResizable(true);
        setVisible(true);

        if (hotel!=null) {

            buttonAddHotel.setText("GÜNCELLE");
            labelHotelAddWindow.setText("OTEL GÜNCELLEME PENCERESİ");

            textAddHotelName.setText(hotel.getName());
            textAddtextAddHotelPhone.setText(hotel.getPhone());
            textAddHotelMail.setText(hotel.getMail());
            textAddHotelCity.setText(hotel.getCity());
            textAddHotelRegion.setText(hotel.getRegion());
            textAddHotelAddress.setText(hotel.getAddress());
            comboAddHotelStars.setSelectedItem(hotel.getStar());


            //FEATURES
            if (hotel.getFeature().contains("Ücretsiz Otopark")) checkBoxAddHotelFreePark.setSelected(true);
            if (hotel.getFeature().contains("Vücut Geliştirme Merkezi")) checkBoxAddHotelFitness.setSelected(true);
            if (hotel.getFeature().contains("Yüzme Havuzu")) checkBoxAddHotelSwimmingPool.setSelected(true);
            if (hotel.getFeature().contains("Ücretsiz Wi-Fi")) checkBoxAddHotelFreeWifi.setSelected(true);
            if (hotel.getFeature().contains("Otel Kapıcısı")) checkBoxAddHotelConcierge.setSelected(true);
            if (hotel.getFeature().contains("SPA")) checkBoxAddHotelSPA.setSelected(true);
            if (hotel.getFeature().contains("7 / 24 Oda Servisi")) checkBoxAddHotel24HoursRoomService.setSelected(true);


            //PENSION TYPES

            if (hotel.getPensionType().contains("Ultra Her Şey Dahil")) checkUltraAll.setSelected(true);
            if (hotel.getPensionType().contains("Her Şey Dahil")) checkAll.setSelected(true);
            if (hotel.getPensionType().contains("Oda Kahvaltı")) checkRoomBreakfast.setSelected(true);
            if (hotel.getPensionType().contains("Tam Pansiyon")) checkFullBoard.setSelected(true);
            if (hotel.getPensionType().contains("Yarım Pansiyon")) checkHalfBoard.setSelected(true);
            if (hotel.getPensionType().contains("Sadece Yatak")) checkOnlyBed.setSelected(true);
            if (hotel.getPensionType().contains("Alkol Hariç Full credit")) checkFullCreditExcpAlcohol.setSelected(true);



        }




        buttonCancel.addActionListener(e -> {
            dispose();

        });
        buttonAddHotel.addActionListener(e -> {

            String name = textAddHotelName.getText().trim().toUpperCase();

            String pensionType = "";

            JCheckBox[] checkBoxesPensionTypes = {checkUltraAll, checkAll, checkRoomBreakfast, checkFullBoard, checkHalfBoard, checkOnlyBed, checkFullCreditExcpAlcohol};

            for (JCheckBox checkBox : checkBoxesPensionTypes) {

                if (checkBox.isSelected()) {
                    pensionType += checkBox.getText() + " - ";
                }

            }


            String feature = "";

            JCheckBox[] checkboxes = {checkBoxAddHotelFreePark, checkBoxAddHotelFitness, checkBoxAddHotelSwimmingPool, checkBoxAddHotelFreeWifi, checkBoxAddHotelConcierge, checkBoxAddHotelSPA, checkBoxAddHotel24HoursRoomService};


            for (JCheckBox checkBox : checkboxes) {

                if (checkBox.isSelected()) {
                    feature += checkBox.getText() + " - ";
                }

            }


            int star = comboAddHotelStars.getSelectedIndex() + 1;
            String phone = textAddtextAddHotelPhone.getText().trim();
            String mail = textAddHotelMail.getText().trim();
            String region = textAddHotelRegion.getText().trim().toUpperCase();
            String city = textAddHotelCity.getText().trim().toUpperCase();
            String address = textAddHotelAddress.getText().trim();



            if (Support.isAnyOfTheseTextFieldsEmpty(new JTextField[]{textAddHotelName, textAddtextAddHotelPhone, textAddHotelMail, textAddHotelRegion, textAddHotelCity}) || textAddHotelAddress.getText().trim().isEmpty()) {

                Support.showMessage("empty");

            } else if (!Support.isMailValid(mail)) {


                Support.showMessage("E-Posta adresiniz hatalı!");


            } else{


                    if (hotel != null) {


                        while (true){

                            for(Hotel htl :Hotel.getAll() ) {

                                if (htl.getName().equals(name) && htl.getId()!=hotel.getId()) {
                                    Support.showMessage("Aynı isimde otel mevcuttur, farklı bir isim tercih ediniz!");
                                    return;

                                }

                            }
                            break;


                        }





                        if (Hotel.update(hotel.getId(), name, pensionType, feature, star, phone, mail, region, city, address)) {

                            Support.showMessage("okey");
                            dispose();

                        } else {

                            Support.showMessage("error");
                        }


                    } else {

                        while (true){

                            for(Hotel htl :Hotel.getAll() ) {

                                if (htl.getName().equals(name)) {
                                    Support.showMessage("Aynı isimde otel mevcuttur, farklı bir isim tercih ediniz!");
                                    return;

                                }

                            }
                            break;


                        }






                            if (Hotel.add(name, pensionType, feature, star, phone, mail, region, city, address)) {

                                Support.showMessage("okey");
                                dispose();

                            } else {

                                Support.showMessage("error");
                            }




                    }


                }








        });
    }



}