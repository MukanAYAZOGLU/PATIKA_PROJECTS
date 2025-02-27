package View;

import Model.*;
import Support.Support;
import Support.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class DashboardGUI extends JFrame{
    private JPanel mainPanel;
    private JLabel labelWelcome;
    private JButton buttonExit;
    private JTextField textCustomerName;
    private JComboBox<Customer.TYPE> comboCustomerType;
    private JButton buttonAddCustomer;
    private JButton buttonClearAll;
    private JButton buttonSearchCustomer;
    private JTabbedPane panelBasket;
    private JTable tableCustomer;
    private JPanel panelCustomers;
    private JPanel panelProducts;
    private JTable tableProduct;
    private JPanel panelCustomerAddSearchClear;
    private JPanel panelProductAddSearchClear;
    private JTextField textProductCode;
    private JButton buttonSearchProduct;
    private JButton buttonClearProduct;
    private JButton buttonAddProduct;
    private JComboBox<Item> comboStock;
    private JTextField textProductName;
    private JTable tableBasket;
    private JComboBox<Item> comboBasketCustomers;
    private JButton buttonClearBasket;
    private JButton buttonAddBasket;
    private JLabel labelBasketTotalPrice;
    private JLabel labelBasketTotalProduct;
    private JTable tableOrders;
    private DefaultTableModel modelTableCustomer;
    private JPopupMenu popupMenuCustomer=new JPopupMenu();
    private Object[] rowsCustomer;
    private DefaultTableModel modelTableProduct;
    private Object[] rowsProduct;
    private JPopupMenu popupMenuProduct=new JPopupMenu();
    private DefaultTableModel modelTableBasket;
    private Object[] rowsBasket;
    private DefaultTableModel modelTableOrders;
    private Object[] rowsOrders;




    public DashboardGUI(User user) {
        add(mainPanel);
        setTitle("Kullanıcı Arayüzü");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1200,500);
        setLocation(Support.locateScreen("x",1200),Support.locateScreen("y",500));
        setResizable(true);
        setVisible(true);


        labelWelcome.setText("Hoş Geldiniz "+user.getName());

        comboCustomerType.setModel(new DefaultComboBoxModel<>(Customer.TYPE.values()));
        comboCustomerType.setSelectedItem(null);



        //TABLE CUSTOMER
        modelTableCustomer=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column==0){return false;}
                return super.isCellEditable(row, column);
            }
        };


        Object [] columnsCustomer={"ID","AD SOYAD","MÜŞTERİ TİPİ","TELEFON NUMARASI","E-POSTA ADRESİ","ADRESİ"};
        modelTableCustomer.setColumnIdentifiers(columnsCustomer);
        rowsCustomer=new Object[columnsCustomer.length];


        loadTableCustomer();


        tableCustomer.getTableHeader().setResizingAllowed(true);
        tableCustomer.getTableHeader().setReorderingAllowed(false);
        tableCustomer.getColumnModel().getColumn(0).setMaxWidth(50);
        tableCustomer.setEnabled(true); //tablo üzerinde fare ilde değişiklik yapılmasını devre dışı bırakır.




        //TABLE PRODUCT
        modelTableProduct=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column==0){return false;}
                return super.isCellEditable(row, column);
            }
        };

        Object [] columnsProduct={"ID","ÜRÜN ADI","ÜRÜN KODU","FİYAT", "STOK"};
        modelTableProduct.setColumnIdentifiers(columnsProduct);
        rowsProduct=new Object[columnsProduct.length];


        loadTableProduct();

        tableProduct.getTableHeader().setResizingAllowed(true);
        tableProduct.getTableHeader().setReorderingAllowed(false);
        tableProduct.getColumnModel().getColumn(0).setMaxWidth(50);
        tableProduct.setEnabled(true);



        //TABLE BASKET
        modelTableBasket=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column==0){return false;}
                return super.isCellEditable(row, column);
            }
        };

        Object [] columnsBasket={"ID","ÜRÜN ADI","ÜRÜN KODU","FİYAT", "STOK"};
        modelTableBasket.setColumnIdentifiers(columnsBasket);
        rowsBasket=new Object[columnsBasket.length];


        loadTableBasket();

        tableBasket.getTableHeader().setResizingAllowed(true);
        tableBasket.getTableHeader().setReorderingAllowed(false);
        tableBasket.getColumnModel().getColumn(0).setMaxWidth(50);
        tableBasket.setEnabled(true);


        //TABLE ORDERS
        modelTableOrders=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column==0){return false;}
                return super.isCellEditable(row, column);
            }
        };

        Object [] columnsOrders={"ID","MÜŞTERİ ADI","ÜRÜN ADI","FİYATI", "SİPARİŞ TARİHİ","NOT"};
        modelTableOrders.setColumnIdentifiers(columnsOrders);
        rowsOrders=new Object[columnsOrders.length];


        loadTableOrders();

        tableOrders.getTableHeader().setResizingAllowed(true);
        tableOrders.getTableHeader().setReorderingAllowed(false);
        tableOrders.getColumnModel().getColumn(0).setMaxWidth(50);
        tableOrders.setEnabled(true);




        comboStock.addItem(new Item(1,"Stokta Yok"));
        comboStock.addItem(new Item(2,"Stokta Var"));
        comboStock.setSelectedItem(null);








        loadPopupMenuCustomer();

        loadPopupMenuProduct();

        loadButtonsCustomer();

        loadButtonsProduct();

        loadButtonsBasket();

        loadComboBasketCustomers();



    }

    private void loadTableBasket() {


        DefaultTableModel clear=(DefaultTableModel) tableBasket.getModel();
        clear.setRowCount(0);
        int i;
        int totalPrice=0;

        for(Basket basket : Basket.getAll()) {
            i=0;
            rowsBasket[i++]=basket.getId();
            rowsBasket[i++]=basket.getProduct().getName();
            rowsBasket[i++]=basket.getProduct().getCode();
            rowsBasket[i++]=basket.getProduct().getPrice();
            rowsBasket[i++]=basket.getProduct().getStock();


            modelTableBasket.addRow(rowsBasket);

            totalPrice+=basket.getProduct().getPrice();
            labelBasketTotalPrice.setText(totalPrice+" TL");

        }

        labelBasketTotalProduct.setText(Basket.getAll().size() + " Adet");

        tableBasket.setModel(modelTableBasket);







    }

    public void loadTableCustomer() {

        DefaultTableModel clear=(DefaultTableModel) tableCustomer.getModel();
        clear.setRowCount(0);
        int i;

        for(Customer customer : Customer.getCustomers()) {
            i=0;
            rowsCustomer[i++]=customer.getId();
            rowsCustomer[i++]=customer.getName();
            rowsCustomer[i++]=customer.getType();
            rowsCustomer[i++]=customer.getPhone();
            rowsCustomer[i++]=customer.getEmail();
            rowsCustomer[i++]=customer.getAddress();
            modelTableCustomer.addRow(rowsCustomer);


        }

        tableCustomer.setModel(modelTableCustomer);





    }

    public void loadTableCustomer(ArrayList<Customer> customers) {

        DefaultTableModel clear=(DefaultTableModel) tableCustomer.getModel();
        clear.setRowCount(0);
        int i;

        for(Customer customer : customers) {
            i=0;
            rowsCustomer[i++]=customer.getId();
            rowsCustomer[i++]=customer.getName();
            rowsCustomer[i++]=customer.getType();
            rowsCustomer[i++]=customer.getPhone();
            rowsCustomer[i++]=customer.getEmail();
            rowsCustomer[i++]=customer.getAddress();
            modelTableCustomer.addRow(rowsCustomer);


        }

        tableCustomer.setModel(modelTableCustomer);

    }

    public void loadTableProduct(){
        DefaultTableModel clear=(DefaultTableModel) tableProduct.getModel();
        clear.setRowCount(0);
        int i;
        for(Product product : Product.getProducts()) {
            i=0;
            rowsProduct[i++]=product.getId();
            rowsProduct[i++]=product.getName();
            rowsProduct[i++]=product.getCode();
            rowsProduct[i++]=product.getPrice();
            rowsProduct[i++]=product.getStock();
            modelTableProduct.addRow(rowsProduct);
        }
        tableProduct.setModel(modelTableProduct);


    }

    public void loadTableOrders(){

        DefaultTableModel clear=(DefaultTableModel) tableOrders.getModel();
        clear.setRowCount(0);
        int i;
        for(Cart cart : Cart.getCarts()) {
            i=0;
            rowsOrders[i++]=cart.getId();
            rowsOrders[i++]=Customer.getCustomer(cart.getCustomerID()).getName();
            rowsOrders[i++]=Product.getProduct(cart.getProductID()).getName();
            rowsOrders[i++]=cart.getPrice();
            rowsOrders[i++]=cart.getDate();
            rowsOrders[i++]=cart.getNote();
            modelTableOrders.addRow(rowsOrders);
        }
        tableOrders.setModel(modelTableOrders);

    }

    public void loadPopupMenuCustomer(){

        tableCustomer.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow=tableCustomer.rowAtPoint(e.getPoint());
                tableCustomer.setRowSelectionInterval(selectedRow,selectedRow);
            }
        });


        popupMenuCustomer.add("Güncelle").addActionListener(e -> {


            try{
                int id=Integer.parseInt(tableCustomer.getValueAt(tableCustomer.getSelectedRow(),0).toString());

                Customer customer=Customer.getCustomer(id);

                CustomerAddOrEditGUI customerAddOrEditGUI=new CustomerAddOrEditGUI(customer);
                customerAddOrEditGUI.setVisible(true);

                customerAddOrEditGUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadTableCustomer();
                        loadComboBasketCustomers();

                    }

                });


        }catch(Exception exc){


                Support.giveMessage("Lütfen işlem yapmadan önce satır seçiniz!");

                    }

        });

        popupMenuCustomer.add("Sil").addActionListener(e -> {


            try{
                int id=Integer.parseInt(tableCustomer.getValueAt(tableCustomer.getSelectedRow(),0).toString());


                if (Support.confirm("sure")){

                    if (Customer.delete(id)){
                        loadTableCustomer();
                        loadComboBasketCustomers();
                        Support.giveMessage("başarı");
                    }else Support.giveMessage("hata");


                }else Support.giveMessage("iptal");


                }
            catch(Exception exc){

                Support.giveMessage("Lütfen işlem yapmadan önce satır seçiniz!");


                    }


        });

        tableCustomer.setComponentPopupMenu(popupMenuCustomer);


    }

    public void loadPopupMenuProduct(){

        tableProduct.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selectedRow=tableProduct.rowAtPoint(e.getPoint());
                tableProduct.setRowSelectionInterval(selectedRow,selectedRow);
            }
        });


        popupMenuProduct.add("Sepete Ekle").addActionListener(e -> {

            try{

                int id=Integer.parseInt(tableProduct.getValueAt(tableProduct.getSelectedRow(),0).toString());

                Product product=Product.getProduct(id);

                if (product.getStock()<=0){

                    Support.giveMessage("Bu ürün stokta yoktur!");
                }else {

                    if (Basket.add(id)){
                        loadTableBasket();
                        Support.giveMessage("başarı");

                    }else Support.giveMessage("hata");

                }


                }catch(Exception exc){

                Support.giveMessage("Lütfen işlem yapmadan önce satır seçiniz!");


                    }


        });

        popupMenuProduct.add("Güncelle").addActionListener(e -> {


            try{
                int id=Integer.parseInt(tableProduct.getValueAt(tableProduct.getSelectedRow(),0).toString());

                Product product=Product.getProduct(id);


                ProductAddOrEditGUI productAddOrEditGUI=new ProductAddOrEditGUI(product);
                productAddOrEditGUI.setVisible(true);

                productAddOrEditGUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadTableProduct();
                        loadTableBasket();
                    }

                });



            }catch(Exception exc){


                Support.giveMessage("Lütfen işlem yapmadan önce satır seçiniz!");

            }

        });

        popupMenuProduct.add("Sil").addActionListener(e -> {


            try{

                int id=Integer.parseInt(tableProduct.getValueAt(tableProduct.getSelectedRow(),0).toString());

                if (Support.confirm("sure")){

                    if (Product.delete(id)){

                        loadTableProduct();

                        Support.giveMessage("başarı");

                    }else Support.giveMessage("hata");


                }else Support.giveMessage("iptal");


            }catch(Exception exc){

                Support.giveMessage("Lütfen işlem yapmadan önce satır seçiniz!");


            }


        });



        tableProduct.setComponentPopupMenu(popupMenuProduct);


    }

    public void loadButtonsCustomer(){


        buttonExit.addActionListener(e -> {
            dispose();
            LoginGUI loginGUI=new LoginGUI();
        });
        buttonAddCustomer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                CustomerAddOrEditGUI customerAddOrEditGUI=new CustomerAddOrEditGUI(null);
                customerAddOrEditGUI.setVisible(true);

                customerAddOrEditGUI.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        loadTableCustomer();
                        loadComboBasketCustomers();

                    }
                });
            }

        });
        buttonSearchCustomer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String name=textCustomerName.getText().trim();

                loadTableCustomer(Customer.search(name,(Customer.TYPE)comboCustomerType.getSelectedItem()));


            }
        });
        buttonClearAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textCustomerName.setText(null);
                comboCustomerType.setSelectedItem(null);
                loadTableCustomer();

            }
        });

    }

    public void loadButtonsProduct(){

        buttonClearProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textProductName.setText(null);
                textProductCode.setText(null);
                comboStock.setSelectedItem(null);

                loadTableProduct();


            }
        });
        buttonAddProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               ProductAddOrEditGUI productAddOrEditGUI=new ProductAddOrEditGUI(null);
               productAddOrEditGUI.setVisible(true);
               productAddOrEditGUI.addWindowListener(new WindowAdapter() {
                   @Override
                   public void windowClosed(WindowEvent e) {
                       loadTableProduct();
                   }
               });

            }
        });
        buttonSearchProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name=textProductName.getText().trim();
                String code=textProductCode.getText().trim();
                /*
                                String selected=comboStock.getSelectedItem();

                loadTableProduct(Product.search(name,code,item));


                 */





            }
        });


    }

    public void loadButtonsBasket(){

        buttonClearBasket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Basket.deleteAll()){

                    Support.giveMessage("başarı");

                    loadTableBasket();

                    labelBasketTotalPrice.setText("0 TL");
                    labelBasketTotalProduct.setText("0 ADET");
                    comboBasketCustomers.setSelectedItem(null);


                }else Support.giveMessage("hata");




            }
        });
        buttonAddBasket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Item item=(Item)comboBasketCustomers.getSelectedItem();

                ArrayList<Basket> baskets= Basket.getAll();



                if (item==null){

                    Support.giveMessage("Lütfen geçerli bir müşteri seçiniz!");

                }else if(baskets.isEmpty()) {

                    Support.giveMessage("Lütfen sepete ürün ekleyiniz!");

                }else {


                    CartGUI cartGUI=new CartGUI(Customer.getCustomer(item.getKey()));
                    cartGUI.setVisible(true);
                    cartGUI.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            loadTableBasket();
                            loadTableProduct();
                            loadTableOrders();

                        }
                    });


                }



            }
        });


    }

    public void loadComboBasketCustomers(){

        comboBasketCustomers.removeAllItems();

        for(Customer customer :Customer.getCustomers() ) {

            comboBasketCustomers.addItem(new Item(customer.getId(),customer.getName()));

        }

        comboBasketCustomers.setSelectedItem(null);



    }



    public static void main(String[] args) {
        Support.theme();
        Support.TROptions();
        User user=new User(1,"MUKAN AYAZOĞLU","12@yaani.com","şifre");

        new DashboardGUI(user);



    }


}
