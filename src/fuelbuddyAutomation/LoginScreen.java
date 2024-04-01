package fuelbuddyAutomation;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginScreen {
	
	 private AppiumDriver<WebElement> driver;

	 public LoginScreen(AppiumDriver<WebElement> driver2) {
			this.driver = driver2;
			PageFactory.initElements(driver, this);
	 }
	 
	 @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Get Started\"]/android.view.ViewGroup")
	    	private MobileElement getStartedButton;

	  @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Login\"]/android.view.ViewGroup")
	    	private MobileElement loginToggleButton;
	    
	    public void navigateToLoginPage() {
	        getStartedButton.click();
	        loginToggleButton.click();
	    }

	 public boolean isElementPresent() {
	        try {
	            MobileElement uniqueElement = (MobileElement) driver.findElement(By.
	            		xpath("//android.widget.TextView[@text=\"Send Login Code\"]"));
	            return uniqueElement.isDisplayed();
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }
	 
		public void isFuelbudyyLogoDisplayed() {
			MobileElement fuelBuddyLogo = (MobileElement) driver.findElement(By.xpath(
					"//android.widget.ImageView"));
			fuelBuddyLogo.isDisplayed();
		}

}
