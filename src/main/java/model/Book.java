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

    public boolean compareItem(LibraryItem libraryItemToBeCheckout, LibraryItemType libraryItemType) {
        if(libraryItemType == this.itemType) {
            return this.equals(libraryItemToBeCheckout);
        }
        return false;
    }

    @Override
    public boolean equals(Object libraryItemToBeCheckout){
        if (this == libraryItemToBeCheckout){
            return true;
        }
        if (libraryItemToBeCheckout == null || getClass() != libraryItemToBeCheckout.getClass()){
            return false;
        }
        Book book = (Book) libraryItemToBeCheckout;
        return Objects.equals(title, book.title);
    }


}
