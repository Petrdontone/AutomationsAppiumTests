/*package TestsSpesialForLessons;

import LibSpesialForLesson.ConfigurationForTests;
import MethodsSpesialForTestsAndLessons.ArticlePageObjectCloneSpecialForLessons;
import MethodsSpesialForTestsAndLessons.SearchPageObjectCloneSpecialForLessons;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchRelatedTests extends ConfigurationForTests
{

    @Test
    public void checkingWordInSearch()
    {

        {
            SearchPageObjectCloneSpecialForLessons SearchPageObjectCloneSpecialForLessons = new SearchPageObjectCloneSpecialForLessons(driver);

            SearchPageObjectCloneSpecialForLessons.skipSearchLine();
            SearchPageObjectCloneSpecialForLessons.initSearchInput();
            SearchPageObjectCloneSpecialForLessons.typeSearchLine("JavaScript");
            SearchPageObjectCloneSpecialForLessons.waitForCancelButtonToDisappear();
        }

        ArticlePageObjectCloneSpecialForLessons ArticlePageObjectCloneSpecialForLessons = new ArticlePageObjectCloneSpecialForLessons(driver);
        String article_title = ArticlePageObjectCloneSpecialForLessons.getArticleTitle();
        assertEquals
                (
                        "We see unexpected title",
                        "Save",
                        article_title
                );



    @Test
    public void checkingWord()
    {

        SearchPageObjectCloneSpecialForLessons SearchPageObjectCloneSpecialForLessons = new SearchPageObjectCloneSpecialForLessons(driver);

        SearchPageObjectCloneSpecialForLessons.skipSearchLine();

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

    @Test
    public void testForCancelSearch()
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
                        "Queen",
                        "Cannot find out Queen Victoria:)",
                        5
                );

        waitSecondMethodAndClick
                (
                        By.xpath("//*[contains(@text, 'British rock band formed in 1970')]"),
                        "These words were not found",
                        8
                );

        WebElement title_element = waitFirstMainMethod
                (
                        By.xpath("//*[contains(@text, 'Theme')]"),
                        "Cannot find article title",
                        13
                );

        String article_title = title_element.getAttribute("text");

        Assert.assertEquals
                (
                        "We see unexpected title",
                        "Theme",
                        article_title
                );

        waitSecondMethodAndClick
                (
                        By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                        "Cannot find this xpath for Navigate up",
                        6
                );

        waitSecondMethodAndClick
                (
                        By.xpath("//*[contains(@text, 'Topics referred to by the same term')]"),
                        "Cannot find for Victoria",
                        5
                );

        WebElement title_element1 = waitFirstMainMethod
                (
                        By.xpath("//*[contains(@text, 'Save')]"),
                        "Cannot find article title",
                        13
                );

        String article_title1 = title_element1.getAttribute("text");

        Assert.assertEquals
                (
                        "We see unexpected title",
                        "Save",
                        article_title1
                );

        waitSecondMethodAndClick
                (
                        By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"),
                        "Cannot find this xpath for Navigate up",
                        6
                );

        waitSecondMethodAndClick
                (
                        By.id("org.wikipedia:id/search_close_btn"),
                        "Cannot find for close button",
                        5
                );

        WebElement title_element2 = waitFirstMainMethod
                (
                        By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                        "Cannot find article title",
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
                        "Java",
                        "Cannot find out Queen Victoria:)",
                        5
                );

        WebElement title_element1 = waitFirstMainMethod
                (
                        By.xpath("//*[contains(@text, 'JavaScript')]"),
                        "Cannot find article title first",
                        13
                );

        String article_title1 = title_element1.getAttribute("text");

        Assert.assertEquals
                (
                        "We see unexpected title",
                        "JavaScript",
                        article_title1
                );



        WebElement title_element2 = waitFirstMainMethod
                (
                        By.xpath("//*[contains(@text, 'Java (programming language)')]"),
                        "Cannot find article title second",
                        13
                );

        String article_title2 = title_element2.getAttribute("text");

        Assert.assertEquals
                (
                        "We see unexpected title",
                        "Java (programming language)",
                        article_title2
                );


        WebElement title_element3 = waitFirstMainMethod
                (
                        By.id("org.wikipedia:id/page_list_item_title"),
                        "Cannot find article title third",
                        13
                );

        String article_title3 = title_element3.getAttribute("text");

        Assert.assertEquals
                (
                        "We see unexpected title",
                        "Java",
                        article_title3
                );
    }
}


 */

