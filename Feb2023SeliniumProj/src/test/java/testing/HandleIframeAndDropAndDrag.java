package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandleIframeAndDropAndDrag {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver(); // that means open the chrome browser
        System.out.println("browser opened success");

        driver.manage().window().maximize();
        System.out.println("browser maximaze success");

        //naviagte to amazon
        driver.get("https://jqueryui.com/droppable/");

      // click on element inside the iframe
        driver.switchTo().frame(0);  // the franme that you need to access is 0
        System.out.println("switch to iFrame success");

        Actions actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).build().perform();







        Thread.sleep(3000);


        driver.close();

    }}


