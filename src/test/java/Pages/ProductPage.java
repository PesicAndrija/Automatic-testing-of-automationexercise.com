package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseTest {

    public ProductPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.product-information > h2")
    public WebElement productName;

    @FindBy(xpath = "//p[contains(text(), 'Category:')]")
    public WebElement productCategory;

    @FindBy(xpath = "//span[contains(text(), 'Rs.')]")
    public WebElement productPrice;

    @FindBy(xpath = "//b[text()='Availability:']")
    public WebElement productAvailability;

    @FindBy(xpath = "//b[text()='Condition:']")
    public WebElement productCondition;

    @FindBy(xpath = "//b[text()='Brand:']")
    public WebElement productBrand;

    @FindBy(id = "quantity")
    public WebElement productQuantity;

    @FindBy(css = ".btn.btn-default.cart")
    public WebElement addToCartButton;

    @FindBy(linkText = "View Cart")
    public WebElement viewCartLink;

    //-----------------------------------------------------------------------------------

    public void inputQuantity(String s){
        productQuantity.clear();
        productQuantity.sendKeys(s);
    }

    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }

    public void clickOnViewCart(){
        viewCartLink.click();
    }

}
