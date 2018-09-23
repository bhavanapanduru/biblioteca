package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryHelperTest {

    @DisplayName("Should return a new Library")
    @Test
    void testShouldReturnNewLibrary() {
        assertEquals(Library.class, new LibraryHelper().createLibrary().getClass());
    }

}
