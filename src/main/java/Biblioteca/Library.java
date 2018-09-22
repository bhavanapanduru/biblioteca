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

    public int checkBookIsAvailable(String userCheckOutBookTitle) {

        Book userCheckOutBook = new Book(userCheckOutBookTitle, "", 0);

        for (int bookIndex = 0; bookIndex < books.size(); bookIndex++) {
            if(books.get(bookIndex).equals(userCheckOutBook)) {
                return bookIndex;
            }
        }

        return -1;
    }

    public boolean checkOut(String userCheckOutBookTitle) {

        int checkOutBookIndex = checkBookIsAvailable(userCheckOutBookTitle);

        if(checkOutBookIndex != -1) {
            books.remove(checkOutBookIndex);
            return true;
        }

        return false;
    }
}
