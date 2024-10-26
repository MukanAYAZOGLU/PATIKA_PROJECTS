public abstract class Academician extends Workers {

    private String departure;
    private String title;

    public Academician(String nameSurname, String phoneNumber, String ePosta, String departure, String title) {
        super(nameSurname, phoneNumber, ePosta);
        this.departure=departure;
        this.title=title;

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }



    public abstract void entryLesson ();


}
