package piit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import piit.us.CommonAPI;

public class Blog extends CommonAPI {
Logger log = LogManager.getLogger(Blog.class.getName());


@Test
public void addComment(){

    String expectedTitle = "Automation – Automate eCommerce";
    String actualTitle = getCurrentTitle();
    Assert.assertEquals(expectedTitle, actualTitle);

// click on
    clickOn("");
    log.info("click on blog success");
    clickOn("//a[text()='Laptop']");
    log.info("gskaksl");
    waitFor(3);

   // WebElement targetElement = null;
    clickOn("//li[@id='menu-item-292']/a[1]");

    WebDriver driver = null;
  //  Actions actions=new Actions(driver);
    clickOn("//li[@id='menu-item-292']/a[1]").scrollToElement().perform();

}


}
