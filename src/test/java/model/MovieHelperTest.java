package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieHelperTest {

    private MovieHelper movieHelper;
    private List<LibraryItem> movies;

    @BeforeEach
    void init() {
        movieHelper = new MovieHelper();

        movies = new ArrayList<>();
        movies.add(new Movie("Avatar", 2009, "James Cameron", "10"));
        movies.add(new Movie("Pulp Fiction", 1994, "Quentin Tarantino", "10"));
        movies.add(new Movie("Dunkirk", 2017, "Christopher Nolan", "7"));
        movies.add(new Movie("Batman Begins", 2005, "Christopher Nolan", "9"));
    }

    @DisplayName("Should return correct Books")
    @Test
    void testShouldReturnCorrectBooks() {

        assertEquals(movies.get(0).getDetails(LibraryItemType.MOVIE), movieHelper.getMovies().get(0).getDetails(LibraryItemType.MOVIE));
        assertEquals(movies.get(1).getDetails(LibraryItemType.MOVIE), movieHelper.getMovies().get(1).getDetails(LibraryItemType.MOVIE));
        assertEquals(movies.get(2).getDetails(LibraryItemType.MOVIE), movieHelper.getMovies().get(2).getDetails(LibraryItemType.MOVIE));
        assertEquals(movies.get(3).getDetails(LibraryItemType.MOVIE), movieHelper.getMovies().get(3).getDetails(LibraryItemType.MOVIE));

    }
}
