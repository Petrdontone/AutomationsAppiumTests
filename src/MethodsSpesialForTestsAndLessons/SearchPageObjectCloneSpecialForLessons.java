package MethodsSpesialForTestsAndLessons;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class SearchPageObjectCloneSpecialForLessons extends MethodsObjectMainInMyTests
{
    private static final String
            SKIP_ELEMENT = "//*[contains(@text,'SKIP')]", //Объявление константы
            SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_INPUT_ON_ADD_LIST = "//*[contains(@text,'Name of this list')]",
            SEARCH_CANCEL_BUTTON = "//*[contains(@text,'Japan')]",
            SEARCH_CANNOT_BUTTON = "org.wikipedia:id/search_src_text",
            TYPE_CLEAR_LINE = "org.wikipedia:id/search_src_text",
            SEARCH_RESULT_BY_STRING_TPL = "//*[contains(@text,'{SUBSTRING}')]",
            SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']",
            SEARCH_EMPTY_RESULT = "//*[@text='No results']",
            SEARCH_ASSERT_RESULT = "//*[@resource-id='org.wikipedia:id/search_results_list']";

    public SearchPageObjectCloneSpecialForLessons(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_STRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitFirstMainMethod(By.xpath(search_result_xpath), "Cannot find search result " + substring, 5);
    }


    public void typeSearchLine(String search_line)
    {
        this.waitThirdMethodAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find input by word",5);
    }
    public void typeSearchLineInAddList(String search_line)
    {
        this.waitThirdMethodAndSendKeys(By.xpath(SEARCH_INPUT_ON_ADD_LIST), search_line, "Cannot find input by word",5);
    }

    public void skipSearchLine()
    {
        this.waitSecondMethodAndClick(By.xpath(SKIP_ELEMENT), "Cannot find line 'SKIP'", 5);
    }

    public void initSearchInput()
    {
        this.waitFirstMainMethod(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element",5);
        this.waitSecondMethodAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
    }

    public void waitForCancelButtonAppear()
    {
        this.waitFirstMainMethod(By.xpath(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementNotPresent(By.id(SEARCH_CANNOT_BUTTON), "Cannot find this element id", 5);
    }

    public void clearLine()
    {
        this.waitForElementAndClear(By.id(TYPE_CLEAR_LINE), "Cannot clear this line", 5);
    }


    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitSecondMethodAndClick(By.xpath(search_result_xpath), "Cannot find and click search result " + substring, 5);
    }

    public int getAmountFoundArticles()
    {
        this.waitFirstMainMethod
                (
                        By.xpath(SEARCH_RESULT_ELEMENT),
                        "Cannot find anything by the request",
                        15
                );
        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));
    }

    public void waitForEmptyResultsLabel()
    {
        this.waitFirstMainMethod(By.xpath(SEARCH_EMPTY_RESULT), "Cannot find empty result element. ", 10);
    }

    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(By.id(SEARCH_ASSERT_RESULT), "We supposed not to find any results");
    }
}
