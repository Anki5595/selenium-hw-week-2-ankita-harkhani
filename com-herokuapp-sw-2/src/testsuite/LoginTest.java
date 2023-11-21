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
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter “tomsmith” username
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith");

        // Enter “SuperSecretPassword!” password
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        WebElement logInButton = driver.findElement(By.xpath("//button[@class = 'radius' and @type = 'submit']"));
        logInButton.click();

        //Verify the text “Secure Area”
        String expectedText = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[text() = ' Secure Area']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        // Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");

        // Enter “SuperSecretPassword!” password
       WebElement passwordField = driver.findElement(By.name("password"));
       passwordField.sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class = 'radius' and @type = 'submit']")).click();

        //Verify the error message “Your username is invalid!”
        String expectedErrorMessage = "Your username is invalid!\n×";
        WebElement actualErrorMessageElement = driver.findElement(By.xpath("//div[contains(text(), 'Your username is invalid!')]"));
        String actualErrorMessage = actualErrorMessageElement.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage(){
        // Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        // Enter “SuperSecretPassword” password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[@class = 'radius' and @type = 'submit']")).click();

        //Verify the error message “Your username is invalid!”
        String expectedErrorMessage = "Your password is invalid!\n×";
        WebElement actualErrorMessageElement = driver.findElement(By.id("flash"));
        String actualErrorMessage = actualErrorMessageElement.getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}
