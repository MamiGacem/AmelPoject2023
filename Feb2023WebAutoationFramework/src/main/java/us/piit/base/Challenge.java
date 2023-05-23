package us.piit.base;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Challenge {
    String browserName = "chrome";
    String url = "https://www.saucelabs.com/";
    // that means open the chrome browser
    // ChromeDriver driver = new ChromeDriver();// global which belong to the class
    WebDriver driver;

    @BeforeMethod
    public void setUp() { // the before and after is setup method
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            System.out.println("chrome browser open success");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            System.out.println("firefox browser open success");
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
            System.out.println("edge browser open success");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        driver.manage().window().maximize();

        driver.get(url);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
        System.out.println("browser close success");
  }


    @Test
    public void bestseller() throws InterruptedException {

        //click on Best Sellers button
        driver.findElement(By.xpath("//a[contains(text(),'Best Sellers')]")).click();
        System.out.println("click on best seller button success");

        //hover over
        Actions actions = new Actions(driver);
        WebElement elmt = driver.findElement(By.xpath("//div[contains(text(),'Crocs Unisex-Adult Classic Clog')]"));
        actions.moveToElement(elmt).build().perform();
        Thread.sleep(3000);
        elmt.click();
        System.out.println("hover over success");

        //add to cart
        driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
        System.out.println("item add to cart");

 // check if the cart add the item

//        WebElement cartcount = driver.findElement(By.xpath("//span[@id='nav-cart-count' and text()='1']"));
//        boolean cartcountIsDisplayed= cartcount.isDisplayed();
      // ///// boolean cartCount = driver.findElement(By.xpath("//span[text()='1'and @id='nav-cart-count']")).isDisplayed();********************************
      //  boolean cartCount = driver.findElement(By.xpath("//*[starts-with(@id,'nav-cart-count')]")).isDisplayed();
       // boolean cartCount = driver.findElement(By.xpath("//span[contains(@id,'nav-cart-count')]")).isDisplayed();
    /// /////   boolean cartCount = driver.findElement(By.xpath("//span[text()='1']")).isDisplayed();**************************************************
      //  boolean cartCount = driver.findElement(By.xpath("//span[contains(text(),'1')]")).isDisplayed();
       // boolean cartCount = driver.findElement(By.xpath("//div[@id='nav-cart-count-container']/span[1]")).isDisplayed();
     //   boolean cartCount = driver.findElement(By.xpath("//span[@class='nav-cart-icon nav-sprite']/preceding-sibling::span[1]")).isDisplayed();
      //  boolean cartCount = driver.findElement(By.xpath("/html/body/div[1]/header[1]/div[1]/div[1]/div[3]/div[1]/a[4]/div[1]/span[1]")).isDisplayed();
        boolean cartCount = driver.findElement(By.cssSelector("[#nav-cart-count]")).isDisplayed();
      //  boolean cartCount = driver.findElement(By.cssSelector(".nav-cart-count.nav-cart-1.nav-progressive-attribute.nav-progressive-content")).isDisplayed();******************
     //   boolean cartCount = driver.findElement(By.cssSelector("div[id='nav-cart-count-container'] span")).isDisplayed();
     //   boolean cartCount = driver.findElement(By.cssSelector("  div[id='nav-cart-count-container'] span:nth-child(1) ")).isDisplayed();

        System.out.println(cartCount);
        Assert.assertTrue(cartCount);
        Thread.sleep(1000);
        System.out.println("add to cart success");



    }
}