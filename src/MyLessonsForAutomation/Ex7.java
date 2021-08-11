package MyLessonsForAutomation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.time.Duration;



public class Ex7
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
        capabilities.setCapability("orientation", "PORTRAIT");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }


    @Test
    public void testChangeScreenOrientationOnSearchResults()
    {
        waitForElementAndClick
                (
                        By.xpath("//*[contains(@text,'SKIP')]"),
                        "cannot find don't tap skip",
                        4
                );

        waitForElementAndClick
                (
                        By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                        "Cannot find search input",
                        5
                );

        String search_line = "Javelin throw";

        waitForElementAndSendKeys
                (
                        By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                        search_line,
                        "Cannot don't word",
                        5
                );

        waitForElementAndClick
                (

                        By.xpath("//*[contains(@text,'Track and field athletics event')]"),
                        "Cannot find our text for OOP " + search_line,
                        10
                );

        String title_before_rotation = waitForElementAndGetAttribute
                (
                        By.xpath("//*[contains(@text,'Javelin throw')]"),
                        "text",
                        "Cannot find title of article",
                        15
                );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = waitForElementAndGetAttribute
                (
                        By.xpath("//*[contains(@text,'Javelin throw')]"),
                        "text",
                        "Cannot find title of article1",
                        15
                );

        Assert.assertEquals
                (
                        "Article title have been changed after screen rotation",
                        title_before_rotation,
                        title_after_rotation
                );

        driver.rotate(ScreenOrientation.PORTRAIT);

        String title_after_second_rotation = waitForElementAndGetAttribute
                (
                        By.xpath("//*[contains(@text,'Javelin throw')]"),
                        "text",
                        "Cannot find title of article1",
                        15
                );


        Assert.assertEquals
                (
                        "Article title have been changed after screen rotation",
                        title_before_rotation,
                        title_after_second_rotation
                );

        waitForElementAndClear
                (
                        By.xpath("//*[contains(@text,'Javelin throw')]"),
                        "Cannot find title of article1",
                        15
                );
    }


    @Test
    public void testCheckSearchArticleInBackground()
    {
        waitForElementAndClick
                (
                        By.xpath("//*[contains(@text,'SKIP')]"),
                        "cannot find don't tap skip",
                        4
                );

        waitForElementAndClick
                (
                        By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                        "Cannot find search input",
                        5
                );

        waitForElementAndSendKeys
                (
                        By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                        "Java",
                        "Cannot don't search this word",
                        5
                );

        waitForElementPresent
                (
                        By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Java']"),
                        "Cannot find our text for Appium",
                        13
                );

        driver.runAppInBackground(Duration.ofSeconds(3));

        waitForElementPresent
                (
                        By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Java']"),
                        "Cannot find article after returning from background",
                        13
                );

        driver.rotate(ScreenOrientation.PORTRAIT);

        String title_after_rotation = waitForElementAndGetAttribute
                (
                        By.xpath("//*[contains(@text,'Java')]"),
                        "text",
                        "Cannot find title of article1",
                        15
                );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_second_rotation = waitForElementAndGetAttribute
                (
                        By.xpath("//*[contains(@text,'Java')]"),
                        "text",
                        "Cannot find title of article1",
                        15
                );

        Assert.assertEquals
                (
                        "Article title have been changed after screen rotation",
                        title_after_rotation,
                        title_after_second_rotation
                );

    }


        private WebElement waitForElementPresent (By by, String error_message,long timeoutInSeconds)
        {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.withMessage(error_message + "\n");
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }


        private WebElement waitForElementAndClick (By by, String error_message,long timeoutInSeconds)
        {
            WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
            element.click();
            return element;
        }

        private WebElement waitForElementAndSendKeys (By by, String value, String error_message,long timeoutInSeconds)
        {
            WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
            element.sendKeys(value);
            return element;
        }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

        private String waitForElementAndGetAttribute (By by, String attribute, String error_message,
        long timeoutInSeconds)
        {
            WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
            return element.getAttribute(attribute);
        }

}

