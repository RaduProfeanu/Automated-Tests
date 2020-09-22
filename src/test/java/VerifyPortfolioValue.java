import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

        String folioValue=driver.findElement(By.xpath("//*[@id=\"2027855965\"]/tbody[2]/tr/td[8]")).getText();
      //  String folioValue=driver.findElement(By.xpath("//*[boolean(number(substring-before(substring-after(@id, \"td[8]\"), \"td[8]\")))]")).getText();

        //*[@id="1576598214"]/tbody[2]/tr/td[8]
        //  //*[boolean(number(substring-before(substring-after(@id, "td[8]"), "td[8]")))]
        System.out.println("valoarea este "+folioValue);


/*     //   WebElement folioValue =driver.findElement(By.xpath("/html/body/form/div[7]/div[2]/div[2]/div[4]/div[3]/div/div/table/tbody/tr[9]/td/span/span[1]"));
      //  String value = folioValue.getAttribute("43,225.73 RON ");

     //  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       String folioValue = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",driver.findElement(By.xpath("//*[@id=\\\"e4cdd972-75a8-4e37-803e-42452a3d49c4\\\"]/span[1]")));

       // String folioValue=driver.findElement(By.xpath("//*[@id=\"698524cf-845a-4388-bb13-a6ff2223b7a7\"]/span[1]")).getText();

        System.out.println("valoarea este "+folioValue);*/


    }
}
