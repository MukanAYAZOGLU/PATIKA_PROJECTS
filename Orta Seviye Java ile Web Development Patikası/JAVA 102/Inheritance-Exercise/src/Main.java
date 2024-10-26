public class Main {
    public static void main(String[] args) {


        Lecturer lecturer= new Lecturer("Bahadır Akkergen", "0435345", "bahadır@dev.patika","Mat","Matematican",101);

        System.out.println(lecturer.getNameSurname());
        System.out.println(lecturer.getPhoneNumber());
        System.out.println(lecturer.getePosta());
        System.out.println(lecturer.getDeparture());
        System.out.println(lecturer.getTitle());
        System.out.println(lecturer.getDoorNo());


        LaboratoryAssistant labAsis= new LaboratoryAssistant("Bahadır Akkergen", "0435345", "bahadır@dev.patika","Mat","Matematican","10.00-15.00");


        labAsis.enterLab();
        labAsis.entryLesson();






    }
}