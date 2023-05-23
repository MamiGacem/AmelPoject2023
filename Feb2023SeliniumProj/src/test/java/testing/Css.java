package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Css {
    public static void main(String[] args) {

        ChromeDriver driver = new ChromeDriver(); // that means open the chrome browser
        System.out.println("browser opened success");

        driver.manage().window().maximize();
        System.out.println("browser maximaze success");
        driver.get("https://www.facebook.com/");

        //tag and id
      //  driver.findElement(By.cssSelector("input#email")).sendKeys("AMEL");// or #email

        // tag &class
       // driver.findElement(By.cssSelector("input.inputtext")).sendKeys("AMEL");

        // tag and attribute
      //  driver.findElement(By.cssSelector("[id=email]")).sendKeys("AMEL BOUCETTA");

        //tag,class and attribute
        driver.findElement(By.cssSelector("input.inputtext[id=email]")).sendKeys("AMEL BOUCETTA");
    }
}
