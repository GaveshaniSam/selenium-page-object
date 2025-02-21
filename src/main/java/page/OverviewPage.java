package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
    private final WebDriver driver;

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductNameByPositionInOverviewPage(int position) {
        return driver.findElement(By.xpath(getProductLocatorByPosition(position) +
                "//a//div[@class='inventory_item_name']")).getText();
    }

    public String getProductPriceByPositionInOverviewPage(int position) {
        return driver.findElement(By.xpath(getProductLocatorByPosition(position) +
                "//div[@class='inventory_item_price']")).getText();
    }

    private String getProductLocatorByPosition(int position) {
        return "(//div[@class='cart_item_label'])[" + position + "]";
    }

    public String getTax() {
        return driver.findElement(By.className("summary_tax_label")).getText();
    }

    public String getTotalPrice() {
        return driver.findElement(By.className("summary_total_label")).getText();
    }
}