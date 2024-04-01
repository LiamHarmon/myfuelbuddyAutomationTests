package fuelbuddyAutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fuelbuddyAutomation.LoginScreen;
import fuelbuddyAutomation.VerificationScreen;

public class LoginScreenTest extends BaseTestClass {
    
    @BeforeMethod(groups = {"regression", "smoke"})
    public void loginPageNavigation() {
        driver.resetApp();
        LoginScreen loginScreen = new LoginScreen(driver);
        loginScreen.navigateToLoginPage();
    }
    
    @Test(groups = {"regression"}, priority = 1)
	public void testFuelBuddyLogo() {
		LoginScreen loginScreen = new LoginScreen(driver);
		boolean actualValue = loginScreen.isFuelbuddyLogoDisplayed();
		Assert.assertTrue(actualValue, "The FuelBuddy logo is not displayed.");
	}
    
	@Test(groups = { "regression" }, priority = 2)
	public void testPhoneNumberTextField() {
		LoginScreen loginScreen = new LoginScreen(driver);
		String actualText = loginScreen.isPhoneNumberTextFieldDisplayed();
		String expectedText = "Phone Number";
		Assert.assertEquals(actualText, expectedText, "The phone number text field does not match the expected value.");
	}

	@Test(groups = { "regression" }, priority = 3)
	public void testPhoneNumberField() {
		LoginScreen loginScreen = new LoginScreen(driver);
		boolean actualValue = loginScreen.isPhoneNumberFieldDisplayed();
		Assert.assertTrue(actualValue, "The phone number field is not displayed.");
	}
	
	@Test(groups = { "regression" }, priority = 4)
	public void testCountryCodeField() {
		LoginScreen loginScreen = new LoginScreen(driver);
		boolean actualValue = loginScreen.isCountryCodeFieldDisplayed();
		Assert.assertTrue(actualValue, "The country code field is not displayed.");
	}
	
	@Test(groups = { "regression" }, priority = 5)
	public void testCountryCodeTextField() {
		LoginScreen loginScreen = new LoginScreen(driver);
		String actualText = loginScreen.isCorrectCountryCodeTextDisplayed();
		String expectedText = "+353";
		Assert.assertEquals(actualText, expectedText, "The country code text field does not match the expected value.");
	}
	
	@Test(groups = {"regression", "smoke"}, priority = 18)
	public void testInvalidPhoneNumber() {
		LoginScreen  loginScreen = new LoginScreen(driver);
		loginScreen.invalidPhoneNumber("1234567890");
		loginScreen.clickSendLoginCodeButton();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//android.widget.TextView[@text=\"Please enter a valid phone number (e.g. 8XXXXXXXX or 08XXXXXXXX)\"]")));
		Assert.assertTrue(loginScreen.isElementPresent(), "The Invalid Phone Number message was not displayed.");
	}
	
	@Test(groups = {"regression", "smoke"}, priority = 19)
	public void testValidPhoneNumber() {
		LoginScreen loginScreen = new LoginScreen(driver);
		loginScreen.validPhoneNumber("876543210");
		loginScreen.clickSendLoginCodeButton();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Verification Code\"]")));
		VerificationScreen nextScreen = new VerificationScreen(driver);
		Assert.assertTrue(nextScreen.isElementPresent(), "The Verification Screen was not displayed.");
	}
		
}
