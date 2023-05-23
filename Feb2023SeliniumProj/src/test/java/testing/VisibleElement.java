package testing;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class VisibleElement {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver(); // that means open the chrome browser
        System.out.println("browser opened success");

        driver.manage().window().maximize();
        System.out.println("browser maximaze success");

        //naviagte to amazon
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // click on hide , check if the element is not visible
        // click on show and check that the element is visible
        driver.findElement(By.id("hide-textbox")).click();
      Assert.assertFalse(driver.findElement(By.id("displayed-text")).isDisplayed());
        Thread.sleep(3000);

      driver.findElement(By.id("show-textbox")).click();
        Assert.assertTrue(driver.findElement(By.id("displayed-text")).isDisplayed());



        Thread.sleep(3000);
        driver.close();

    }}



