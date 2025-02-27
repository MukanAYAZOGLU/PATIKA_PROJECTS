package View;

import Model.Product;
import Support.Support;

import javax.swing.*;

public class ProductAddOrEditGUI extends JFrame{
    private JPanel mainPanel;
    private JLabel labelProductAddEdit;
    private JTextField textName;
    private JTextField textPrice;
    private JTextField textCode;
    private JComboBox comboStock;
    private JButton buttonProductAddOrEdit;
    private JTextField textStock;


    public ProductAddOrEditGUI(Product product){
        add(mainPanel);
        setTitle("ÜRÜN EKLE / DÜZENLE");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(330,400);
        setLocation(Support.locateScreen("x",330),Support.locateScreen("y",400));
        setResizable(true);
        setVisible(true);



        if (product!=null){

            labelProductAddEdit.setText("ÜRÜN DÜZENLE");
            buttonProductAddOrEdit.setText("DÜZENLE");

            textName.setText(product.getName());
            textPrice.setText(String.valueOf(product.getPrice()));
            textCode.setText(String.valueOf(product.getCode()));
            textStock.setText(String.valueOf(product.getStock()));



        }else {

            labelProductAddEdit.setText("ÜRÜN EKLE");
            buttonProductAddOrEdit.setText("EKLE");
        }


        buttonProductAddOrEdit.addActionListener(e -> {


            if (Support.isAnyOfTextFieldEmpty(new JTextField[]{textName,textCode,textStock,textPrice})){

                Support.giveMessage("boş");


            }else if (product==null){


                String name=textName.getText().trim().toUpperCase();
                String code=textCode.getText().trim();
                try{
                    int price=Integer.parseInt(textPrice.getText().trim());
                    int stock=Integer.parseInt(textStock.getText().trim());


                    if (Product.add(name,code,price,stock)){

                        Support.giveMessage("başarı");
                        dispose();

                    }else Support.giveMessage("hata");


                    }
                catch(Exception exc){

                    Support.giveMessage("Lütfen fiyat ve stok değerini sadece rakamsal değer giriniz!");
                        }





            }else {

                String name=textName.getText().trim().toUpperCase();
                String code=textCode.getText().trim();
                try{
                    int price=Integer.parseInt(textPrice.getText().trim());
                    int stock=Integer.parseInt(textStock.getText().trim());


                    if (Product.update(product.getId(),name,code,price,stock)){

                        Support.giveMessage("başarı");
                        dispose();

                    }else Support.giveMessage("hata");


                }
                catch(Exception exc){

                    Support.giveMessage("Lütfen fiyat ve stok değerini sadece rakamsal değer giriniz!");
                }




            }







        });














    }

    public static void main(String[] args) {
        new ProductAddOrEditGUI(null);
    }






}
