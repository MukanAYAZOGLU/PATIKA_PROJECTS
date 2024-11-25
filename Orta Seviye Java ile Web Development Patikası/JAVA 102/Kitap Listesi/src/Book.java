public class Book {

    //Enum sınıfın elle oluşturulmuş hali


    private String bookName;
    private int pages;
    private String writer;
    private String dateOfPublication;

    public Book(String bookName, int pages, String writer, String dateOfPublication) {
        this.bookName = bookName;
        this.pages = pages;
        this.writer = writer;
        this.dateOfPublication = dateOfPublication;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }
}
