package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    static String baseurl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    // create class with name - userShouldLoginSuccessfullyWithValidCredentials
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “Admin” username
        driver.findElement(By.name("username")).sendKeys("Admin");

        //Enter “admin123 password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[contains(@type, 'submit')]")).click();

        //Verify the ‘Dashboard’ text is display
        String expectedText = "Dashboard";
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[starts-with(@class, 'oxd')]"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals(actualText, expectedText);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}


