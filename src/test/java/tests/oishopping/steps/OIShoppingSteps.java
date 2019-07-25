package tests.oishopping.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import cucumber.api.java.en.When;
import tests.shoppinghelper.tests.ShoppingList_Helper;

public class OIShoppingSteps  {

 ShoppingList_Helper helper = new ShoppingList_Helper();
    
   
    @Given("^Create new lists \"([^\"]*)\"$")
    public void createNewList(String arg) throws Throwable {
 	
    	helper.createNewList(arg);   	 
    }
    @And("^Add items \"([^\"]*)\"$")		
    public void addItemsToList(String arg) throws Throwable {
        
    	helper.addItemsToList(arg);
    }
    
    @When("^Delete an Item from \"([^\"]*)\"$")
    public void deleteItemsFromList(String arg) throws Throwable {
    	 
    helper.deleteItemsFromList(arg);
       }

    @When("^Validate sorting of Items from list \"([^\"]*)\"$")
    public void validateSortingOfListElements(String arg0) throws Throwable {
    	
      helper.sortListValues(arg0);
    }



    @After
    public synchronized void teardown () {
       // teardown();
        System.out.println("teardown'a girdi!");
    }
}
