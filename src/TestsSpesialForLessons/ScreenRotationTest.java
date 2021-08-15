package TestsSpesialForLessons;

import LibSpesialForLesson.ConfigurationForTests;
import MethodsSpesialForTestsAndLessons.ArticlePageObjectCloneSpecialForLessons;
import MethodsSpesialForTestsAndLessons.SearchPageObjectCloneSpecialForLessons;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

import java.time.Duration;

public class ScreenRotationTest extends ConfigurationForTests
{
    @Test
    public void testChangeScreenOrientationOnSearchResults()
    {
        SearchPageObjectCloneSpecialForLessons SearchPageObjectCloneSpecialForLessons = new SearchPageObjectCloneSpecialForLessons(driver);

        SearchPageObjectCloneSpecialForLessons.skipSearchLine();
        SearchPageObjectCloneSpecialForLessons.initSearchInput();
        String search_line = "Javelin throw";
        SearchPageObjectCloneSpecialForLessons.typeSearchLine(search_line);
        SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("Track and field athletics event");


        ArticlePageObjectCloneSpecialForLessons ArticlePageObjectCloneSpecialForLessons = new ArticlePageObjectCloneSpecialForLessons(driver);
        String title_before_rotation = ArticlePageObjectCloneSpecialForLessons.getArticleTitle();

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = ArticlePageObjectCloneSpecialForLessons.getArticleTitle();
        Assert.assertEquals
                (
                        "Article title have been changed after screen rotation",
                        title_before_rotation,
                        title_after_rotation
                );

        driver.rotate(ScreenOrientation.PORTRAIT);

        String title_after_second_rotation = ArticlePageObjectCloneSpecialForLessons.getArticleTitle();
        Assert.assertEquals
                (
                        "Article title have been changed after screen rotation",
                        title_before_rotation,
                        title_after_second_rotation
                );
    }


    @Test
    public void testCheckSearchArticleInBackground()
    {
        SearchPageObjectCloneSpecialForLessons SearchPageObjectCloneSpecialForLessons = new SearchPageObjectCloneSpecialForLessons(driver);

        SearchPageObjectCloneSpecialForLessons.skipSearchLine();
        SearchPageObjectCloneSpecialForLessons.initSearchInput();
        String search_line = "Java";
        SearchPageObjectCloneSpecialForLessons.typeSearchLine(search_line);
        SearchPageObjectCloneSpecialForLessons.waitForSearchResult(search_line);

        driver.runAppInBackground(Duration.ofSeconds(3));

        SearchPageObjectCloneSpecialForLessons.waitForSearchResult(search_line);
        driver.rotate(ScreenOrientation.PORTRAIT);

        String title_after_rotation = SearchPageObjectCloneSpecialForLessons.waitForElementAndGetAttribute
                (
                        By.xpath("//*[contains(@text,'Java')]"),
                        "text",
                        "Cannot find title of article after Portrait",
                        15
                );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_second_rotation = SearchPageObjectCloneSpecialForLessons.waitForElementAndGetAttribute
                (
                        By.xpath("//*[contains(@text,'Java')]"),
                        "text",
                        "Cannot find title of article after Landscape",
                        15
                );

        Assert.assertEquals
                (
                        "Article title have been changed after screen rotation",
                        title_after_rotation,
                        title_after_second_rotation
                );
    }
}



