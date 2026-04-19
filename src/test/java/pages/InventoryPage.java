package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    private By addToCartBtn = By.cssSelector(".inventory_item button");
    private By cartIcon = By.className("shopping_cart_link");

    public void addFirstProductToCart() {
        click(addToCartBtn);
    }

    public void goToCart() {
        click(cartIcon);
    }
}