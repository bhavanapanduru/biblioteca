package Biblioteca;

// Book has a title
public class Book {

    private final String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
