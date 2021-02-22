import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDrop {
    
   private WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/dragdrop");
    }

    @AfterMethod
    public void close(){
        driver.close();
    }

    @Test
    public void dragAndDrop(){

        WebElement seleniumLoggo =driver.findElement(By.id("image"));
        WebElement box=driver.findElement(By.id("box"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(seleniumLoggo,box).build().perform();

        String theText=driver.findElement(By.id("box")).getText();

        assert theText.compareTo("Dropped!")==0;
    }
}
