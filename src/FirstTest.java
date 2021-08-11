import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.time.Duration;
import java.util.List;

//     "//*[@resource-id='id']//*[@text='text']" ------ Конкатенация в xpath
//     By.xpath("//android.widget.ImageView[@content-desc='Navigate up']") Поиск по классу и контенс деску

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
    public void firstTest()
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
    }




    @Test
    public void testCancelSearch()
    {
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


                @Test
                public void testSwipeArticle()
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
                                    "Appium",
                                    "Cannot don't search this word",
                                    5
                            );

                    waitForElementAndClick
                            (
                                    By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
                                    "Cannot find our text for Appium",
                                    13
                            );

                    waitForElementPresent
                            (
                                    By.id("org.wikipedia:id/article_menu_bookmark"),
                                    "Cannot find article title",
                                    13
                            );

                    swipeUpToFindElement
                            (
                                    By.xpath("//*[@text='View edit history']"),
                                    "Cannot find the end of the article",
                                    20
                            );
                }

                @Test
                public void saveFirstArticleToMyList()
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

                    waitForElementPresent
                            (
                                    By.xpath("//*[@text='Java (programming language)']"),
                                    "Cannot find article title",
                                    13
                            );

                    waitForElementAndClick
                            (
                                    By.id("org.wikipedia:id/article_menu_bookmark"),
                                    "Cannot find button to save",
                                    5
                            );

                    waitForElementAndClick
                            (
                                    By.id("org.wikipedia:id/snackbar_action"),
                                    "Cannot find button 'Add To List'",
                                    5
                            );

                    String name_of_folder = "Learning programming";

                    waitForElementAndSendKeys
                            (
                                    By.id("org.wikipedia:id/text_input"),
                                    name_of_folder,
                                    "Cannot put text into articles folder input",
                                    5
                            );

                    waitForElementAndClick
                            (
                                    By.xpath("//*[@text='OK']"),
                                    "Cannot press 'OK' button",
                                    5
                            );

                    waitForElementAndClick
                            (
                                    By.id("org.wikipedia:id/snackbar_action"),
                                    "Cannot find word 'View List'",
                                    5
                            );


                    swipeElementToLeft
                            (
                                    By.id("org.wikipedia:id/page_list_item_description"),
                                    "Cannot swipe this word"

                            );


                    waitForElementNotPresent
                            (
                                    By.id("org.wikipedia:id/page_list_item_description"),
                                    "Cannot deleted saved article",
                                    5
                            );
                }

                @Test
                public void testAmountOfNotEmptySearch()
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

                    String search_line = "Vance Joy";

                    waitForElementAndSendKeys
                            (
                                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                                    search_line,
                                    "Cannot don't word",
                                    5
                            );

                    String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']";
                    waitForElementPresent
                            (
                                    By.xpath(search_result_locator),
                                    "Cannot find anything by the request " + search_line,
                                    15
                            );

                    int amount_of_search_results = getAmountOfElements
                            (
                                    By.xpath(search_result_locator)
                            );
                    
                    Assert.assertTrue
                            (
                                    "We found too few results!",
                                    amount_of_search_results > 0
                            );
                }

                @Test
                public void testAmountOfEmptySearch()
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

                    String search_line = "oweooewfjweofewjo";

                    waitForElementAndSendKeys
                            (
                                    By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                                    search_line,
                                    "Cannot don't word",
                                    5
                            );

                    String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']";
                    String empty_result_label = "//*[@text='No results']";

                    waitForElementPresent
                            (
                                    By.xpath(empty_result_label),
                                    "Cannot find empty result label by the request " + search_line,
                                    15
                            );

                    assertElementNotPresent
                            (
                                   By.xpath(search_result_locator),
                                   "We've found some results by request " + search_line
                            );
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

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }


    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "/n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    protected void swipeUp(int timeOfSwipe)
    {
        TouchAction touchAction = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2; //ширина устройства / на 2
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        touchAction
                .press(PointOption.point(x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                .moveTo(PointOption.point(x, end_y))
                .release()
                .perform();
    }

    protected void swipeUpQuick()
    {
        swipeUp(1000);
    }

    protected void swipeUpToFindElement(By by, String error_message, int max_swipes)
    {
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0)
        {
            if (already_swiped > max_swipes)
            {
                waitForElementPresent(by, "Cannot find element by swiping up. \n" + error_message, 0);
                return;
            }

            swipeUpQuick();
            ++already_swiped;
        }
    }

    protected void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitForElementPresent
                (
                        by,
                        error_message,
                        10
                );
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction touchAction = new TouchAction(driver);
        touchAction
                .press(PointOption.point(right_x, middle_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(left_x, middle_y))
                .release()
                .perform();
    }

    private int getAmountOfElements(By by)
    {
        List elements = driver.findElements(by);
        return elements.size();
    }

    private void assertElementNotPresent(By by, String error_message)
    {
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements > 1)
        {
            String default_message = "An element '" + by.toString() + "' supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    private String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        return element.getAttribute(attribute);
    }

}
