package Biblioteca;

// Book has a title
public class Book {

    private final String title;
    private final String author;
    private final int publishedYear;

    public Book(final String title, final String author, final int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return title + "," + author + "," + publishedYear;
    }

}
