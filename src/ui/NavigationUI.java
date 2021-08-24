package ui;

import io.appium.java_client.AppiumDriver;

public class NavigationUI extends MainPageObject
{
    private static final String
                 MY_LISTS_LINK = "id:org.wikipedia:id/snackbar_action";

    public NavigationUI(AppiumDriver driver)
    {
        super(driver);
    }

    public void clickMyViewLists()
    {
        this.waitForElementAndClick
                (
                        MY_LISTS_LINK,
                        "Cannot find word 'View List'",
                        5
                );
    }
}
