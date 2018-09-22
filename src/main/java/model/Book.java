package model;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final int publishedYear;

    public Book(String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return title + "," + author + "," + publishedYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publishedYear);
    }
}
