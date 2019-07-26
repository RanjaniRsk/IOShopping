
Feature: Add,Delete and Sort functionality of Shopping List

  Scenario: Deletion of an item from the added list
    Given Create new list "FRUITS"
    And	Create new list "FOOD"
    When Add items "Apple,Orange,Grapes" to List "FRUITS"
    And Add items "Bread,Egg,Milk" to List "FOOD"
    Then Delete an Item from list "FRUITS"
    
    
  Scenario: Sort Validation of List Items
  Given Create new list "VEGETABLES"
    And	Add items "Cabbage,Carrot,Tomato,Potato" to List "VEGETABLES"
    When sorting of Items from list "VEGETABLES"
    Then Validate the list
   
    