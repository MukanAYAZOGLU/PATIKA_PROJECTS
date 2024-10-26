public abstract class Officer extends Workers{

    private String departure;
    private String shift;


    public Officer(String nameSurname, String phoneNumber, String ePosta, String departure, String shift) {
        super(nameSurname, phoneNumber, ePosta);
        this.departure=departure;
        this.shift=shift;
    }


    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }


    public void work() {

        System.out.println(getNameSurname()+ " çalıştı.");

    }
}
