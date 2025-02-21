package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage {
    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getProductList() {
        return driver.findElements(By.xpath("//div[@class='inventory_item_name']"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath("//div[@class='inventory_item_name']" +
                "[text()='" + productName + "']/following::div[@class='inventory_item_price'][1]")).getText();
    }

    public void addProductToCart(String productName) {
        driver.findElement(By.xpath("//div[@class='inventory_item_name']" +
                "[text()='" + productName + "']/following::button[@class='btn_primary btn_inventory'][1]")).click();
    }
}

