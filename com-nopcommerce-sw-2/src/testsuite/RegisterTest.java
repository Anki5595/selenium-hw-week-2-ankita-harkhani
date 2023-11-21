package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.UUID;

public class RegisterTest extends BaseTest {
    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//a[contains(@class, 'ico-register')]")).click();

        //Verify the text ‘Register’
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//h1[text()='Register']")).getText();
        Assert.assertEquals("Text is displayed", actualText, expectedText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//a[contains(@class, 'ico-register')]")).click();

        //Select male gender radio button
        driver.findElement(By.id("gender-male")).click();

        //Select female gender radio button
        driver.findElement(By.id("gender-female")).click();

        //Enter First name
        driver.findElement(By.id("FirstName")).sendKeys("Pari");

        //Enter Last name
        driver.findElement(By.name("LastName")).sendKeys("Patel");

        //Select Day Month and Year
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("12"); //Enter day
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("August"); //Enter Month
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1995"); //Enter Year

        //Generate A random Email
        final String randomEmail = randomEmail();

        //Enter Email address
        driver.findElement(By.xpath("//input[contains(@id, 'Email')]")).sendKeys(randomEmail);


        //Enter Password
        driver.findElement(By.xpath("//input[starts-with(@id, 'Password')]")).sendKeys("12345678");

        //Enter Confirm password
        driver.findElement(By.xpath("//input[starts-with(@id, 'ConfirmPassword')]")).sendKeys("12345678");

        //Click on REGISTER button
        driver.findElement(By.xpath("//button[text()= 'Register']")).click();

        //Verify the text 'Your registration completed'
        String expectedText = "Your registration completed";
        String actualText = driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText();
        Assert.assertEquals("text are matched", actualText, expectedText);
    }

    private String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
