package model;

import java.util.Objects;

// Movie is a LibraryItem has state like name, year, director and rating
public class Movie implements LibraryItem{

    private final String name;
    private final int year;
    private final String director;
    private final String rating;
    private final LibraryItemType itemType = LibraryItemType.MOVIE;

    public Movie(final String name, final int year, final String director, final String rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public String getDetails(final LibraryItemType libraryItemType) {
        if(libraryItemType == this.itemType) {
            return name + "," + year + "," + director + "," + rating;
        }
        return "";
    }

    public boolean compareItem(final LibraryItem libraryItemObject, final LibraryItemType libraryItemType) {
        if(libraryItemType == LibraryItemType.MOVIE) {
            if (this == libraryItemObject){
                return true;
            }
            if (libraryItemObject == null || getClass() != libraryItemObject.getClass()){
                return false;
            }
            Movie movie = (Movie) libraryItemObject;
            return Objects.equals(this.name, movie.name);
        }
        return false;
    }

}
