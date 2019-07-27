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
formatter.result({
  "duration": 10283855345,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Electronics",
      "offset": 17
    }
  ],
  "location": "ShoppingListStepDef.createNewList(String)"
});
formatter.result({
  "duration": 6962998931,
  "error_message": "org.openqa.selenium.NoSuchElementException: An element could not be located on the page using the given search parameters.\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027DESKTOP-ADCM4MU\u0027, ip: \u0027192.168.0.101\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_161\u0027\nDriver info: io.appium.java_client.android.AndroidDriver\nCapabilities {app: E:\\APK\\OI Shopping List_org..., appActivity: org.openintents.shopping.Sh..., appPackage: org.openintents.shopping, appWaitActivity: org.openintents.shopping.Sh..., appWaitPackage: org.openintents.shopping, databaseEnabled: false, desired: {app: E:\\APK\\OI Shopping List_org..., deviceName:  OnePlus 6, noReset: true, platformName: android, platformVersion: 9.0.5, udid: e0def1a8}, deviceManufacturer: OnePlus, deviceModel: ONEPLUS A6000, deviceName: e0def1a8, deviceScreenSize: 1080x2280, deviceUDID: e0def1a8, javascriptEnabled: true, locationContextEnabled: false, networkConnectionEnabled: true, noReset: true, platform: LINUX, platformName: Android, platformVersion: 9, takesScreenshot: true, udid: e0def1a8, warnings: {}, webStorageEnabled: false}\nSession ID: f24e750c-cde9-47cd-ad0a-90f5c37f2d1b\n*** Element info: {Using\u003did, value\u003dorg.openintents.shopping:id/edittext}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\r\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat io.appium.java_client.remote.AppiumCommandExecutor.execute(AppiumCommandExecutor.java:239)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:42)\r\n\tat io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.execute(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:62)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:372)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElementById(DefaultGenericMobileDriver.java:70)\r\n\tat io.appium.java_client.AppiumDriver.findElementById(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElementById(AndroidDriver.java:1)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:188)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\r\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:58)\r\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\r\n\tat io.appium.java_client.android.AndroidDriver.findElement(AndroidDriver.java:1)\r\n\tat com.shopping.cucumber.ShoppingList.ShoppingList_Helper.createNewList(ShoppingList_Helper.java:59)\r\n\tat com.shopping.cucumber.ShoppingList.ShoppingListStepDef.createNewList(ShoppingListStepDef.java:20)\r\n\tat ✽.And Create new list \"Electronics\"(src/test/java/shopping/cucumber/features/Shopping.feature:10)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Watches",
      "offset": 17
    }
  ],
  "location": "ShoppingListStepDef.createNewList(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Electronics",
      "offset": 19
    }
  ],
  "location": "ShoppingListStepDef.addItemToList(String,String\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Watches",
      "offset": 19
    }
  ],
  "location": "ShoppingListStepDef.addItemToList(String,String\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Electronics",
      "offset": 26
    }
  ],
  "location": "ShoppingListStepDef.deleteItemsFromList(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 19,
  "name": "Sort validation of list items",
  "description": "",
  "id": "validation-of-add-,-delete-and-sort-functionality-of-shopping-cart;sort-validation-of-list-items",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 18,
      "name": "@AddAndSortValidation"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "Create new list \"Grocery\"",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "Add items to list \"Grocery\"",
  "rows": [
    {
      "cells": [
        "Cereal",
        "Spices",
        "Pastas",
        "Sweets"
      ],
      "line": 22
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "Sort shopping list and validate sorting of list items",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Grocery",
      "offset": 17
    }
  ],
  "location": "ShoppingListStepDef.createNewList(String)"
});
formatter.result({
  "duration": 222772,
  "error_message": "java.lang.NullPointerException\r\n\tat com.shopping.cucumber.ShoppingList.ShoppingList_Helper.createNewList(ShoppingList_Helper.java:57)\r\n\tat com.shopping.cucumber.ShoppingList.ShoppingListStepDef.createNewList(ShoppingListStepDef.java:20)\r\n\tat ✽.Given Create new list \"Grocery\"(src/test/java/shopping/cucumber/features/Shopping.feature:20)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Grocery",
      "offset": 19
    }
  ],
  "location": "ShoppingListStepDef.addItemToList(String,String\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ShoppingListStepDef.sortAndValidationOfSortedItems()"
});
formatter.result({
  "status": "skipped"
});
});