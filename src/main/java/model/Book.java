package model;

import java.util.Objects;

// Book is a LibraryItem has state like title, author, published year.
public class Book implements LibraryItem{
    private final String title;
    private final String author;
    private final int publishedYear;
    private final LibraryItemType itemType = LibraryItemType.BOOK;

    public Book(final String title, final String author, final int publishedYear) {
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

    public boolean compareItem(LibraryItem libraryItem, LibraryItemType libraryItemType) {
        if(libraryItemType == this.itemType) {
            return equals(libraryItem);
        }
        return false;
    }

    @Override
    public boolean equals(Object libraryItem){
        if (this == libraryItem){
            return true;
        }
        if (libraryItem == null || getClass() != libraryItem.getClass()){
            return false;
        }
        Book book = (Book) libraryItem;
        return Objects.equals(title, book.title);
    }


}
