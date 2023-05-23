package piit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import piit.us.CommonAPI;

public class LoginTest extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName()); // when you creating the log object you have to use the class where you are

    @Test
    public void validCred() {
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        // entre username,passwoord,and click on login button
        clickOn("//a[text()='Login/Register']");
        log.info("click on login/Register button success");
        type("//input[@id='username']", "boucettaamel811@gmail.com"); // accept xpath and ccs
        log.info("enter username success");
       type("//input[@id='password']", "mamigacem693");
        log.info("enter password success");
        clickOn("// button[@name='login']");
        log.info("click on login button success");
        waitFor(3);
//        // check user is logged in
        String expectedText = "My account";
        String actualText = getElementText("//h1[text()='My account']");
        Assert.assertEquals(expectedText, actualText);
        log.info("user logged in success");

    }

    @Test
    public void missingpassword() {
        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        clickOn("//a[text()='Login/Register']");
        log.info("click on login/Register button success");
        type("//input[@id='username']", "boucettaamel811@gmail.com"); // accept xpath and ccs
        log.info("enter username success");
        type("//input[@id='password']", "");
        log.info("enter password success");
        clickOn("// button[@name='login']");
        log.info("click on login button success");
        waitFor(3);
//        // check user is logged in
        String expectedError = "Error: The password field is empty.";
        String actualError = getElementText("//div[@class='woocommerce-notices-wrapper']/ul[1]/li[1]");
        log.info("user logged in success");

    }
}





