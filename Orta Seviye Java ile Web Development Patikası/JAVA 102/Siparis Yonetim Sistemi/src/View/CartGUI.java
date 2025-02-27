package View;

import Model.Basket;
import Model.Cart;
import Model.Customer;
import Model.Product;
import Support.Support;

import javax.swing.*;
import javax.swing.text.MaskFormatter;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CartGUI extends JFrame{
    private JPanel mainPanel;
    private JLabel labelCustomerName;
    private JTextField textDate;
    private JTextArea textAreaNote;
    private JButton buttonCreateOrder;


    public CartGUI(Customer customer) {
        add(mainPanel);
        setTitle("Sipariş Oluştur");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,400);
        setLocation(Support.locateScreen("x",400),Support.locateScreen("y",500));
        setResizable(true);
        setVisible(true);





        labelCustomerName.setText("Müşteri: "+customer.getName());


        buttonCreateOrder.addActionListener(e -> {

            if (Support.isTextFieldEmpty(textDate)) {
                Support.giveMessage("boş");
            }else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd//MM//yyyy");


                for(Basket basket : Basket.getAll()) {

                    if (basket.getProduct().getStock()<=0) continue;

                    Cart.addCart(customer.getId(),basket.getProductID(),basket.getProduct().getPrice(),textDate.getText(),textAreaNote.getText());


                    Product product = basket.getProduct();
                    product.setStock(product.getStock()-1);
                    product.update(product.getId(),product.getName(),product.getCode(),product.getPrice(),product.getStock());


                }

                Basket.deleteAll();
                Support.giveMessage("başarı");
                dispose();

            }







        });







    }




    private void createUIComponents() throws ParseException {
        textDate = new JFormattedTextField(new MaskFormatter("##/##/####"));
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        textDate.setText(dateTimeFormatter.format(LocalDate.now()));
    }
}
