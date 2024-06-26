package fuelbuddyAutomation;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class VerificationScreen {

	private AppiumDriver<WebElement> driver;

	public VerificationScreen(AppiumDriver<WebElement> driver2) {
		this.driver = driver2;
	}
	public boolean isElementPresent() {
        try {
            MobileElement uniqueElement = (MobileElement) driver.findElement(By.
            		xpath("//android.widget.TextView[@text=\"Verification Code\"]"));
            return uniqueElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
