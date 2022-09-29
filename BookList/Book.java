
package BookList;

public class Book {

    private String bookName;
    private int pageNumber;
    private String author;
    private int publishDate;


    public Book(String bookName, int pageNumber, String author, int publishDate) {
        this.bookName = bookName;
        this.pageNumber = pageNumber;
        this.author = author;
        this.publishDate = publishDate;
    }


    public String getBookName() {
        return bookName;
    }


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public int getPageNumber() {
        return pageNumber;
    }


    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }


    public String getAuthor() {
        return author;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public int getPublishDate() {
        return publishDate;
    }


    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

}
