package testing;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlert {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver(); // that means open the chrome browser
        System.out.println("browser opened success");

        driver.manage().window().maximize();
        System.out.println("browser maximaze success");

        //naviagte to amazon
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // enter name ,click alert , get text ,confirm alert
        driver.findElement(By.id("name")).sendKeys("John Doe");
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(3000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        // enter name ,click confirm , get text ,confirm alert
        driver.findElement(By.id("name")).sendKeys("John Doe");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(3000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        // enter name ,click confirm , get text ,cancel alert
        driver.findElement(By.id("name")).sendKeys("John Doe");
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(3000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);


        driver.close();

    }}




