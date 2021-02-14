import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxes {

    private WebDriver driver;

    @BeforeMethod
     public void setup(){
        System.setProperty("webdriver.chrome.driver", "/Chromedriver/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/checkbox");
    }

    @AfterMethod
    public void close(){
        driver.close();
    }

    @Test
    public void checkBoxes(){
        driver.findElement(By.id("checkbox-1")).click();
        driver.findElement(By.id("checkbox-2")).click();
        driver.findElement(By.id("checkbox-3")).click();

    }
}
