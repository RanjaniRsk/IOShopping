package com.shopping.cucumber.ShoppingList;

import java.util.List;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingListStepDef {
		
	ShoppingList_Helper helper = new ShoppingList_Helper();
@Given("Launch the application and navigate to Shopping Screen")	 
public void appLaunchAndLayoutNavigation() throws Throwable  {
	helper.appLaunchAndShoppingCartNavigation();
}
	
@And("^Create new list \"([^\"]*)\"$")
public void createNewList(String value){
	helper.createNewList(value);
	}

@When("^Add items to list \"([^\"]*)\"$")
public void addItemToList(String listName, List<String> itemValues) {
	helper.addItemsToList(listName, itemValues);
}

@Then("^Delete an Item from list \"([^\"]*)\"$")
public void deleteItemsFromList(String list) throws Throwable {
	helper.deleteItemsFromList(list);
   }

@Then("^Sort shopping list and validate sorting of list items$")
public void sortAndValidationOfSortedItems() {
	helper.sortandValidationOfSortedListItems();
}

		
	
	
}
