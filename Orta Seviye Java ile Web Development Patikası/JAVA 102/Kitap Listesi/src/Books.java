public enum Books {

    firstBook("Aklından Bir Sayı Tut", 250,"John Verdon","22.11.2023"),
    secondBook("Şeytanı Uyandırma",400,"John Verdon","10.11.2022"),
    thirdBook("Kurt Gölü",500,"John Verdon","03.05.2020"),
    forthBook("Tepenin Laneti",750,"John Verdon","09.04.2024"),
    fifthBook("Yırtıcı Kuşlar Zamanı",250,"Ahmet Ümit","02.10.2024"),
    sixthBook("Gece Yarısı Kütüphanesi",250,"Matt Haig","23.02.2022"),
    seventhBook("Dersimiz Atatürk",112,"Turgut Özakman","17.03.2010"),
    eighthBook("Kum Saati",128,"Fatih Tuncay","09.10.2019"),
    ninethBook("Kayıp Madalyon",656,"Bilgehan Demir","11.11.2024"),
    tenthBook("Animal Firm",98,"George Orwell","04.01.2021");

    private String bookName;
    private int pages;
    private String writer;
    private String dateOfPublication;


    Books(String bookName, int pages, String writer, String dateOfPublication) {
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
