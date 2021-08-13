package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject
{
    private static final String
                TITLE = "org.wikipedia:id/article_menu_bookmark",
                FOOTER_ELEMENT = "//*[@text='View edit history']",
                OPTIONS_BUTTON = "org.wikipedia:id/article_menu_bookmark",
                OPTIONS_ADD_TO_MY_LIST_BUTTON = "org.wikipedia:id/snackbar_action",
                MY_LIST_NAME_INPUT = "org.wikipedia:id/text_input",
                MY_LIST_OK_BUTTON = "//*[@text='OK']";


    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }



   public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(By.id(TITLE), "Cannot find article title on page!", 10);
    }

    
    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement
                (
                        By.xpath(FOOTER_ELEMENT),
                        "Cannot find the end of article",
                        20
                );
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick
                (
                        By.id(OPTIONS_BUTTON),
                        "Cannot find button to save",
                        5
                );

        this.waitForElementAndClick
                (
                        By.id(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                        "Cannot find button 'Add To List'",
                        5
                );


        this.waitForElementAndSendKeys
                (
                        By.id(MY_LIST_NAME_INPUT),
                        name_of_folder,
                        "Cannot put text into articles folder input",
                        5
                );

        this.waitForElementAndClick
                (
                        By.xpath(MY_LIST_OK_BUTTON),
                        "Cannot press 'OK' button",
                        5
                );
    }
}
