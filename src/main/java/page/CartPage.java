package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnCartButton() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    public String getProductNameByPosition(int position) {
        return driver.findElement(By.xpath(getProductLocatorByPosition(position) +
                "//a//div[@class='inventory_item_name']")).getText();
    }

    public String getProductPriceByPosition(int position) {
        return driver.findElement(By.xpath(getProductLocatorByPosition(position) +
                "//div//div[@class='inventory_item_price']")).getText();
    }

    private String getProductLocatorByPosition(int position) {
        return "(//div[@class='cart_item_label'])[" + position + "]";
    }

    public void removeProductFromCart(String productName) {
        driver.findElement(By.xpath("//div[@class='inventory_item_name']" +
                "[text()='" + productName + "']/following::button[@class='btn_secondary cart_button'][1]")).click();
    }

    public void clickCheckout() {
        driver.findElement(By.xpath("//a[@class='btn_action checkout_button']")).click();
    }
}
