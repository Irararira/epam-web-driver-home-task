import com.epam.LvLoginPage;
import com.epam.LvSendMailPage;
import com.epam.YahooCheckMailPage;
import com.epam.YahooLoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static com.epam.Constants.*;
import static com.epam.Constants.MAIL_ACCOUNT;
import static org.junit.Assert.assertEquals;

public class SendMessageTest {

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
    public void sendMessage() {

        LvLoginPage lvLoginPage = new LvLoginPage(driver);
        lvLoginPage.open()
                .sendKeysById(LV_LOGIN, LV_INPUT_LOGIN)
                .sendKeysById(LV_PASSWORD, LV_INPUT_PASSWORD)
                .clickById(LV_ENTER);

        // send mail
        LvSendMailPage lvSendMailPage = new LvSendMailPage(driver);
        lvSendMailPage.waitByXpath(WRITE_MESSAGE_XPATH)
                .clickByXpath(WRITE_MESSAGE_XPATH)
                .waitById(OPEN_FORM_MESSAGE)
                .sendKeysById(OPEN_FORM_MESSAGE,CONTACT)
                .sendKeysById(SUBJECT, TITLE_VALUE)
                .switchToMessageFrame()
                .sendKeysByXpath(BODY_XPATH, TITLE_MESSAGE)
                .switchToDefaultFrame()
                .clickByClassName(SEND_MESSAGE)
                .waitByClassName(HEAD_TITLE)
                .clickById(SIDE_MENU)
                .waitByClassName(LV_EXIT)
                .clickByClassName(LV_EXIT);

        // enter Yahoo mailbox
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

        // check email
        YahooCheckMailPage yahooCheckMailPage = new YahooCheckMailPage(driver);
        yahooCheckMailPage.clickByXpath(OPEN_EMAIL)
                .waitByXpath(MESSAGE_CONTAINER);

        String title = yahooCheckMailPage.getTextByXpath(MESSAGE_CONTAINER);
        assertEquals(TITLE_VALUE, title);
        String textMessage = yahooCheckMailPage.getTextByXpath(MESSAGE_BODY_XPATH);
        assertEquals(TITLE_MESSAGE, textMessage);

        yahooCheckMailPage.clickByXpath(DELETE_XPATH);

    }
}
