import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.util.List;


public class Ex6
{
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/Users/user/Desktop/JavaAppium/apks/org.wikipedia_50363_apps.evozi.com (1).apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }


    @Test
    public void assertTitle()
    {
        waitSecondMethodAndClick
                (
                        By.xpath("//*[contains(@text, 'SKIP')]"),
                        "Cannot find this word - SKIP",
                        5
                );
        waitSecondMethodAndClick
                (
                        By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                        "Cannot find Search Wikipedia",
                        5
                );

        String firstValue = "JavaScript";

        waitThirdMethodAndSendKeys
                (
                        By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                        firstValue,
                        "Cannot find in search 'JavaScript'",
                        5
                );

        waitSecondMethodAndClick
                (
                    By.xpath("//*[contains(@text, 'High-level programming language')]"),
                        "Cannot find this word 'JavaScript'",
                        5
                );

        String xpath_locator = "//android.view.View[@text='JavaScript']";


    }

    private WebElement assertElementPresent(By by, String error_message, int timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitSecondMethodAndClick(By by, String error_message, int timeoutInSeconds)
    {
        WebElement element = assertElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitThirdMethodAndSendKeys(By by, String value, String error_message, int timeoutInSeconds)
    {
        WebElement element = assertElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }



}