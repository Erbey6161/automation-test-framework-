package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");
    private By successMsg = By.className("complete-header");

    public void fillInformation() {
        type(firstName, "Eren");
        type(lastName, "Bodur");
        type(postalCode, "64000");
    }

    public void continueToOverview() {
        click(continueBtn);
    }

    public void finishOrder() {
        click(finishBtn);
    }

    public String getSuccessMessage() {
        return getText(successMsg);
    }
}