import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExecuteJavaScript {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/Chromedriver/chromedriver.exe");
         driver= new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/modal");
    }

    @AfterMethod
    public void close(){
        driver.close();
    }

    @Test
    public void executeJavaScript(){
        driver.findElement(By.id("modal-button")).click();
        WebElement closeButton=driver.findElement(By.id("close-button"));
        JavascriptExecutor js=(JavascriptExecutor)driver ;
        js.executeScript("arguments[0].click();",closeButton);
    }
}
