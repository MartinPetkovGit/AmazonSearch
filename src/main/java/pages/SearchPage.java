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


    /**
     * This method used first verifies that the current URL matches the one initially provided in the Base class and then uses JS to verify that the ready state of the page is completed.
     * After both assertions pass successfully the method will check that a web element is enabled on the page.
     */
    public static void verifyPageIsCorrectAndOpen() {


        JavascriptExecutor js = (JavascriptExecutor) WebDriverRunner.getWebDriver();
        Boolean state = js.executeScript("return document.readyState").equals("complete");

        Assert.assertEquals(WebDriverRunner.url(), Urls.amazonUK);
        Assert.assertTrue(state);
        category.should(enabled);
    }

    /**
     * This method will select a product category to search by.
     * @param section the search category that will be selected.
     */
    public static void selectSearchSection(String section) {
        category.selectOption(section);
    }


    /**
     * This method will execute a search for a string provided as a param
     * @param bookTitle search string
     */
    public static void searchFor(String bookTitle) {
        searchBox.sendKeys(bookTitle);
        searchBox.pressEnter();
    }
}
