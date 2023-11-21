package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Enter “standard_user” username
        driver.findElement(By.name("user-name")).sendKeys("standard_user");

        //Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        driver.findElement(By.name("login-button")).click();

        //Verify the text “Products”
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter “standard_user” username
        WebElement userNameField = driver.findElement(By.name("user-name"));
        userNameField.sendKeys("standard_user");

        //Enter “secret_sauce” password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        WebElement logInButton = driver.findElement(By.name("login-button"));
        logInButton.click();

        //Verify that six products are displayed on page
        List<WebElement> productsElement = driver.findElements(By.className("inventory_item"));
        System.out.println("There are " + productsElement.size() + " products are displayed on page");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
