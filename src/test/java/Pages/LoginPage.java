package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public String url = "https://automationexercise.com/login";

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    public WebElement signupFormTitle;

    @FindBy(css = "input[data-qa='signup-name']")
    public WebElement signupNameField;

    @FindBy(css = "input[data-qa='signup-email']")
    public WebElement signupEmailField;

    @FindBy(css = "button[data-qa='signup-button']")
    public WebElement signupButton;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    public WebElement loginFormTitle;

    @FindBy(css = "input[data-qa='login-email']")
    public WebElement loginEmailField;

    @FindBy(css = "input[data-qa='login-password']")
    public WebElement loginPasswordField;

    @FindBy(css = "button[data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    public WebElement loginError;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    public WebElement signupError;

    //----------------------------------------------------------------------------

    public void inputSignupName(String s){
        signupNameField.clear();
        signupNameField.sendKeys(s);
    }

    public void inputSignupEmail(String s){
        signupEmailField.clear();
        signupEmailField.sendKeys(s);
    }

    public void clickOnSignupButton(){
        signupButton.click();
    }

    public void inputLoginEmail(String s){
        loginEmailField.clear();
        loginEmailField.sendKeys(s);
    }

    public void inputLoginPassword(String s){
        loginPasswordField.clear();
        loginPasswordField.sendKeys(s);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }
}
