package Biblioteca;

import java.util.List;
import java.util.stream.Collectors;

// Library has list of books
public class Library {

    private List<Book> books;

    Library(List<Book> books) {
        this.books = books;
    }

    public List<String> getBookTitles() {
        return books.stream().map(Book::toString).collect(Collectors.toList());
    }

}
