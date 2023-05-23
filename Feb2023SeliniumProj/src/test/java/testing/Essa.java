package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Essa {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver(); // that means open the chrome browser
        System.out.println("browser opened success");

        driver.manage().window().maximize();
        System.out.println("browser maximaze success");
        driver.get("https://www.facebook.com/");
        driver.findElement(By.className("inputtext")).sendKeys("2676169147");
        driver.findElement(By.name("pass")).sendKeys("amelboucetta96");
        driver.findElement(By.name("login")).click();
//        //naviagte to amazon
//        driver.get("https://www.amazon.com/");
//        driver.findElement(By.name("field-keywords")).sendKeys("amel96");
//       // driver.findElement(By.className("nav-input")).click();
//        Thread.sleep(30000);
//        driver.close();
//    }
    }
}
