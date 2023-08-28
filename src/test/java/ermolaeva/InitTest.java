package ermolaeva;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;

public abstract class InitTest {
    public void setUp(){
        //WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserVersion = "116.0.5845.111";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false ;
        Configuration.holdBrowserOpen = true;
    }

    @Before
    public void init(){
        setUp();
    }

    @AfterAll
    public static void tearDown(){
        Selenide.closeWebDriver();
    }
}
