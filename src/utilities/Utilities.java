package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utilities extends BaseTest {

    public void clickOnElement(By by){

        WebElement loginLink = driver.findElement(by);
        loginLink.click();
    }

    public void sendTextToElement(By by, String text){

        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by){
        WebElement actualTextMessageElement = driver.findElement(by);
        return actualTextMessageElement.getText();
    }

    // Verify text from Element
    public void verifyText(By by, String text){
        String expectedText = text;
        String actualText = getTextFromElement(by);
        Assert.assertEquals(expectedText,actualText);

    }

    //***************************** Alert Methods *************************************

    public void switchToAlert(){
        driver.switchTo().alert();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromAlert(){
        String s = driver.switchTo().alert().getText();
        return s;
    }

    public void sendTextToAlert(String text){
        driver.switchTo().alert().sendKeys("text");
    }

    //*********************** Action Methods ******************************

    public void mouseHoverToElement(By by){
        Actions actions = new Actions(driver);
        WebElement menuOption = driver.findElement(by);
        actions.moveToElement(menuOption).perform();
    }

    // mouseHoverToElementAndClick(By by)
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseClick = driver.findElement(by);
        actions.moveToElement(mouseClick).click().build().perform();
    }

    /**
     *  This method will select option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);

        Select select = new Select(dropDown);
        // Select by value
        select.selectByVisibleText(text);
    }

    /**
     * This method will select the option by value
     */

    public void selectByValueFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    /**
     * This method will select the option by index
     */

    public void selectByIndexFromDropDown(By by, int index){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    /**
     * This method will select the option by contains text
     */

    public void selectByContainsTextFromDropDown(By by, int index){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);

    }

    //*********** Select date
    public void selectDate(String year, String month, String date) {


        clickOnElement(By.xpath("//button[@class='btn btn-default']/i[@class='fa fa-calendar']")); // Opens the date picker
        while (true) {
            String monthYear = driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr/th[@class='picker-switch']")).getText(); // Nov 2022
            String arr[] = monthYear.split(" ");

            String mon = arr[0];
            String yer = arr[1];

            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-days']/table[@class='table-condensed']/thead/tr/th[@class='next']"));
            }
        }

        // select date
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='table-condensed']/tbody//tr//td"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }

    }

}
