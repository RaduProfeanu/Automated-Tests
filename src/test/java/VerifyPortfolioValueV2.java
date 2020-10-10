import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VerifyPortfolioValueV2 {

    public static void main(String[] args) {

        String data = null;
        File myObj = new File("C:\\Users\\Radu\\Desktop\\java\\Tradeville.txt");

        if (myObj.exists()) {
            try {
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    data = myReader.nextLine();
                }
                myReader.close();

            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else {
            System.out.println("Wrong file");
            return;
        }
        System.setProperty("webdriver.chrome.driver", "/Chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://tradeville.eu/");

        driver.findElement(By.id("ac--two")).click();

        WebElement utilizator = driver.findElement(By.id("inputLogin"));
        utilizator.click();
        utilizator.sendKeys("Pradu");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"ctl00_phContent_ucComposeLogin_ucLoginStartrade_pnlLoginStartrade\"]/input[2]"));
        password.click();
        password.sendKeys(String.valueOf(data));

        driver.findElement(By.xpath("//*[@id=\"ctl00_phContent_ucComposeLogin_ucLoginStartrade_btnLogin\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"ctl00_lc_ucLeftMenu_li_1_4\"]/a[2]")).click();

        driver.findElement(By.xpath("//*[@id=\"ctl00_lc_ucLeftMenu_leaf_2_35\"]")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String folioValue=driver.findElement(By.xpath("//*[@id=\"698524cf-845a-4388-bb13-a6ff2223b7a7\"]/span[1]")).getText();

        System.out.println("valoarea este "+folioValue);
    }
}