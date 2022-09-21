package BookSorter;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        
        TreeSet <Book> book = new TreeSet<>();

        Book book1 = new Book("Nineteen Eighty-Four (1984)", 352, "George Orwell", "1949");
        Book book2 = new Book("Suç ve Ceza", 705, "Fyodor Dostoyevski", "1867");
        Book book3 = new Book("Olasılıksız", 472, "Adam Fawer", "2005");
        Book book4 = new Book("Abum Rabum", 528, "İskender Pala", "2017");
        Book book5 = new Book("Aşk", 420, "Elif Şafak", "2009");

        book.add(book1);
        book.add(book2);
        book.add(book3);
        book.add(book4);
        book.add(book5);

        // sort by name
        System.out.println("***** sorted by name *****\n");
        for (Book bookName : book) {
            System.out.println( "Book's Name    : " + bookName.getBookName()+ 
                                "\nNumber of Page : " + bookName.getPageNumber()+
                                "\nAuthor's Name  : " + bookName.getAuthorName()+
                                "\nPublish Date   : " + bookName.getPublishDate());
            System.out.println("------------------------------");
        }

        //number of page
        TreeSet <Book> books = new TreeSet <> (new Comparator<Book>() {

            @Override
            public int compare(Book b1, Book b2) {
                
                return b1.getPageNumber() - b2.getPageNumber();
            }
            
        });

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        System.out.println("\n***** sorted by number of page *****\n");
        for (Book bookPage : books) {
            System.out.println("Book's Name      : " + bookPage.getBookName()+
                            "\nNumber of Page   : " + bookPage.getPageNumber()+
                            "\nAuthor's Name    : " + bookPage.getAuthorName()+
                            "\nPublish Date     : " + bookPage.getPublishDate());
            System.out.println("------------------------------");
            
        }

    }
}
