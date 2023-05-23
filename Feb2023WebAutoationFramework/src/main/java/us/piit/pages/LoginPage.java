package us.piit.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.Commom;
import us.piit.base.CommonAPI;

public class LoginPage extends CommonAPI {
    Logger log = LogManager.getLogger(LoginPage.class.getName());
    public LoginPage(WebDriver driver){  // make page factory in constructor that will be applicable for the whole class with passing webdriver driver inside as a parameter
        PageFactory.initElements(driver,this);
    }  // here my script does not know which element is initializing this is why we use the find by annotations

    //locators
    @FindBy(css = "#user-name") // this method is like driver.findelement(BY.xpath
     WebElement usernameField;
    // String usernameField = "#user-name";
    @FindBy(css = "#password")
    WebElement passwordField;
    @FindBy(css = "#login-button")
    WebElement loginBtn;
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]")
    WebElement errorMessage;

    @FindBy(xpath = "//div[contains(text(),'Swag Labs')]")
    WebElement loginPageHeader;


    //   String loginBtn = "#login-button";
    // String errorMessage = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]";


    //reusable methods
    public void enterUsername(String username) {
        type(usernameField, username);

        log.info("enter username success");
    }

    public void enterPassword(String password) {
        type(passwordField, password);
        log.info("enter password success");
    }

    public void clickOnLoginBtn() {
        clickOn(loginBtn);
        log.info("click on login button success");

    }

    public String getErrorMessage() {           // return because its gonna return the error message
        String text = getElementText(errorMessage);
        log.info("get error message text success");
        return text;
    }

    public boolean checkPresenceOfLoginPageHeader() {
        boolean loginPageHeaderIsDisplayed = isVisible(loginPageHeader);
        log.info("login page header presence " + loginPageHeaderIsDisplayed);
        return loginPageHeaderIsDisplayed;
    }

    public String getLoginPageHeaderText() {
        String loginPageHeaderText = getElementText(loginPageHeader);
        log.info("login page header text is " + loginPageHeaderText);
        return loginPageHeaderText;

    }
}


