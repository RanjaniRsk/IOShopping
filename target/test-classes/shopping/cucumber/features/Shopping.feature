

@ShoppingListValidation
Feature: Validation of Add , Delete and Sort functionality of Shopping Cart
  

  @AddAndDeleteLIstItem
  Scenario: Create New list , add Items and delete an Item from the List
    Given Launch the application and navigate to Shopping Screen
    And Create new list "Electronics"
    And Create new list "Watches"
    When Add items to list "Electronics"
    | Camera | Computer | Tablet |
    And Add items to list "Watches"
    | Fossil | Casio | Timex |
    Then Delete an Item from list "Electronics"
   
  @AddAndSortValidation
  Scenario: Sort validation of list items
    Given Create new list "Grocery"
    When Add items to list "Grocery"    
     | Cereal | Spices | Pastas | Sweets |
    Then Sort shopping list and validate sorting of list items
