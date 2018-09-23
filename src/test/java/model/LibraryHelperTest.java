package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class LibraryHelperTest {

    @DisplayName("Should return a new Library")
    @Test
    void testShouldReturnNewLibrary() {
        LibraryActionListener librarian = mock(LibraryActionListener.class);
        assertEquals(Library.class, new LibraryHelper().createLibrary(librarian).getClass());
    }

}
