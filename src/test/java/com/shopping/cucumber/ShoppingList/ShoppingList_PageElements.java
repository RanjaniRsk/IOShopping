package com.shopping.cucumber.ShoppingList;

public class ShoppingList_PageElements {
	
	
	
	
	
	// LayoutPage
	
	public static final String PREFLAYOUT_PHEADER_TXT ="//android.widget.TextView[@text='Choose your preferred layout']";
	public static final String LAYOUT_BUTTON_RID ="org.openintents.shopping:id/layout_choice_bottom";
	
	// MyShoppLIst Screen
	public static final String SHOPPING_LIST_PHEADER ="//android.widget.TextView[@text='My shopping list']";
	public static final String HAMBURGER_MENU ="//android.widget.ImageButton[@content-desc='Open navigation drawer']";
	
	//New List 
	public static final String NEW_LIST_ADDICON ="";
	public static final String NEW_LIST ="//android.widget.TextView[@text='New list']";
	
	
	// Alert pop=up - Enter Details
	public static final String ALERT_TITLE ="//android.widget.TextView[@text='Enter name of new shopping list']";
	public static final String INPUT_TEXTBOX_RID="org.openintents.shopping:id/edittext";
	public static final String OK_BUTTON="//android.widget.Button[@text='OK']";
	public static final String CANCEL_BUTTON="//android.widget.Button[@text='CANCEL']";
	
	
	// Add Item
	// public static final String  list selection - text name is sdipslyed use nEW_LIST xpath
	
	public static final String ADD_ITEM_INPUTTEXT_RID= "org.openintents.shopping:id/autocomplete_add_item";
	public static final String ADD_BTN_RID= "org.openintents.shopping:id/button_add_item";
	public static final String TOTAL_ITEM_LIST ="//android.widget.ListView[@resource-id='org.openintents.shopping:id/list_items']/child::android.widget.LinearLayout" ; 
	public static final String ADDED_LIST_VALUE ="//android.widget.ListView[@resource-id='org.openintents.shopping:id/list_items']/child::android.widget.LinearLayout[1]/descendant::android.widget.TextView[@text='Vhjhgghhh']";		
	
	public static final String CHECK_BOX_XPATH="//android.widget.ListView[@resource-id='org.openintents.shopping:id/list_items']/child::android.widget.LinearLayout[1]/descendant::android.widget.CheckBox";
	public static final String SELECT_ITEM ="//android.widget.ListView[@resource-id='org.openintents.shopping:id/list_items']/child::android.widget.LinearLayout[1]";
	
	// Settings
	
	public static final String SETTINGS_MENU = "//android.widget.ImageView[@content-desc='More options']";
	public static final String DELETE_LIST ="//android.widget.TextView[@text='Delete list']";
	public static final String CLEAN_UP_ITEM ="//android.widget.TextView[@content-desc='Clean up list']";
	
	
	//  Settings - Sort
	public static final String SETTINGS_MENU_OPTION = "//android.widget.TextView[@text='Settings']";
	public static final String CHANGE_SORT_ORDER = "//android.widget.TextView[@text='Change sort order of list items']";
	public static final String ALPHABETICAL_SORT = "//android.widget.CheckedTextView[@text='alphabetical']";
	
	
	
	// Delete an item - long click on symbol
	// alert header is same as option

	public static final String DELETE_ITEM ="//android.widget.TextView[@text='Delete item permanently']";
	public static final String DELETE_ALERT_TEXT="//android.widget.TextView[@text='Are you sure you want to permanently delete this item?']";
	public static final String DELETE_BUTTON="//android.widget.Button[@text='DELETE']";
	
	
	
	public static final String TOTAL_LIST_ITEMS="//android.widget.TextView[@text='LIST']/following-sibling::android.widget.FrameLayout";
	public static final String  LIST_VALUES ="//android.widget.TextView[@text='LIST']/following-sibling::android.widget.FrameLayout[1]/child::android.widget.TextView['A']";
	
	
	// Device config file
	public static final String CONFIGFILE_NAME = "device-configuration";

	public enum SortOrder {
		ASCENDING, DECENDING
	}

	public enum LocatorType {
		ID, TEXT, XPATH, NAME, CLASSNAME, XPATHGEN_TEXT, XPATHGEN_BUTTON
	}

	public enum AttributeValue {
		ID("id"), TEXT("text"), NAME("name"), CLASSNAME("className");

		private String value;

		public String getValue() {
			return this.value;
		}

		private AttributeValue(String value) {
			this.value = value;
		}
	}

}
