package testing;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebTable {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver(); // that means open the chrome browser
        System.out.println("browser opened success");

        driver.manage().window().maximize();
        System.out.println("browser maximaze success");

        //naviagte to amazon
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement targetElement =driver.findElement(By.xpath("//*[@id=\"product\"]/tbody/tr[9]/td[4]"));
        Actions actions=new Actions(driver);
        actions.scrollToElement(targetElement).perform();
  Thread.sleep(3000);
  driver.close();

//      driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//        WebElement targetElement =driver.findElement(By.xpath("//*[@id=\"product\"]/tbody/tr[11]/td[3]"));
//      Actions actions=new Actions(driver);
//        actions.scrollToElement(targetElement).perform();
//  Thread.sleep(3000);
//  driver.close();

// input id-"...." = wlwment attribute value
    }

}



