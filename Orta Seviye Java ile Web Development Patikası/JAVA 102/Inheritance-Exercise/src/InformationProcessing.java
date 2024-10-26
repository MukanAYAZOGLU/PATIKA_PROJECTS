public class InformationProcessing extends Officer{

private String duty;


    public InformationProcessing(String nameSurname, String phoneNumber, String ePosta, String departure, String shift, String duty) {
        super(nameSurname, phoneNumber, ePosta, departure, shift);
        this.duty=duty;
    }


    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public void networkSetup() {

        System.out.println(getNameSurname()+" network kurulumunu gerçekleştirdi.");

    }
}
