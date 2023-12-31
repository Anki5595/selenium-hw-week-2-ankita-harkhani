package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
public class BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    static String browser = "Chrome";
    public WebDriver driver;

    public void openBrowser() {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser Name");
        }

        driver.get(baseUrl); //get url
        driver.manage().window().maximize(); // maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait for 10 second to load a page
    }
        public void closeBrowser() {
        driver.quit();
    }
}
