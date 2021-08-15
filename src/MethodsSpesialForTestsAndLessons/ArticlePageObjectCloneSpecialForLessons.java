package MethodsSpesialForTestsAndLessons;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ArticlePageObjectCloneSpecialForLessons extends MethodsObjectMainInMyTests
{
    private static final String
            TITLE1 = "//*[@text='High-level programming language']",
            TITLE = "org.wikipedia:id/article_menu_bookmark",
            FOOTER_ELEMENT = "//*[@text='View edit history']",
            OPTIONS_BUTTON = "org.wikipedia:id/article_menu_bookmark",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "org.wikipedia:id/snackbar_action",
            MY_LIST_NAME_INPUT = "//*[@text='MyFolderInProgrammingCourses']",
            MY_LIST_OK_BUTTON = "//*[@text='OK']";


    public ArticlePageObjectCloneSpecialForLessons(AppiumDriver driver)
    {
        super(driver);
    }



    public WebElement waitForTitleElement()
    {
        return this.waitFirstMainMethod(By.id(TITLE), "Cannot find article title on page!", 10);
    }


    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }
//BAD IDEAS
    public WebElement waitForTitleElementForXpath()
    {
        return this.waitFirstMainMethod(By.xpath(TITLE1), "Cannot find article title on page for xpath!", 10);
    }


    public String getArticleTitleForXpath()
    {
        WebElement title_element = waitForTitleElementForXpath();
        return title_element.getAttribute("text");
    }
    //BAD IDEAS

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

        this.waitThirdMethodAndSendKeys
                (
                        By.xpath(MY_LIST_NAME_INPUT),
                        name_of_folder,
                        "Cannot put text into articles folder input",
                        5
                );

        this.waitSecondMethodAndClick
                (
                        By.id(OPTIONS_BUTTON),
                        "Cannot find button to save",
                        5
                );

        this.waitSecondMethodAndClick
                (
                        By.id(OPTIONS_ADD_TO_MY_LIST_BUTTON),
                        "Cannot find button 'Add To List'",
                        5
                );


        this.waitSecondMethodAndClick
                (
                        By.xpath(MY_LIST_OK_BUTTON),
                        "Cannot press 'OK' button",
                        5
                );
    }
}
