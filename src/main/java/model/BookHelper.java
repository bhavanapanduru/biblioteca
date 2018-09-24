package model;

import java.util.ArrayList;
import java.util.List;

// BookHelper is used to create books for the library
class BookHelper {

    private final List<LibraryItem> books;

    BookHelper() {

        books = new ArrayList<>();

        books.add(new Book("Harry Potter", "J.K.Rowling", 1997));
        books.add(new Book("The Half GirlFriend", "Chetan Bhagat", 2014));

    }

    List<LibraryItem> getBooks() {
        return books;
    }
}
