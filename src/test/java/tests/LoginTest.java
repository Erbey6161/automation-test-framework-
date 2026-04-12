package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.ConfigReader;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {

        loginPage.enterUsername(ConfigReader.get("username"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLogin();

        assert driver.getCurrentUrl().contains("inventory");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
