package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

public class LaptopsAndNotebooksTest extends Utilities {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        // Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

        // Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        // Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.
        verifyText(By.xpath("//option[contains(text(),'Price (High > Low)')]"), "Price (High > Low)");
    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException{

        Thread.sleep(1000);

        //Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));

        //Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        //Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        //Select Product “MacBook”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[2]/div[1]/h4[1]/a[1]"));

        //Verify the text “MacBook”
        verifyText(By.xpath("//h1[contains(text(),'MacBook')]"),"MacBook");

        //Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));


        //Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedText ="Success: You have added MacBook to your shopping cart!\n"+"×";
        String actualText = getTextFromElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible"));
        Assert.assertEquals("Invalid text",expectedText,actualText);

        //Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        //2.9 Verify the text "Shopping Cart"
        verifyText(By.xpath("//h1[contains(text(),'(0.00kg)')]"),"Shopping Cart  (0.00kg)");

        //Verify the Product name "MacBook"
        verifyText(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),"MacBook");

        //Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");

        //Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));

        //Verify the message “Success: You have modified your shopping cart!”
        String expectedshopText ="Success: You have added MacBook to your shopping cart!\n"+"×";
        String actualshopText = getTextFromElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"));
        Assert.assertEquals("Invalid text",expectedText,actualText);

        //Verify the Total £737.45
        verifyText(By.xpath("//tbody/tr[1]/td[6]"),"$1,204.00");

        //Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

        //Verify the text “Checkout”
        verifyText(By.xpath("//h1[contains(text(),'Checkout')]"),"Checkout");

        //Verify the Text “New Customer”
        Thread.sleep(2000);
        verifyText(By.xpath("//div/h2[contains(text(),'New Customer')]"),"New Customer");

        //Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//div[1]/div[2]/label[1]/input[1]"));

        //Click on “Continue” tab
        clickOnElement(By.id("button-account"));

        //Fill the mandatory fields
        Thread.sleep(5000);
        sendTextToElement(By.id("input-payment-firstname"),"Shawnyl");
        sendTextToElement(By.id("input-payment-lastname"),"Glenn");
        sendTextToElement(By.id("input-payment-email"),"shawnyyl@example.com");
        sendTextToElement(By.id("input-payment-telephone"),"9875290212");
        sendTextToElement(By.id("input-payment-address-1"),"12 Proctoer Close");
        sendTextToElement(By.id("input-payment-city"),"Coventry");
        sendTextToElement(By.id("input-payment-postcode"),"111115");
        selectByValueFromDropDown(By.id("input-payment-country"),"222");
        selectByValueFromDropDown(By.id("input-payment-zone"),"3523");

        //Click on “Continue” Button
        clickOnElement(By.id("button-guest"));

        // Add Comments About your order into text area
        sendTextToElement(By.xpath("//div[1]/p[2]/textarea[1]"),"Not available");

        //Check the Terms & Conditions check box
        Thread.sleep(2000);
        clickOnElement(By.name("agree"));

        //Click on “Continue” button
        clickOnElement(By.id("button-payment-method"));

        //Verify the message “Warning: Payment method required!”
        String expectedWarningText = "Warning: Payment method required!\n" + "×";
        String actualWarningText = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible'][text()='Warning: Payment method required!']"));
        Assert.assertEquals("Warning message is not matched",expectedWarningText,actualWarningText);
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
