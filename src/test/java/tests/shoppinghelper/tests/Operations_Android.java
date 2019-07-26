package tests.shoppinghelper.tests;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import tests.shoppinghelper.tests.OIShopping_Constants.LocatorType;

public class Operations_Android {

	protected WebDriverWait wait;
	private AndroidDriver<MobileElement> androidDriver;

	public Operations_Android(AndroidDriver<MobileElement> driver) {

		this.androidDriver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	private WebElement element;
	List<AndroidElement> element1 = null;
	MobileElement melement = new AndroidElement();

	public MobileElement findElement(String XPathString) {
		try {
			melement = androidDriver.findElementByAndroidUIAutomator(XPathString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return melement;
	}

	public boolean findElement(String XPathString, LocatorType locateBy) {
		boolean found = true;
		try {
			switch (locateBy) {
			case ID:
				element = androidDriver.findElement(By.id(XPathString));
			case NAME:
				element = androidDriver.findElement(By.name(XPathString));
			case XPATH:
				element = androidDriver.findElement(By.xpath(XPathString));
			case TEXT:
				element = androidDriver.findElement(By.id(XPathString));
			case XPATHGEN:
				element = androidDriver
						.findElement(By.xpath("//android.widget.TextView" + "[" + "@text=" + XPathString + "]"));
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (element == null) {
			found = false;
		}
		return found;
	}
	

	public void Click(String XPathString, LocatorType type) {
		try {
			findElement(XPathString, type);
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void hideKeyboard() {
		try {
			androidDriver.navigate().back();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<MobileElement> findElements(String XPathString) {

		List<MobileElement> elements = null;
		try {
			elements = androidDriver.findElementsByAndroidUIAutomator(XPathString);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return elements;
	}

	public boolean typeText(String UIAxapthValue, String text) {
		try {
			element = findElement(UIAxapthValue);
			if (!(text == null)) {
				element.sendKeys(text);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public String getTextFromAttribute(String UIAxapthValue, String AttributeValue) {
		String value = null;
		try {
			element = findElement(UIAxapthValue);
			if (!(AttributeValue == null)) {
				value = element.getAttribute(AttributeValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

	public ArrayList<String> getTextFromAttributes(String UIAxapthValue, String text) {
		List<MobileElement> element = null;
		ArrayList<String> attributeList = new ArrayList<String>();
		try {
			element = findElements(UIAxapthValue);
			for (MobileElement a : element) {
				attributeList.add(a.getAttribute(text));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return attributeList;

	}

}
