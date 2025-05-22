package Support;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Support {

    public static String ProjectTitle = "Turizm Acente Sistemi";


    public static void theme(){


        for(UIManager.LookAndFeelInfo info  : UIManager.getInstalledLookAndFeels() ) {

            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                } catch (ClassNotFoundException | IllegalAccessException | UnsupportedLookAndFeelException |
                         InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }

        }



    }

    public static int setLocation(String  corner, int x) {

        switch (corner){

            case "x": return (Toolkit.getDefaultToolkit().getScreenSize().width - x)/2;
            case "y": return (Toolkit.getDefaultToolkit().getScreenSize().height - x)/2;
            default: return 0;

        }


    }

    public static void trOptions(){

        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");


    }

    public static void showMessage(String title){


        switch (title){
            case "empty": JOptionPane.showMessageDialog(null,"Lütfen tüm boşluları doldurun!","Sonuç",JOptionPane.INFORMATION_MESSAGE); break;
            case "error": JOptionPane.showMessageDialog(null,"Hata meydana geldi!","Sonuç",JOptionPane.INFORMATION_MESSAGE); break;
            case "cancel": JOptionPane.showMessageDialog(null,"İşlem iptal edildi!","Sonuç",JOptionPane.INFORMATION_MESSAGE); break;
            case "okey": JOptionPane.showMessageDialog(null,"İşlem başarılı!","Sonuç",JOptionPane.INFORMATION_MESSAGE); break;
            default:JOptionPane.showMessageDialog(null,title,"Sonuç",JOptionPane.INFORMATION_MESSAGE); break;
        }



    }

    public static boolean confirm(String title){

        if (title.equals("confirm")){
          return  JOptionPane.showConfirmDialog(null,"Bu işlemi gerçekleştirmek istediğinize emin misiniz?","Onay",JOptionPane.YES_NO_OPTION)==0;
        }else {
            return  JOptionPane.showConfirmDialog(null,title,"Onay",JOptionPane.YES_NO_OPTION)==0;
        }


    }

    public static boolean isTextFieldEmpty(JTextField title){
        return title.getText().trim().isEmpty();
    }

    public static boolean isAnyOfTheseTextFieldsEmpty(JTextField [] title){

        for(JTextField titleField : title ) {

            if (isTextFieldEmpty(titleField)){
                return true;
            }


        }

        return false;
    }

    public static boolean isMailValid(String mail){

        if (mail==null || mail.trim().isEmpty()){
            return false;
        }

        if (!mail.contains("@")){
            return false;
        }

        String [] emails = mail.split("@");

        if (emails.length != 2){
            return false;
        }

        if (emails[0].trim().isEmpty() || emails[1].trim().isEmpty()){
            return false;
        }

        if (!emails[1].contains(".")){
            return false;
        }

        if (emails[0].contains(" ")) return false;

        if (emails[1].contains(" ")) return false;




        return true;

    }

    public static boolean isPasswordsSame(JPasswordField password1, JPasswordField password2){

        if (password1.getPassword()!= password2.getPassword()){
            return false;
        }

        return true;
    }

    public static boolean isComboBoxContains(JComboBox comboBox, String item){

        for (int i = 0; i <comboBox.getItemCount() ; i++) {

            if (comboBox.getItemAt(i).toString().equals(item)){
                return true;
            }

        }
        return false;
    }

    public static String comboReturnStringOrNull(JComboBox comboBox){

        if (comboBox.getSelectedItem()!=null){
            return comboBox.getSelectedItem().toString();
        }else return null;
    }


    public static String getComboString(JComboBox comboBox){

            return comboBox.getSelectedItem().toString();

    }

    public static Double getComboDouble(JComboBox comboBox){

        return Double.parseDouble(comboBox.getSelectedItem().toString());

    }

    public static boolean isTCValid(String tckn) {
        // TC Kimlik numarası 11 haneli olmalıdır
        if (tckn.length() != 11) {
            return false;
        }

        // TC Kimlik numarası sadece rakamlardan oluşmalıdır
        if (!tckn.matches("^[0-9]+$")) {
            return false;
        }

        // İlk hane 0 olamaz
        if (tckn.charAt(0) == '0') {
            return false;
        }

        int[] digits = new int[11];
        for (int i = 0; i < 11; i++) {
            digits[i] = Character.getNumericValue(tckn.charAt(i));
        }

        // 10. hane kontrolü
        int sumEven = 0;
        int sumOdd = 0;

        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                sumEven += digits[i];
            } else {
                sumOdd += digits[i];
            }
        }

        int digit10 = ((sumEven * 7) - sumOdd) % 10;
        if (digit10 != digits[9]) {
            return false;
        }

        // 11. hane kontrolü
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += digits[i];
        }

        int digit11 = sum % 10;
        if (digit11 != digits[10]) {
            return false;
        }

        return true;
    }

    public static boolean isAnyOFTCValid(String [] tckn) {


        for(String TC :tckn ) {

            // TC Kimlik numarası 11 haneli olmalıdır
            if (TC.length() != 11) {
                return false;
            }

            // TC Kimlik numarası sadece rakamlardan oluşmalıdır
            if (!TC.matches("^[0-9]+$")) {
                return false;
            }

            // İlk hane 0 olamaz
            if (TC.charAt(0) == '0') {
                return false;
            }

            int[] digits = new int[11];
            for (int i = 0; i < 11; i++) {
                digits[i] = Character.getNumericValue(TC.charAt(i));
            }

            // 10. hane kontrolü
            int sumEven = 0;
            int sumOdd = 0;

            for (int i = 0; i < 9; i++) {
                if (i % 2 == 0) {
                    sumEven += digits[i];
                } else {
                    sumOdd += digits[i];
                }
            }

            int digit10 = ((sumEven * 7) - sumOdd) % 10;
            if (digit10 != digits[9]) {
                return false;
            }

            // 11. hane kontrolü
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += digits[i];
            }

            int digit11 = sum % 10;
            if (digit11 != digits[10]) {
                return false;
            }

        }


        return true;
    }






}
