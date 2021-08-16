package TestsSpesialForLessons;

import LibSpesialForLesson.ConfigurationForTests;
import MethodsSpesialForTestsAndLessons.ArticlePageObjectCloneSpecialForLessons;
import MethodsSpesialForTestsAndLessons.NavigationUICloneSpecialForLessons;
import MethodsSpesialForTestsAndLessons.SearchPageObjectCloneSpecialForLessons;
import org.junit.Test;

public class SearchRelatedTests extends ConfigurationForTests
{

    @Test
    public void testCheckingWordInSearch()
    {

        {
            SearchPageObjectCloneSpecialForLessons SearchPageObjectCloneSpecialForLessons = new SearchPageObjectCloneSpecialForLessons(driver);

            SearchPageObjectCloneSpecialForLessons.skipSearchLine();
            SearchPageObjectCloneSpecialForLessons.initSearchInput();
            SearchPageObjectCloneSpecialForLessons.typeSearchLine("JavaScript");
            SearchPageObjectCloneSpecialForLessons.waitForSearchResult("High-level programming language");
        }

        ArticlePageObjectCloneSpecialForLessons ArticlePageObjectCloneSpecialForLessons = new ArticlePageObjectCloneSpecialForLessons(driver);
        String article_title = ArticlePageObjectCloneSpecialForLessons.getArticleTitleForXpath();
        assertEquals
                (
                        "We see unexpected title",
                        "High-level programming language",
                        article_title
                );
    }


    @Test
    public void testForCancelSearch() {
        SearchPageObjectCloneSpecialForLessons SearchPageObjectCloneSpecialForLessons = new SearchPageObjectCloneSpecialForLessons(driver);

        SearchPageObjectCloneSpecialForLessons.skipSearchLine();
        SearchPageObjectCloneSpecialForLessons.initSearchInput();
        SearchPageObjectCloneSpecialForLessons.typeSearchLine("Queen");
        SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("British rock band formed in 1970");
        SearchPageObjectCloneSpecialForLessons.waitForEmptyResultsLabel();

        NavigationUICloneSpecialForLessons NavigationUICloneSpecialForLessons = new NavigationUICloneSpecialForLessons(driver);
        NavigationUICloneSpecialForLessons.clickMyNavigateUp();

        SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("Topics referred to by the same term");

        ArticlePageObjectCloneSpecialForLessons ArticlePageObjectCloneSpecialForLessons = new ArticlePageObjectCloneSpecialForLessons(driver);
        String article_title = ArticlePageObjectCloneSpecialForLessons.getArticleTitle();
        assertEquals
                (
                        "We see unexpected title",
                        "Save",
                        article_title
                );

        NavigationUICloneSpecialForLessons.clickMyNavigateUp();
        SearchPageObjectCloneSpecialForLessons.waitForCancelButtonToDisappear();

    }

    @Test
    public void testAssertTitle()
    {
        SearchPageObjectCloneSpecialForLessons SearchPageObjectCloneSpecialForLessons = new SearchPageObjectCloneSpecialForLessons(driver);

        SearchPageObjectCloneSpecialForLessons.skipSearchLine();
        SearchPageObjectCloneSpecialForLessons.initSearchInput();
        SearchPageObjectCloneSpecialForLessons.typeSearchLine("New York City");
        SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("Most populous city in the United States");

        ArticlePageObjectCloneSpecialForLessons ArticlePageObjectCloneSpecialForLessons = new ArticlePageObjectCloneSpecialForLessons(driver);
        String article_title = ArticlePageObjectCloneSpecialForLessons.getArticleTitle();
        assertEquals
                (
                        "We see unexpected title",
                        "Save",
                        article_title
                );
    }
}






