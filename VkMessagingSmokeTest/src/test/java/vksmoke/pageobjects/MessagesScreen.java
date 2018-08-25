package vksmoke.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vksmoke.PageObject;

import java.util.List;

public class MessagesScreen extends PageObject {

    @FindBy(className = "android.view.View")
    private List<WebElement> firstChatView;

    @FindBy(id = "createNewDialog")
    private WebElement createNewDialog;

    public MessagesScreen(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForMessagesScreen() {
        return new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(createNewDialog));
    }

    public void openFirstChat() {
        firstChatView.get(0).click();
    }
}
