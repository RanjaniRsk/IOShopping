$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/shopping/cucumber/features/Shopping.feature");
formatter.feature({
  "line": 4,
  "name": "Validation of Add , Delete and Sort functionality of Shopping Cart",
  "description": "",
  "id": "validation-of-add-,-delete-and-sort-functionality-of-shopping-cart",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@ShoppingListValidation"
    }
  ]
});
formatter.scenario({
  "line": 8,
  "name": "Create New list , add Items and delete an Item from the List",
  "description": "",
  "id": "validation-of-add-,-delete-and-sort-functionality-of-shopping-cart;create-new-list-,-add-items-and-delete-an-item-from-the-list",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@AddAndDeleteLIstItem"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "Launch the application and navigate to Shopping Screen",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Create new list \"Electronics\"",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Create new list \"Watches\"",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Add items to list \"Electronics\"",
  "rows": [
    {
      "cells": [
        "Camera",
        "Computer",
        "Tablet"
      ],
      "line": 13
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "Add items to list \"Watches\"",
  "rows": [
    {
      "cells": [
        "Fossil",
        "Casio",
        "Timex"
      ],
      "line": 15
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "Delete an Item from list \"Electronics\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ShoppingListStepDef.appLaunchAndLayoutNavigation()"
});
