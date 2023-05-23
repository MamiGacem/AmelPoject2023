package us.piit.base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import us.piit.utility.Utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;


public class Commom {   // differents browers is local acces but differents systems like mac , windows is remote access
    // String browserName = "edge"; // that means open the chrome browser
    Logger log = LogManager.getLogger(Commom.class.getName());
    Properties prop= Utility.loadProperties();

    String browserstackUsername=prop.getProperty("browserstack.username");
    String browserstackPassword=prop.getProperty("browserstack.password");
//    String saucelabsUsername=prop.getProperty("saucelabs.username");
//    String saucelabsPassword=prop.getProperty("saucelabs.password");
    String implicitWait=prop.getProperty("implicit.Wait","5");
    String windowMaximize=prop.getProperty("window.maximize","true");// if you don't find this parameter wait time in properties just put it as true
    String takeScreenshots=prop.getProperty("take.screenshots","false");// if you dont find the screenshot set it to false

    //    String useCloudEnv = "true";     delete
//    String url = "https://www.saucedemo.com/";   delete

    // ChromeDriver driver = new ChromeDriver();// global which belong to the class
    WebDriver driver;

    public void getCloudDriver(String envName, String os, String osVersion, String browserName, String browserVersion, String username, String password) throws MalformedURLException {

// to access to the website you need :username,password,url   ( not really special)
        // OS operationg sys,os version,browser name,browser version

        DesiredCapabilities cap = new DesiredCapabilities();  // desire object
        cap.setCapability("os", os);  // set the browser stacks
        cap.setCapability("os_verson", osVersion);
        cap.setCapability("browser", browserName);
        cap.setCapability("browser_version", browserVersion);

        if (envName.equalsIgnoreCase("browserstack")) {  // i am using the if because i have two websites
            cap.setCapability("resoltion", "1026x768"); // i want the resolution to be a part or valid only for rowserstack
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@hub-cloud.browserstack.com:80/wd/hub"), cap);
        } else if (envName.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://"+username+":"+password+"@ondemand.saucelabs.com:80/wd/hub"), cap);
        }
    }

    public void getLocalDriver(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            log.info("chrome browser open success");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            log.info("firefox browser open success");
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
            log.info("edge browser open success");
        }

    }
    @Parameters({"useCloudEnv","envName","os","osVersion","browserName","browserVersion","url"})
// in order to link the parameters on the runner xml you need to use the parameter annotation
    @BeforeMethod
    public void setUp(@Optional("false") String useCloudEnv, @Optional("browserstack") String envName, @Optional("windows") String os, @Optional("10") String osVersion, @Optional("chrome") String browserName, @Optional("110") String browserVersion, @Optional("https://www.google.com") String url) throws MalformedURLException { // the before and after is setup method
        // optional is telling my xml file if you didn't find this information just set it to false
        if (useCloudEnv.equalsIgnoreCase("true")) {
            getCloudDriver(envName, os, osVersion, browserName, browserVersion, browserstackUsername, browserstackPassword);  // we need to change from here if you want to use saucelabs
        } else if (useCloudEnv.equalsIgnoreCase("false")) {
            getLocalDriver(browserName);

            //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//            String excpectedTitle = "Swag Labs";
//            String actualTitle = driver.getTitle();
//            Assert.assertEquals(excpectedTitle, actualTitle);
            // the wait time : i am telling the browser if i tell you to click on something but it didn't , wait on that wait time to put it as an error
        }
        //open the chrome browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(implicitWait)));
        if (windowMaximize.equalsIgnoreCase("true")) {
            driver.manage().window().maximize();
        }

// navigate to login page
        driver.get(url);

    }


    @AfterMethod
    public void tearDown() {
        //close the browser
        driver.quit();
        log.info("browser close success");
    }


    //........................................................
    //                            selinium methods  are generic nethods you cn use them whenever you want
    //..............................................................
    public WebDriver getDriver() {
        return driver;
    }
    public String getCurrentTitle(){
        return driver.getTitle();
    }
    public String getElementText(WebElement element){
        return element.getText();
    }
    public void clickOn(WebElement element){
        element.click();
    }
    public void type(WebElement element, String text){
        element.sendKeys(text);

    }
    public void hoverOver(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
    public void hoverOverAndClickOn(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isVisible(WebElement element){
        return element.isDisplayed();
    }
    public boolean isInteractible(WebElement element){
        return element.isEnabled();
    }
    public boolean isChecked(WebElement element){
        return element.isSelected();
    }
}

// all thes selinium code , to customized methods

