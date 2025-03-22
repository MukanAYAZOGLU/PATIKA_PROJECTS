package View;

import Model.Reservation;
import Model.Room;
import Support.Support;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.sql.Date;
import java.util.ArrayList;

public class MakeReservationGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel paneTop;
    private JPanel paneBottom;
    private JButton buttonLogOut;
    private JPanel panelContactInfo;
    private JTextField textContactPhone;
    private JTextField textContactMail;
    private JPanel panelOfCustomers;
    private JButton buttonAddReservation;
    private JTextField textContactNameSurname;
    private JTextField textContactTC;
    private JTextArea textContactNote;
    private ArrayList<JLabel> listLabelTCs=new ArrayList<>();
    private ArrayList<JTextField> listTextTCs=new ArrayList<>();
    private ArrayList<JLabel> listLabelNames=new ArrayList<>();
    private ArrayList<JTextField> listTextNames=new ArrayList<>();
    private ArrayList<JPanel> listPanels=new ArrayList<>();
    private JPanel thePanel=new JPanel();
    int b=0;



    public MakeReservationGUI(int guest, int roomID, int hotelID , String  hotelName, Date entryDate, Date releaseDate,double price) {

    add(mainPanel);
    setTitle(Support.ProjectTitle);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(750,500);
    setLocation(Support.setLocation("x", 750),Support.setLocation("y",500));
    setResizable(true);
    GridLayout myLayout = new GridLayout(guest,4);
    panelOfCustomers.setLayout(myLayout);


        textContactPhone.setSize(new Dimension(250,25));
        textContactMail.setSize(new Dimension(250,25));
        textContactNameSurname.setSize(new Dimension(250,25));
        textContactTC.setSize(new Dimension(250,25));
        textContactNote.setSize(new Dimension(250,50));

        //SET CHARACTER BORDER FOR CUSTOMER TC JTEXTFIELD
        textContactTC.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null) return;
                if ((getLength() + str.length()) <= 11) {
                    super.insertString(offs, str, a);
                }
            }
        });


        //ADD JTEXTFIELD AS MANY AS GUEST
        for (int i = 0; i <guest ; i++) {

            listLabelTCs.add(new JLabel((i+1)+". Müşteri TC: "));
            listTextTCs.add(new JTextField());
            listLabelNames.add(new JLabel(" Ad Soyad: "));
            listTextNames.add(new JTextField());


            listLabelTCs.get(i).setSize(new Dimension(50,10));
            listTextTCs.get(i).setSize(new Dimension(50,10));
            listLabelNames.get(i).setSize(new Dimension(50,10));
            listTextNames.get(i).setSize(new Dimension(50,10));

            panelOfCustomers.add(listLabelTCs.get(i));
            panelOfCustomers.add(listTextTCs.get(i));
            panelOfCustomers.add(listLabelNames.get(i));
            panelOfCustomers.add(listTextNames.get(i));

        }


        setVisible(true);

        //SET CHARACTER BORDER FOR JTEXTFIELD
        for (int i = 0; i <guest ; i++) {

            listTextTCs.get(i).setDocument(new PlainDocument() {
                @Override
                public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                    if (str == null) return;
                    if ((getLength() + str.length()) <= 11) {
                        super.insertString(offs, str, a);
                    }
                }
            });




        }



        Room theRoom=Room.getRoom(roomID);






    buttonLogOut.addActionListener(e -> {
        dispose();
    });


    buttonAddReservation.addActionListener(e -> {

    while(true) {


        String name = textContactNameSurname.getText().trim();
        String TC = textContactTC.getText().trim();
        String phone = textContactPhone.getText().trim();
        String mail = textContactMail.getText().trim();
        String note = textContactNote.getText().trim();


        if (Support.isAnyOfTheseTextFieldsEmpty(new JTextField[]{textContactNameSurname, textContactNameSurname, textContactPhone, textContactMail}) || note.isEmpty()) {

            Support.showMessage("empty");
            break;


        } else if (!Support.isTCValid(TC)){

            Support.showMessage("İrtibat TC'si hatalı!");
            break;



        }else if (!Support.isMailValid(mail)) {

            Support.showMessage("E-Posta adresiniz hatalı!");
            break;


        } else {


            String customerTC=null;
            String customerNames=null;

            for (int i = 0; i < guest; i++) {

                customerNames= listTextNames.get(i).getText().trim();
                customerTC= listTextTCs.get(i).getText().trim();


                //ARE THEY EMPTY
                if (customerTC.isEmpty() || customerNames.isEmpty()) {

                    Support.showMessage("empty");
                    break;

                }else if (!Support.isTCValid(customerTC)) {

                    Support.showMessage((i+1)+". Müşterinin TC'si hatalı!");

                    break;


                }else {

                    b++;


                }

            }

            String theName="";
            String theTC="";

            if (b==guest){

                for (int i = 0; i < guest; i++) {

                    theName += listTextNames.get(i).getText().trim() + " - ";
                    theTC += listTextTCs.get(i).getText().trim() + " - ";
                }


                    if (Reservation.add(theTC,theName,TC,name,mail,phone,note,price, entryDate,releaseDate,roomID,hotelID,hotelName ,theRoom.getRoomType(), theRoom.getRegion(), theRoom.getCity())) {

                            Support.showMessage("okey");

                            if (Room.reduceRoomStock(roomID, theRoom.getRoomStock())) {


                            }else Support.showMessage("Rezervasyon yapılan odanın stok adedini azaltmada sorun oluştu!");


                    } else Support.showMessage("error");

                dispose();



                break;


            }else break;









        }

    }




    });












    }

    public static void main(String[] args) {
        new MakeReservationGUI(2,1,1,null,null,null,1010);
    }


}
