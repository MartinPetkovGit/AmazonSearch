package core;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import utils.Urls;

import static com.codeborne.selenide.Selenide.open;

public class Base {

    @BeforeMethod
    public void setUp(){
        Configuration.startMaximized = true;

        open(Urls.amazonUK);
    }
}
