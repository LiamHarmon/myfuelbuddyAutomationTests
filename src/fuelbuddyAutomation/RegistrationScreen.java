package fuelbuddyAutomation;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class RegistrationScreen {
    private AppiumDriver<WebElement> driver;

    public RegistrationScreen(AppiumDriver<WebElement> driver2) {
        this.driver = driver2;
    }
    
    public void navigateToRegistrationPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10); 
        MobileElement getStartedButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Get Started\"]")));
        getStartedButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Send Register Code\"]")));
    }

    public boolean isElementPresent() {
        try {
            MobileElement uniqueElement = (MobileElement) driver.findElement(By.
            		xpath("//android.widget.TextView[@text=\"Send Register Code\"]"));
            return uniqueElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public boolean isFuelBuddyLogoDisplayed() {
		MobileElement fuelBuddyLogo = (MobileElement) driver.findElement(By.
				xpath("//android.widget.ImageView"));
		return fuelBuddyLogo.isDisplayed();
	}
    
	public boolean isLoginToggleButtonDisplayed() {
		MobileElement loginToggleButton = (MobileElement) driver.findElement(By
				.xpath("//android.widget.TextView[@text=\"Login\"]"));
		return loginToggleButton.isDisplayed();
	}

	public void clickLoginToggleButton() {
		MobileElement loginToggleButton = (MobileElement) driver
				.findElement(By.xpath("//android.widget.TextView[@text=\"Login\"]"));
		loginToggleButton.click();
	}
	
	public String getNameFieldText() {
		MobileElement nameField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.TextView[@text=\"Name\"]"));
		return nameField.getText();
	}
	
	public boolean isNameFieldDisplayed() {
		MobileElement nameField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]"));
		return nameField.isDisplayed();
	}
	
	public String getUsernameFieldText() {
		MobileElement usernameField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.TextView[@text=\"Username\"]"));
		return usernameField.getText();
	}
	
	public boolean isUsernameFieldDisplayed() {
		MobileElement usernameField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]"));
		return usernameField.isDisplayed();
	}
	
	public String getPhoneNumberFieldText() {
		MobileElement phoneField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.TextView[@text=\"Phone Number\"]"));
		return phoneField.getText();
	}
		
	public boolean isPhoneNumberFieldDisplayed() {
		MobileElement phoneField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[4]"));
		return phoneField.isDisplayed();
	}
	
	public boolean isPhoneNumberPrefixFieldDisplayed() {
		MobileElement phoneField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.EditText[@text=\"+353\"]"));
		return phoneField.isDisplayed();
	}
	
	public String getPhoneNumberPrefixFieldText() {
		MobileElement phoneField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.EditText[@text=\"+353\"]"));
		return phoneField.getText();
	}
	
	public boolean isRegisterButtonDisplayed() {
		MobileElement registerButton = (MobileElement) driver
				.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Send Register Code\"]"));
		return registerButton.isDisplayed();
	}
	
	public String getRegisterButtonText() {
		MobileElement registerButton = (MobileElement) driver
				.findElement(By.xpath("//android.widget.TextView[@text=\"Send Register Code\"]"));
		return registerButton.getText();
	}
	
	public void clickRegisterButton() {
		MobileElement registerButton = (MobileElement) driver
				.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Send Register Code\"]"));
		registerButton.click();
	}
	
	public void enterInvalidNameAndValidUsernameAndPhone(String name, String username, String phone) {
		MobileElement nameField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]"));
		nameField.sendKeys(name);
		MobileElement usernameField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]"));
		usernameField.sendKeys(username);
		MobileElement phoneField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[4]"));
		phoneField.sendKeys(phone);
	}
	
	public void enterBlankNameAndValidUsernameAndPhone(String username, String phone) {
		MobileElement usernameField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]"));
		usernameField.sendKeys(username);
		MobileElement phoneField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[4]"));
		phoneField.sendKeys(phone);
	}
	
	public void enterValidNameAndInvalidUsernameAndValidPhone(String name, String username, String phone) {
		MobileElement nameField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]"));
		nameField.sendKeys(name);
		MobileElement usernameField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]"));
		usernameField.sendKeys(username);
		MobileElement phoneField = (MobileElement) driver
				.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[4]"));
		phoneField.sendKeys(phone);
	}
	
		
	
}