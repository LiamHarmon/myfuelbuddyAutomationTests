package fuelbuddyAutomationTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.URL;

public class BaseTestClass {
    protected AppiumDriver<WebElement> driver;

    @BeforeClass
    public void setUp() throws Exception {
    	DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        
        dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\liamh\\OneDrive\\Desktop\\AndroidAPK\\fuelbuddy_v1.0.0.apk");
		
		URL url = new URL("http://10.102.222.70:4723/");
		
		driver = new AndroidDriver<WebElement>(url, dc);
		Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
