import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.DriverManager;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverManager.createDriver("chrome");
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/v1/"); // open login page
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
