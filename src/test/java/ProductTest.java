import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;

public class ProductTest extends BaseTest {
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OverviewPage overviewPage;

    @BeforeMethod
    public void before() {
        LoginPage loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @Test
    public void validateProductDetails() {
//page.ProductPage
        Assert.assertTrue(productPage.getProductList().contains("Sauce Labs Bike Light"));
        Assert.assertEquals(productPage.getProductPrice("Sauce Labs Bike Light"), "$9.99");
    }

    @Test
    public void validateCartDetails() {
//page.ProductPage
        productPage.addProductToCart("Sauce Labs Bike Light");
//page.CartPage
        cartPage.clickOnCartButton();
        Assert.assertEquals(cartPage.getProductNameByPosition(1), "Sauce Labs Bike Light");
        Assert.assertEquals(cartPage.getProductPriceByPosition(1), "9.99");
    }

    @Test
    public void testCheckoutProduct() {
        productPage.addProductToCart("Sauce Labs Bike Light");
        cartPage.clickOnCartButton();
//        cartPage.removeProductFromCart("Sauce Labs Bike Light");
        cartPage.clickCheckout();
//page.CheckoutPage
        checkoutPage.inputFirstName("Gaveshani");
        checkoutPage.inputLastName("Samarawickrama");
        checkoutPage.inputZipCode("51000");
        checkoutPage.clickOnContinue();
//page.OverviewPage
        Assert.assertEquals(overviewPage.getProductNameByPositionInOverviewPage(1), "Sauce Labs Bike Light");
        Assert.assertEquals(overviewPage.getProductPriceByPositionInOverviewPage(1), "$9.99");
        Assert.assertEquals(overviewPage.getTax(), "Tax: $0.80");
        Assert.assertEquals(overviewPage.getTotalPrice(), "Total: $10.79");
    }
}

