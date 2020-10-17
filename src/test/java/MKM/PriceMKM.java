package MKM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PriceMKM {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cardmarket.com/en/Magic");

        WebElement findcard=driver.findElement(By.xpath("//*[@id=\"ProductSearchInput\"]"));
        findcard.click();
        findcard.sendKeys("Arid Mesa");
        findcard.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//*[@id=\"productRow21744\"]/div[4]/div/div[1]/a")).click();

    }
}
