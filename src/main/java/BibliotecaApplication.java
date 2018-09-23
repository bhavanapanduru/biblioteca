import model.Library;
        import model.LibraryActionListener;
        import model.LibraryHelper;
        import controller.LibraryManagementSystem;
        import view.InputDriver;
        import view.OutputDriver;

// model is an Library Management System Application
public class BibliotecaApplication {

    public static void main(String[] args) {

        LibraryActionListener librarian = () -> {
        };

        Library library = new LibraryHelper().createLibrary(librarian);
        LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem(
                new OutputDriver(), new InputDriver(), library).initializeMenu();

        start(libraryManagementSystem);

    }

    private static void start(LibraryManagementSystem libraryManagementSystem) {
        libraryManagementSystem.displayWelcomeMessage();
        libraryManagementSystem.displayMenu();
    }

}