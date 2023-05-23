package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandleNewWindow {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver(); // that means open the chrome browser
        System.out.println("browser opened success");

        driver.manage().window().maximize();
        System.out.println("browser maximaze success");

        //naviagte to amazon
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

      // click on the button to open new window then grab the test from the web element
        driver.findElement(By.id("openwindow")).click();
 //let transfere the big window to another window
       Set<String> windows = driver .getWindowHandles();
      Iterator<String>iterator= windows.iterator(); //we use the iterator to use another method
        String parentdWind= iterator.next(); // for the first window
        String childWind= iterator.next(); // for the second window


        driver.switchTo().window(childWind);// switch to the second window after that you can do whatever you want
        System.out.println("switch to child win success");
        String text =driver.findElement(By.cssSelector(".header-opening-time.text-lg-right.text-center p")).getText();
         System.out.println(text);// we use the css selector becuse it doesn't have any id or classname ....ect

       Thread.sleep(3000);

        driver.close();

        driver.switchTo().window(parentdWind);

        driver.close();

    }}

