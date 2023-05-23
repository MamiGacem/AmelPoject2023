package testing;


import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {

        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Amel Boucetta Gacem\\eclipse-workspace\\SeliniumProject\\driver\\chromedriver.exe");
// we n=dont need this after deleating the driver directory
        // open the chrome browser   //testing is validation between the expected and the actual result
        ChromeDriver driver=new ChromeDriver(); // that means open the chrome browser
        System.out.println("browser opened success");
// FirefoxDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        System.out.println("browser maximaze success");
        //naviagte to amazon
        driver.get("https://www.amazon.com");
        String currentUrl=driver.getCurrentUrl();// method to get the title
        String expectedUrl="https://www.amazon.com/";
        Assert.assertEquals(expectedUrl,currentUrl);
        System.out.println("lnd on amazon home page sucess");

        //type java book on the search bar
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book");
        System.out.println("type java book on the search bar success");
        // click on search button
        driver.findElement(By.id("nav-search-submit-button")).click();
        System.out.println("click on search button success");

        String actualTitle=driver.getTitle();
        String expectedTitle="Amazon.com : java book";
        Assert.assertEquals(expectedTitle,actualTitle);
        System.out.println("validate the title success");

        driver.close();
        System.out.println("browser close success");
// this is validation in testing
        Assert.assertEquals("","");
    }
}

