package model;

import java.util.ArrayList;
import java.util.List;

// MovieHelper is used to create the movies for the library
class MovieHelper {

    private List<LibraryItem> movies;

    MovieHelper() {

        movies = new ArrayList<>();

        movies.add(new Movie("Avatar", 2009,  "James Cameron", "10"));
        movies.add(new Movie("Pulp Fiction", 1994,"Quentin Tarantino", "10"));
        movies.add(new Movie("Dunkirk", 2017,"Christopher Nolan", "7"));
        movies.add(new Movie("Batman Begins", 2005,"Christopher Nolan", "9"));

    }

    List<LibraryItem> getMovies() {
        return movies;
    }

}
