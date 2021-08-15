package MethodsSpesialForTestsAndLessons;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class NavigationUICloneSpecialForLessons extends MethodsObjectMainInMyTests
{
    private static final String
            MY_LISTS_LINK = "//android.widget.ImageButton[@content-desc='Navigate up']";

    public NavigationUICloneSpecialForLessons(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyNavigateUp()
    {
        this.waitSecondMethodAndClick
                (
                        By.xpath(MY_LISTS_LINK),
                        "Cannot find word 'Navigate up'",
                        5
                );
    }
}
