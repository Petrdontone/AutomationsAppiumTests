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


public class Ex2
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
    public void checkingWordInSearch()
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
                        "Peter",
                        "Cannot find out Queen Victoria:)",
                        5
                );


        WebElement title_element1 = assertElementHasText
                (
                        By.xpath("//*[contains(@text, '19th United States secretary of transportation and former Mayor of South Bend, Indiana')]"),
                        "Cannot find article title first",
                        13
                );

        String article_title1 = title_element1.getAttribute("text");

        Assert.assertEquals
                (
                        "We see unexpected title",
                        "19th United States secretary of transportation and former Mayor of South Bend, Indiana",
                        article_title1
                );
    }
        @Test
        public void checkingWord()
        {

            waitSecondMethodAndClick
                    (
                            By.xpath("//*[contains(@text, 'SKIP')]"),
                            "Cannot find this word - SKIP",
                            5
                    );

            WebElement title_element2 = assertElementHasText
                (
                        By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                        "Cannot find article title first",
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


    


    private WebElement assertElementHasText(By by, String error_message, int timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private WebElement waitSecondMethodAndClick(By by, String error_message, int timeoutInSeconds)
    {
        WebElement element = assertElementHasText(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitThirdMethodAndSendKeys(By by, String value, String error_message, int timeoutInSeconds)
    {
        WebElement element = assertElementHasText(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

}