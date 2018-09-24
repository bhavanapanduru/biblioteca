package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user1;
    private User user2;

    @BeforeEach
    void init() {

        user1 = new User("Bhavana", "bhavana.p@thoughtworks.com", "8985322285", "123-121510", "bhavana");
        user2 = new User("Anju", "anju.g@oracle.com", "8333960577", "123-121451", "anju");

    }

    @DisplayName("should expects true if a object credentials are equal with user given credentials")
    @Test
    void testShouldReturnTrueIfCredentailsAreEqual() {
        assertTrue(user1.login("123-121510", "bhavana"));
    }

    @DisplayName("should expects false if a object credentials are not equal with user given credentials")
    @Test
    void testShouldReturnFalseIfCredentailsAreNotEqual() {
        assertFalse(user2.login("123-121510", "bhavana"));
    }

    @DisplayName("should return correct name, email address and phone number")
    @Test
    void testShouldReturnNameEmailAddressAndPhoneNumberCorrectly() {
        assertEquals("Bhavana,bhavana.p@thoughtworks.com,8985322285", user1.toString());
        assertNotEquals("Anju,bhavana.p@thoughtworks.com,8985322285", user1.toString());
    }

}
