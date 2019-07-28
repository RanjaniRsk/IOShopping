package com.shopping.cucumber.ShoppingList;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.ElementOption;

public class ShoppingList_Helper extends ShoppingList_PageElements {

	public AndroidDriver<MobileElement> driver;
	WebDriverWait wait;

	public WebElement element;
	List<AndroidElement> aElement = null;
	MobileElement melement = new AndroidElement();
	ArrayList<String> listOptions = new ArrayList<String>();
	MobileElement melement1 = new AndroidElement();

	public void appLaunchAndShoppingCartNavigation() throws IOException {

		File app = new File("E:\\APK\\OI Shopping List_org.openintents.shopping.apk");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", " OnePlus 6");
		caps.setCapability("platformVersion", "9.0.5");
		caps.setCapability("platformName", "Android");
		caps.setCapability("udid", "e0def1a8");
		caps.setCapability("app", app.getAbsolutePath());
		caps.setCapability("noReset", "true");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		if (getElementPresence(By.xpath(PREFLAYOUT_PHEADER_TXT))) {
			Click(By.id(LAYOUT_BUTTON_RID));
		} else {
			System.out.println("<<<<<LayOut Page Not Displayed >>>>>>>");
		}

	}
	public void createNewList(String value) {
		driver.findElement(By.xpath(HAMBURGER_MENU)).click();
		driver.findElement(By.xpath(NEW_LIST)).click();
		driver.findElement(By.id(INPUT_TEXTBOX_RID)).sendKeys(value);
		driver.findElement(By.xpath(OK_BUTTON)).click();
	}
	
	public void addItemsToList(String listName, List<String> itemValues) {
		driver.findElement(By.xpath(HAMBURGER_MENU)).click();
		String list_XPathString = "//*[@text='" + listName + "']";
		for (String value : itemValues) {
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);			
			driver.findElement(By.xpath(list_XPathString)).click();
			driver.findElement(By.id(ADD_ITEM_INPUTTEXT_RID)).clear();
			driver.findElement(By.id(ADD_ITEM_INPUTTEXT_RID)).sendKeys(value.toString());
			driver.findElement(By.id(ADD_BTN_RID)).click();
			
		}
	}


	public void deleteItemsFromList(String listName) {
		List<MobileElement> element;
		MobileElement melement;
		driver.findElement(By.xpath(HAMBURGER_MENU)).click();
		String list_XPathString = "//android.widget.TextView[@text='" + listName + "']";
		driver.findElement(By.xpath(list_XPathString)).click();
		element = driver.findElements(By.xpath(TOTAL_ITEM_LIST));
		System.out.println("<<<<<<<<<<<NoOfItemsDisplayed : " + element.size());
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);		
		Click(By.xpath(CHECK_BOX_XPATH));
        Click(By.xpath(CLEAN_UP_ITEM));
		
	}

	public void sortandValidationOfSortedListItems() {
		List<String> actualList = new ArrayList<String>();
		List<String> afterSortList = new ArrayList<String>();
		Boolean isSorted;
		driver.findElement(By.xpath(HAMBURGER_MENU)).click();
		actualList = getListItems(AttributeValue.TEXT);
		driver.findElement(By.xpath(HAMBURGER_MENU)).click();
		Click(By.xpath(SETTINGS_MENU));
		Click(By.xpath(SETTINGS_MENU_OPTION));
		Click(By.xpath(CHANGE_SORT_ORDER));
		Click(By.xpath(ALPHABETICAL_SORT));
		hideKeyboard();
		afterSortList = getListItems(AttributeValue.TEXT);
		isSorted =listWithStringComparison(afterSortList,SortOrder.ASCENDING.toString());
		if(isSorted) {
			System.out.println("<<<<<<<<<<<<<<<<<<<<Value is sorted Properly as per Alphabetical Order : "+getItemsFromArrayList(afterSortList));
		}
		else {
			System.out.println("<<<<<<<<<<<<<<<<<<<<Value is not sorted in Alphabetical Order" +getItemsFromArrayList(afterSortList));
		}

	}

	public List<String> getListItems(AttributeValue attributeValue) {
		int countOflist = 0;
		String XpathString = null;
		MobileElement element;
		List<String> attributeList = new ArrayList<String>();
		countOflist = driver.findElements(By.xpath(TOTAL_ITEM_LIST)).size();
		System.out.println("<<<<<<<<<<<<<<<<<<<No of list available : " + countOflist);
		for (int i = 1; i < countOflist; i++) {
			XpathString = "//android.widget.TextView[@text='LIST']/following-sibling::android.widget.FrameLayout["+i+"]/child::android.widget.TextView";
			element = driver.findElement(By.xpath(XpathString));
			attributeList.add(element.getAttribute(attributeValue.toString().toLowerCase()));
			System.out.println("List Value :" + attributeList.get(countOflist));
		}
		return attributeList;

	}

	

	public List<String> getAttributesFromMobileElements(By by, AttributeValue attributeValue) {
		int counter = 0;
		List<String> attributeList = new ArrayList<String>();

		List<MobileElement> elementList = locateElements(by);
		System.out.println("Number of Elements found - " + elementList.size());
		for (WebElement e : elementList) {

			try {
				attributeList.add(e.getAttribute(attributeValue.toString().toLowerCase()));
				System.out.println("Value : " + attributeList.get(counter));
				counter++;
			} catch (NoSuchElementException ex) {
				ex.printStackTrace();
			}

		}
		return attributeList;

	}

	public List<MobileElement> locateElements(By by) {

		List<MobileElement> elements = null;
		try {
			elements = driver.findElements(by);

		} catch (NoSuchElementException e) {
			e.printStackTrace();

		}
		return elements;

	}

	public boolean getElementPresence(By by) {

		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	public MobileElement findElement(By by) {

		MobileElement element = null;

		try {
			element = driver.findElement(by);
		} catch (NoSuchElementException e) {

			return element;
		}

		return element;

	}

	protected void hideKeyboard() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void Click(By by) {
		MobileElement element;
		try {
			element = driver.findElement(by);
			if (!(element == null)) {
				element.click();
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		return;
	}

	public String getTextFromAttribute(By by, String AttributeValue) {
		String value = null;
		try {
			element = findElement(by);
			if (!(AttributeValue == null)) {
				value = element.getAttribute(AttributeValue.toString().toLowerCase());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

	public String getItemsFromArrayList(List<String> value) {
		String result = "";
		for (String temp : value)
			result += temp + ",";
		result = result.substring(0, result.lastIndexOf(","));
		return result;
	}

	public boolean StringListMatch(ArrayList<String> firstValue, ArrayList<String> secondValue) {

		for (int i = 0; i < firstValue.size(); i++) {
			if (firstValue.get(i).equals(secondValue.get(i))) {
				System.out.println(
						"firstValue.get(i) : " + firstValue.get(i) + "SecondValue.get(i) :" + secondValue.get(i));
			} else {
				System.out.println(
						"firstValue.get(i) : " + firstValue.get(i) + "SecondValue.get(i) :" + secondValue.get(i));
				return false;
			}
		}
		return true;
	}

	public boolean listWithStringComparison(List<String> array, String order) {
		int i = 0, count = 0;
		boolean value = false;
		ArrayList<String> array1 = new ArrayList<String>();
		try {
			for (String d : array) {
				array1.add(d);
			}
			Collections.sort(array1);
			switch (order) {
			case "Ascending":
				for (String d : array) {
					if (d.equals(array1.get(i))) {
						count++;
					}
					i++;
				}
				break;
			case "Descending":
				for (int k = array.size() - 1; k >= 0; k--) {
					if (array.get(1).equals(array1.get(k))) {
						count++;
					}
					i++;
				}
				break;
			}
			if (count == array.size()) {
				value = true;
			} else {
				value = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
