package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private By cartItem = By.className("cart_item");
    private By checkoutBtn = By.id("checkout");

    public boolean isProductDisplayed() {
        return driver.findElements(cartItem).size() > 0;
    }

    public void clickCheckout() {
        click(checkoutBtn);
    }
}
