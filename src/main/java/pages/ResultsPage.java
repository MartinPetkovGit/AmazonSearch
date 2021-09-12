package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static org.apache.commons.lang.StringUtils.substringBeforeLast;

public class ResultsPage {

    private static SelenideElement searchResult = $(By.xpath("//div[@data-cel-widget='search_result_0']//h2//span[contains(text, '')]"));
    private static SelenideElement firstResultBadge = $(By.xpath("//div[@data-cel-widget='search_result_0']//span[@class='a-badge']"));
    private static SelenideElement defaultSelectedBookFormat = $(By.xpath("//span[contains(@class, 'button-selected')]/span/a/span[1]"));
    private static SelenideElement currentItemPrice = $(By.xpath("//span[@id='price']"));
    private static SelenideElement addToBasketButton = $(By.xpath("//input[@id='add-to-cart-button' and @value= 'Add to Basket']"));


    /**
     * This method will verify that a predefined string matches the title of the first result.
     * In order to match the result string to the search string the method will first change "&" to match the "and" in the search sting.
     * Once this is done a substring of the title of the result sting will be extracted
     * @param resultTitle string to verify against
     */
    public static void verifyFirstItemsTitle(String resultTitle) {

        String firstResultTitle = searchResult.getOwnText().replace("One and Two", "One & Two");

        firstResultTitle = substringBeforeLast(firstResultTitle, ":");

        Assert.assertEquals(firstResultTitle, resultTitle);
    }

    /**
     * Method verifies that element is displayed on page.
     */
    public static void verifyThatFirstResultHasABadge() {

        Assert.assertTrue(firstResultBadge.isDisplayed());
    }

    /**
     * This method will click on the first search result.
     */
    public static void openFirstResult() {
        searchResult.click();
    }

    /**
     * Method checks that the default selected format matches the string provided as a param.
     * @param bookFormat the expected default format.
     */
    public static void verifyThatCorrectFormatIsPreSelected(String bookFormat) {
        Assert.assertEquals(bookFormat, defaultSelectedBookFormat.getOwnText());
    }

    /**
     * This method will first get the price of the currently selected item, then add it to the basket.
     */
    public static void getCurrentPriceAndVerifyItMatchOnceInBasket() {
        String currentPrice = currentItemPrice.getOwnText();
        addToBasketButton.click();
        BasketPage.checkIfPricesMatch(currentPrice);

    }
}
