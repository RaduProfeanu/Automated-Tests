import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Autocomplete {

    private WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/Chromedriver/chromedriver.exe");

       driver = new ChromeDriver();

        driver.navigate().to("https://formy-project.herokuapp.com/autocomplete");
    }

    @AfterTest
    public void driverClose(){
        driver.close();
    }

    @Test
    public void autocomplete(){

        driver.findElement(By.xpath("/html/body/div[1]/form/div/div[1]/input")).sendKeys("1555 Park Vlvs, Palo Alto, CA");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement autocompleteResult = driver.findElement(By.className("pac-item"));
        autocompleteResult.click();
    }

}
