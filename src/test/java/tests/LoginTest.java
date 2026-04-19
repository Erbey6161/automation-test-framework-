package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverFactory;

public class LoginTest extends BaseTest {

    @Test
    public void openGoogle() {

        DriverFactory.getDriver().get("https://www.google.com");

        String title = DriverFactory.getDriver().getTitle();

        Assert.assertTrue(title.contains("Google"));
    }
}