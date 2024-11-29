public abstract class Workers {


    private String nameSurname;
    private String phoneNumber;
    private String ePosta;



    public Workers(String nameSurname, String phoneNumber, String ePosta) {
        this.nameSurname = nameSurname;
        this.phoneNumber = phoneNumber;
        this.ePosta = ePosta;
        }



    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getePosta() {
        return ePosta;
    }

    public void setePosta(String ePosta) {
        this.ePosta = ePosta;
    }


    public void entry() {

        System.out.println(this.nameSurname+" giriş yaptı.");

    }


    public void exit() {

        System.out.println(this.nameSurname+" çıkış yaptı.");

    }


    public abstract void diningHall();



}
