package Biblioteca;

import java.util.List;
import java.util.stream.Collectors;

// Library has list of books
public class Library {

    private final List<Book> books;

    Library(final List<Book> books) {
        this.books = books;
    }

    public List<String> getBookDetails() {
        return books.stream().map(Book::toString).collect(Collectors.toList());
    }

}
