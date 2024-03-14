package fuelbuddyAutomationTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fuelbuddyAutomation.LoginScreen;

public class LoginScreenTest extends BaseTestClass {
	
	private LoginScreen fuelBuddyLoginPage;
    
    @BeforeMethod(groups = {"regression", "smoke"})
    public void setup() {
        driver.resetApp();
    }

    @Test(groups = {"regression"}, priority = 1)
    public void testNavigateToLoginScreen() {
        fuelBuddyLoginPage.navigateToLoginPage();
        Assert.assertTrue(fuelBuddyLoginPage.isElementPresent(), "The Login Screen was not displayed.");
    }

	
	
}
