public class Assistant extends Academician{

private String officeHour;


    public Assistant(String nameSurname, String phoneNumber, String ePosta, String departure, String title, String officeHour) {
        super(nameSurname, phoneNumber, ePosta, departure, title);
        this.officeHour=officeHour;
    }


    public String getOfficeHour() {
        return officeHour;
    }

    public void setOfficeHour(String officeHour) {
        this.officeHour = officeHour;
    }

    public  void makeQuiz() {

        System.out.println(getNameSurname()+ " sözlü yaptı.");

    }






}
