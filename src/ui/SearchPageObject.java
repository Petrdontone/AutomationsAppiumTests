package ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject
{
    private static final String
            SKIP_ELEMENT = "//*[contains(@text,'SKIP')]",
            SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text,'Search Wikipedia')]",
            SEARCH_CANCEL_BUTTON = "//android.widget.ImageView[@content-desc=\"Search Wikipedia\"]\n",
            SEARCH_CANNOT_BUTTON = "org.wikipedia:id/search_src_text",
            TYPE_CLEAR_LINE = "org.wikipedia:id/search_src_text",
            SEARCH_RESULT_BY_STRING_TPL = "//*[contains(@text,'{SUBSTRING}')]",
            SEARCH_RESULT_ELEMENT = "//*[@resource-id='org.wikipedia:id/search_results_list']",
            SEARCH_EMPTY_RESULT = "//*[@text='No results']",
            SEARCH_ASSERT_RESULT = "//*[@resource-id='org.wikipedia:id/search_results_list']";

    public SearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_STRING_TPL.replace("{SUBSTRING}", substring);
    }
    /* TEMPLATES METHODS */

    public void skipSearchLine()
    {
        this.waitForElementAndClick(By.xpath(SKIP_ELEMENT), "Cannot find line 'SKIP'", 5);
    }

    public void initSearchInput()
    {
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find search input after clicking search init element",5);
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Cannot find and click search init element", 5);
    }

    public void waitForCancelButtonAppear()
    {
        this.waitForElementPresent(By.xpath(SEARCH_CANCEL_BUTTON), "Cannot find search cancel button", 5);
    }

    public void waitForCancelButtonToDisappear()
    {
        this.waitForElementPresent(By.id(SEARCH_CANNOT_BUTTON), "Cannot find this element id", 5);
    }

    public void clearLine()
    {
        this.waitForElementAndClear(By.id(TYPE_CLEAR_LINE), "Cannot clear this line", 5);
    }

    public void typeSearchLine(String search_line)
    {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into search input", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result " + substring, 5);
    }

    public void clickByArticleWithSubstring(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result " + substring, 5);
    }

    public int getAmountFoundArticles()
    {
        this.waitForElementPresent
                (
                        By.xpath(SEARCH_RESULT_ELEMENT),
                        "Cannot find anything by the request",
                        15
                );
        return this.getAmountOfElements(By.xpath(SEARCH_RESULT_ELEMENT));
    }

    public void waitForEmptyResultsLabel()
    {
        this.waitForElementPresent(By.xpath(SEARCH_EMPTY_RESULT), "Cannot find empty result element. ", 10);
    }

    public void assertThereIsNoResultOfSearch()
    {
        this.assertElementNotPresent(By.id(SEARCH_ASSERT_RESULT), "We supposed not to find any results");
    }
}
