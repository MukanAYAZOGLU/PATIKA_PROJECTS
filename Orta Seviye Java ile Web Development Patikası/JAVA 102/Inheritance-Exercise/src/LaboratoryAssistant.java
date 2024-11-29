public class LaboratoryAssistant extends Assistant{


    public LaboratoryAssistant(String nameSurname, String phoneNumber, String ePosta, String departure, String title, String officeHour) {
        super(nameSurname, phoneNumber, ePosta, departure, title, officeHour);
    }


    public void enterLab() {

        System.out.println(getNameSurname()+ " laboratuvara girdi.");
    }


    @Override
    public void entryLesson() {
        System.out.println(getNameSurname()+" (lab asistanı) derse girdi.");
    }

}
