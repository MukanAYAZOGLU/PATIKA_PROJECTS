import java.text.DecimalFormat;

public class Student {

    Course c1;
    Course c2;
    Course c3;
    String name;
    int studentNo;
    String classes;
    double avarage;
    boolean isPass;



    public Student(String name, int studentNo, String classes, Course c1, Course c2, Course c3) {
        this.c1 = c1;
        this.name = name;
        this.studentNo = studentNo;
        this.classes = classes;
        this.c2 = c2;
        this.c3 = c3;
        this.isPass = false;
    }



    public void addBulkExamNote(int note1, int note2, int note3) {

        if (note1>=0 &&note1<=100) {
            this.c1.note=note1;

        }

        if (note2>=0 &&note2<=100) {
            this.c2.note=note2;

        }

        if (note3>=0 &&note3<=100) {
            this.c3.note=note3;

        }

    }

    public void addBulkQuizNote(int quiz1, int quiz2, int quiz3) {

        if (quiz1>=0 &&quiz1<=100) {
            this.c1.quiz=quiz1;

        }

        if (quiz2>=0 &&quiz2<=100) {
            this.c2.quiz=quiz2;

        }

        if (quiz3>=0 &&quiz3<=100) {
            this.c3.quiz=quiz3;

        }


    }


    void isPass() {
        this.avarage=((this.c1.note)*0.80+(this.c1.quiz*0.20)+
                    (this.c1.note)*0.80+(this.c1.quiz*0.20)+
                    (this.c1.note)*0.80+(this.c1.quiz*0.20))/3;

        System.out.println("----------------");

        if (this.avarage>55) {
            System.out.println("Sınıftan geçtiniz.");

        }else {
            System.out.println("Sınıftan kaldınız.");
        }
        printNoteInfo();
    }

    void printNoteInfo() {

        System.out.println(this.c1.name+ " Notu: \t"+this.c1.note+" Sözlüsü:  \t"+this.c1.quiz);
        System.out.println(this.c2.name+ " Notu: \t"+this.c2.note+" Sözlüsü:  \t"+this.c2.quiz);
        System.out.println(this.c3.name+ " Notu: \t"+this.c3.note+" Sözlüsü:  \t"+this.c3.quiz);
        System.out.println("Ortalamanız: \t"+new DecimalFormat("##.##").format(this.avarage));
    }






}
