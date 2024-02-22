package fuelbuddyAutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fuelbuddyAutomation.RegistrationScreen;
import io.appium.java_client.MobileElement;

public class RegistrationScreenTest extends BaseTestClass {
	
	@BeforeMethod(groups = {"regression", "smoke"})
	public void setUpEach() throws Exception {
	    if (driver != null) {
	    	MobileElement getStartedButton = (MobileElement) driver.findElement(By.
	    			xpath("//android.widget.TextView[@text=\"Get Started\"]"));
	    	getStartedButton.click();
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, 500);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Send Register Code\"]")));
	    } else {
	    	System.out.println("Driver has not been initialized.");
	    }
	}
	
	@Test(groups = {"regression"})
	public void testFuelBuddyLogo() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		boolean actualValue = registrationScreen.isFuelBuddyLogoDisplayed();
		Assert.assertTrue(actualValue, "The FuelBuddy logo is not displayed.");
	}

}
