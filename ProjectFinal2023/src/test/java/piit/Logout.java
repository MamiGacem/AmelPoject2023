package piit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import piit.us.CommonAPI;

public class Logout extends CommonAPI {
    Logger log = LogManager.getLogger(Logout.class.getName());

    @Test
    public void logout() throws InterruptedException {

        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

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


        // hover hover & click on logout link
        hoverOver("//a[text()='Logout']");
        log.info("hover over on logout link success");
        waitFor(3);
        clickOn("//a[text()='Logout']");
        log.info("click on logout success");
         waitFor(3);

      // check user is landed to the login page

        boolean loginPageHeaderIsDisplayed=isVisible(("//header[@class='entry-header']/h1[1]"));
        Assert.assertTrue(loginPageHeaderIsDisplayed);
        log.info("login page is displayed");
        String expectedLoginPageHeaderText="My account";
        String actualLoginPageHeaderText=getElementText("//header[@class='entry-header']/h1[1]");
        Assert.assertEquals(expectedLoginPageHeaderText,actualLoginPageHeaderText);
        log.info("login page header text validation success");
//

    }
}