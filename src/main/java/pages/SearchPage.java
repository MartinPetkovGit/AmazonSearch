package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import utils.Urls;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private static SelenideElement category = $(By.xpath("//select[@id='searchDropdownBox'] "));
    private static SelenideElement searchBox = $(By.xpath("//input[@id='twotabsearchtextbox']"));

    public static void verifyPageIsCorrectAndOpen() {


        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        Boolean state = js.executeScript("return document.readyState").equals("complete");

        Assert.assertEquals(WebDriverRunner.url(), Urls.amazonUK);
        Assert.assertTrue(state);
        category.should(enabled);
    }

    public static void selectSearchSection(String section) {
        category.selectOption(section);
    }

    public static void searchFor(String bookTitle) {
        searchBox.sendKeys(bookTitle);
        searchBox.pressEnter();
    }
}
