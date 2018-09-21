package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookHelper {

    private List<Book> books;

    public BookHelper() {

        books = new ArrayList<>();

        books.add(new Book("Harry Potter", "a", 1990));
        books.add(new Book("The Half GirlFriend", "b", 1991));

    }

    public List<Book> getBooks() {
        return books;
    }
}
