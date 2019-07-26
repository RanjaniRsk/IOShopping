package tests.shoppinghelper.tests;

public class OIShopping_Constants {
	
	// Navigation menu
	public static final String NAVIGATION_DRAWER = "//android.widget.imageButton[@text='Open navigation drawer']";
	public static final String LAYOUTRADIOBUTTON_TEXT = "Layout with add item at the bottom. Use this if you usually add one item at a time.";
	public static final String LAYOUTRADIOBUTTON_RID = "org.openintents.shopping:id/layout_choice_bottom";
	public static final String LAYOUTPAGETITLE_XPATH = "//android.widget.TextView[@text='Choose your preferred layout']";
	public static final String LAYOUTRADIOBUTTON_XPATH = "UISelector().resourceId(\"org.openintents.shopping:id/layout_choice_bottom\")/";
	
	// New List , Alert pop-up
	public static final String NEW_LIST_RID = "org.openintents.shopping:id/mode_radio_button";
	public static final String ALERT_TITLE_RID = "android:id/alertTitle";
	public static final String INPUTTEXT_RID = "org.openintents.shopping:id/edittext";
	public static final String OKBUTTON_TXT = "//android.widget.Button[@text='OK']";
	public static final String CANCELBUTTON_TXT = "//android.widget.Button[@text='CANCEL']";
	
	// Add item
	public static final String ADD_BTN = "//android.widget.Button[@text='Add']";
	public static final String ITEM_LIST = "//*[@resource-id='org.openintents.shopping:id/name']";
	public static final String CHECKBOX_ITEMLIST = "UISelector().Xpath(\"andorid.widget.CheckBox[@resource-id='org.openintents.shopping:id/check'][1]\")/";
	
	// Settings Menu
	public static final String SETTINGS_MENU = "//android.widget.imageView[text='More options']";
	public static final String DELETE_LIST = "//android.widget.textView[@text='Delete list']";
	public static final String SORT_ORDER="//*[@text='Sort Order']";
	public static final String ALPHABATICAL_ORDER="//*[@text='alphabatical']";
	public static final String ALRERT_POP_UP_MESSAGE = "//android.widget.textView[@text='Do you really want to delete this shopping list?']";
	
	// Device config file
	public static final String CONFIGFILE_NAME = "device-configuration";

	public enum SortOrder {
		ASCENDING, DECENDING
	}

	public enum LocatorType {
		ID, TEXT, XPATH, NAME, CLASSNAME, XPATHGEN
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
