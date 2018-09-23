package model;

import java.util.Objects;

// Book is a LibraryItem has state like title, author, published year.
public class Book implements LibraryItem{
    private final String title;
    private final String author;
    private final int publishedYear;
    private final LibraryItemType itemType = LibraryItemType.BOOK;

    public Book(String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getDetails(LibraryItemType libraryItemType) {
        if(libraryItemType == LibraryItemType.BOOK) {
            return title + "," + author + "," + publishedYear;
        }
        return "";
    }

    public boolean compareItem(LibraryItem libraryItemObject, LibraryItemType libraryItemType) {
        if(libraryItemType == LibraryItemType.BOOK) {
            if (this == libraryItemObject){
                return true;
            }
            if (libraryItemObject == null || getClass() != libraryItemObject.getClass()){
                return false;
            }
            Book book = (Book) libraryItemObject;
            return Objects.equals(title, book.title);
        }
        return false;
    }
}
