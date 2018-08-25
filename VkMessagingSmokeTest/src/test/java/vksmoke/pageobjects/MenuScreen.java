package vksmoke.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vksmoke.PageObject;

public class MenuScreen extends PageObject {

    @FindBy(xpath = "//android.widget.TextView[@text='Messages']")
    private WebElement menuButton;

    public MenuScreen(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForMenuScreen() {
        return new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(menuButton));
    }

    public void openMessages() {
        menuButton.click();
    }
}
