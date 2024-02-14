package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.ProductsPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://automationexercise.com/");

        homePage = new HomePage();

        wait.until(ExpectedConditions.visibilityOf(homePage.slider));
        Assert.assertTrue(homePage.slider.isDisplayed());

        productsPage = new ProductsPage();
        productPage = new ProductPage();
        cartPage =new CartPage();
    }

    @Test(priority = 10)
    public void every_item_has_all_details(){

        homePage.clickOnProductsLink();
        Assert.assertTrue(productsPage.allProductsTitle.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), productsPage.url);

        for(int i=0; i<productsPage.viewProductLinks.size(); i++){
            productsPage.clickOnProductLink(productsPage.viewProductLinks.get(i));
            Assert.assertTrue(productPage.productName.isDisplayed());
            Assert.assertTrue(productPage.productCategory.isDisplayed());
            Assert.assertTrue(productPage.productPrice.isDisplayed());
            Assert.assertTrue(productPage.productAvailability.isDisplayed());
            Assert.assertTrue(productPage.productCondition.isDisplayed());
            Assert.assertTrue(productPage.productBrand.isDisplayed());
            driver.navigate().back();
        }
    }

    @Test(priority = 20)
    public void every_item_is_searchable_through_its_name(){

        homePage.clickOnProductsLink();
        Assert.assertTrue(productsPage.allProductsTitle.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), productsPage.url);

        for(int i=0; i<productsPage.productsNames.size(); i++){
            String searchTerm = productsPage.productsNames.get(i).getText();
            productsPage.inputSearchTerm(searchTerm);
            productsPage.clickOnSearchButton();
            Assert.assertTrue(productsPage.searchedProductsTitle.isDisplayed());
            Assert.assertEquals(productsPage.productsNames.size(), 1);
            Assert.assertEquals(productsPage.productsNames.getFirst().getText(), searchTerm);
            driver.navigate().back();
        }
    }

    @Test(priority = 30)
    public void items_are_added_to_cart(){

        homePage.clickOnProductsLink();
        Assert.assertTrue(productsPage.allProductsTitle.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), productsPage.url);

        int x = random.nextInt(34), y = random.nextInt(34);
        while(y==x)
            y = random.nextInt(34);

        String item1Name = productsPage.productsNames.get(x).getText();
        String item1Price = productsPage.productsPrices.get(x).getText();
        productsPage.clickOnAddToCartLink(productsPage.addToCartButtons.get(x));
        wait.until(ExpectedConditions.elementToBeClickable(productsPage.continueShoppingButton));
        productsPage.clickOnContinueShoppingButton();

        String item2Name = productsPage.productsNames.get(y).getText();
        String item2Price = productsPage.productsPrices.get(y).getText();
        productsPage.clickOnAddToCartLink(productsPage.addToCartButtons.get(y));
        wait.until(ExpectedConditions.elementToBeClickable(productsPage.continueShoppingButton));
        productsPage.clickOnContinueShoppingButton();

        homePage.clickOnCartLink();
        Assert.assertEquals(driver.getCurrentUrl(), cartPage.url);
        Assert.assertTrue(cartPage.breadcrumb.isDisplayed());

        Assert.assertEquals(cartPage.itemsNames.getFirst().getText(), item1Name);
        Assert.assertEquals(cartPage.itemsNames.getLast().getText(), item2Name);

        Assert.assertEquals(cartPage.itemsPrices.getFirst().getText(), item1Price);
        Assert.assertEquals(cartPage.itemsPrices.getLast().getText(), item2Price);

        Assert.assertEquals(cartPage.itemsTotalPrices.getFirst().getText(), item1Price);
        Assert.assertEquals(cartPage.itemsTotalPrices.getLast().getText(), item2Price);

    }

    @Test(priority = 40)
    public void correct_item_quantity_is_added_to_cart(){

        int x = random.nextInt(homePage.viewProductLinks.size());
        homePage.clickOnAddToCartLink(homePage.viewProductLinks.get(x));

        int y = random.nextInt(15)+1;
        productPage.inputQuantity(""+y);
        productPage.clickOnAddToCartButton();

        wait.until(ExpectedConditions.elementToBeClickable(productPage.viewCartLink));
        productPage.clickOnViewCart();

        Assert.assertEquals(cartPage.itemsQuantity.getLast().getText(), ""+y);
    }

    @Test(priority = 40)
    public void remove_product_from_cart(){

        int x = random.nextInt(34);
        String itemName = productsPage.productsNames.get(x).getText();
        String itemID = productsPage.addToCartButtons.get(x).getAttribute("data-product-id");
        productsPage.clickOnAddToCartLink(productsPage.addToCartButtons.get(x));
        wait.until(ExpectedConditions.elementToBeClickable(productPage.viewCartLink));
        productPage.clickOnViewCart();
        Assert.assertEquals(driver.getCurrentUrl(), cartPage.url);
        Assert.assertTrue(cartPage.breadcrumb.isDisplayed());
        Assert.assertEquals(cartPage.itemsNames.getLast().getText(), itemName);
        cartPage.clickOnRemoveButtonByID(itemID);
        Assert.assertNotSame(cartPage.itemsNames.getLast().getText(), itemName);

    }

    @Test(priority = 50)
    public void view_category_products() {

        int x = random.nextInt(homePage.itemCategories.size());
        String tempCategory = homePage.itemCategories.get(x).getText().trim();
        String category = tempCategory.substring(0, 1).toUpperCase() + tempCategory.substring(1).toLowerCase();
        homePage.clickOnCategoryByName(category);
        int y = random.nextInt(homePage.subcategoriesOfCategory(category).size());
        wait.until(ExpectedConditions.elementToBeClickable(homePage.subcategoriesOfCategory(category).get(y)));
        String tempSubcategory = homePage.subcategoriesOfCategory(category).get(y).getText().trim();
        String subcategory = tempSubcategory.substring(0, 1).toUpperCase() + tempSubcategory.substring(1).toLowerCase();
        homePage.clickOnSubcategoryByName(subcategory);
        Assert.assertEquals(homePage.categorySubcategoryBrandTitle.getText(), category.toUpperCase()+" - "+subcategory.toUpperCase()+" PRODUCTS");

    }

    @Test(priority = 60)
    public void view_brand_products() {

        homePage.clickOnProductsLink();
        Assert.assertTrue(productsPage.allProductsTitle.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), productsPage.url);
        Assert.assertFalse(homePage.itemBrands.isEmpty());
        Assert.assertTrue(homePage.itemBrands.get(0).isDisplayed());

        int x = random.nextInt(homePage.itemBrands.size());
        String tempBrand= homePage.itemBrands.get(x).getText().substring(4);
        System.out.println(tempBrand);
        String brand = tempBrand.substring(0, 1).toUpperCase() + tempBrand.substring(1).toLowerCase();
        System.out.println(brand);
        homePage.clickOnBrandByName(brand);

        Assert.assertEquals(homePage.categorySubcategoryBrandTitle.getText(), "BRAND - "+brand.toUpperCase()+" PRODUCTS");

    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
