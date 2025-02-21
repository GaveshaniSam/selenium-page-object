import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LoginPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void before() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");
    }

    @Test
    public void testInvalidLogin() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce1");
        loginPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/");
    }

    @Test
    public void validateProductDetails() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();

    }
}
