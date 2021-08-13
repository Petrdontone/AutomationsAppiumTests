package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUI extends MainPageObject
{
    private static final String
                 MY_LISTS_LINK = "org.wikipedia:id/snackbar_action";

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyViewLists()
    {
        this.waitForElementAndClick
                (
                        By.id(MY_LISTS_LINK),
                        "Cannot find word 'View List'",
                        5
                );
    }
}
