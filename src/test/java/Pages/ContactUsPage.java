package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends BaseTest {

    public ContactUsPage(){
        PageFactory.initElements(driver, this);
    }

    public String url = "https://automationexercise.com/contact_us";

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    public WebElement getInTouchTitle;

    @FindBy(css = "input[data-qa='name']")
    public WebElement nameField;

    @FindBy(css = "input[data-qa='email']")
    public WebElement emailField;

    @FindBy(css = "input[data-qa='subject']")
    public WebElement subjectField;

    @FindBy(id = "message")
    public WebElement messageField;

    @FindBy(css = "input[data-qa='submit-button']")
    public WebElement submitButton;

    @FindBy(css = ".status.alert.alert-success")
    public WebElement successMessage;

    @FindBy(css = ".btn.btn-success")
    public WebElement homeButton;

    @FindBy(css = "input[name='upload_file']")
    public WebElement uploadFile;

    //----------------------------------------------------------

    public void inputName(String s){
        nameField.clear();
        nameField.sendKeys(s);
    }

    public void inputEmail(String s){
        emailField.clear();
        emailField.sendKeys(s);
    }

    public void inputSubject(String s){
        subjectField.clear();
        subjectField.sendKeys(s);
    }

    public void inputMessage(String s){
        messageField.clear();
        messageField.sendKeys(s);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

    public void uploadFile(String s){
        uploadFile.sendKeys(s);
    }
}
