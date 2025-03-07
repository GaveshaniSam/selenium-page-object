package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputFirstName(String firstname) {
        driver.findElement(By.id("first-name")).sendKeys(firstname);
    }

    public void inputLastName(String lastname) {
        driver.findElement(By.id("last-name")).sendKeys(lastname);
    }

    public void inputZipCode(String zipcode) {
        driver.findElement(By.id("postal-code")).sendKeys(zipcode);
    }

    public void clickOnContinue() {
        driver.findElement(By.xpath("//input[@class='btn_primary cart_button']")).click();
    }
}
