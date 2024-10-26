public class SecurityGuard extends Officer{

private String document;



    public SecurityGuard(String nameSurname, String phoneNumber, String ePosta, String departure, String shift, String document) {
        super(nameSurname, phoneNumber, ePosta, departure, shift);
        this.document=document;
    }


    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void guarDuty() {

        System.out.println(getNameSurname()+" nöbeti gerçekleştirdi.");
    }
}
