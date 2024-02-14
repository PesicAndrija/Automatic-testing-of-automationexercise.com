package Tests;

import Base.BaseTest;
import Pages.AccountCreatedPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignupPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserRegistrationTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://automationexercise.com/");

        homePage = new HomePage();
        loginPage = new LoginPage();
        signupPage = new SignupPage();

        wait.until(ExpectedConditions.visibilityOf(homePage.slider));
        Assert.assertTrue(homePage.slider.isDisplayed());

        accountCreatedPage = new AccountCreatedPage();
    }

    @Test(priority = 10)
    public void user_can_register_with_valid_inputs(){

        homePage.clickOnSignupLoginLink();
        Assert.assertTrue(loginPage.signupFormTitle.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.url);
        Assert.assertTrue(loginPage.signupButton.isDisplayed());

        loginPage.inputSignupName("Petar");
        loginPage.inputSignupEmail("pera12345@gmail.com");
        loginPage.clickOnSignupButton();
        Assert.assertTrue(signupPage.enterAccInfoTitle.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), signupPage.url);
        Assert.assertTrue(signupPage.createAccountButton.isDisplayed());

        signupPage.clickOnMrRadioButton();
        signupPage.clickOnMrsRadioButton();
        signupPage.inputPassword("Lozinka123$");
        signupPage.chooseRandomDOBDay();
        signupPage.chooseRandomDOBMonth();
        signupPage.chooseRandomDOBYear();
        signupPage.clickOnNewsletterCheckbox();
        signupPage.clickOnOptinCheckbox();
        signupPage.inputFirstName("Petar");
        signupPage.inputLastName("Petrović");
        signupPage.inputCompany("ITG");
        signupPage.inputAddress1("Mije Kovačevića 7b");
        signupPage.inputAddress2("5th floor");
        signupPage.chooseRandomCountry();
        signupPage.inputState("Palilula");
        signupPage.inputCity("Belgrade");
        signupPage.inputZipcode("11000");
        signupPage.inputMobileNumber("+38169420666");
        signupPage.clickOnCreateAccountButton();
        Assert.assertTrue(accountCreatedPage.accountCreatedTitle.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), accountCreatedPage.url);
        Assert.assertTrue(accountCreatedPage.continueButton.isDisplayed());

    }

    @Test(priority = 20)
    public void user_cannot_register_with_existing_email(){

        homePage.clickOnSignupLoginLink();
        Assert.assertTrue(loginPage.signupFormTitle.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.url);
        Assert.assertTrue(loginPage.signupButton.isDisplayed());

        loginPage.inputSignupName("Petar");
        loginPage.inputSignupEmail("pera12345@gmail.com");
        loginPage.clickOnSignupButton();
        Assert.assertTrue(loginPage.signupError.isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
