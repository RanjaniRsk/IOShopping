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

public class ShoppingList_Helper {

	ArrayList<String> listOptions1 = new ArrayList<String>();
	public static AndroidDriver<MobileElement> driver;
	Operations_Android opj = new Operations_Android(driver);
	protected ShoppingList_Helper shoppingHelper = null;
	MobileElement element = new AndroidElement();

	public void createNewList(String value) {
		String listName= getlistName(value);
		if (opj.findElement(OIShopping_Constants.NAVIGATION_DRAWER, LocatorType.XPATH)) {
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<Navigation Drawer is Displayed>>>>>>>>>>>");
				opj.Click(OIShopping_Constants.NAVIGATION_DRAWER, LocatorType.XPATH);
				if (opj.findElement(OIShopping_Constants.NEW_LIST_RID, LocatorType.ID)) {
					opj.Click(OIShopping_Constants.NEW_LIST_RID, LocatorType.ID);
					System.out.println("<<<<<<<<<<<Clicked On New List Option>>>>>>>>>>>>>>>>>");

					if (opj.findElement(OIShopping_Constants.ALERT_TITLE_RID, LocatorType.ID)) {
						element = opj.findElement(OIShopping_Constants.INPUTTEXT_RID);
						element.clear();
						element.sendKeys(listName);
						opj.Click(OIShopping_Constants.OKBUTTON_TXT, LocatorType.XPATH);
						System.out.println("<<<<<<<<<<<<<List Name Created "+listName.toString());
					}
				} else {
					System.out.println("<<<<<<<<<<<<New List Option is missing in Menu>>>>>>>>>>");
				}
			}

		else {
			System.out.println("<<<<<<<<<<<<<<<<<<<Navigation Drawer is not Displayed>>>>>>>>>>>>");
		}

	}

	public void addItemsToList(String arg) {
		 
		 ArrayList<String> listItems = getItemslistName(arg);
		 String listName =listItems.get(0);
		if (opj.findElement(OIShopping_Constants.NAVIGATION_DRAWER, LocatorType.XPATH)) {
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<Navigation Drawer is Displayed>>>>>>>>>>>");
			opj.Click(OIShopping_Constants.NAVIGATION_DRAWER, LocatorType.XPATH);
			if (opj.findElement(listName, LocatorType.XPATHGEN)) {
				opj.Click(listName, LocatorType.XPATHGEN);
				System.out.println("<<<<<<<<<<<Clicked On List " + listName);
			} else {
				System.out.println("<<<<<<<<<<<<New List Option is missing in Menu>>>>>>>>>>");
			}
			for (String list : listItems) {
				if (opj.findElement(OIShopping_Constants.INPUTTEXT_RID, LocatorType.ID)) {
					opj.findElement(OIShopping_Constants.INPUTTEXT_RID).sendKeys(list);
					opj.Click(OIShopping_Constants.ADD_BTN, LocatorType.ID);
					opj.hideKeyboard();
				}
			}

		} else {
			System.out.println("<<<<<<<<<<<<<<<<<<<Navigation Drawer is not Displayed>>>>>>>>>>>>");
		}

	}

	public void deleteItemsFromList(String value) {
		String listName= getlistName(value);
		if (opj.findElement(OIShopping_Constants.NAVIGATION_DRAWER, LocatorType.XPATH)) {
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<Navigation Drawer is Displayed>>>>>>>>>>>");
			opj.Click(OIShopping_Constants.NAVIGATION_DRAWER, LocatorType.XPATH);
			if (opj.findElement(listName, LocatorType.XPATHGEN)) {
				opj.Click(listName, LocatorType.XPATHGEN);
				System.out.println("<<<<<<<<<<<Clicked On List " + listName);
			} else {
				System.out.println("<<<<<<<<<<<<Given " + listName + "is missing in Menu");
			}
			List<MobileElement> elements = opj.findElements(OIShopping_Constants.ITEM_LIST);
			elements.size();
			System.out.println("<<<<<<<<<<<<<<User is displayed with : " + element.getSize() + "Options in iTem List");
			
			    	opj.Click(OIShopping_Constants.CHECKBOX_ITEMLIST,LocatorType.XPATH);
					if (opj.findElement(OIShopping_Constants.SETTINGS_MENU, LocatorType.ID)) {
						opj.Click(OIShopping_Constants.SETTINGS_MENU, LocatorType.ID);
						opj.findElement(OIShopping_Constants.DELETE_LIST, LocatorType.TEXT);
						if (opj.findElement(OIShopping_Constants.DELETE_LIST, LocatorType.TEXT)) {
							System.out.println("<<<<<<<<<<<<<Alert Pop-up is displayed with Cancel and OK Button");
							opj.Click(OIShopping_Constants.OKBUTTON_TXT, LocatorType.TEXT);
							System.out.println("<<<<<<<<<<<<<Item Deleted from the List>>>>>>>>>>");
						} else {
							System.out.println("<<<<<<<<<<<<<Alert Pop-up is not displayed to delete the item");						
				}
			}
		} else {
			System.out.println("<<<<<<<<<<<<<<<<<<<Navigation Drawer is not Displayed>>>>>>>>>>>>");
		}

	}

	public void sortListValues(String listName) {
		
		ArrayList<String> itemList_Vegetable = new ArrayList<>(Arrays.asList("Cabbage", "Carrot", "Potato", "Tomato"));

		if (opj.findElement(OIShopping_Constants.NAVIGATION_DRAWER, LocatorType.TEXT)) {
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<Navigation Drawer is Displayed>>>>>>>>>>>");
			opj.Click(OIShopping_Constants.NAVIGATION_DRAWER, LocatorType.TEXT);
			if (opj.findElement(listName, LocatorType.XPATHGEN)) {
				System.out.println("<<<<<<<<<<<Clicked On List " + listName);
			} else {
				System.out.println("<<<<<<<<<<<<Given " + listName + "is missing in Menu");
			}
			List<MobileElement> elements = opj.findElements(OIShopping_Constants.ITEM_LIST);
			elements.size();
			System.out.println("<<<<<<<<<<<<<<User is displayed with : " + element.getSize() + "Options in iTem List");

			ArrayList<String> iTemValuesDisplayed = opj.getTextFromAttributes(OIShopping_Constants.ITEM_LIST,
					AttributeValue.TEXT.toString());
			Boolean isMatching = StringListMatch(itemList_Vegetable, iTemValuesDisplayed);
			if(isMatching) {
				System.out.println("<<<<<<<<<<<<<<<<<<<<Values displayed in the Itemlist is not sorted in proper order ,"
						+ " Actual Value Displayed"+getItemsFromArrayList(iTemValuesDisplayed)+
						"Sorted Items"+getItemsFromArrayList(itemList_Vegetable));
			}
			else {
				System.out.println("<<<<<<<<<<<<<<<<<<<<Values displayed in the Itemlist is Sorted in proper order , "
						+ "Actual Value Displayed"+getItemsFromArrayList(iTemValuesDisplayed)+
						"Sorted Items"+getItemsFromArrayList(itemList_Vegetable));	
			}
		} else {
			System.out.println("<<<<<<<<<<<<<<<<<<<Navigation Drawer is not Displayed>>>>>>>>>>>>");
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
