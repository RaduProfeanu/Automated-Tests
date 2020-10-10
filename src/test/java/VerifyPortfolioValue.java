import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class VerifyPortfolioValue {
    public static void main(String[] args) {

        String data = null;
        File myObj = new File("C:\\Users\\Radu\\Desktop\\java\\Tradeville.txt");

        if (myObj.exists()){
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
        }else{
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

        driver.findElement(By.xpath("//*[@id=\"ctl00_lc_ucLeftMenu_leaf_2_104\"]")).click();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        driver.manage().window().maximize();

       String folioValue=driver.findElement(By.cssSelector("td.total")).getText();
       String moneyLeft=driver.findElement(By.xpath("//*[@id=\"258853670\"]/tbody[1]/tr[6]/td[8]")).getText();

       double folioValue1 = parseDouble(folioValue);
       double moneyLeft1= parseDouble(moneyLeft);

        System.out.println("valoarea folio este"+folioValue1);
        System.out.println("cash ul din portofolio"+moneyLeft1);


      /* List<WebElement> rows = driver.findElements(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div[4]/div[3]/div"));
        for (WebElement row: rows) {
            List<WebElement> cells = row.findElements(By.cssSelector("td.data"));
            for (WebElement cell: cells) {
                System.out.println(cell.getText());
            }
        } */





    }
}
