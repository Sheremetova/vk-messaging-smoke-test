package vksmoke;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class BaseDriver {

    static ThreadLocal<AppiumDriverLocalService> service = new ThreadLocal<>();

    static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public BaseDriver() {
    }

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public AppiumDriver restartDriver() throws Exception {
        driver.get().quit();
        driver.set(new AndroidDriver<AndroidElement>(service.get().getUrl(), getCaps()));
        return driver.get();
    }

    public void startAppium() {
        AppiumServiceBuilder appiumServiceBuilder = new AppiumServiceBuilder()
                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1");
        service.set(appiumServiceBuilder.build());
        service.get().start();

        if (service == null || !service.get().isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("An appium server node is not started!");
        }
    }

    public DesiredCapabilities getCaps() throws Exception {
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "src/test/app");
        File app = new File(appDir.getCanonicalPath(), "com.vkontakte.android.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.vkontakte.android");
        capabilities.setCapability("appActivity", ".MainActivity");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);
        return capabilities;
    }

    @Before
    public void startServer() throws Exception {
        startAppium();
        driver.set(new AndroidDriver<AndroidElement>(service.get().getUrl(), getCaps()));
    }

    @After
    public void stopServer() {
        if (driver.get() != null) {
            driver.get().quit();
        }
        if (service.get() != null) {
            service.get().stop();
        }
    }
}
