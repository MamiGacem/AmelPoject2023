package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Test {
    //  public static void main(String[] args) {


    String browserName = "chrome";
    String url = "https://automation.scaledupit.com//";
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


    @org.testng.annotations.Test
    public void bestseller() throws InterruptedException {

        //click on Best Sellers button
        driver.findElement(By.xpath("//a[text()='Login/Register']")).click();
        System.out.println("click on login success");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("boucettaamel811@gmail.com");
        System.out.println("username success");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("mamigacem693");
        System.out.println("password success");
        Thread.sleep(3000);
        driver.findElement(By.xpath("// button[@name='login']")).click();
        System.out.println("login success");
        //hover over
//        Actions actions = new Actions(driver);
//        WebElement elmt = driver.findElement(By.xpath("//div[contains(text(),'Crocs Unisex-Adult Classic Clog')]"));
//        actions.moveToElement(elmt).build().perform();
//        Thread.sleep(3000);
//        elmt.click();
//        System.out.println("hover over success");
    }
}