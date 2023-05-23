package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Essai {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver(); // that means open the chrome browser
        System.out.println("browser opened success");

        driver.manage().window().maximize();
        System.out.println("browser maximaze success");

        //naviagte to amazon
        driver.get("https://www.amazon.com/");
//       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
//       driver.findElement(By.className("nav-input nav-progressive-attribute")).click();

    //    driver.findElements(By.className("a-section a-spacing-none _cropped-image-map_style"));

       /* driver.findElement(By.className("nav-search-scope nav-sprite")).click();


        // driver.findElement(By.id("twotabsearchtextbox")).sendKeys("t-shirt");// just one single elemnt
        // for multiple use
     /*  WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
       searchbox.sendKeys("t-shirt");
  driver.findElement(By.id("nav-search-submit-button")).click();

//  driver.findElement(By.linkText("Men's Crew T-Shirts, Multipack, Style G1100")).click();
  driver.findElement(By.partialLinkText("Men's Crew T-Shirts")).click();
// class and  tagName to find multiple elements*/

       int links=driver.findElements(By.tagName("input")).size();// or "a"
       System.out.println(links);
        Thread.sleep(3000);
  driver.close();




    }
}
