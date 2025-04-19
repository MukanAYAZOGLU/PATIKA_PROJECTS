package Support;


import javax.swing.*;
import java.awt.*;

public class Support {

    public static final String PROJECT_TITLE="PATIKA.DEV";
    public static final String DB_URL="jdbc:mysql://localhost:3306/patika";
    public static final String DB_USER_NAME="patika";
    public static final String DB_PASSWORD="MySqlPatika.?0";






    public static void theme() {

        for(UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels() ) {

            if ("Nimbus".equals(info.getName())) {

                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException |InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }

        }




    }

    public static int arrangeLocation(String corner, int measurement) {

        switch (corner) {
            case "x": return (Toolkit.getDefaultToolkit().getScreenSize().width-measurement)/2;
            case "y": return (Toolkit.getDefaultToolkit().getScreenSize().height-measurement)/2;
            default:return 0;
        }

    }

    public static boolean isTextFieldEmpty(JTextField field) {
        return field.getText().isEmpty();
    }

    public static boolean isTextFieldEmpty(JTextArea field) {
        return field.getText().isEmpty();
    }

    public static void giveMessage(String title) {

        String message;
        switch (title) {

            case "hata": message="Hata gerçekleşti !";
                JOptionPane.showMessageDialog(null, message,"Sonuç",JOptionPane.INFORMATION_MESSAGE);
                break;

            case "boş": message="Tüm boşlukları doldurunuz !";
            JOptionPane.showMessageDialog(null, message,"Sonuç",JOptionPane.INFORMATION_MESSAGE);
            break;

            case "başarı": message="İşlem başarılı !";
            JOptionPane.showMessageDialog(null, message,"Sonuç",JOptionPane.INFORMATION_MESSAGE);
            break;

            case "iptal": message="İşlem iptal edildi !";
            JOptionPane.showMessageDialog(null,message,"Sonuç",JOptionPane.INFORMATION_MESSAGE);
            break;

            default: message=title;
                JOptionPane.showMessageDialog(null, message,"Sonuç",JOptionPane.INFORMATION_MESSAGE);


        }

    }

    public static void TROptions() {
        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText","Hayır");
    }

    public static boolean confirm(String answer) {

        TROptions();

        String message;

        switch (answer) {

            case "sure":message="Bu işlemi gerçekleştirmek istediğinize emin misiniz?";
                return JOptionPane.showConfirmDialog(null, message, "ONAY", JOptionPane.YES_NO_OPTION)==0;

            default: message=answer;
                return JOptionPane.showConfirmDialog(null, message, "ONAY", JOptionPane.YES_NO_OPTION)==0;

        }



    }



}
