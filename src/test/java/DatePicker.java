import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePicker {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/datepicker");
    }

    @AfterMethod
    public void close(){
        driver.close();
    }

    @Test
    public void datePicker(){
        driver.findElement(By.id("datepicker")).sendKeys("03/03/2021");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
    }

}
