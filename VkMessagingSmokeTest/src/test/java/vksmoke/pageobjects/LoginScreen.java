package vksmoke.pageobjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import vksmoke.PageObject;


public class LoginScreen extends PageObject {

    @FindBy(id = "auth_login")
    private WebElement loginField;

    @FindBy(id = "auth_pass")
    private WebElement passwordField;

    @FindBy(id = "auth_login_btn")
    private WebElement loginButton;

    public LoginScreen(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForLoginScreen() {
        return new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(loginField));
    }

    public void login_with(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        driver.hideKeyboard();
        loginButton.click();
    }
}
