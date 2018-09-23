package model;

import java.util.ArrayList;
import java.util.List;

// Library has list of availableItemsList and also it performs operations on items
public class Library {

    private final List<LibraryItem> availableItemsList;
    private final List<LibraryItem> checkedOutItemsList;

    Library(final List<LibraryItem> availableItemsList) {
        this.availableItemsList = availableItemsList;
        checkedOutItemsList = new ArrayList<>();
    }

    public List<String> getLibraryItemDetails(final LibraryItemType libraryItemType) {
        List<String> itemDetails = new ArrayList<>();
        for (LibraryItem anAvailableItemsList : availableItemsList) {
            String details = anAvailableItemsList.getDetails(libraryItemType);
            if(!details.equals(""))
                itemDetails.add(details);
        }
        return itemDetails;
    }

    public boolean checkoutLibraryItem(final LibraryItem libraryItemObject,final LibraryItemType libraryItemType) {

        for (LibraryItem anAvailableItem : availableItemsList) {
            if(anAvailableItem.compareItem(libraryItemObject, libraryItemType)){
                checkedOutItemsList.add(anAvailableItem);
                availableItemsList.remove(anAvailableItem);
                return true;
            }
        }
        return false;
    }

    public boolean returnLibraryItem(final LibraryItem libraryItemObject, final LibraryItemType libraryItemType) {


        for (LibraryItem checkedoutItem : checkedOutItemsList) {
            if(checkedoutItem.compareItem(libraryItemObject, libraryItemType)){
                checkedOutItemsList.remove(checkedoutItem);
                availableItemsList.add(checkedoutItem);
                return true;
            }
        }
        return false;
    }
}
