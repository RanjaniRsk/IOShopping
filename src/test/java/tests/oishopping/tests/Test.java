package tests.oishopping.tests;

import tests.BaseTest;
import tests.shoppinghelper.tests.ShoppingList_Helper;

public class Test extends BaseTest{

	ShoppingList_Helper helper = new ShoppingList_Helper();
	
	
    public void validateDeletionOfElementSfterAddingItemToList(String arg) throws Throwable {
	 	
	    	helper.createNewList(arg);
	    	helper.addItemsToList(arg);
	    	helper.deleteItemsFromList(arg);
	    }
	
public void validateSortFunctionalityAfterAddingItemToList(String arg) throws Throwable {
 	
	helper.createNewList(arg);
	helper.addItemsToList(arg);
	helper.sortListValues(arg);
}    
	  
	   
	    }





