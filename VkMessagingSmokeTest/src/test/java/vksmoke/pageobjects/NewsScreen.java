package vksmoke.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vksmoke.PageObject;

import java.util.List;

public class NewsScreen extends PageObject {

    @FindBy(className = "android.widget.ImageButton")
    private List<WebElement> imageButtons;

    @FindBy(id = "search")
    private WebElement searchButton;

    public NewsScreen(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForNewsScreen() {
        return new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(searchButton));
    }

    public void openMenu() {
        imageButtons.get(0).click();
    }

}
