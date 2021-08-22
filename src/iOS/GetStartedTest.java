package iOS;

import lib.iOSConfigurationForTests;
import org.junit.Test;
import ui.WelcomePageObject;

public class GetStartedTest extends iOSConfigurationForTests
{
    @Test
    public void testPassThroughWelcome()
        {
            WelcomePageObject WelcomePage = new WelcomePageObject(driver);

            WelcomePage.waitForLearnMoreLink();
            WelcomePage.clickNextButton();

            WelcomePage.waitForNewWaysToExploreText();
            WelcomePage.clickNextButton();

            WelcomePage.waitForAddOrEditPreferredLangText();
            WelcomePage.clickNextButton();

            WelcomePage.waitForLearnMoreAboutDateCollectedText();
            WelcomePage.clickGetStartedButton();
        }
}
