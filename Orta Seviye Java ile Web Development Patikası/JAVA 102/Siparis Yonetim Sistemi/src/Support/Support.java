package Support;

import javax.swing.*;
import java.awt.*;

public class Support {

    public static int locateScreen(String corner, int measurement){

        switch (corner) {
            case "x": return (Toolkit.getDefaultToolkit().getScreenSize().width-measurement)/2;
            case "y": return (Toolkit.getDefaultToolkit().getScreenSize().height-measurement)/2;
        }

        return 0;

    }

    public static void theme(){

        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                         UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }

        }


    }

    public static void TROptions(){

        UIManager.put("OptionPane.okButtonText","Tamam");
        UIManager.put("OptionPane.yesButtonText","Evet");
        UIManager.put("OptionPane.noButtonText","Hayır");


    }

    public static void giveMessage(String title){

        String message;

        switch(title){
            case "boş": message = "Lütfen tüm boşluları doldurun!";
                JOptionPane.showMessageDialog(null, message,"Sonuç",JOptionPane.INFORMATION_MESSAGE);
                break;

            case "iptal": message = "İşlem İptal Edildi!";
                JOptionPane.showMessageDialog(null, message,"Sonuç",JOptionPane.INFORMATION_MESSAGE);
                break;

            case "hata": message = "Hata meydana geldi";
                JOptionPane.showMessageDialog(null, message,"Sonuç",JOptionPane.INFORMATION_MESSAGE);
                break;

            case "başarı": message = "İşlem başarılı!";
                JOptionPane.showMessageDialog(null, message,"Sonuç",JOptionPane.INFORMATION_MESSAGE);
                break;


            default: message = title;
                JOptionPane.showMessageDialog(null, message,"Sonuç",JOptionPane.INFORMATION_MESSAGE);
                break;





        }



    }

    public static boolean confirm(String answer){

        String message=answer;

        switch (message){
            case "sure": message="Bu işlemi gerçekleştirmek istedğinize emin misinz?";
              return  JOptionPane.showConfirmDialog(null,message,"Onay",JOptionPane.YES_NO_OPTION)==0;

            default: message=answer;
                   return  JOptionPane.showConfirmDialog(null,message,"Onay",JOptionPane.YES_NO_OPTION)==0;
        }

    }

    public static boolean isTextFieldEmpty(JTextField textField){

        return textField.getText().trim().isEmpty();


    }

    public static boolean isAnyOfTextFieldEmpty(JTextField [] textFields){

        for(JTextField textField : textFields ) {
            if(isTextFieldEmpty(textField)){
                return true;

            }

        }
        return false;

    }

    public static boolean isEPostaValid(String eposta){

        if (eposta==null || eposta.trim().isEmpty()) return false;

        if (!eposta.contains("@")){
            return false;
        }

        String [] array=eposta.split("@");



        if(array.length!=2){
            return false;
        }


        if (array[0].trim().isEmpty() || array[1].trim().isEmpty()){
            return false;
        }

        if (!array[1].contains(".")){
            return false;
        }



        return true;



    }






}
