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
	 
		public boolean isFuelbuddyLogoDisplayed() {
			MobileElement fuelBuddyLogo = (MobileElement) driver.findElement(By.xpath(
					"//android.widget.ImageView"));
			return fuelBuddyLogo.isDisplayed();
		}
		
		public String isPhoneNumberTextFieldDisplayed() {
			MobileElement phoneNumberTextField = (MobileElement) driver
					.findElement(By.xpath("//android.widget.TextView[@text=\"Phone Number\"]"));
			return phoneNumberTextField.getText();
		}
		
		public boolean isPhoneNumberFieldDisplayed() {
			MobileElement phoneNumberField = (MobileElement) driver
					.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Phone Input\"]"));
			return phoneNumberField.isDisplayed();
		}
		
		public boolean isCountryCodeFieldDisplayed() {
			MobileElement countryCodeField = (MobileElement) driver
					.findElement(By.xpath("//android.widget.EditText[@text=\"+353\"]"));
			return countryCodeField.isDisplayed();
		}
		
		public String isCorrectCountryCodeTextDisplayed() {
			MobileElement countryCodeField = (MobileElement) driver
					.findElement(By.xpath("//android.widget.EditText[@text=\"+353\"]"));
			return countryCodeField.getText();
		}
		
		public boolean isSendLoginCodeButtonDisplayed() {
			MobileElement sendLoginCodeButton = (MobileElement) driver
					.findElement(By.xpath("//android.widget.TextView[@text=\"Send Login Code\"]"));
			return sendLoginCodeButton.isDisplayed();
		}
		
		public void clickSendLoginCodeButton() {
			MobileElement sendLoginCodeButton = (MobileElement) driver
					.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Send Login Code\"]/android.view.ViewGroup"));
			sendLoginCodeButton.click();
		}
		
		public void invalidPhoneNumber(String phoneNumber) {
			MobileElement phoneNumberField = (MobileElement) driver
					.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Phone Input\"]"));
			phoneNumberField.sendKeys(phoneNumber);
			MobileElement sendLoginCodeButton = (MobileElement) driver
					.findElement(By.xpath("//android.widget.TextView[@text=\"Send Login Code\"]"));
			sendLoginCodeButton.click();
		}
		
		public void validPhoneNumber(String phoneNumber) {
			MobileElement phoneNumberField = (MobileElement) driver
					.findElement(By.xpath("//android.widget.EditText[@content-desc=\"Phone Input\"]"));
			phoneNumberField.sendKeys(phoneNumber);
			MobileElement sendLoginCodeButton = (MobileElement) driver
					.findElement(By.xpath("//android.widget.TextView[@text=\"Send Login Code\"]"));
			sendLoginCodeButton.click();
		}

}
