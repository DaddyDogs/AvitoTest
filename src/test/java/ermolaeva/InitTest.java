package ermolaeva;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class InitTest {
    protected Logger logger = LoggerFactory.getLogger(InitTest.class);
    public static void setUp(){
        Configuration.browser = "chrome";
        Configuration.browserVersion = "116.0.5845.111";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--lang=RU");
    }

    @BeforeAll
    public static void init(){
        setUp();
    }

    @AfterAll
    public static void tearDown(){
        Selenide.webdriver().driver().close();
    }
}
