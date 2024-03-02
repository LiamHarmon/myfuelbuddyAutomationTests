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
}