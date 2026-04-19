package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.CartPage;
import utils.DriverFactory;

public class AddToCartTest extends BaseTest {

    @Test
    public void verifyProductCanBeAddedToCart() {

        // 🌐 Site aç
        DriverFactory.getDriver().get("https://www.saucedemo.com/");

        // 🔐 Login
        DriverFactory.getDriver().findElement(org.openqa.selenium.By.id("user-name"))
                .sendKeys("standard_user");

        DriverFactory.getDriver().findElement(org.openqa.selenium.By.id("password"))
                .sendKeys("secret_sauce");

        DriverFactory.getDriver().findElement(org.openqa.selenium.By.id("login-button"))
                .click();

        // 📦 Inventory Page
        InventoryPage inventoryPage = new InventoryPage(DriverFactory.getDriver());

        inventoryPage.addFirstProductToCart();
        inventoryPage.goToCart();

        // 🛒 Cart Page
        CartPage cartPage = new CartPage(DriverFactory.getDriver());

        // ✅ Assertion
        Assert.assertTrue(
                cartPage.isProductDisplayed(),
                "Product was NOT added to cart!"
        );
    }
}