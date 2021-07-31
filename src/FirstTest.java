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



public class FirstTest
{
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","11");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/user/Desktop/JavaAppium/apks/org.wikipedia_50363_apps.evozi.com (1).apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

   @Test
    public void firstTest() {
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
                        "Cannot don't word",
                        5
                );

        waitForElementAndClick
                (
                        By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                        "Cannot find our text for OOP",
                        13
                );
    }




    @Test
    public void testCancelSearch() {
        waitForElementAndClick
                (
                        By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                        "cannot find don't tap skip",
                        5
                );

        waitForElementAndClick
                (
                        By.xpath("//android.widget.ImageView[@content-desc=\"Search Wikipedia\"]\n"),
                        "cannot find this className",
                        5
                );

        waitForElementAndSendKeys
                (
                        By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                        "Java",
                        "Cannot don't word",
                        5
                );

        waitForElementAndClear
                (
                        By.id("org.wikipedia:id/search_src_text"),
                        "Cannot find search field",
                        15
                );

        waitForElementNotPresent
                (
                        By.xpath("//android.widget.ImageView[@content-desc=\"Search Wikipedia\"]\n"),
                        "cannot find this className1",
                        5
                );
    }



            @Test
            public void testCompareArticleTitle()
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
                            "Cannot don't word",
                            5
                    );

            waitForElementAndClick
                    (

                            By.xpath("//*[contains(@text,'Object-oriented programming language')]"),
                            "Cannot find our text for OOP",
                            13
                    );
            WebElement title_element = waitForElementPresent
                    (
                            By.id("org.wikipedia:id/article_menu_bookmark"),
                            "Cannot find article title",
                            13
                    );

            String article_title = title_element.getAttribute("text");

            Assert.assertEquals
                    (
                            "We see unexpected title",
                            "Save",
                            article_title
                    );
        }




    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }


    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "/n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

}
