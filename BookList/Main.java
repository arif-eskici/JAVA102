package BookList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        ArrayList <Book> bookList = new ArrayList<>();

        bookList.add(new Book("1984", 352, "George ORWELL", 1949));
        bookList.add(new Book("Aşk", 420, "Elif ŞAFAK", 2009));
        bookList.add(new Book("On Dakika Otuz Sekiz Saniye", 392, "Elif ŞAFAK", 2019));
        bookList.add(new Book("Şah & Sultan", 390, "İskander PALA", 2010));
        bookList.add(new Book("Katre-i Matem", 480, "İskender PALA", 2009));
        bookList.add(new Book("Abum Rabum", 528, "İskender PALA", 2017));
        bookList.add(new Book("Olasılıksız", 472, "Adem FAWER", 2005));
        bookList.add(new Book("Kayıp Sembol", 527, "Dan BROWN", 2009));
        bookList.add(new Book("Hayvan Çiftliği", 115, "George ORWELL", 1945));
        bookList.add(new Book("Masumiyet Müzesi", 592, "Orhan PAMUK", 2008));

        System.out.println("*-----------------------------------*");

        Map <String, String> bookMap = new HashMap<>();

        bookList.stream().forEach(book -> bookMap.put(book.getBookName(), book.getAuthor()));

        for (String i : bookMap.keySet()) {
            System.out.println("\nBook Name : " +i+ "\nAuthor Name : " +bookMap.get(i));
        }
        System.out.println("*-----------------------------------*");

        System.out.println("\nBooks with more than '500' pages :\n");
        List <Book> listBook = bookList.stream().filter(book -> book.getPageNumber() > 500).collect(Collectors.toList());
        listBook.stream().forEach(b -> System.out.println("Book Name : " + b.getBookName() + ", " + 
                                                          "Page Number : " + b.getPageNumber() + ", " +
                                                          "Author : " + b.getAuthor()+ ", " +
                                                          "Publish Date : " + b.getPublishDate())); 

        System.out.println("*-----------------------------------*");

        long count = bookList.stream().count();
        System.out.println("Number of total books : " + count);

        System.out.println("*-----------------------------------*");

    }
}
