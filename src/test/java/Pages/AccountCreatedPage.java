package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage extends BaseTest {

    public AccountCreatedPage(){
        PageFactory.initElements(driver, this);
    }

    public String url = "https://automationexercise.com/account_created";

    @FindBy(xpath = "//b[text()='Account Created!']")
    public WebElement accountCreatedTitle;

    @FindBy(linkText = "Continue")
    public WebElement continueButton;

    //-------------------------------------------------------------------------

    public void clickOnContinueButton(){
        continueButton.click();
    }
}
