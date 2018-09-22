package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Library has list of books
public class Library {

    private final List<Book> books;
    private List<Book> checkedOutBooks;

    Library(final List<Book> books) {
        this.books = books;
        checkedOutBooks = new ArrayList<>();
    }

    public List<String> getBookDetails() {
        return books.stream().map(Book::toString).collect(Collectors.toList());
    }

    public boolean checkoutBook(String checkOutBookTitle) {

        for (Book book: books) {
            if (book.equals(new Book(checkOutBookTitle,"",0))) {
                checkedOutBooks.add(book);
                books.remove(book);
                return true;
            }
        }

        return false;
    }

    public boolean returnBook(String returnBookTitle) {

        Book returnBook = new Book(returnBookTitle, "", 0);

        for (Book checkedOutBook: checkedOutBooks) {
            if(checkedOutBook.equals(returnBook)) {
                books.add(checkedOutBook);
                checkedOutBooks.remove(checkedOutBook);
                return true;
            }

        }

        return false;
    }
}
