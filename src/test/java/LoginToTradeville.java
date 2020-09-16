import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Base64;

public class LoginToTradeville {
    public static void main(String[] args) {

        byte[] decodedBytes= Base64.getDecoder().decode("SW5uaXN0cmFkMQ==");
        String decodeString= new String(decodedBytes);

        System.setProperty("webdriver.chrome.driver","/Chromedriver/chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        driver.get("https://tradeville.eu/");

        driver.findElement(By.id("ac--two")).click();

        WebElement utilizator = driver.findElement(By.id("inputLogin"));
        utilizator.click();
        utilizator.sendKeys("Pradu");

        WebElement password =driver.findElement(By.xpath("//*[@id=\"ctl00_phContent_ucComposeLogin_ucLoginStartrade_pnlLoginStartrade\"]/input[2]"));
        password.click();
        password.sendKeys(String.valueOf(decodeString));

        driver.findElement(By.xpath("//*[@id=\"ctl00_phContent_ucComposeLogin_ucLoginStartrade_btnLogin\"]")).click();
    }
}
