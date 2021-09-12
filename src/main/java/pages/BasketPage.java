package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    private static SelenideElement itemPriceInBasket = $(By.xpath("//div[@data-item-count='1']//p//span[contains(text, '')]"));
    private static SelenideElement basketButton = $(By.xpath("//a[@id='nav-cart']"));

    protected static void checkIfPricesMatch(String productPagePrice){
        basketButton.click();
        itemPriceInBasket.shouldHave(Condition.exactText(productPagePrice));

    }
}
