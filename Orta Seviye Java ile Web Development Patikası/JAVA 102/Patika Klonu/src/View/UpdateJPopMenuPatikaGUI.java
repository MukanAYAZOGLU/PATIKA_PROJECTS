package View;

import Model.Patika;
import Support.Support;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateJPopMenuPatikaGUI extends JFrame{
    private JPanel mainPanel;
    private JPanel panelFull;
    private JTextField textUpdatePatikaName;
    private JComboBox comboUpdatePatikaLanguage;
    private JButton buttonUpdatePatika;



    public UpdateJPopMenuPatikaGUI(int id, String patikaName, String language){

        add(mainPanel);
        setTitle(Support.PROJECT_TITLE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,150);
        setLocation(Support.arrangeLocation("x",700),Support.arrangeLocation("y",150));
        setVisible(true);


        textUpdatePatikaName.setText(patikaName);
        comboUpdatePatikaLanguage.setSelectedItem(language);


        buttonUpdatePatika.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Patika pat=Patika.getFetchByPatikaName(textUpdatePatikaName.getText());

                if (pat!=null && pat.getId()!=id){

                    Support.giveMessage("Bu isimde patika mevcuttur. Lütfen başka bir isim tercih ediniz!");
                }else {


                    if (Patika.updatePatika(id, textUpdatePatikaName.getText().toUpperCase(), comboUpdatePatikaLanguage.getSelectedItem().toString())) {

                        Support.giveMessage("başarı");
                        dispose();
                    }else Support.giveMessage("hata");


                }






            }
        });
    }











}
