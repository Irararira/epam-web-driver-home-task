import com.epam.YahooLoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static com.epam.Constants.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LoginTest {

    private WebDriver driver;
    private Map<String, Object> vars;
    private JavascriptExecutor js;

    @BeforeClass
    public static void setDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void verifyLoginPasswordCorrect() {
        YahooLoginPage yahooLoginPage = new YahooLoginPage(driver);
        yahooLoginPage.open()
                .checkHover()
                .clickByClassName(SING_IN)
                .waitElementVisibleById(LOGIN_USERNAME)
                .inputDataById(LOGIN_USERNAME, LOGIN)
                .clickById(NEXT)
                .waitElementVisibleById(LOGIN_PASSWORD)
                .inputDataById(LOGIN_PASSWORD, PASSWORD)
                .clickById(NEXT)
                .waitElementVisibleById(MAIL_ACCOUNT)
                .clickById(MAIL_ACCOUNT);

        assertNotNull(yahooLoginPage.getElementById(SEARCH_BOX));

        yahooLoginPage.moveToElement(ACCOUNT_MENU)
                .waitElementVisibleById(SING_OUT)
                .clickById(SING_OUT);
    }

    @Test
    public void verifyLoginPasswordIncorrectTest() {
        YahooLoginPage yahooLoginPage = new YahooLoginPage(driver);
        yahooLoginPage.open()
                .checkHover()
                .clickByClassName(SING_IN)
                .waitElementVisibleById(LOGIN_USERNAME)
                .inputDataById(LOGIN_USERNAME, LOGIN)
                .clickById(NEXT)
                .waitElementVisibleById(LOGIN_PASSWORD)
                .inputDataById(LOGIN_PASSWORD, WRONG_PASSWORD)
                .clickById(NEXT)
                .waitElementVisibleByClassName(ERROR_MESSAGE);

        WebElement errorMessage = yahooLoginPage.getElementByClassName(ERROR_MESSAGE);

        assertEquals("Invalid password. Please try again", errorMessage.getText());


    }

    @Test
    public void verifyEmptyLoginPasswordTest() {
        YahooLoginPage yahooLoginPage = new YahooLoginPage(driver);
        yahooLoginPage.open()
                .checkHover()
                .clickByClassName(SING_IN)
                .waitElementVisibleById(LOGIN_USERNAME)
                .inputDataById(LOGIN_USERNAME,"")
                .clickById(NEXT)
                .waitElementVisibleById(USERNAME_ERROR);

        WebElement errorMessage = yahooLoginPage.getElementById(USERNAME_ERROR);

        assertEquals("Sorry, we don't recognize this email.", errorMessage.getText());
    }
}
