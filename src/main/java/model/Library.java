package model;

import java.util.ArrayList;
import java.util.List;

// Library has list of availableItems and also it performs operations on items
public class Library {

    private final List<LibraryItem> availableItems;
    private final List<LibraryItem> checkedOutItems;
    private final LibraryActionListener librarian;
    private final List<User> users;
    private User currentUser;

    Library(final List<LibraryItem> availableItems, final LibraryActionListener librarian, final List<User> users) {
        this.availableItems = availableItems;
        this.librarian = librarian;
        this.users = users;
        this.currentUser = null;
        checkedOutItems = new ArrayList<>();
    }

    public List<String> getLibraryItemDetails(final LibraryItemType libraryItemType) {
        final List<String> itemDetails = new ArrayList<>();
        for (LibraryItem anAvailableItemsList : availableItems) {
            String details = anAvailableItemsList.getDetails(libraryItemType);
            if (!details.equals(""))
                itemDetails.add(details);
        }
        return itemDetails;
    }

    public boolean checkoutLibraryItem(final LibraryItem libraryItemToBeCheckout, final LibraryItemType libraryItemType) {

        for (LibraryItem anAvailableItem : availableItems) {
            if (anAvailableItem.compareItem(libraryItemToBeCheckout, libraryItemType)) {
                checkedOutItems.add(anAvailableItem);
                availableItems.remove(anAvailableItem);
                librarian.informWhenAnItemCheckedOut();
                return true;
            }
        }
        return false;
    }

    public boolean returnLibraryItem(final LibraryItem libraryItemToBeReturn, final LibraryItemType libraryItemType) {

        for (LibraryItem checkedoutItem : checkedOutItems) {
            if (checkedoutItem.compareItem(libraryItemToBeReturn, libraryItemType)) {
                checkedOutItems.remove(checkedoutItem);
                availableItems.add(checkedoutItem);
                return true;
            }
        }
        return false;
    }

    public boolean isUserLoggedIn() {
        return currentUser != null;
    }

    public boolean authenticate(final String libraryNumber, final String password) {

        for (User user : users) {
            currentUser = user.login(libraryNumber, password) ? user : null;
            if (currentUser != null) {
                return true;
            }
        }

        return false;
    }

    public String getUserInformation() {
        if (currentUser != null)
            return currentUser.toString();
        return "";
    }

    public boolean unauthenticateUser() {
        currentUser = currentUser.logout();
        return currentUser == null;
    }
}
