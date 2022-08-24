import com.epam.GooglePicturePage;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.epam.Constants.*;
import static org.junit.Assert.*;

public class SearchPictureTest {

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
    public void searchPicture() {

        GooglePicturePage googlePicturePage = new GooglePicturePage(driver);
        googlePicturePage.open()
                .acceptToClick(ACCEPT_EVERYTHING)
                .waitElementVisibleByLinkText(TEXT_ON_PAGE)
                .clickByXpath(BUTTON_PICTURES)
                .acceptToClick(ACCEPT_EVERYTHING)
                .waitElementVisibleByXpath(SEARCH)
                .inputDataByXpath(SEARCH, WORD_INPUT)
                .clickByXpath(SEARCH);

        List<WebElement> imagesByTagName = googlePicturePage.getElementsByTagName(IMG);

        assertNotNull(imagesByTagName);
        assertTrue(imagesByTagName.size() > 1);


    }

}
