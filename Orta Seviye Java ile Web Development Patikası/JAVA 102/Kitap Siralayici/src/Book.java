import java.text.SimpleDateFormat;
import java.util.Date;

public class Book implements Comparable<Book> {

    private final String bookName;
    private final int page;
    private final String writer;
    private final Date publicationDate;

    public Book(String bookName, int page, String writer, Date publicationDate) {
        this.bookName = bookName;
        this.page = page;
        this.writer = writer;
        this.publicationDate = publicationDate;
    }

    public String getBookName() {
        return bookName;
    }


    public String getWriter() {
        return writer;
    }

    public String getPublicationDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM.yyyy");
        return formatter.format(publicationDate);
    }


    public int getPage() {
        return page;
    }


    @Override
    public int compareTo(Book o) {
        return this.bookName.compareTo(o.bookName);
    }
}
