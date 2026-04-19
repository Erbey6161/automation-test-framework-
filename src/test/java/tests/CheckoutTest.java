package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.CartPage;
import pages.CheckoutPage;
import utils.DriverFactory;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutFlow() {

        DriverFactory.getDriver().get("https://www.saucedemo.com/");

        // login
        DriverFactory.getDriver().findElement(org.openqa.selenium.By.id("user-name")).sendKeys("standard_user");
        DriverFactory.getDriver().findElement(org.openqa.selenium.By.id("password")).sendKeys("secret_sauce");
        DriverFactory.getDriver().findElement(org.openqa.selenium.By.id("login-button")).click();

        // inventory
        InventoryPage inventoryPage = new InventoryPage(DriverFactory.getDriver());
        inventoryPage.addFirstProductToCart();
        inventoryPage.goToCart();

        // cart
        CartPage cartPage = new CartPage(DriverFactory.getDriver());
        cartPage.clickCheckout();

        // checkout
        CheckoutPage checkoutPage = new CheckoutPage(DriverFactory.getDriver());
        checkoutPage.fillInformation();
        checkoutPage.continueToOverview();
        checkoutPage.finishOrder();

        // assert
        Assert.assertTrue(
                checkoutPage.getSuccessMessage().contains("Thank you"),
                "Checkout failed!"
        );
    }
}