
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        System.out.println ("Kitap ismine göre sıralanış:");

        TreeSet <Book> bookName= new TreeSet<>(Book::compareTo);

        bookName.add(new Book("Kuşatma 1453",350,"Okay Tiryakioğlu", new GregorianCalendar(1951, Calendar.JULY, 16).getTime()));

        bookName.add(new Book("Tutunamayanlar", 500,"Oğuz Atay",new GregorianCalendar(1951, Calendar.JUNE, 9).getTime()));


        bookName.add(new Book("Aklından Bir Sayı Tut", 450,"John Verdon",new GregorianCalendar(2022, Calendar.NOVEMBER, 17).getTime()));


        bookName.add(new Book("Seytanı Uyandırma", 600,"John Verdon",new GregorianCalendar(2023, Calendar.OCTOBER, 23).getTime()));


        bookName.add(new Book("Kurt Gölü", 650,"John Verdon",new GregorianCalendar(2023, Calendar.MAY, 10).getTime()));


        for(Book a: bookName ) {
            System.out.println(a.getBookName());

        }



        System.out.println ("Sayfa sayısına göre sıralanış:");

        TreeSet <Book> bookPage= new TreeSet<>(Comparator.comparingInt(Book::getPage));

        bookPage.addAll(bookName);

        for(Book a: bookPage ) {
            System.out.println(a.getPage());

        }


        System.out.println ("Yazara göre sıralanış:");


        TreeSet <Book> bookWriter= new TreeSet<>(Comparator.comparing(Book::getWriter));

        bookWriter.addAll(bookName);

        for(Book a: bookWriter ) {
            System.out.println(a.getWriter());

        }



        System.out.println ("Kitap basım tarihine göre sıralanış:");


        TreeSet <Book> bookReleasedDate= new TreeSet<>(Comparator.comparing(Book::getPublicationDate));

        bookReleasedDate.addAll(bookName);

        for(Book a: bookReleasedDate ) {
            System.out.println(a.getPublicationDate());

        }






    }
}