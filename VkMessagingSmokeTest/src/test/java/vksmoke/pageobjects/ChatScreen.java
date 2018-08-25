package vksmoke.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vksmoke.PageObject;

import java.util.ArrayList;
import java.util.List;

public class ChatScreen extends PageObject {

    @FindBy(id = "msg_text")
    private List<WebElement> messages;

    @FindBy(id = "writebar_edit")
    private WebElement writebarEditView;

    @FindBy(id = "writebar_send")
    private WebElement sendButton;

    public ChatScreen(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForChatScreen() {
        return new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(writebarEditView));
    }

    public void sendMessage(String text) {
        writebarEditView.sendKeys(text);
        sendButton.click();
    }

    public List<String> getMessages() {
        List<String> listOfMessages = new ArrayList<>();
        messages.forEach(message -> listOfMessages.add(message.getText()));
        return listOfMessages;
    }
}
