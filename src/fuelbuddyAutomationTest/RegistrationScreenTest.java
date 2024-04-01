package fuelbuddyAutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fuelbuddyAutomation.LoginScreen;
import fuelbuddyAutomation.RegistrationScreen;
import fuelbuddyAutomation.VerificationScreen;
import fuelbuddyAutomation.WelcomeScreen;

public class RegistrationScreenTest extends BaseTestClass {
	
	 @BeforeMethod (groups = {"regression", "smoke"})
	    public void navigateToRegistrationPage() {
		 	driver.resetApp();
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
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Send Login Code\"]]")));
        LoginScreen nextScreen = new LoginScreen(driver);
        Assert.assertTrue(nextScreen.isElementPresent(), "The Login Screen was not displayed.");
	}
	
	@Test(groups = {"regression"}, priority = 4)
	public void testNameFieldText() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
        String actualText = registrationScreen.getNameFieldText();
        String expectedText = "First Name";
        Assert.assertEquals(actualText, expectedText, "The Name field text does not match the expected value.");
	}
	
	@Test(groups = {"regression"}, priority = 5)
	public void testNameFieldDisplayed() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		boolean actualValue = registrationScreen.isNameFieldDisplayed();
		Assert.assertTrue(actualValue, "The Name field is not displayed.");
	}
	
	@Test(groups = {"regression"}, priority = 6)
	public void testUsernameFieldText() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		String actualText = registrationScreen.getUsernameFieldText();
		String expectedText = "Username";
		Assert.assertEquals(actualText, expectedText, "The Username field text does not match the expected value.");
	}
	
	@Test(groups = {"regression"}, priority = 7)
	public void testUsernameFieldDisplayed() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		boolean actualValue = registrationScreen.isUsernameFieldDisplayed();
		Assert.assertTrue(actualValue, "The Username field is not displayed.");
	}
	
	@Test(groups = {"regression"}, priority = 8)
	public void testPhoneNumberFieldText() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		String actualText = registrationScreen.getPhoneNumberFieldText();
		String expectedText = "Phone Number";
		Assert.assertEquals(actualText, expectedText, "The Phone Number field text does not match the expected value.");
	}
	
	@Test(groups = {"regression"}, priority = 9)
	public void testPhoneNumberFieldDisplayed() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		boolean actualValue = registrationScreen.isPhoneNumberFieldDisplayed();
		Assert.assertTrue(actualValue, "The Phone Number field is not displayed.");
	}
	
	@Test(groups = {"regression"}, priority = 10)
	public void testPhoneNumberPrefixFieldDisaplys() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		boolean actualValue = registrationScreen.isPhoneNumberPrefixFieldDisplayed();
		Assert.assertTrue(actualValue, "The Phone Number Prefix field is not displayed.");
	}
	
	@Test(groups = {"regression"}, priority = 11)
	public void testPhoneNumberPrefixFieldText() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		String actualText = registrationScreen.getPhoneNumberPrefixFieldText();
		String expectedText = "+353";
		Assert.assertEquals(actualText, expectedText, "The Phone Number Prefix field text does not match the expected value.");
	}
	
	@Test(groups = {"regression"}, priority = 12)
	public void testRegisterButtonDisplayed() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		boolean actualValue = registrationScreen.isRegisterButtonDisplayed();
		Assert.assertTrue(actualValue, "The Register Button is not displayed.");
	}
	
	@Test(groups = {"regression"}, priority = 13)
	public void testRegisterButtonText() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		String actualText = registrationScreen.getRegisterButtonText();
		String expectedText = "Send Register Code";
		Assert.assertEquals(actualText, expectedText, "The Register Button text does not match the expected value.");
	}
	
	@Test(groups = {"regression", "smoke"}, priority = 14)
	public void testInvalidName() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		registrationScreen.invalidName("A", "tttttAutoTest", "0858594108");
		registrationScreen.clickRegisterButton();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Please enter a valid First Name\"]")));
		Assert.assertTrue(registrationScreen.isElementPresent(), "The Invalid Name message was not displayed.");
	}
	
	@Test(groups = {"regression", "smoke"}, priority = 15)
	public void testBlankName() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		registrationScreen.blankName("tttttAutoTest", "0858594108");
		registrationScreen.clickRegisterButton();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Please enter a valid First Name\"]")));
		Assert.assertTrue(registrationScreen.isElementPresent(), "The Name is required message was not displayed.");
	}
	
	@Test(groups = {"regression", "smoke"}, priority = 16)
	public void testInvalidUnsername() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		registrationScreen.invalidUsername("AutoTest", "t", "0858594108");
		registrationScreen.clickRegisterButton();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//android.widget.TextView[@text=\"Username must be between 6-20 characters inclusive\"]")));
		Assert.assertTrue(registrationScreen.isElementPresent(), "The Invalid Username message was not displayed.");
	}
	
	@Test(groups = {"regression", "smoke"}, priority = 17)
	public void testBlankUsername() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		registrationScreen.blankUsername("AutoTest", "0858594108");
		registrationScreen.clickRegisterButton();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//android.widget.TextView[@text=\"Username must be between 6-20 characters inclusive\"]")));
		Assert.assertTrue(registrationScreen.isElementPresent(), "The Username is required message was not displayed.");
	}
	
	@Test(groups = {"regression", "smoke"}, priority = 18)
	public void testInvalidPhoneNumber() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		registrationScreen.invalidPhoneNumber("AutoTest", "tttttAutoTest", "1234567890");
		registrationScreen.clickRegisterButton();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//android.widget.TextView[@text=\"Please enter a valid phone number (e.g. 8XXXXXXXX or 08XXXXXXXX)\"]")));
		Assert.assertTrue(registrationScreen.isElementPresent(), "The Invalid Phone Number message was not displayed.");
	}
	
	@Test(groups = {"regression", "smoke"}, priority = 19)
	public void testBlankPhoneNumber() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		registrationScreen.blankPhoneNumber("AutoTest", "tttttAutoTest");
		registrationScreen.clickRegisterButton();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//android.widget.TextView[@text=\"Please enter a valid phone number (e.g. 8XXXXXXXX or 08XXXXXXXX)\"]")));
		Assert.assertTrue(registrationScreen.isElementPresent(),
				"The Phone Number is required message was not displayed.");
	}
	
	@Test(groups = {"regression", "smoke"}, priority = 20)
	public void testAllValidCredentials() {
		RegistrationScreen registrationScreen = new RegistrationScreen(driver);
		registrationScreen.allValidCredentials("AutoTest", "tttttAutoTest", "0858594108");
		registrationScreen.clickRegisterButton();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Verification Code\"]")));
		VerificationScreen nextScreen = new VerificationScreen(driver);
		Assert.assertTrue(nextScreen.isElementPresent(), "The Verification Screen was not displayed.");
	}
	
	 @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit(); 
	        }
	    }

}
