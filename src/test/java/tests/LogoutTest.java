package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import utils.ConfigReader;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        // Page objectler
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        // Login
        loginPage.enterUsername(ConfigReader.get("username"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLogin();

        // Menü aç
        homePage.clickMenu();

        // Logout
        homePage.clickLogout();

        // Assertion → login sayfasına döndü mü?
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"),
                "Logout sonrası login sayfasına dönülmedi!");

        System.out.println("LOGOUT TEST PASSED");
    }
}
