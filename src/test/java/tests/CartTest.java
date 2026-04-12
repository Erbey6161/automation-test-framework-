package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.InventoryPage;

public class CartTest extends BaseTest {

    @Test
    public void addToCartTest() {

        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        // Login
        String username = "standard_user";
        loginPage.enterUsername(username);
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Ürün ekle ve sepete git
        inventoryPage.addProductToCart();
        inventoryPage.goToCart();

        // Kontrol
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart sayfasına gidilemedi");
    }
}


