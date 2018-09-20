package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookHelper {

    private List<Book> books;

    public BookHelper() {

        books = new ArrayList<>();

        books.add(new Book("Harry Potter"));
        books.add(new Book("The Half GirlFriend"));

    }

    public List<Book> getBooks() {
        return books;
    }
}
