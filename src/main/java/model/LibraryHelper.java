package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// LibraryHelper is used to create a new Library for the Library Management System.
public class LibraryHelper {

    public Library createLibrary(LibraryActionListener librarian) {

        BookHelper bookHelper = new BookHelper();
        MovieHelper movieHelper = new MovieHelper();

        List<LibraryItem> availableItemList = new ArrayList<>();
        availableItemList.addAll(bookHelper.getBooks());
        availableItemList.addAll(movieHelper.getMovies());

        List<User> users = new ArrayList<>(createUsers());

        return new Library(availableItemList, librarian, users);

    }

    private Collection<? extends User> createUsers() {

        final List<User> users = new ArrayList<>();

        users.add(new User("Bhavana", "bhavana.p@thoughtworks.com", "8985322285", "123-121510", "bhavana"));
        users.add(new User("Anju", "anju.g@oracle.com", "8333960577", "123-121451", "anju"));
        users.add(new User("Sindhu", "sindhu@thoughtworks.com", "8888899999", "123-121512", "sindhu"));
        users.add(new User("Roshini", "roshini.j@gmail.com", "9090909090", "123-121511", "roshini"));

        return users;
    }


}
