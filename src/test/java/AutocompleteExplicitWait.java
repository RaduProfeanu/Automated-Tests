import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AutocompleteExplicitWait {

    private WebDriver driver;

    @BeforeMethod

    public void setup(){
        System.setProperty("webdriver.chrome.driver","/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://formy-project.herokuapp.com/autocomplete");
    }

    @AfterMethod

    public void close(){ driver.close();}

    @Test
    public void autocomplete(){
        driver.findElement(By.id("autocomplete")).sendKeys("1555 Park Vlvs, Palo Alto, CA");
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("pac-item"))).click();
    }
}
