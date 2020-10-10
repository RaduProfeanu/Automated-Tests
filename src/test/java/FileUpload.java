import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/fileupload");
        WebElement importButton = driver.findElement(By.xpath("/html/body/div/form/div/div/span[1]/button"));
        importButton.click();


       // Actions action= new Actions(driver);   -----version 1
      //  action.sendKeys("D:\\radu's junk\\radu\\realistic dragon.PNG").perform();---- version 1
        // Alert alert;  ---- version 2
       // alert = driver.switchTo().alert().sendKeys("D:\\radu's junk\\radu\\realistic dragon.PNG")
       // WebElement fileinput=driver.findElement(By.name());  // ----version 3
       //fileinput.sendKeys("D:\\radu's junk\\radu\\realistic dragon.PNG");

      // driver.SwitchTo().Window(driver.WindowHandles.Last());
    }
}
