import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //Book sınıfından 10 tane nesne üretip bunu bir ArrayList yapısında saklayınız.

        ArrayList<Books> books = new ArrayList<>();
        books.add(Books.firstBook);
        books.add(Books.secondBook);
        books.add(Books.thirdBook);
        books.add(Books.forthBook);
        books.add(Books.fifthBook);
        books.add(Books.sixthBook);
        books.add(Books.seventhBook);
        books.add(Books.eighthBook);
        books.add(Books.ninethBook);
        books.add(Books.tenthBook);

        //Stream yapısını ve lambda ifadelerini kullanarak kitap isminin karşısında yazar ismi olacak şekilde yeni bir Map<String, String> oluşturacak şekilde yazınız.

        Map<String,String> mapOfBooks = new HashMap<>();

        books.stream().forEach(i->mapOfBooks.put(i.getBookName(),i.getWriter()));

        //Bu 10 elemanlık Book listesinden sayfa sayısı 100'den fazla olan kitapları filtreleyen ve yeni bir liste olarak verecek geliştirmeyi yapınız. (Stream ve Lambda ifadeleri kullanabilirsiniz.)

        List<Books> newList=books.stream().filter(i->i.getPages()>100).toList();









    }
}