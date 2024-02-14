package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupPage extends BaseTest {

    public SignupPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    public WebElement enterAccInfoTitle;

    @FindBy(id = "uniform-id_gender1")
    public WebElement mrRadioButton;

    @FindBy(id = "uniform-id_gender2")
    public WebElement mrsRadioButton;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "days")
    public WebElement dobDays;

    @FindBy(id = "months")
    public WebElement dobMonths;

    @FindBy(id = "years")
    public WebElement dobYears;

    @FindBy(id = "newsletter")
    public WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    public WebElement optinCheckbox;

    @FindBy(id = "first_name")
    public WebElement firstNameField;

    @FindBy(id = "last_name")
    public WebElement lastNameField;

    @FindBy(id = "company")
    public WebElement companyField;

    @FindBy(id = "address1")
    public WebElement address1Field;

    @FindBy(id = "address2")
    public WebElement address2Field;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "state")
    public WebElement stateField;

    @FindBy(id = "city")
    public WebElement cityField;

    @FindBy(id = "zipcode")
    public WebElement zipcodeField;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumberField;

    @FindBy(css = "button[data-qa='create-account']")
    public WebElement createAccountButton;

    //---------------------------------------------------------------------------

    public void clickOnMrRadioButton(){
        scrollElementIntoView(mrRadioButton);
        mrRadioButton.click();
    }

    public String url = "https://automationexercise.com/signup";

    public void clickOnMrsRadioButton(){
        scrollElementIntoView(mrsRadioButton);
        mrsRadioButton.click();
    }

    public void inputPassword(String s){
        scrollElementIntoView(passwordField);
        passwordField.clear();
        passwordField.sendKeys(s);
    }

    public void chooseRandomDOBDay(){
        scrollElementIntoView(dobDays);
        Select select = new Select(dobDays);
        select.selectByIndex(random.nextInt(select.getOptions().size())+1);
    }

    public void chooseRandomDOBMonth(){
        scrollElementIntoView(dobMonths);
        Select select = new Select(dobMonths);
        select.selectByIndex(random.nextInt(select.getOptions().size())+1);
    }

    public void chooseRandomDOBYear(){
        scrollElementIntoView(dobYears);
        Select select = new Select(dobYears);
        select.selectByIndex(random.nextInt(select.getOptions().size())+1);
    }

    public void clickOnNewsletterCheckbox(){
        scrollElementIntoView(newsletterCheckbox);
        newsletterCheckbox.click();
    }

    public void clickOnOptinCheckbox(){
        scrollElementIntoView(optinCheckbox);
        optinCheckbox.click();
    }

    public void inputFirstName(String s){
        scrollElementIntoView(firstNameField);
        firstNameField.clear();
        firstNameField.sendKeys(s);
    }

    public void inputLastName(String s){
        scrollElementIntoView(lastNameField);
        lastNameField.clear();
        lastNameField.sendKeys(s);
    }

    public void inputCompany(String s){
        scrollElementIntoView(companyField);
        companyField.clear();
        companyField.sendKeys(s);
    }

    public void inputAddress1(String s){
        scrollElementIntoView(address1Field);
        address1Field.clear();
        address1Field.sendKeys(s);
    }

    public void inputAddress2(String s){
        scrollElementIntoView(address2Field);
        address2Field.clear();
        address2Field.sendKeys(s);
    }

    public void chooseRandomCountry(){
        scrollElementIntoView(country);
        Select select = new Select(country);
        select.selectByIndex(random.nextInt(select.getOptions().size())+1);
    }

    public void inputState(String s){
        scrollElementIntoView(stateField);
        stateField.clear();
        stateField.sendKeys(s);
    }

    public void inputCity(String s){
        scrollElementIntoView(cityField);
        cityField.clear();
        cityField.sendKeys(s);
    }

    public void inputZipcode(String s){
        scrollElementIntoView(zipcodeField);
        zipcodeField.clear();
        zipcodeField.sendKeys(s);
    }

    public void inputMobileNumber(String s){
        scrollElementIntoView(mobileNumberField);
        mobileNumberField.clear();
        mobileNumberField.sendKeys(s);
    }

    public void clickOnCreateAccountButton(){
        scrollElementIntoView(createAccountButton);
        createAccountButton.click();
    }
}

