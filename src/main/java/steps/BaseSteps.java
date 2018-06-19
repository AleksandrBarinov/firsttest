package steps;

import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import util.TestProperties;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseSteps {

    public static WebDriver driver;
    private String baseUrl;
    public static Properties properties = TestProperties.getInstance().getProperties();

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
        baseUrl = properties.getProperty("app.url");
        driver.manage().timeouts().implicitlyWait(28, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public static void afterTest() {
        driver.quit();
    }

    @Attachment(type = "image/png")
    public static byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}

