package testing;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckBox {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver(); // that means open the chrome browser
        System.out.println("browser opened success");

        driver.manage().window().maximize();
        System.out.println("browser maximaze success");

        //naviagte to amazon
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // ckeck the second checkbox and make sure the 1st is unckecked,the second is checked and the third is unchecked
        driver.findElement(By.id("checkBoxOption2")).click();
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption2")).isSelected());
        System.out.println(driver.findElement(By.id("checkBoxOption2")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption3")).isSelected());
        System.out.println(driver.findElement(By.id("checkBoxOption3")).isSelected());

 // Assert.assertEquals(false,actual);this is instate of the a


        Thread.sleep(3000);
        driver.close();

    }}


