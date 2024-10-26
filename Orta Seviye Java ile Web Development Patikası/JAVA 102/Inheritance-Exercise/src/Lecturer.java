public class Lecturer extends Academician{

private int doorNo;



    public Lecturer(String nameSurname, String phoneNumber, String ePosta, String departure, String title, int doorNo) {
        super(nameSurname, phoneNumber, ePosta, departure, title);
        this.doorNo=doorNo;

    }


    public int getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(int doorNo) {
        this.doorNo = doorNo;
    }

    public void senateMeeting() {

        System.out.println(getNameSurname()+ " senato toplantısına geldi.");

    }

    public void makingExam() {

        System.out.println(getNameSurname()+ " sınav yaptı.");

    }

}
