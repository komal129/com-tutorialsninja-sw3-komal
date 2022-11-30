package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

import java.util.Random;

public class MyAccountsTest extends Utilities {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";
    String email = "jhones" + new Random().nextInt(100000) + "@example.com";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }


    public void selectMyAccountOptions(String menu){
        String exp = String.format("//a[text()='%s']", menu) ;
        driver.findElement(By.xpath(exp)).click();
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){

        //Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //Call the method “selectMyAccountOptions”
        selectMyAccountOptions("Register");

        //Verify the text “Register Account”
        verifyText(By.xpath("//h1[text()='Register Account']"), "Register Account");
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){

        //Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //Call the method “selectMyAccountOptions”
        selectMyAccountOptions("Login");

        //Verify the text “Register Account”
        verifyText(By.xpath("//h2[text()='Returning Customer']"), "Returning Customer");
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){

        //Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //Call the method “selectMyAccountOptions”
        selectMyAccountOptions("Register");

        //Enter First Name
        sendTextToElement(By.id("input-firstname"), "Joel");
        sendTextToElement(By.id("input-lastname"),"Jhones");
        sendTextToElement(By.id("input-email"), email);
        sendTextToElement(By.id("input-telephone"), "9876543213");
        sendTextToElement(By.id("input-password"), "joel12345");
        sendTextToElement(By.id("input-confirm"), "joel12345");
        clickOnElement(By.name("newsletter"));
        clickOnElement(By.name("agree"));
        clickOnElement(By.xpath("//input[@type='submit']"));
        verifyText(By.xpath("//h1[text()='Your Account Has Been Created!']"), "Your Account Has Been Created!");
        clickOnElement(By.xpath("//div[@class='pull-right']/a[text()='Continue']"));
        //Click on My Account Link
        clickOnElement(By.xpath("//span[text()='My Account']"));
        selectMyAccountOptions("Logout");
        //Verify the text “Register Account”
        verifyText(By.xpath("//h1[text()='Account Logout']"), "Account Logout");
        clickOnElement(By.xpath("//div[@class='pull-right']/a[text()='Continue']"));

    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){

        //Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //Call the method “selectMyAccountOptions” method and pass the parameter Login”
        selectMyAccountOptions("Login");

        //Enter Email address
        sendTextToElement(By.id("input-email"),email);

        //Enter Password
        sendTextToElement(By.id("input-password"),"joel12345");

        //Click on Login button
        clickOnElement(By.xpath("//input[@class='btn btn-primary']"));

        //Verify text “My Account”
        verifyText(By.xpath("//h2[text()='My Account']"),"My Account");

        //Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");

        //Verify the text “Account Logout”
        verifyText(By.xpath("//h1[text()='Account Logout']"),"Account Logout");

        //Click on Continue button
        clickOnElement(By.xpath("//div[@class='pull-right']/a[text()='Continue']"));
    }


    @After
    public void teardown(){
       closeBrowser();
    }

}
