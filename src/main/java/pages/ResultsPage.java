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



    public static void verifyFirstItemsTitle(String resultTitle) {

        String firstResultTitle = searchResult.getOwnText().replace("One and Two", "One & Two");

        firstResultTitle = substringBeforeLast(firstResultTitle, ":");

        Assert.assertEquals(firstResultTitle, resultTitle);
    }

    public static void verifyThatFirstResultHasABadge() {

        Assert.assertTrue(firstResultBadge.isDisplayed());
    }

    public static void openFirstResult() {
        searchResult.click();
    }

    public static void verifyThatCorrectFormatIsPreSelected(String bookFormat) {
        Assert.assertEquals(bookFormat, defaultSelectedBookFormat.getOwnText());
    }

    public static void getCurrentPriceAndVerifyItMatchOnceInBasket() {
        String currentPrice = currentItemPrice.getOwnText();
        addToBasketButton.click();
        BasketPage.checkIfPricesMatch(currentPrice);

    }
}
