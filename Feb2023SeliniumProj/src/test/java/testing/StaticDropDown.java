package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDown {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver(); // that means open the chrome browser
        System.out.println("browser opened success");

        driver.manage().window().maximize();
        System.out.println("browser maximaze success");

        //naviagte to amazon
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

      // select option3 in the static dropdown  (to apply select tag you have to use the select object and this is the only case where you can apply the select tag)
        WebElement dropdown= driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(dropdown);
       for (WebElement option: select.getOptions()){
           System.out.println(option.getText()); // we use t get text to see the options
       }
         select.selectByValue("option2");


        Thread.sleep(3000);
        driver.close();

    }}


