package View;

import Model.Customer;
import Support.Support;

import javax.swing.*;

public class CustomerAddOrEditGUI extends JFrame {


    private JPanel mainPanel;
    private JTextField textName;
    private JComboBox<Customer.TYPE> comboType;
    private JTextField textPhone;
    private JTextField textMail;
    private JTextArea textAddress;
    private JButton buttonAddOrEdit;
    private JLabel labelCustomerAddEdit;
    private JButton buttonDispose;

    public CustomerAddOrEditGUI(Customer customer) {

        add(mainPanel);
        setTitle("Müşteri Ekle / Düzenle");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(330,400);
        setLocation(Support.locateScreen("x",330),Support.locateScreen("y",400));
        setResizable(true);
        setVisible(true);

        if (customer==null){

            labelCustomerAddEdit.setText("MÜŞTERİ EKLE");
            buttonAddOrEdit.setText("EKLE");


        }else {

            labelCustomerAddEdit.setText("MÜŞTERİ DÜZENLE");
            buttonAddOrEdit.setText("DÜZENLE");


            textName.setText(customer.getName());
            comboType.getModel().setSelectedItem(customer.getType());
            textPhone.setText(customer.getPhone());
            textMail.setText(customer.getEmail());
            textAddress.setText(customer.getAddress());


        }




        buttonAddOrEdit.addActionListener(e -> {

            String name = textName.getText().trim().toUpperCase();
            String type = comboType.getSelectedItem().toString();
            String phone = textPhone.getText().trim();
            String mail = textMail.getText().trim();
            String address = textAddress.getText().trim();


            if (customer==null) {

                if (name.isEmpty()) {

                    Support.giveMessage("Ad Soyad içeriği boş olamaz.");

                } else if (!mail.trim().isEmpty() && !Support.isEPostaValid(mail)) {

                    Support.giveMessage("Lütfen geçerli bir e-posta adresi giriniz!");

                }else{

                    if (Customer.add(name,type,phone,mail,address)){

                        Support.giveMessage("başarı");
                        dispose();

                    }else Support.giveMessage("hata");

                }


            }else {

                if (name.isEmpty()) {
                    Support.giveMessage("Ad Soyad içeriği boş olamaz.");

                } else if (!mail.trim().isEmpty() && !Support.isEPostaValid(mail)) {

                    Support.giveMessage("Lütfen geçerli bir e-posta adresi giriniz!");


                }else{

                    if (Customer.update(customer.getId(), name, type, phone, mail, address)) {
                        Support.giveMessage("başarı");
                        dispose();
                    } else Support.giveMessage("hata");

                }

            }



        });

        buttonDispose.addActionListener(e -> {
            dispose();
        });



        comboType.setModel(new DefaultComboBoxModel<>(Customer.TYPE.values()));
        
        
        
        
        
        
    }

    public static void main(String[] args) {
        Support.theme();
        //new CustomerAddOrEditGUI();
    }
    
    
}
