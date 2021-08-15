package tests;

import lib.CoreTestCase;
import org.junit.Test;
import ui.ArticlePageObject;
import ui.MyListsPageObject;
import ui.NavigationUI;
import ui.SearchPageObject;

public class MyListsTests extends CoreTestCase
{
    @Test
    public void testSaveFirstArticleToMyList()
    {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.skipSearchLine();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyViewLists();


        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.swipeByArticleToDelete(article_title);
    }
}


