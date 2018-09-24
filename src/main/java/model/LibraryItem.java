package model;

// LibraryItem is a book and movie
public interface LibraryItem {

    String getDetails(LibraryItemType libraryItemType);

    boolean compareItem(LibraryItem libraryItemObject, LibraryItemType libraryItemType);

}
