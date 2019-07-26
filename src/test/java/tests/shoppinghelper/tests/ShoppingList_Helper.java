package tests.shoppinghelper.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import tests.shoppinghelper.tests.OIShopping_Constants;
import tests.shoppinghelper.tests.OIShopping_Constants.AttributeValue;
import tests.shoppinghelper.tests.OIShopping_Constants.LocatorType;
import tests.shoppinghelper.tests.Operations_Android;

public class ShoppingList_Helper extends OIShopping_Constants{

	ArrayList<String> listOptions1 = new ArrayList<String>();
	public static AndroidDriver<MobileElement> driver;
	Operations_Android opj = new Operations_Android(driver);
	protected ShoppingList_Helper shoppingHelper = null;
	MobileElement element = new AndroidElement();
	
	public void createNewList(String value) {
		String listName = getlistName(value);
		try {
			if (opj.findElement(NAVIGATION_DRAWER, LocatorType.XPATH)) {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<Navigation Drawer is Displayed>>>>>>>>>>");
				opj.Click(NAVIGATION_DRAWER, LocatorType.XPATH);
				if (opj.findElement(NEW_LIST_RID, LocatorType.ID)) {
					opj.Click(NEW_LIST_RID, LocatorType.ID);
					System.out.println("<<<<<<<<<<<Clicked On New List Option>>>>>>>>>>>>>>>>>");

					if (opj.findElement(ALERT_TITLE_RID, LocatorType.ID)) {
						element = opj.findElement(INPUTTEXT_RID);
						element.clear();
						element.sendKeys(listName);
						opj.Click(OKBUTTON_TXT, LocatorType.XPATH);
						System.out.println("<<<<<<<<<<<<<List Name Created " + listName.toString());
					}
				} else {
					System.out.println("<<<<<<<<<<<<New List Option is missing in Menu>>>>>>>>>>");
				}
			}

			else {
				System.out.println("<<<<<<<<<<<<<<<<<<<Navigation Drawer is not Displayed>>>>>>>>>>>>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void addItemsToList(String arg) {
		ArrayList<String> listItems = getItemslistName(arg);
		String listName = listItems.get(0);
		try {
			if (opj.findElement(NAVIGATION_DRAWER, LocatorType.XPATH)) {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<Navigation Drawer is Displayed>>>>>>>>>>>");
				opj.Click(NAVIGATION_DRAWER, LocatorType.XPATH);
				if (opj.findElement(listName, LocatorType.XPATHGEN)) {
					opj.Click(listName, LocatorType.XPATHGEN);
					System.out.println("<<<<<<<<<<<Clicked On List " + listName);
				} else {
					System.out.println("<<<<<<<<<<<<New List Option is missing in Menu>>>>>>>>>>");
				}
				for (String list : listItems) {
					if (opj.findElement(INPUTTEXT_RID, LocatorType.ID)) {
						opj.findElement(INPUTTEXT_RID).sendKeys(list);
						opj.Click(ADD_BTN, LocatorType.ID);
						opj.hideKeyboard();
					}
				}

			} else {
				System.out.println("<<<<<<<<<<<<<<<<<<<Navigation Drawer is not Displayed>>>>>>>>>>>>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteItemsFromList(String value) {
		String listName = getlistName(value);
		try {
			if (opj.findElement(NAVIGATION_DRAWER, LocatorType.XPATH)) {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<Navigation Drawer is Displayed>>>>>>>>>>>");
				opj.Click(NAVIGATION_DRAWER, LocatorType.XPATH);
				if (opj.findElement(listName, LocatorType.XPATHGEN)) {
					opj.Click(listName, LocatorType.XPATHGEN);
					System.out.println("<<<<<<<<<<<Clicked On List " + listName);
				} else {
					System.out.println("<<<<<<<<<<<<Given " + listName + "is missing in Menu");
				}
				List<MobileElement> elements = opj.findElements(ITEM_LIST);
				elements.size();
				System.out.println(
						"<<<<<<<<<<<<<<User is displayed with : " + element.getSize() + "Options in iTem List");

				opj.Click(CHECKBOX_ITEMLIST, LocatorType.XPATH);
				if (opj.findElement(SETTINGS_MENU, LocatorType.ID)) {
					opj.Click(SETTINGS_MENU, LocatorType.ID);
					opj.findElement(DELETE_LIST, LocatorType.XPATH);
					if (opj.findElement(DELETE_LIST, LocatorType.XPATH)) {
						System.out.println("<<<<<<<<<<<<<Alert Pop-up is displayed with Cancel and OK Button");
						opj.Click(OKBUTTON_TXT, LocatorType.XPATH);
						System.out.println("<<<<<<<<<<<<<Item Deleted from the List>>>>>>>>>>");
					} else {
						System.out.println("<<<<<<<<<<<<<Alert Pop-up is not displayed to delete the item");
					}
				}
			} else {
				System.out.println("<<<<<<<<<<<<<<<<<<<Navigation Drawer is not Displayed>>>>>>>>>>>>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sortListValues(String listName) {

		ArrayList<String> itemList_Vegetable = new ArrayList<>(Arrays.asList("Cabbage", "Carrot", "Potato", "Tomato"));
		try {
			if (opj.findElement(NAVIGATION_DRAWER, LocatorType.XPATH)) {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<Navigation Drawer is Displayed>>>>>>>>>>>");
				opj.Click(NAVIGATION_DRAWER, LocatorType.XPATH);
				if (opj.findElement(listName, LocatorType.XPATHGEN)) {
					System.out.println("<<<<<<<<<<<Clicked On List " + listName);
				} else {
					System.out.println("<<<<<<<<<<<<Given " + listName + "is missing in Menu");
				}
				List<MobileElement> elements = opj.findElements(ITEM_LIST);
				elements.size();
				System.out.println(
						"<<<<<<<<<<<<<<User is displayed with : " + element.getSize() + "Options in iTem List");		
				opj.Click(SETTINGS_MENU,LocatorType.XPATH);
				opj.Click(SORT_ORDER, LocatorType.XPATH);
				opj.Click(ALPHABATICAL_ORDER, LocatorType.XPATH);
				ArrayList<String> iTemValuesDisplayed = opj.getTextFromAttributes(ITEM_LIST,
						AttributeValue.TEXT.toString());
				Boolean isMatching = StringListMatch(itemList_Vegetable, iTemValuesDisplayed);
				if (isMatching) {
					System.out.println(
							"<<<<<<<<<<<<<<<<<<<<Values displayed in the Itemlist is not sorted in proper order ,"
									+ " Actual Value Displayed" + getItemsFromArrayList(iTemValuesDisplayed)
									+ "Sorted Items" + getItemsFromArrayList(itemList_Vegetable));
				} else {
					System.out
							.println("<<<<<<<<<<<<<<<<<<<<Values displayed in the Itemlist is Sorted in proper order , "
									+ "Actual Value Displayed" + getItemsFromArrayList(iTemValuesDisplayed)
									+ "Sorted Items" + getItemsFromArrayList(itemList_Vegetable));
				}
			} else {
				System.out.println("<<<<<<<<<<<<<<<<<<<Navigation Drawer is not Displayed>>>>>>>>>>>>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return;

	}

	
	public String getItemsFromArrayList(ArrayList<String> value) {
		String result="";
		for(String temp : value)
			result += temp+",";
		result = result.substring(0,result.lastIndexOf(","));		
		return null;		
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

	public boolean listWithStringComparison(ArrayList<String> array, String flow) {
		int i = 0, count = 0;
		boolean value = false;
		ArrayList<String> array1 = new ArrayList<String>();
		try {
			for (String d : array) {
				array1.add(d);
			}
			Collections.sort(array1);
			switch (flow) {
			case "Ascending":
				for (String d : array) {
					if (d.equals(array1.get(i))) {
						count++;
					}
					i++;				}
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
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public String getlistName(String value) {
		String[] val = value.split("list",2);
		value= val[1].trim();				
		return value;		
	}
	
public ArrayList<String> getItemslistName(String value) {
		
	    ArrayList<String> list = new ArrayList<>();	
		String[] listname =	value.split("to List", 2);
		list.add(listname[1].trim());
		String[] sample = listname[0].split("items", 2);
		String[] itemList =sample[1].split(",", 3);
		list.add(itemList[0].trim());
		list.add(itemList[1].trim());
		list.add(itemList[2].trim());		
		return list;
		
	}
}
