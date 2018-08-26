package vksmoke.steps;

import cucumber.api.java.en.*;
import io.appium.java_client.AppiumDriver;
import vksmoke.BaseDriver;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

import vksmoke.pageobjects.*;

public class SmokeSteps {

    private static AppiumDriver driver;
    private NewsScreen newsScreen;
    private LoginScreen loginScreen;
    private MenuScreen menuScreen;
    private MessagesScreen messagesScreen;
    private ChatScreen chatScreen;
    private Timestamp timestamp;

    @Given("^I've opened chat with User")
    public void i_ve_opened_chat_with_user() {
        driver = new BaseDriver().getDriver();

        navigateToChat();
    }

    @When("^I send a message to User")
    public void i_send_a_message_to_user() {
        timestamp = new Timestamp(System.currentTimeMillis());
        chatScreen.sendMessage(timestamp.toString());
        System.out.println(chatScreen.getMessages());
    }

    @Then("the message should appear in my chat")
    public void the_message_should_appear_in_chat() {
        List<String> list = chatScreen.getMessages();
        assertEquals(timestamp.toString(), list.get(list.size() - 1));
    }

    @Then("^User should receive the same message$")
    public void user_should_receive_the_same_message() throws Exception {
        driver.removeApp("com.vkontakte.android");
        driver = new BaseDriver().restartDriver();
        InputStream input = new FileInputStream("credentials.properties");
        Properties prop = new Properties();
        prop.load(input);

        loginScreen = new LoginScreen(driver);
        loginScreen.waitForLoginScreen();
        loginScreen.login_with(prop.getProperty("login"), prop.getProperty("password"));

        navigateToChat();
        the_message_should_appear_in_chat();
    }

    private void navigateToChat() {
        newsScreen = new NewsScreen(driver);
        newsScreen.waitForNewsScreen();
        newsScreen.openMenu();

        menuScreen = new MenuScreen(driver);
        menuScreen.waitForMenuScreen();
        menuScreen.openMessages();

        messagesScreen = new MessagesScreen(driver);
        messagesScreen.waitForMessagesScreen();
        messagesScreen.openFirstChat();

        chatScreen = new ChatScreen(driver);
        chatScreen.waitForChatScreen();
    }
}
