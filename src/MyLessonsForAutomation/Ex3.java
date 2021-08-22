package MyLessonsForAutomation;

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


public class Ex3
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
        capabilities.setCapability("app", "/Users/user/Desktop/JavaAppium/apks/org.wikipedia_50363_apps.evozi.com.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }


    @Test
    public void testForCancelSearch()
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

        waitThirdMethodAndSendKeys
                (
                        By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                        "Queen",
                        "Cannot find out Queen Victoria:)",
                        5
                );

        waitSecondMethodAndClick
                (
                        By.xpath("//*[contains(@text, 'British rock band formed in 1970')]"),
                        "These words were not found",
                        8
                );

        WebElement title_element = waitFirstMainMethod
                (
                        By.xpath("//*[contains(@text, 'Theme')]"),
                        "Cannot find article title",
                        13
                );

        String article_title = title_element.getAttribute("text");

        Assert.assertEquals
                (
                        "We see unexpected title",
                        "Theme",
                        article_title
                );

        waitSecondMethodAndClick
                (
                        By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                        "Cannot find this xpath for Navigate up",
                        6
                );

       waitSecondMethodAndClick
                (
                        By.xpath("//*[contains(@text, 'Topics referred to by the same term')]"),
                        "Cannot find for Victoria",
                        5
                );

        WebElement title_element1 = waitFirstMainMethod
                (
                        By.xpath("//*[contains(@text, 'Save')]"),
                        "Cannot find article title",
                        13
                );

        String article_title1 = title_element1.getAttribute("text");

        Assert.assertEquals
                (
                        "We see unexpected title",
                        "Save",
                        article_title1
                );

        waitSecondMethodAndClick
                (
                        By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                        "Cannot find this xpath for Navigate up",
                        6
                );

        waitSecondMethodAndClick
                (
                        By.id("org.wikipedia:id/search_close_btn"),
                        "Cannot find for close button",
                        5
                );

        WebElement title_element2 = waitFirstMainMethod
                (
                        By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                        "Cannot find article title",
                        13
                );

        String article_title2 = title_element2.getAttribute("text");

        Assert.assertEquals
                (
                        "We see unexpected title",
                        "Search Wikipedia",
                        article_title2
                );
    }


    private WebElement waitFirstMainMethod(By by, String error_message, int timeoutInSeconds)
    {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.withMessage(error_message + "\n");
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitSecondMethodAndClick(By by, String error_message, int timeoutInSeconds)
    {
        WebElement element = waitFirstMainMethod(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitThirdMethodAndSendKeys(By by, String value, String error_message, int timeoutInSeconds)
    {
        WebElement element = waitFirstMainMethod(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

}
