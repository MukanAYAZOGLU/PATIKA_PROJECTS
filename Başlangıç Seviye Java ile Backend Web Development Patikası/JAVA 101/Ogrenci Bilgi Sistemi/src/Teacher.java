public class Teacher {

    String name;
    String mpno;
    String branch;

    public Teacher(String name, String mono, String branch) {
        this.name = name;
        this.mpno = mono;
        this.branch = branch;
    }




    void printTeacherInfo() {

        System.out.println("Adı: "+this.name);
        System.out.println("Telefonu: "+this.mpno);
        System.out.println("Bölümü: "+this.branch);
    }






}
