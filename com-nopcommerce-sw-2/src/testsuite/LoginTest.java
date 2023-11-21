package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //click on the ‘Login’ link
        WebElement logInLink = driver.findElement(By.xpath("//a[text()='Log in']"));
        logInLink.click();

        //Verify the text ‘Welcome, Please Sign In!’
        String exceptedText = "Welcome, Please Sign In!";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(exceptedText, actualText);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //click on the ‘Login’ link
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        //Enter valid username
        driver.findElement(By.id("Email")).sendKeys("ankptl12@gmail.com");

        //Enter valid password
        driver.findElement(By.name("Password")).sendKeys("ankptl12");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        //Verify the ‘Log out’ text is display
        String exceptedText = "Log out";
        String actualText = driver.findElement(By.xpath("//a[contains(@href, '/logout')]")).getText();
        Assert.assertEquals(actualText, exceptedText);
    }

    @Test
    public void verifyTheErrorMessage() {
        //click on the ‘Login’ link
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        //Enter invalid username
        WebElement userNameField = driver.findElement(By.id("Email"));
        userNameField.sendKeys("abcd1234@gmail.com");

        //Enter invalid password
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("ankptl12");

        //Click on ‘LOGIN’ button
        WebElement logInButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        logInButton.click();

        //Verify the error message ‘Login was unsuccessful. Please correct the errors and try again. No customer account found’
        String exceptedText = "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[starts-with(@class, 'mes')]"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(exceptedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
