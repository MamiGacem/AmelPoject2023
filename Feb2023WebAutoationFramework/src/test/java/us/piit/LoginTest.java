package us.piit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.Commom;
import us.piit.base.CommonAPI;
import us.piit.pages.HomePage;
import us.piit.pages.LoginPage;
import us.piit.utility.Utility;

import java.util.Properties;


public class LoginTest extends CommonAPI {    // instate of systemout we need to use the log instate   //  Logger log = LogManager.getLogger(LoginTestLog4j.class.getName());

Logger log= LogManager.getLogger(LoginTest.class.getName()); // when you creating the log object you have to use the class where you are

    Properties prop= Utility.loadProperties();

    String validUsername=Utility.decode(prop.getProperty("saucedemo.username"));
    String validPassword=Utility.decode(prop.getProperty("saucedemo.password"));
  // HomePage homePage=new HomePage(); put it inside each method

  @Test
    public void validCred () {
      //use default constructor
        LoginPage loginPage= new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        String expectedTitle="Swag Labs";
        String actualTitle=getCurrentTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        waitFor(3);
        // entre username,passwoord,and click on login button

        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickOnLoginBtn();


       // waitFor(3);
        // check user is logged in
        String expectedHomePageHeader = "Products"; // this is data product , username & password
        String actualHomePageHeader = homePage.getHeaderText();//getElementText("//span[contains(text(),'Products')]");
        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
      waitFor(3);

    }


  // @Test
    public void invalidUsername () {
        LoginPage loginPage= new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());

        String expectedTitle="Swag Labs";
        String actualTitle=getCurrentTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        // entre username,passwoord,and click on login button

      //  type("#user-name","invalid_username"); // this driver is local belongs inside the methode
       loginPage.enterUsername("invalidUsername");
//loginPage.enterUsername(v);
     //   type("#password","secret_sauce");
       loginPage.enterPassword(validPassword);
       loginPage.enterUsername(validUsername);

     //   clickOn("#login-button");
      loginPage.clickOnLoginBtn();

        // validate the error message
        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        String actualError = loginPage.getErrorMessage();//getElementText("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
        Assert.assertEquals(expectedError, actualError);

    }

  //@Test // it is equivalent of main method and you can use it how many to run (it isrunnable)

    public void missingUsername(){
        LoginPage loginPage= new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        String expectedTitle = "Swag Labs";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //enter  username, password, and click on login button
        loginPage.enterUsername("");

        //   type("#password","secret_sauce");
        loginPage.enterPassword(validPassword);

        //   clickOn("#login-button");
        loginPage.clickOnLoginBtn();

        //validate the error message
        String expectedError = "Epic sadface: sername is required";
        String actualError = loginPage.getErrorMessage();//getElementText("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]");
        Assert.assertEquals(expectedError, actualError);
    }

    //@Test
    public void missingpassword () {
        LoginPage loginPage= new LoginPage(getDriver());
        HomePage homePage=new HomePage(getDriver());
        String expectedTitle="Swag Labs";
        String actualTitle=getCurrentTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        loginPage.enterUsername(validUsername);

        //   type("#password","secret_sauce");
        loginPage.enterPassword("");

        //   clickOn("#login-button");
        loginPage.clickOnLoginBtn();

        // validate the error message
        String expectedError = "Epic sadface: Password is required";
        String actualError =loginPage.getErrorMessage();//getElementText("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
        Assert.assertEquals(expectedError, actualError);

    }
}


