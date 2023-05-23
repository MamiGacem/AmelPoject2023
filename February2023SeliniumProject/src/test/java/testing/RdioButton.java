package testing;

import org.openqa.selenium.chrome.ChromeDriver;

public class RdioButton {
    public static void main(String[] args) {
        ChromeDriver driver=new ChromeDriver(); // that means open the chrome browser
        System.out.println("browser launch success");
// FirefoxDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        System.out.println("browser maximaze success");
        //naviagte to amazon
        driver.get("https://www.amazon.com");

}
