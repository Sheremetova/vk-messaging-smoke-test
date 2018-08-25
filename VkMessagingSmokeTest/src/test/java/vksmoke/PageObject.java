package vksmoke;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;

public class PageObject {
    protected AppiumDriver driver;

    public PageObject(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}