package model;

import java.util.ArrayList;
import java.util.List;

// BookHelper is used to create books for the library
class BookHelper {

    private List<LibraryItem> books;

    BookHelper() {

        books = new ArrayList<>();

        books.add(new Book("Harry Potter", "a", 1990));
        books.add(new Book("The Half GirlFriend", "b", 1991));

    }

    List<LibraryItem> getBooks() {
        return books;
    }
}
