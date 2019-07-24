package tests;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import tests.shoppinghelper.tests.ShoppingList_Helper;
import tests.shoppinghelper.tests.OIShopping_Constants;
import tests.shoppinghelper.tests.OIShopping_Constants.LocatorType;
import utilities.PropReader;
import tests.shoppinghelper.tests.Operations_Android;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriverWait wait;


	public static AndroidDriver<MobileElement> driver;
    
    protected ShoppingList_Helper shoppingHelper =null;
    Operations_Android opj = new Operations_Android(driver);

    @BeforeMethod
    @Parameters({"deviceName", "platformVersion"})
    public void setup (String deviceName, String platformVersion) throws IOException {
        System.out.println("TestNG Before");

        //Unlock the device if it is locked.
        final Runtime rt = Runtime.getRuntime();
        rt.exec("adb shell input keyevent 224");
        File app = new File("E:\\APK\\OI Shopping List_org.openintents.shopping.apk");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("platformName", PropReader.getPlatformName());;
		caps.setCapability("udid", PropReader.getUDID());
        caps.setCapability("app", app.getAbsolutePath());
        caps.setCapability("noReset",PropReader.getNoReset());

    	driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Layout Selection on App Launch
        
        if(opj.findElement(OIShopping_Constants.LAYOUTPAGETITLE_XPATH, LocatorType.XPATH)) {
        	
        	opj.Click(OIShopping_Constants.LAYOUTRADIOBUTTON_XPATH, LocatorType.XPATH);
        	System.out.println("<<<<<<<<<<<<<<<<<<< Clicking On Preffred Layout on Launching the Application");
        }
      
        // Helper class initialization
        shoppingHelper = new ShoppingList_Helper();
      
    }

    @AfterMethod
    public  void teardown(){
        ThreadLocalDriver.getTLDriver().quit();
    }

}
