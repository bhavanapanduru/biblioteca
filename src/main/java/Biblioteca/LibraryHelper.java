package Biblioteca;

public class LibraryHelper {

    private Library library;
    private BookHelper bookHelper;

    public Library createLibrary() {

        bookHelper = new BookHelper();
        library = new Library(bookHelper.getBooks());

        return library;

    }

}
