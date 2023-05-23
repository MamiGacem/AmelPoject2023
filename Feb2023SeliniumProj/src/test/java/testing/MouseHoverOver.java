package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class MouseHoverOver {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver(); // that means open the chrome browser
        System.out.println("browser opened success");

        driver.manage().window().maximize();
        System.out.println("browser maximaze success");
        //naviagte to amazon
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // hover over the button
Actions actions = new Actions(driver);
actions.moveToElement(driver.findElement(By.id("mousehover"))).build().perform();

        Thread.sleep(3000);
        driver.close();
// iframe is a tag and you have to switch inside the iframe
    }}

