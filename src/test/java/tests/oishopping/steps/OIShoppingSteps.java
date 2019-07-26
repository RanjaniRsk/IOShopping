package tests.oishopping.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.shoppinghelper.tests.ShoppingList_Helper;

public class OIShoppingSteps  {

 ShoppingList_Helper helper = new ShoppingList_Helper();
    
   
    @Given("^Create new list \"([^\"]*)\"$")
    public void createNewList(String arg) throws Throwable {
 	
    	helper.createNewList(arg);   	 
    }
    @When("^Add items \"([^\"]*)\" to List \"([^\"]*)\"$")		
    public void addItemsToList(String items, String list) throws Throwable {
        
    	helper.addItemsToList(items,list);
    }
    
    @Then("^Delete an Item from list \"([^\"]*)\"$")
    public void deleteItemsFromList(String arg) throws Throwable {
    	 
    helper.deleteItemsFromList(arg);
       }

    @When("^sorting of Items from list \"([^\"]*)\"$")
    public void validateSortingOfListElements(String arg0) throws Throwable {
    	
      helper.sortListValues(arg0);
    }

    @Then("^Validate the list$")
    public void sortValidationofList() throws Throwable {
    	 
    helper.sortValidationOfListItems();
       }


    @After
    public synchronized void teardown () {
       // teardown();
        System.out.println("teardown'!");
    }
}
