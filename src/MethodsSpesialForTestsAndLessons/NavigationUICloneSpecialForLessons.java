package MethodsSpesialForTestsAndLessons;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import ui.MainPageObject;

public class NavigationUICloneSpecialForLessons extends MethodsObjectMainInMyTests
{
    private static final String
            MY_LISTS_LINK = "org.wikipedia:id/snackbar_action";

    public NavigationUICloneSpecialForLessons(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyViewLists()
    {
        this.waitSecondMethodAndClick
                (
                        By.id(MY_LISTS_LINK),
                        "Cannot find word 'View List'",
                        5
                );
    }
}
