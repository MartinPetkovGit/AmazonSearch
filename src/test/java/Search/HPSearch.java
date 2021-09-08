package Search;

import core.Base;
import org.testng.annotations.Test;
import pages.ResultsPage;
import pages.SearchPage;
import utils.BookTitles;

public class HPSearch extends Base {

    @Test
    public void verifyTitleBadgeTypeAndPriceOfFirstResult(){

        SearchPage.verifyPageIsCorrectAndOpen();
        SearchPage.selectSearchSection("Books");
        SearchPage.searchFor(BookTitles.HarryPotter8);
        ResultsPage.verifyFirstItemsTitle(BookTitles.HarryPotter8);


    }
}
