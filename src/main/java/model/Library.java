package model;

import java.util.ArrayList;
import java.util.List;

// Library has list of availableItemsList and also it performs operations on items
public class Library {

    private final List<LibraryItem> availableItemsList;
    private final List<LibraryItem> checkedOutItemsList;
    private final LibraryActionListener librarian;
    private final List<User> users;
    private User currentUser;

    Library(final List<LibraryItem> availableItemsList, LibraryActionListener librarian, List<User> users) {
        this.availableItemsList = availableItemsList;
        this.librarian = librarian;
        this.users = users;
        this.currentUser = null;
        checkedOutItemsList = new ArrayList<>();
    }

    public List<String> getLibraryItemDetails(final LibraryItemType libraryItemType) {
        List<String> itemDetails = new ArrayList<>();
        for (LibraryItem anAvailableItemsList : availableItemsList) {
            String details = anAvailableItemsList.getDetails(libraryItemType);
            if (!details.equals(""))
                itemDetails.add(details);
        }
        return itemDetails;
    }

    public boolean checkoutLibraryItem(final LibraryItem libraryItemObject, final LibraryItemType libraryItemType) {

        for (LibraryItem anAvailableItem : availableItemsList) {
            if (anAvailableItem.compareItem(libraryItemObject, libraryItemType)) {
                checkedOutItemsList.add(anAvailableItem);
                availableItemsList.remove(anAvailableItem);
                librarian.informWhenAnItemCheckedOut();
                return true;
            }
        }
        return false;
    }

    public boolean returnLibraryItem(final LibraryItem libraryItemObject, final LibraryItemType libraryItemType) {

        for (LibraryItem checkedoutItem : checkedOutItemsList) {
            if (checkedoutItem.compareItem(libraryItemObject, libraryItemType)) {
                checkedOutItemsList.remove(checkedoutItem);
                availableItemsList.add(checkedoutItem);
                return true;
            }
        }
        return false;
    }

    public boolean userLoggedIn() {
        return currentUser != null;
    }

    public boolean login(String libraryNumber, String password) {

        for(User user : users) {
            currentUser = user.authenticate(libraryNumber, password) ? user : null;
            if (currentUser != null) {
                return true;
            }
        }

        return false;
    }

    public String getUserInformation() {
        if(currentUser != null)
            return currentUser.toString();
        return "";
    }
}
