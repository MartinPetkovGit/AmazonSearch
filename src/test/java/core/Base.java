package core;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import utils.Urls;

import static com.codeborne.selenide.Selenide.open;

public class Base {

    /**
     * This method will open the browser in full screen mode and will then navigate to the preselected url before each test
     */
    @BeforeMethod
    public void setUp(){
        Configuration.startMaximized = true;

        open(Urls.amazonUK);
    }
}
