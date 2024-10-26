public class Main {
    public static void main(String[] args) {

        Teacher teach= new Teacher("Mukan Akkurt","053...","TRH");
        Teacher teach2 = new Teacher("Motun","0537...","FZK");
        Teacher teach3 = new Teacher("Hunkurt","0536...","BIO");


        Course tarih = new Course("Tarih","TRH","TRH");
        tarih.addTeacher(teach);

        Course fizik = new Course("Fizik","102","FZK");
        fizik.addTeacher(teach2);

        Course biyoyoloji= new Course("Biyoloji","103","BIO");
        biyoyoloji.addTeacher(teach3);


        Student s1 = new Student("Kurtay",123,"4",tarih, fizik, biyoyoloji);
        s1.addBulkExamNote(100,100,50);
        s1.addBulkQuizNote(80,70,67);
        s1.isPass();


        Student s2 = new Student("Hazar",213,"4",tarih, fizik, biyoyoloji);
        s2.addBulkExamNote(45,54,50);
        s1.addBulkQuizNote(50,90,67);
        s2.isPass();



    }
}