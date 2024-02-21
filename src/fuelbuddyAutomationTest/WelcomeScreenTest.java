package fuelbuddyAutomationTest;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import fuelbuddyAutomation.WelcomeScreen;
import fuelbuddyAutomation.RegistrationScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WelcomeScreenTest extends BaseTestClass {
	
	@BeforeMethod
	public void setUpEach() {
		driver.resetApp();
	}
	
	@Test(groups = {"regression"})
	public void testFuelBuddyLogo() {
		WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
		boolean actualValue = welcomeScreen.isFuelBuddyLogoDisplayed();
		Assert.assertTrue(actualValue, "The FuelBuddy logo is not displayed.");
	}
	
	@Test
	public void testWelcomeText() {
		WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
        String actualText = welcomeScreen.getWelcomeText();
        String expectedText = "Welcome";
        Assert.assertEquals(actualText, expectedText, "The welcome text does not match the expected value.");
	}

    @Test
    public void testWelcomeSloganText() {
        WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
        String actualText = welcomeScreen.getWelcomeSloganText();
        String expectedText = "The Friend Your Tank Deserves.";
        Assert.assertEquals(actualText, expectedText, "The welcome slogan text does not match the expected value.");
    }
    
    @Test
    public void testFuelStationImage() {
    	WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
    	boolean actualValue = welcomeScreen.isFuelStationImageDisplayed();
    	Assert.assertTrue(actualValue, "The Fuel Starion Image does not match the expected value.");
    }
    
    @Test
    public void testGetStartedButtonDisplay() {
    	WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
    	boolean actualValue = welcomeScreen.isGetStartedButtonDisplayed();
    	Assert.assertTrue(actualValue, "The Get Started Button does not match the expected value.");
    }
    
    @Test
    public void testGetStartedText() {
    	WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
        String actualText = welcomeScreen.getStartedText();
        String expectedText = "Get Started";
        Assert.assertEquals(actualText, expectedText, "The Get Started text does not match the expected value.");
    }
    
    @Test
    public void testClickGetStartedButton() {
    	WelcomeScreen welcomeScreen = new WelcomeScreen(driver);
        welcomeScreen.clickGetStartedButton();
        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Send Register Code\"]")));
        RegistrationScreen nextScreen = new RegistrationScreen(driver);
        Assert.assertTrue(nextScreen.isElementPresent(), "The Register Screen was not displayed.");
    }
    
}
