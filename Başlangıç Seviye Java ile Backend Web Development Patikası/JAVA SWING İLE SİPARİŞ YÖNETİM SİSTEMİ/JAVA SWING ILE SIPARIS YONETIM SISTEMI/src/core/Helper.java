package core;

import javax.swing.*;
import javax.swing.text.html.Option;

public class Helper {

public static void setTheme() {

    for (UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()) {

        if (info.getName().equals("Nimbus")){

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

public static boolean isFieldEmty(JTextField field) {

    return field.getText().trim().isEmpty();

}

public static boolean isFieldListEmty(JTextField [] fields) {

    for(JTextField field : fields ) {

        if (Helper.isFieldEmty(field)) return true;

    }

    return false;

}

public static boolean isEMailValid(String eMail) {

    if (eMail==null || eMail.trim().isEmpty()) return false;

    if (!eMail.contains("@")) return false;

    String [] parts= eMail.split("@");

    if (parts.length!=2) return false;

    if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) return false;

    if (!parts[1].contains(".")) {return false;}



    return true;
}

public static void optionPanelDialogTR() {

    UIManager.put("OptionPane.okButtonText","Tamam");

}


public static void showMessage(String message) {

    String title;
    String msg;

    optionPanelDialogTR();

         switch (message) {
        case "fill" -> {
            msg = "Lütfen tüm alanları dodurunuz.";
            title= "HATA!";
        }
        case "done" -> {
            msg = "İşlem başarılı.";
            title= "SONUÇ";
        }
        case "error" -> {
            msg = "Bir hata oluştu.";
            title= "HATA!";
        }
        default -> {
            msg = message;
            title= "Mesaj";
        }
    };
         JOptionPane.showMessageDialog(null,msg,title,JOptionPane.INFORMATION_MESSAGE);



}







}
