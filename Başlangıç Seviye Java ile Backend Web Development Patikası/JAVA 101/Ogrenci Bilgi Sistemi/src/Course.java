public class Course {

Teacher teacher;
String name;
String code;
String prefix;
int note;
int quiz;

    public Course(String name, String code, String prefix) {
        this.prefix = prefix;
        this.name = name;
        this.code = code;
        this.note = 0;
        this.quiz=0;

    }

    void addTeacher(Teacher teacher) {
        if (teacher.branch.equals(this.prefix)) {

            this.teacher=teacher;

        } else System.out.println("Öğretmen ve ders bölümleri uyuşmamaktadır.");

    }


void printInfo() {

        this.teacher.printTeacherInfo();
}






}
