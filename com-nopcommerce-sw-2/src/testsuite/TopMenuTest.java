package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {

    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //click on the ‘Computers’ Tab
        WebElement computerTab = driver.findElement(By.xpath("//a[text()='Computers ']"));
        computerTab.click();

        //Verify the text ‘Computers’
        String expectedText = "Computers";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Computers']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        //click on the ‘Computers’ Tab
        WebElement electronicsTab = driver.findElement(By.xpath("//a[contains(@href,'/electronics') and text()='Electronics ']"));
        electronicsTab.click();

        //Verify the text ‘Electronics’
        String expectedText = "Electronics";
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Electronics']"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        // click on the ‘Apparel’ Tab
        driver.findElement(By.xpath("//a[text()='Apparel ']")).click();

        //Verify the text ‘Apparel’
        String expectedText = "Apparel";
        String actualText = driver.findElement(By.xpath("//h1[text()='Apparel']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        //click on the ‘Digital downloads’ Tab
        driver.findElement(By.xpath("//a[text()='Digital downloads ']")).click();

        // Verify the text ‘Digital downloads’
        String expectedText = "Digital downloads";
        String actualText = driver.findElement(By.xpath("//h1[text()='Digital downloads']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        //click on the ‘Books’ Tab
        driver.findElement(By.xpath("//a[text()='Books ']")).click();

        // Verify the text ‘Books’
        String expectedText = "Books";
        String actualText = driver.findElement(By.xpath("//h1[text()='Books']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        //click on the ‘Jewelry’ Tab
        driver.findElement(By.xpath("//a[text()='Jewelry ']")).click();

        //click on the ‘Jewelry’ Tab
        String expectedText = "Jewelry";
        String actualText = driver.findElement(By.xpath("//h1[text()='Jewelry']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        //click on the ‘Gift Cards’ Tab
        driver.findElement(By.xpath("//a[text()='Gift Cards ']")).click();

        //Verify the text ‘Gift Cards’
        String expectedText = "Gift Cards";
        String actualText = driver.findElement(By.xpath("//h1[text()='Gift Cards']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
