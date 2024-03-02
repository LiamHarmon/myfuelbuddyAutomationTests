package fuelbuddyAutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fuelbuddyAutomation.LoginScreen;
import fuelbuddyAutomation.RegistrationScreen;

public class RegistrationScreenTest extends BaseTestClass {
	
	 @BeforeClass
	    public void navigateToRegistrationPage() {
		 	RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		    registrationScreen.navigateToRegistrationPage();
	    }
	
	@Test(groups = {"regression"}, priority = 1)
	public void testFuelBuddyLogo() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		boolean actualValue = registrationScreen.isFuelBuddyLogoDisplayed();
		Assert.assertTrue(actualValue, "The FuelBuddy logo is not displayed.");
	}
	
	@Test(groups = {"regression"}, priority = 2)
	public void testLoginToggleButtonDisplayed() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		boolean actualValue = registrationScreen.isLoginToggleButtonDisplayed();
		Assert.assertTrue(actualValue, "The Login Toggle Button is not displayed.");
	}
	
	@Test(groups = {"regression"}, priority = 3)
	public void testLoginToggleButtonClick() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		registrationScreen.clickLoginToggleButton();
		WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Send Login Code\"]")));
        LoginScreen nextScreen = new LoginScreen(driver);
        Assert.assertTrue(nextScreen.isElementPresent(), "The Login Screen was not displayed.");
	}
	
	 @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit(); 
	        }
	    }

}
