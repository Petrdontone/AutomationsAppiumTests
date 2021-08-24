package ui;

import io.appium.java_client.AppiumDriver;

public class MyListsPageObject extends MainPageObject
{
    public static final String
                ARTICLE_BY_TITLE_TPL = "id:org.wikipedia:id/page_list_item_description";

    private static String getFolderXpathByName(String name_of_folder)
    {
        return ARTICLE_BY_TITLE_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }


    public MyListsPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementPresent(article_xpath,"Cannot find saved article by title" + article_xpath, 15);
    }
    


    public void waitForArticleToDisappearByTitle(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementNotPresent(article_xpath,"Saved article still present with title " + article_xpath, 15);
    }

    public void swipeByArticleToDelete(String article_title)
    {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getFolderXpathByName(article_title);
        this.swipeElementToLeft
                (
                        article_xpath,
                        "Cannot swipe this word"
                );
        this.waitForArticleToDisappearByTitle(article_title);
    }

}
