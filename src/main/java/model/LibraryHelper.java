package model;

import java.util.ArrayList;
import java.util.List;

// LibraryHelper is used to create a new Library for the Library Management System.
public class LibraryHelper {

    public Library createLibrary() {

        BookHelper bookHelper = new BookHelper();
        MovieHelper movieHelper = new MovieHelper();

        List<LibraryItem> availableItemList = new ArrayList<>();
        availableItemList.addAll(bookHelper.getBooks());
        availableItemList.addAll(movieHelper.getMovies());

        return new Library(availableItemList);

    }

}
