package TestsSpesialForLessons;

import LibSpesialForLesson.ConfigurationForTests;
import MethodsSpesialForTestsAndLessons.MyListsPageObjectCloneSpecialForLessons;
import MethodsSpesialForTestsAndLessons.SearchPageObjectCloneSpecialForLessons;
import org.junit.Test;


public class TestRelatedToCheckingAndSavingArticles extends ConfigurationForTests
{
    @Test
    public void testSavingTwoArticles()
        {
            SearchPageObjectCloneSpecialForLessons SearchPageObjectCloneSpecialForLessons = new SearchPageObjectCloneSpecialForLessons(driver);

            SearchPageObjectCloneSpecialForLessons.skipSearchLine();
            SearchPageObjectCloneSpecialForLessons.initSearchInput();
            SearchPageObjectCloneSpecialForLessons.typeSearchLine("China");
            SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("Country in East Asia");
            SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("Save");
            SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("ADD TO LIST");
            SearchPageObjectCloneSpecialForLessons.typeSearchLineInAddList("MyFolderInProgrammingCourses");

            SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("OK");
            SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("Search Wikipedia");
            SearchPageObjectCloneSpecialForLessons.typeSearchLine("Japan");
            SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("Island country in East Asia");
            SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("Save");
            SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("ADD TO LIST");
            SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("MyFolderInProgrammingCourses");//
            SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("VIEW LIST");

            MyListsPageObjectCloneSpecialForLessons MyListsPageObjectCloneSpecialForLessons = new MyListsPageObjectCloneSpecialForLessons(driver);
            MyListsPageObjectCloneSpecialForLessons.swipeByArticleToDelete("MyFolderInProgrammingCourses");

            SearchPageObjectCloneSpecialForLessons.waitForCancelButtonAppear();
            SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("Japan");
        }

        @Test
        public void testAssertTitle ()
        {
            SearchPageObjectCloneSpecialForLessons SearchPageObjectCloneSpecialForLessons = new SearchPageObjectCloneSpecialForLessons(driver);

            SearchPageObjectCloneSpecialForLessons.skipSearchLine();
            SearchPageObjectCloneSpecialForLessons.initSearchInput();
            String firstValue = "John Cena";
            SearchPageObjectCloneSpecialForLessons.typeSearchLine(firstValue);
            SearchPageObjectCloneSpecialForLessons.clickByArticleWithSubstring("American professional wrestler, actor, television presenter, and former rapper");
            String search_line_Cena = "Contents";
            SearchPageObjectCloneSpecialForLessons.waitForSearchResult(search_line_Cena);
        }
    }

