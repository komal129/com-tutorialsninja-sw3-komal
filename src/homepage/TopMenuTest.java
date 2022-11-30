package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utilities;

public class TopMenuTest extends Utilities {

    String baseUrl = "http://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){
        String exp = String.format("//a[text()='%s']", menu) ;
        driver.findElement(By.xpath(exp)).click();
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){

        mouseHoverToElementAndClick(By.xpath("//div/ul/li/a[text()='Desktops']"));
        selectMenu("Show All Desktops");
        verifyText(By.xpath("//h2[text()='Desktops']"),"Desktops");

    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){

        //Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverToElement(By.xpath("//a[text()='Laptops & Notebooks']"));

        //call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show All Laptops & Notebooks");

        //Verify the text ‘Laptops & Notebooks’
        verifyText(By.xpath("//h2[text()='Laptops & Notebooks']"),"Laptops & Notebooks");

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){

        //Mouse hover on “Components” Tab and click
        mouseHoverToElement(By.xpath("//a[text()='Components']"));

        //call selectMenu method and pass the menu = “Show All Components”
        selectMenu("Show All Components");

        // Verify the text
        verifyText(By.xpath("//h2[text()='Components']"),"Components");
    }

    @After
    public void teardown(){
       closeBrowser();
    }
}
