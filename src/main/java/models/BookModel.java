package models;

public class BookModel {
    private int id;
    private String bookname;
    private String bookauthor;
    private int shelfid;

    public BookModel(int id, String bookname, String bookauthor, int shelfid) {
        this.id = id;
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.shelfid = shelfid;
    }

    public BookModel(String bookname, String bookauthor, int shelfid) {
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.shelfid = shelfid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return bookname;
    }

    public String getAuthor() {
        return bookauthor;
    }

    public int getShelfid() {
        return shelfid;
    }
}
