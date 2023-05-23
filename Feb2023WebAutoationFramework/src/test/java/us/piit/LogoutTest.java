package us.piit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.Commom;
import us.piit.base.CommonAPI;
import us.piit.pages.HomePage;
import us.piit.pages.LoginPage;

public class LogoutTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogoutTest.class.getName());

    String validUsername = "standard_user";
    String validPassword = "secret_sauce";

    @Test
    public void logout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();

        //check user is logged in
        String expectedHomePageHeader = "Products";
        String actualHomePageHeader = homePage.getHeaderText();
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
        log.info("user logged in success");

        //click on hamburger menu
        homePage.clickOnHamburgerMenu();
        Thread.sleep(1000);

        //hover hover & click on logout link
        homePage.hoverOverOnAndClickLogoutLink(getDriver());

        //check user is landed to the login page

        Assert.assertTrue(loginPage.checkPresenceOfLoginPageHeader());
        log.info("login page header is displayed");

        String expectedLoginPageHeaderText = "Swag Labs";
        String actualLoginPageHeaderText = loginPage.getLoginPageHeaderText();
        Assert.assertEquals(expectedLoginPageHeaderText, actualLoginPageHeaderText);
        log.info("login page header text validation success");
    }

}







//    Logger log= LogManager.getLogger(LogoutTest.class.getName());
//
//    String validUsername="standard_user";
//    String validPassword="secret_sauce";
//
//    @Test
//    public void logout() throws InterruptedException {
//        LoginPage loginPage= new LoginPage(getDriver());
//        HomePage homePage=new HomePage(getDriver());
//        String expectedTitle="Swag Labs";
//        String actualTitle=getCurrentTitle();
//        Assert.assertEquals(expectedTitle,actualTitle);
//        // entre username,passwoord,and click on login button
//
//        loginPage.enterUsername(validUsername);
//
//        loginPage.enterPassword(validPassword);
//
//        loginPage.clickOnLoginBtn();
//
//
//        // waitFor(3);
//        // check user is logged in
//        String expectedHomePageHeader = "Products"; // this is data product , username & password
//        String actualHomePageHeader = homePage.getHeaderText();//getElementText("//span[contains(text(),'Products')]");
//        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
//            log.info("user logged in success");
//
//
//    // click on hamburger menu
//      homePage.clickOnHamburgerMenu();
//      Thread.sleep(1000);
//
//     // hover hover & click on logout link
//       homePage.hoverOverOnAndClickLogoutLink();
//   //  Actions actions = new Actions(driver);
//// the build and perform is always used in actions class
//
//       //.info("click on logout link success");
//
//
//       // check user is landed to the login page
//      //  WebElement loginPageHeader = driver .findElement(By.xpath("//div[contains(text(),'Swag Labs')]"));
//        //boolean loginPageHeaderIsDisplayed=isVisible(("//div[contains(text(),'Swag Labs')]")); // this method return a boolean true or false
//
////check user is landed to the login page
//        Assert.assertTrue(loginPage.checkPresenceOfLoginPageHeader());
//        log.info("login page header is displayed");
//
//
//        String expectedLoginPageHeaderText="Swag Labs";
//        String actualLoginPageHeaderText=loginPage.getLoginPageHeaderText();//getElementText("//div[contains(text(),'Swag Labs')]");
//        Assert.assertEquals(expectedLoginPageHeaderText,actualLoginPageHeaderText);
//        log.info("login page header text validation success");
//
//
//    }
//}
