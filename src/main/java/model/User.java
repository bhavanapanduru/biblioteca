package model;

// User is a person who can checkout and return Item of a Library
class User {

    private final String name;
    private final String emailAddress;
    private final String PhoneNumber;
    private final String libraryNumber;
    private final String password;

    User(final String name, final String emailAddress, final String phoneNumber,
         final String libraryNumber, final String password) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.PhoneNumber = phoneNumber;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean login(final String libraryNumber, final String password) {
        return this.libraryNumber.equals(libraryNumber) && this.password.equals(password);
    }

    @Override
    public String toString() {
        return name + ',' + emailAddress + ',' +PhoneNumber;
    }
}
