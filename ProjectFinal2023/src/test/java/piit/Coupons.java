package piit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import piit.us.CommonAPI;

public class Coupons extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName()); // when you creating the log object you have to use the class where you are

    @Test
    public void addingCoupons() {
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);


        clickOn(".fa.fa-angle-down.angle-down");
        System.out.println("click on categories success");
        // click on shop
//      hoverOver("//div[@class='slide-title']/a[1]");
//      clickOn("//div[@class='slide-title']/a[1]");
//      waitFor(3);
//       log.info("click on shop successfuuly ");
    }
}
