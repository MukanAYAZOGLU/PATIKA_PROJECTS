package View;

import Model.*;
import Support.Support;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class PersonelGUI extends JFrame {
    private JPanel mainPanel;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JLabel labelWelcome;
    private JButton buttonPricingRoom;
    private JButton buttonAddRoom;
    private JButton buttonAddHotel;
    private JButton buttonLogOut;
    private JTable tableHotels;
    private JPanel panelHotels;
    private JPanel panelRooms;
    private JTable tableRooms;
    private JComboBox comboSearchHotelCity;
    private JComboBox comboSearchHotelRegion;
    private JComboBox comboSearchHotelStar;
    private JComboBox comboSearchHotelPensionType;
    private JButton buttonClearHotel;
    private JButton buttonAddReservation;
    private JTextField textSearchHotelName;
    private JButton buttonSearchHotel;
    private JTable tableReservations;
    private JPanel panelReservations;
    private JComboBox comboSearchRoomType;
    private JComboBox comboSearchRoomBedroomSet;
    private JComboBox comboSearchRoomRegion;
    private JComboBox comboSearchRoomStar;
    private JComboBox comboSearchRoomCity;
    private JButton buttonClearRoom;
    private JButton buttonSearchRoom;
    private JTextField textSearchRoomHotelName;
    private JPanel panelSearchHotel;
    private JComboBox comboSearchRoomStock;
    private JTable tablePensionTypes;
    private JTable tablePeriods;
    private JTable tableHotelFeatures;
    private JTable tableRoomFatures;
    private JComboBox comboSearchPensionType;
    private JButton buttonPricePensionTypes;
    private JTextField textSearchReservationHotelName;
    private JTextField textSearchReservationNameSurname;
    private JButton buttonSearchReservation;
    private JButton buttonClearReservation;
    private JComboBox comboSearchReserRoomType;
    private JComboBox comboSearchReserRegion;
    private JComboBox comboSearchReserCity;
    private JTextField textSearchReservationEntryDate;
    private JTextField textSearchReservationReleaseDate;
    private JPanel panelSearchReser;
    private JTextField textSearchReservationNote;
    private JTable tableCustomerInformations;
    private JSpinner spinnerSearchRoomStock;
    private DefaultTableModel modelHotels = new DefaultTableModel();
    private Object[] rowsHotels;
    private DefaultTableModel modelRooms = new DefaultTableModel();
    private Object[] rowsRooms;
    private JPopupMenu popupHotels = new JPopupMenu();
    private JPopupMenu popupRooms = new JPopupMenu();
    private DefaultTableModel modelPensionTypes = new DefaultTableModel();
    private Object[] rowsPensionTypes;
    private DefaultTableModel modelPeriod = new DefaultTableModel();
    private Object[] rowsPeriod;
    private DefaultTableModel modelHotelFeatures = new DefaultTableModel();
    private Object[] rowsHotelFeatures;
    private DefaultTableModel modelRoomFeatures = new DefaultTableModel();
    private Object[] rowsRoomFeatures;
    private DefaultTableModel modelReservations = new DefaultTableModel();
    private Object[] rowsReservations;
    private JPopupMenu popupReservations = new JPopupMenu();
    private DefaultTableModel modelContactc = new DefaultTableModel();
    private Object[] rowsContact;

    public PersonelGUI(User user) {
        add(mainPanel);
        setTitle(Support.ProjectTitle + " - PERSONEL");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1275, 500);
        setLocation(Support.setLocation("x", 1275), Support.setLocation("y", 500));
        setResizable(true);
        setVisible(true);


        labelWelcome.setText("Hoş Geldiniz " + user.getName() + " " + user.getSurname());

        buttonLogOut.addActionListener(e -> {

            dispose();
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.setVisible(true);
        });


        //HOTEL

        loadCombosOfSearchHotel();

        comboSearchHotelCity.setSelectedItem(null);
        comboSearchHotelRegion.setSelectedItem(null);
        comboSearchHotelStar.setSelectedItem(null);
        comboSearchHotelPensionType.setSelectedItem(null);

        //HOTEL BUTTONS

        buttonAddHotel.addActionListener(e -> {

            AddHotelGUI addHotelGUI = new AddHotelGUI(null);
            addHotelGUI.setVisible(true);
            addHotelGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadTableHotels();
                    loadCombosOfSearchHotel();
                    clearTablePeriods();
                    clearTablePensionTypes();
                    clearTableHotelFeatures();

                }
            });


        });
        buttonClearHotel.addActionListener(e -> {


            textSearchHotelName.setText(null);
            comboSearchHotelCity.setSelectedItem(null);
            comboSearchHotelRegion.setSelectedItem(null);
            comboSearchHotelStar.setSelectedItem(null);
            comboSearchHotelPensionType.setSelectedItem(null);

            loadTableHotels();
            clearTablePeriods();
            clearTablePensionTypes();
            clearTableHotelFeatures();

        });
        buttonSearchHotel.addActionListener(e -> {

            String hotelName = textSearchHotelName.getText();


            String city = Support.comboReturnStringOrNull(comboSearchHotelCity);
            String region = Support.comboReturnStringOrNull(comboSearchHotelRegion);
            String star = Support.comboReturnStringOrNull(comboSearchHotelStar);
            String pensionType = Support.comboReturnStringOrNull(comboSearchHotelPensionType);


            loadTableHotels(Hotel.search(hotelName, pensionType, star, region, city));

            clearTablePeriods();
            clearTablePensionTypes();
            clearTableHotelFeatures();

        });


        loadCombosOfSearchRoom();

        //ROOM

        comboSearchRoomCity.setSelectedItem(null);
        comboSearchRoomRegion.setSelectedItem(null);
        comboSearchRoomStar.setSelectedItem(null);
        comboSearchRoomBedroomSet.setSelectedItem(null);
        comboSearchRoomType.setSelectedItem(null);
        comboSearchRoomStock.setSelectedItem(null);
        comboSearchPensionType.setSelectedItem(null);


        //ROOM BUTTONS

        buttonAddRoom.addActionListener(e -> {
            AddRoomGUI addRoomGUI = new AddRoomGUI(null);
            addRoomGUI.setVisible(true);

            addRoomGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadTableRooms();
                    clearTableRoomFeatures();
                    loadCombosOfSearchRoom();

                }
            });

        });
        buttonClearRoom.addActionListener(e -> {

            textSearchRoomHotelName.setText(null);
            comboSearchRoomCity.setSelectedItem(null);
            comboSearchRoomRegion.setSelectedItem(null);
            comboSearchRoomStar.setSelectedItem(null);
            comboSearchRoomBedroomSet.setSelectedItem(null);
            comboSearchRoomType.setSelectedItem(null);
            comboSearchRoomStock.setSelectedItem(null);
            comboSearchPensionType.setSelectedItem(null);



            loadTableRooms();
            clearTableRoomFeatures();
            clearTablePeriods();

        });
        buttonSearchRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hotelName = textSearchRoomHotelName.getText();
                String city = Support.comboReturnStringOrNull(comboSearchRoomCity);
                String region = Support.comboReturnStringOrNull(comboSearchRoomRegion);
                String star = Support.comboReturnStringOrNull(comboSearchRoomStar);
                String pensionType = Support.comboReturnStringOrNull(comboSearchPensionType);
                String bedroomSet = Support.comboReturnStringOrNull(comboSearchRoomBedroomSet);
                String roomType = Support.comboReturnStringOrNull(comboSearchRoomType);
                int stock = 0;
                //Date dateEntry=Date.valueOf(textSearchRoomPeriodEntry.getText());
                //Date dateRelease=Date.valueOf(textSearchRoomPeriodRelease.getText());


                if (comboSearchRoomStock.getSelectedItem() != null) {
                    stock = comboSearchRoomStock.getSelectedIndex() + 1;
                }


                loadTableRooms(Room.search(hotelName, star, roomType, pensionType, stock, bedroomSet, region, city));
                clearTableRoomFeatures();


            }
        });


        //PRICE ROOM BUTTON

        /*

        buttonPricePensionTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PriceHotelGUI priceHotelGUI = new PriceHotelGUI(null);
                priceHotelGUI.setVisible(true);
                priceHotelGUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        clearTablePensionTypes();

                    }
                });

            }
        });

         */


        loadCombosOfSearchReservation();

        //RESERVATION

        //textSearchReservationEntryDate.setText(null);
        //textSearchReservationReleaseDate.setText(null);
        textSearchReservationHotelName.setText(null);
        textSearchReservationNameSurname.setText(null);
        comboSearchReserCity.setSelectedItem(null);
        comboSearchReserRegion.setSelectedItem(null);
        comboSearchReserRoomType.setSelectedItem(null);
        textSearchReservationNote.setText(null);

        //RESERVATION BUTTONS


        buttonAddReservation.addActionListener(e -> {
            SearchRoomForReservationGUI searchRoomForReservationGUI =new SearchRoomForReservationGUI();
            searchRoomForReservationGUI.setVisible(true);
            searchRoomForReservationGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadTableReservations();
                    loadTableRooms();
                    clearTablePeriods();
                    clearTableRoomFeatures();
                    clearTableContactInfo();

                }
            });

        });
        buttonClearReservation.addActionListener(e -> {

            //textSearchReservationEntryDate.setText(null);
            //textSearchReservationReleaseDate.setText(null);
            textSearchReservationHotelName.setText(null);
            textSearchReservationNameSurname.setText(null);
            comboSearchReserCity.setSelectedItem(null);
            comboSearchReserRegion.setSelectedItem(null);
            comboSearchReserRoomType.setSelectedItem(null);
            textSearchReservationNote.setText(null);


            loadTableReservations();
            clearTableContactInfo();


        });
        buttonSearchReservation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hotelName = textSearchReservationHotelName.getText().trim();
                String nameSurname=textSearchReservationNameSurname.getText().trim();
                String region=Support.comboReturnStringOrNull(comboSearchReserRegion);
                String city=Support.comboReturnStringOrNull(comboSearchReserCity);
                String roomType=Support.comboReturnStringOrNull(comboSearchReserRoomType);
                String note=textSearchReservationNote.getText().trim();
                //String entryDate=textSearchReservationEntryDate.getText();
                //String releaseDate=textSearchReservationReleaseDate.getText();



                loadTableReservations(Reservation.search(nameSurname,hotelName,note,roomType,region,city));
                clearTableContactInfo();





            }
        });


        setTableHotels();
        setTableRooms();
        setTableReservations();
        setTablePensionTypes();
        setTablePeriod();
        setTableHotelFeatures();
        setTableRoomFeatures();
        setTableCustomerInformations();


        setJPopupMenuHotels(popupHotels);
        setJPopupMenuRooms(popupRooms);
        setJPopupMenuReservations(popupReservations);



    }


    //SET TABLES

    public void setTableHotels() {

        Object[] columnsHotel = {"ID", "OTEL ADI", "YILDIZ ADEDİ", "TELEFON", "E-POSTA", "BÖLGE", "ŞEHİR", "ADRES"};
        modelHotels.setColumnIdentifiers(columnsHotel);
        rowsHotels = new Object[columnsHotel.length];


        loadTableHotels();

        tableHotels.getColumnModel().getColumn(0).setMaxWidth(40);
        tableHotels.getTableHeader().setReorderingAllowed(false);
        tableHotels.getTableHeader().setResizingAllowed(true);
        tableHotels.setEnabled(true);


    }

    public void setTableRooms() {
        Object[] columnsRoom = {"ID", "OTEL ID","OTEL ADI", "YILDIZ ADEDİ", "ODA TİPİ", "PANSİYON TİPİ", "PANSİYON FİYATI","YATAK SAYISI", "ALAN(m2)", "ODA STOĞU", "ÇOCUK FİYATI", "YETİŞKİN FİYATI"};
        modelRooms.setColumnIdentifiers(columnsRoom);
        rowsRooms = new Object[columnsRoom.length];


        loadTableRooms();


        tableRooms.getColumnModel().getColumn(0).setMaxWidth(40);
        tableRooms.getTableHeader().setReorderingAllowed(false);
        tableRooms.getTableHeader().setResizingAllowed(true);
        tableRooms.setEnabled(true);

        tableRooms.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int selectedRow = tableRooms.rowAtPoint(e.getPoint());
                tableRooms.setRowSelectionInterval(selectedRow, selectedRow);

            }

        });


    }

    public void setTableReservations() {
        Object[] columnsReservations = {"ID", "ODA ID","OTEL ID", "OTEL ADI", "İRTİBAT AD SOYAD","İRTİBAT TC", "REZERVASYON NOTU","ÜCRET"};
        modelReservations.setColumnIdentifiers(columnsReservations);
        rowsReservations = new Object[columnsReservations.length];



        loadTableReservations();


        tableReservations.getColumnModel().getColumn(0).setMaxWidth(40);
        tableReservations.getTableHeader().setReorderingAllowed(false);
        tableReservations.getTableHeader().setResizingAllowed(true);
        tableReservations.setEnabled(true);

        tableReservations.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int selectedRow = tableReservations.rowAtPoint(e.getPoint());
                tableReservations.setRowSelectionInterval(selectedRow, selectedRow);

            }

        });


    }

    public void setTablePensionTypes() {

        Object[] columnsPensionTypes = {"OTEL ID", "PANSİYON TİPLERİ"};
        modelPensionTypes.setColumnIdentifiers(columnsPensionTypes);
        rowsPensionTypes = new Object[columnsPensionTypes.length];

        clearTablePensionTypes();


        tablePensionTypes.getColumnModel().getColumn(0).setMaxWidth(70);
        tablePensionTypes.getTableHeader().setReorderingAllowed(false);
        tablePensionTypes.getTableHeader().setResizingAllowed(true);
        tablePensionTypes.setEnabled(true);


        tableHotels.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int selectedRow = tableHotels.rowAtPoint(e.getPoint());
                tableHotels.setRowSelectionInterval(selectedRow, selectedRow);

                int i = Integer.parseInt(tableHotels.getValueAt(selectedRow, 0).toString());

                loadTablePensionTypes(i);

            }

        });


    }

    public void setTablePeriod() {

        Object[] columnsPeriodInformation = {"OTEL ID", "BAŞLANGIÇ DÖNEMİ", "BİTİŞ DÖNEMİ"};
        modelPeriod.setColumnIdentifiers(columnsPeriodInformation);
        rowsPeriod = new Object[columnsPeriodInformation.length];


        clearTablePeriods();


        tablePeriods.getColumnModel().getColumn(0).setMaxWidth(70);
        tablePeriods.getTableHeader().setReorderingAllowed(false);
        tablePeriods.getTableHeader().setResizingAllowed(false);
        tablePeriods.setEnabled(true);


        tableRooms.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int selectedRow = tableRooms.rowAtPoint(e.getPoint());
                tableRooms.setRowSelectionInterval(selectedRow, selectedRow);

                int i = Integer.parseInt(tableRooms.getValueAt(selectedRow, 0).toString());

                loadTablePeriod(i);

            }

        });


    }

    public void setTableHotelFeatures() {

        Object[] columnsHotelFeatures = {"OTEL ID", "OTEL ÖZELLİKLERİ"};
        modelHotelFeatures.setColumnIdentifiers(columnsHotelFeatures);
        rowsHotelFeatures = new Object[columnsHotelFeatures.length];

        clearTableHotelFeatures();


        tableHotelFeatures.getColumnModel().getColumn(0).setMaxWidth(70);
        tableHotelFeatures.getTableHeader().setReorderingAllowed(false);
        tableHotelFeatures.getTableHeader().setResizingAllowed(false);
        tableHotelFeatures.setEnabled(true);


        tableHotels.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int selectedRow = tableHotels.rowAtPoint(e.getPoint());
                tableHotels.setRowSelectionInterval(selectedRow, selectedRow);

                int i = Integer.parseInt(tableHotels.getValueAt(selectedRow, 0).toString());

                loadTableHotelFeatures(i);

            }

        });


    }

    public void setTableRoomFeatures() {

        Object[] columnsRoomFeatures = {"ODA ID", "ODA ÖZELLİKLERİ"};
        modelRoomFeatures.setColumnIdentifiers(columnsRoomFeatures);
        rowsRoomFeatures = new Object[columnsRoomFeatures.length];


        clearTableRoomFeatures();

        tableRoomFatures.getColumnModel().getColumn(0).setMaxWidth(70);
        tableRoomFatures.getTableHeader().setReorderingAllowed(false);
        tableRoomFatures.getTableHeader().setResizingAllowed(false);
        tableRoomFatures.setEnabled(true);


        tableRooms.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int selectedRow = tableRooms.rowAtPoint(e.getPoint());
                tableRooms.setRowSelectionInterval(selectedRow, selectedRow);

                int i = Integer.parseInt(tableRooms.getValueAt(selectedRow, 0).toString());

                loadTableRoomFeatures(i);

            }

        });


    }

    public void setTableCustomerInformations() {

        Object[] columnsPensionTypes = {"ODA ID","MİSAFİR AD SOYAD","MİSAFİR TC","İRTİBAT E-POSTA","İRTİBAT TELEFON","GİRİŞ TARİHİ","ÇIKIŞ TARİHİ"};
        modelContactc.setColumnIdentifiers(columnsPensionTypes);
        rowsContact = new Object[columnsPensionTypes.length];


        clearTableContactInfo();

        tableCustomerInformations.getColumnModel().getColumn(0).setMaxWidth(70);
        tableCustomerInformations.getTableHeader().setReorderingAllowed(false);
        tableCustomerInformations.getTableHeader().setResizingAllowed(true);
        tableCustomerInformations.setEnabled(true);


        tableReservations.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                int selectedRow = tableReservations.rowAtPoint(e.getPoint());
                tableReservations.setRowSelectionInterval(selectedRow, selectedRow);

                int i = Integer.parseInt(tableReservations.getValueAt(selectedRow, 0).toString());

                loadTableCustomerInfo(i);

            }

        });


    }



    //LOAD TABLES

    public void loadTableHotels() {
        DefaultTableModel clear = (DefaultTableModel) tableHotels.getModel();
        clear.setRowCount(0);
        int i;

        for (Hotel hotel : Hotel.getAll()) {
            i = 0;
            rowsHotels[i++] = hotel.getId();
            rowsHotels[i++] = hotel.getName();
            rowsHotels[i++] = hotel.getStar();
            rowsHotels[i++] = hotel.getPhone();
            rowsHotels[i++] = hotel.getMail();
            rowsHotels[i++] = hotel.getRegion();
            rowsHotels[i++] = hotel.getCity();
            rowsHotels[i++] = hotel.getAddress();
            modelHotels.addRow(rowsHotels);

        }
        tableHotels.setModel(modelHotels);
    }

    public void loadTableRooms() {
        DefaultTableModel clear = (DefaultTableModel) tableRooms.getModel();
        clear.setRowCount(0);
        int i;

        for (Room room : Room.getRooms()) {
            i = 0;
            rowsRooms[i++] = room.getId();
            rowsRooms[i++] = room.getHotelID();
            rowsRooms[i++] = room.getHotelName();
            rowsRooms[i++] = room.getStar();
            rowsRooms[i++] = room.getRoomType();
            rowsRooms[i++] = room.getPensionType();
            rowsRooms[i++] = room.getPensionPrice();
            rowsRooms[i++] = room.getBedroomSet();
            rowsRooms[i++] = room.getSpace();
            rowsRooms[i++] = room.getRoomStock();
            rowsRooms[i++] = room.getPriceForChild();
            rowsRooms[i++] = room.getPriceForAdult();






            modelRooms.addRow(rowsRooms);

        }
        tableRooms.setModel(modelRooms);


    }

    public void loadTableReservations() {
        DefaultTableModel clear = (DefaultTableModel) tableReservations.getModel();
        clear.setRowCount(0);
        int i;

        for (Reservation reservation : Reservation.getReservations()) {
            i = 0;
            rowsReservations[i++] = reservation.getId();
            rowsReservations[i++] = reservation.getRoomID();
            rowsReservations[i++] = reservation.getHotelID();
            rowsReservations[i++] = reservation.getHotelName();
            rowsReservations[i++] = reservation.getContactPersonName();
            rowsReservations[i++] = reservation.getContactTC();
            rowsReservations[i++] = reservation.getNote();
            rowsReservations[i++] = reservation.getPrice();

            modelReservations.addRow(rowsReservations);

        }
        tableReservations.setModel(modelReservations);


    }

    public void loadTableReservations(ArrayList<Reservation> reservations) {
        DefaultTableModel clear = (DefaultTableModel) tableReservations.getModel();
        clear.setRowCount(0);
        int i;

        for (Reservation reservation : reservations) {
            i = 0;
            rowsReservations[i++] = reservation.getId();
            rowsReservations[i++] = reservation.getRoomID();
            rowsReservations[i++] = reservation.getHotelID();
            rowsReservations[i++] = reservation.getHotelName();
            rowsReservations[i++] = reservation.getContactPersonName();
            rowsReservations[i++] = reservation.getContactTC();
            rowsReservations[i++] = reservation.getNote();
            rowsReservations[i++] = reservation.getPrice();


            modelReservations.addRow(rowsReservations);


        }
        tableReservations.setModel(modelReservations);


    }

    public void loadTableHotels(ArrayList<Hotel> hotels) {

        DefaultTableModel clear = (DefaultTableModel) tableHotels.getModel();
        clear.setRowCount(0);
        int i;

        for (Hotel hotel : hotels) {
            i = 0;
            rowsHotels[i++] = hotel.getId();
            rowsHotels[i++] = hotel.getName();
            rowsHotels[i++] = hotel.getStar();
            rowsHotels[i++] = hotel.getPhone();
            rowsHotels[i++] = hotel.getMail();
            rowsHotels[i++] = hotel.getRegion();
            rowsHotels[i++] = hotel.getCity();
            rowsHotels[i++] = hotel.getAddress();
            modelHotels.addRow(rowsHotels);

        }
        tableHotels.setModel(modelHotels);
    }

    public void loadTableRooms(ArrayList<Room> rooms) {
        DefaultTableModel clear = (DefaultTableModel) tableRooms.getModel();
        clear.setRowCount(0);
        int i;

        for (Room room : rooms) {
            i = 0;
            rowsRooms[i++] = room.getId();
            rowsRooms[i++] = room.getHotelID();
            rowsRooms[i++] = room.getHotelName();
            rowsRooms[i++] = room.getStar();
            rowsRooms[i++] = room.getRoomType();
            rowsRooms[i++] = room.getPensionType();
            rowsRooms[i++] = room.getPensionPrice();
            rowsRooms[i++] = room.getBedroomSet();
            rowsRooms[i++] = room.getSpace();
            rowsRooms[i++] = room.getRoomStock();
            rowsRooms[i++] = room.getPriceForChild();
            rowsRooms[i++] = room.getPriceForAdult();

            modelRooms.addRow(rowsRooms);

        }
        tableRooms.setModel(modelRooms);


    }

    public void loadTablePensionTypes(int p) {
        DefaultTableModel clear = (DefaultTableModel) tablePensionTypes.getModel();
        clear.setRowCount(0);

        Hotel hotel = Hotel.getHotel(p);
        //Price price = Price.getPrice(hotel.getId());
        String[] pensionTypes = hotel.getPensionType().split(" - ");


        int i;

        for (String pens : pensionTypes) {
            i = 0;
            rowsPensionTypes[i++] = hotel.getId();
            rowsPensionTypes[i++] = pens;

            /*
            if (price!=null) {
                if (pens.equals("Ultra Her Şey Dahil")) {rowsPensionTypes[i++] = price.getUltraAll();
                }else if (pens.equals("Her Şey Dahil")) {rowsPensionTypes[i++] = price.getAllThings();
                }else if(pens.equals("Oda Kahvaltı")){rowsPensionTypes[i++]=price.getRoomBreakfast();
                }else if (pens.equals("Tam Pansiyon")){rowsPensionTypes[i++]=price.getFullBoard();
                }else if (pens.equals("Yarım Pansiyon")){rowsPensionTypes[i++]=price.getHalfBoard();
                }else if (pens.equals("Sadece Yatak")) { rowsPensionTypes[i++] = price.getOnlyBed();
                }else if (pens.equals("Alkol Hariç Full Credit")){rowsPensionTypes[i++]=price.getFullCreditExcpAlcohol();
                }

            }
             */



            modelPensionTypes.addRow(rowsPensionTypes);

        }




        tablePensionTypes.setModel(modelPensionTypes);


    }

    public void loadTableCustomerInfo(int p) {
        DefaultTableModel clear = (DefaultTableModel) tableCustomerInformations.getModel();
        clear.setRowCount(0);

        Reservation reservation = Reservation.getReservation(p);

        String theNames=reservation.getNameSurname();
        String theTC=reservation.getTC();

        String [] names=theNames.split(" - ");
        String [] TC=theTC.split(" - ");

        int i;

        for (int a = 0; a <names.length ; a++) {

            i= 0;

            rowsContact[i++] = reservation.getRoomID();
            rowsContact[i++] = names[a];
            rowsContact[i++] = TC[a];
            rowsContact[i++] = reservation.getMail();
            rowsContact[i++] = reservation.getPhone();
            rowsContact[i++] = reservation.getEntryDate();
            rowsContact[i++] = reservation.getReleaseDate();


            modelContactc.addRow(rowsContact);



        }




        tableCustomerInformations.setModel(modelContactc);


    }

    public void loadTablePeriod(int p){
        DefaultTableModel clear=(DefaultTableModel) tablePeriods.getModel();
        clear.setRowCount(0);

        Room room=Room.getRoom(p);

        int i=0;

        rowsPeriod[i++] = room.getId();
        rowsPeriod[i++] = room.getEntryDate();
        rowsPeriod[i++] = room.getReleaseDate();


            modelPeriod.addRow(rowsPeriod);



        tablePeriods.setModel(modelPeriod);


    }

    public void loadTableHotelFeatures(int p){
        DefaultTableModel clear=(DefaultTableModel) tableHotelFeatures.getModel();
        clear.setRowCount(0);

        Hotel hotel=Hotel.getHotel(p);

        String [] features=hotel.getFeature().split(" - ");


        int i;

        for(String feature :features ) {
            i=0;

            rowsHotelFeatures[i++]=hotel.getId();
            rowsHotelFeatures[i]=feature;
            modelHotelFeatures.addRow(rowsHotelFeatures);

        }




        tableHotelFeatures.setModel(modelHotelFeatures);


    }

    public void loadTableRoomFeatures(int p){
        DefaultTableModel clear=(DefaultTableModel) tableRoomFatures.getModel();
        clear.setRowCount(0);

        Room room=Room.getRoom(p);

        assert room != null;
        String [] feature = room.getFeature().split(" - ");


        int i;

        for(String fea :feature ) {
            i=0;

            rowsRoomFeatures[i++]=room.getId();
            rowsRoomFeatures[i++]=fea;
            modelRoomFeatures.addRow(rowsRoomFeatures);

        }




        tableRoomFatures.setModel(modelRoomFeatures);


    }




    //CLEAR TABLES


    public void clearTablePensionTypes(){
        DefaultTableModel clear=(DefaultTableModel) tablePensionTypes.getModel();
        clear.setRowCount(0);

        tablePensionTypes.setModel(modelPensionTypes);

    }

    public void clearTableHotelFeatures(){
        DefaultTableModel clear=(DefaultTableModel) tableHotelFeatures.getModel();
        clear.setRowCount(0);

        tableHotelFeatures.setModel(modelHotelFeatures);



    }

    public void clearTableRoomFeatures(){
        DefaultTableModel clear=(DefaultTableModel) tableRoomFatures.getModel();
        clear.setRowCount(0);

        tableRoomFatures.setModel(modelRoomFeatures);



    }

    public void clearTableContactInfo(){
        DefaultTableModel clear=(DefaultTableModel) tableCustomerInformations.getModel();
        clear.setRowCount(0);

        tableCustomerInformations.setModel(modelContactc);

    }

    public void clearTablePeriods(){
        DefaultTableModel clear=(DefaultTableModel) tablePeriods.getModel();
        clear.setRowCount(0);

        tablePeriods.setModel(modelPeriod);



    }

    public void clearHotel(){
        textSearchHotelName.setText(null);
        comboSearchHotelCity.setSelectedItem(null);
        comboSearchHotelRegion.setSelectedItem(null);
        comboSearchHotelStar.setSelectedItem(null);
        comboSearchHotelPensionType.setSelectedItem(null);

        loadTableHotels();
    }


    //SET JPOPUP MENUS

    public void setJPopupMenuHotels(JPopupMenu popupMenu) {


        popupMenu.add("Oda Ekle").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{


                    int id=Integer.parseInt(tableHotels.getValueAt(tableHotels.getSelectedRow(), 0).toString());

                    Hotel hotel=Hotel.getHotel(id);

                    AddRoomGUI addRoomGUI =new AddRoomGUI(hotel);
                    addRoomGUI.setVisible(true);
                    addRoomGUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadTableRooms();
                            clearTableRoomFeatures();

                        }
                    });


                    }
                catch(Exception exc){

                    Support.showMessage("Lütfen satır seçiniz!");



                        }

            }
        });

       /*

        popupMenu.add("Pansiyon Tipi Fiyatlandır").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    int id=Integer.parseInt(tableHotels.getValueAt(tableHotels.getSelectedRow(), 0).toString());

                    Hotel hotel=Hotel.getHotel(id);

                    PriceHotelGUI priceHotelGUI =new PriceHotelGUI(hotel);
                    priceHotelGUI.setVisible(true);
                    priceHotelGUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadTablePensionTypes(id);
                        }
                    });

                }
                catch(Exception exc){
                    System.out.println(exc.getMessage());

                    Support.showMessage("Lütfen satır seçiniz!");


                }


            }
        });

        */

        popupMenu.add("Güncelle").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    int id=Integer.parseInt(tableHotels.getValueAt(tableHotels.getSelectedRow(), 0).toString());

                    Hotel hotel=Hotel.getHotel(id);

                    AddHotelGUI addHotelGUI =new AddHotelGUI(hotel);
                    addHotelGUI.setVisible(true);
                    addHotelGUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadCombosOfSearchHotel();
                            clearHotel();
                            clearTablePeriods();
                            clearTablePensionTypes();
                            clearTableHotelFeatures();

                        }
                    });

                }
                catch(Exception exc){

                    System.out.println("Lütfen satır seçiniz!");

                }






            }
        });
        popupMenu.add("Sil").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    int id=Integer.parseInt(tableHotels.getValueAt(tableHotels.getSelectedRow(), 0).toString());

                    if (Support.confirm("Bu otel ile bu otele ait odalar ile rezervasyonlar da silinecektir. Devam etmek istediğinize emin misiniz?")){

                            if (Reservation.deleteByHotelID(id)){
                                loadTableReservations();
                                loadCombosOfSearchReservation();

                            }else {
                                Support.showMessage("Bu otele ait rezervasyonları silme işleminde hata oluştu!");
                            }


                            if (Room.deleteByHotelID(id)){

                                Support.showMessage("Bu otele ait odalar silinmiştir.");
                                loadTableRooms();
                                loadCombosOfSearchRoom();
                                clearTableRoomFeatures();
                                clearTablePeriods();

                            }else{
                                Support.showMessage("Bu otele ait odaları silme işleminde hata oluştu!");

                            }


                            if (Hotel.delete(id)){

                                Support.showMessage("okey");
                                loadCombosOfSearchHotel();
                                clearHotel();
                                clearTablePensionTypes();
                                clearTableHotelFeatures();


                            }else {
                                Support.showMessage("error");
                            }





                    }else {

                        Support.showMessage("cancel");
                    }



                }
                catch(Exception exc){

                    Support.showMessage("Lütfen satır seçiniz!");


                }

            }
        });

        tableHotels.setComponentPopupMenu(popupMenu);



    }

    public void setJPopupMenuRooms(JPopupMenu popupMenu) {



        popupMenu.add("Rezervasyon Yap").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    int id=Integer.parseInt(tableRooms.getValueAt(tableRooms.getSelectedRow(), 0).toString());

                    Room room=Room.getRoom(id);

                    PopUpMenuMakeReservationGUI popupMenu =new PopUpMenuMakeReservationGUI(room,room.getEntryDate(),room.getReleaseDate());
                    popupMenu.setVisible(true);
                    popupMenu.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {

                            loadTableRooms();
                            loadTableReservations();
                            loadCombosOfSearchReservation();
                            clearTableContactInfo();




                        }
                    });




                }
                catch(Exception exc){

                    Support.showMessage("Lütfen satır seçiniz!");
                    System.out.println(exc.getMessage());


                }

            }
        });
        popupMenu.add("Güncelle").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    int id=Integer.parseInt(tableRooms.getValueAt(tableRooms.getSelectedRow(), 0).toString());

                    Room room=Room.getRoom(id);

                    UpdateRoomGUI updateRoomGUI =new UpdateRoomGUI(room);
                    updateRoomGUI.setVisible(true);
                    updateRoomGUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            clearTableRoomFeatures();
                            loadTableRooms();
                            clearTablePeriods();
                            loadCombosOfSearchReservation();
                        }
                    });

                }
                catch(Exception exc){

                    Support.showMessage("Lütfen satır seçiniz!");
                    System.out.println(exc.getMessage());


                }






            }
        });
        popupMenu.add("Sil").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    int id=Integer.parseInt(tableRooms.getValueAt(tableRooms.getSelectedRow(), 0).toString());

                    if (Support.confirm("Bu oda ile bu odaya ait rezervasyonlar da silinecektir. Devam etmek istediğinize emin misiniz?")){

                        if (Reservation.deleteByHotelID(id)){

                            loadTableReservations();
                            loadCombosOfSearchReservation();
                        }else {
                            Support.showMessage("Bu otele ait rezervasyonları silme işleminde hata oluştu!");
                        }


                        if (Room.deleteByHotelID(id)){

                            Support.showMessage("Bu otele ait odalar silinmiştir.");
                            loadTableRooms();
                            loadCombosOfSearchRoom();
                            clearTableRoomFeatures();
                            clearTablePeriods();

                        }else{
                            Support.showMessage("Bu otele ait odaları silme işleminde hata oluştu!");

                        }

                    }else {

                        Support.showMessage("cancel");
                    }



                }
                catch(Exception exc){

                    Support.showMessage("Lütfen satır seçiniz!");



                }

            }
        });



        tableRooms.setComponentPopupMenu(popupMenu);


    }

    public void setJPopupMenuReservations(JPopupMenu popupMenu) {

        /*

        popupMenu.add("Güncelle").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    int id=Integer.parseInt(tableReservations.getValueAt(tableReservations.getSelectedRow(), 0).toString());

                    Reservation reservation=Reservation.getReservation(id);

                    /*

                    UpdateRoomGUI updateRoomGUI =new UpdateRoomGUI(room);
                    updateRoomGUI.setVisible(true);
                    updateRoomGUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            clearTableRoomFeatures();
                            loadTableRooms();
                        }
                    });



    }
                catch(Exception exc){

        Support.showMessage("Lütfen satır seçiniz!");
        System.out.println(exc.getMessage());


    }






}
        });


 */


        popupMenu.add("Sil").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    int id=Integer.parseInt(tableReservations.getValueAt(tableReservations.getSelectedRow(), 0).toString());

                    Reservation reservation=Reservation.getReservation(id);

                    if (Support.confirm("confirm")){

                        if (Reservation.delete(id)){

                            loadTableReservations();
                            loadCombosOfSearchReservation();
                            clearTableContactInfo();
                            loadTableRooms();
                            clearTableRoomFeatures();
                            clearTablePeriods();

                            Room.increaseRoomStock(reservation.getRoomID(),Room.getRoom(reservation.getRoomID()).getRoomStock());



                            Support.showMessage("okey");
                        }else {
                            Support.showMessage("error");
                        }



                    }else {

                        Support.showMessage("cancel");
                    }



                }
                catch(Exception exc){

                    Support.showMessage("Lütfen satır seçiniz!");



                }

            }
        });



        tableReservations.setComponentPopupMenu(popupMenu);


    }




    //LOAD COMBOS
    public void loadCombosOfSearchHotel(){

        comboSearchHotelCity.removeAllItems();
        comboSearchHotelRegion.removeAllItems();

        for(Hotel hotel :Hotel.getAll() ) {


            if (!Support.isComboBoxContains(comboSearchHotelCity, hotel.getCity())) {
                comboSearchHotelCity.addItem(hotel.getCity());

            }
            if (!Support.isComboBoxContains(comboSearchHotelRegion, hotel.getRegion())) {
                comboSearchHotelRegion.addItem(hotel.getRegion());
            }


        }


        comboSearchHotelCity.setSelectedItem(null);
        comboSearchHotelRegion.setSelectedItem(null);


    }

    public void loadCombosOfSearchRoom(){

        comboSearchRoomCity.removeAllItems();
        comboSearchRoomRegion.removeAllItems();

        for(Room room :Room.getRooms() ) {


            if (!Support.isComboBoxContains(comboSearchRoomCity, room.getCity())) {
                comboSearchRoomCity.addItem(room.getCity());
            }


            if (!Support.isComboBoxContains(comboSearchRoomRegion, room.getRegion())) {

                comboSearchRoomRegion.addItem(room.getRegion());
            }

        }

        comboSearchRoomCity.setSelectedItem(null);
        comboSearchRoomRegion.setSelectedItem(null);



    }

    public void loadCombosOfSearchReservation(){

        comboSearchReserRegion.removeAllItems();
        comboSearchReserCity.removeAllItems();
        comboSearchReserRoomType.removeAllItems();

        for(Reservation reservation :Reservation.getReservations() ) {


            if (!Support.isComboBoxContains(comboSearchReserCity, Hotel.getHotel(reservation.getHotelID()).getCity())) {

                comboSearchReserCity.addItem(Hotel.getHotel(reservation.getHotelID()).getCity());
            }

            if (!Support.isComboBoxContains(comboSearchReserRegion, Hotel.getHotel(reservation.getHotelID()).getRegion())) {

                comboSearchReserRegion.addItem(Hotel.getHotel(reservation.getHotelID()).getRegion());
            }

            if (!Support.isComboBoxContains(comboSearchReserRoomType,reservation.getRoomType())) {

                comboSearchReserRoomType.addItem(reservation.getRoomType());
            }

        }

        comboSearchReserRegion.setSelectedItem(null);
        comboSearchReserCity.setSelectedItem(null);
        comboSearchReserRoomType.setSelectedItem(null);



    }














    public static void main(String[] args) {
        User user=new User(1,"MUKAN","AYAZOĞLU","mukan","@gmail.com","05443332211","şifre","admin");
        Support.theme();
        new PersonelGUI(user);
    }



}
