import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.time.Duration;


public class Ex5
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
    public void savingTwoArticles()
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
                        "China",
                        "Cannot find in search 'China'",
                        5
                );

        waitSecondMethodAndClick
                (
                        By.xpath("//*[contains(@text, 'Country in East Asia')]"),
                        "Cannot find this resource id and text for China",
                        5
                );

        waitSecondMethodAndClick
                (
                        By.id("org.wikipedia:id/article_menu_bookmark"),
                        "Cannot find button to save",
                        5
                );

        waitSecondMethodAndClick
                (
                        By.id("org.wikipedia:id/snackbar_action"),
                        "Cannot find button 'Add To List'",
                        5
                );

        String nameOfFolder = "MyFolderInProgrammingCourses";

        waitThirdMethodAndSendKeys
                (
                        By.id("org.wikipedia:id/text_input"),
                        nameOfFolder,
                        "Cannot find search my folder ",
                        5
                );

        waitSecondMethodAndClick
                (
                        By.xpath("//*[@text='OK']"),
                        "Cannot press 'OK' button",
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
                        "Japan",
                        "Cannot find in search 'China'",
                        5
                );

        waitSecondMethodAndClick
                (
                        By.xpath("//*[contains(@text, 'Country in East Asia')]"),
                        "Cannot find text for Japan",
                        5
                );

        waitSecondMethodAndClick
                (
                        By.id("org.wikipedia:id/article_menu_bookmark"),
                        "Cannot find button to save",
                        5
                );

        waitSecondMethodAndClick
                (
                        By.id("org.wikipedia:id/snackbar_action"),
                        "Cannot find button 'Add To List'",
                        5
                );

        waitSecondMethodAndClick
                (
                        By.id("org.wikipedia:id/item_title"),
                        "Cannot find button 'Add To List'",
                        5
                );

        waitSecondMethodAndClick
                (
                        By.id("org.wikipedia:id/snackbar_action"),
                        "Cannot find to button 'View list'",
                        5
                );

        swipeElementToLeft
                (
                        By.id("org.wikipedia:id/page_list_item_description"),
                        "Cannot swipe this word"
                );

        waitFirstMainMethod
                (
                        By.xpath("//*[contains(@text, 'Japan')]"),
                        "Cannot deleted saved article",
                        5
                );

        waitSecondMethodAndClick
                (
                        By.xpath("//*[contains(@text, 'Japan')]"),
                        "Cannot find text for China",
                        5

                );

        waitFirstMainMethod
                (
                        By.xpath("//*[contains(@text, 'Japan')]"),
                        "Cannot deleted saved article",
                        5
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

    protected void swipeElementToLeft(By by, String error_message)
    {
        WebElement element = waitFirstMainMethod
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
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300))) //Чем меньше значение - тем быстрее свайп элемента
                .moveTo(PointOption.point(left_x, middle_y))
                .release()
                .perform();
    }

}