package piit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;
import piit.us.CommonAPI;

public class MakeAPurchase extends CommonAPI {
    Logger log = LogManager.getLogger(LoginTest.class.getName());

    @Test
    public void addToCart() throws InterruptedException {


        String expectedTitle = "Automation – Automate eCommerce";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        log.info("user logged in success");

        // click  on categories
        clickOn(".fa.fa-angle-down.angle-down");
        System.out.println("click on categories success");

        // check user is landed to categories menu
        String expectedText = "CATEGORIES";
        String actualText = getElementText("a[class='special-menu");
        Assert.assertEquals(expectedText, actualText);
        log.info("categories header success");
        Thread.sleep(3000);

        // hover over & click on women collection
        hoverOver("//*[contains(text(),'Women Collection')]");
        System.out.println("hover over women collection success");
        clickOn("//*[contains(text(),'Women Collection')]");
        log.info("click on Women Collection success");
        Thread.sleep(3000);

        // check user is landed to the women collection page
        boolean WomenCollectionIsDisplayed = isVisible(("//h1[@class='woocommerce-products-header__title page-title']")); // this method return a boolean true or false
        Assert.assertTrue(WomenCollectionIsDisplayed);
        log.info("women collection page is displayed");
        String expectedheaderText = "Women Collection";
        String actualheaderText = getElementText("h1[class='woocommerce-products-header__title page-title']");
        Assert.assertEquals(expectedheaderText, actualheaderText);
        log.info("Women Collection header success");

        // click on converse item
        clickOn(".woocommerce-loop-product__title");
        log.info("click on converse success");
        Thread.sleep(3000);

        // add to cart
        clickOn("//ul[@class='products columns-4']/li[1]/a[2]");
        log.info("converse added to cart success");
        Thread.sleep(3000);

        //check converse is added to the cart
        boolean cartcount = isVisible((".cart-value.cart-customlocation"));
        Assert.assertTrue(cartcount);
        log.info("1 item on the cart is displayed");
        String expectedcartcount = "1";
        String actualcartcount = getElementText("//span[@class='cart-value cart-customlocation' and text()=1]");
        Assert.assertEquals(expectedcartcount, actualcartcount);
        log.info("1 item added to cart success");


        hoverOver("//span[@class='cart-value cart-customlocation' and text()=1]");
        waitFor(3);


        // click on cart
        clickOn("//span[@class='cart-value cart-customlocation' and text()=1]");
        log.info("click on cart success");
        waitFor(3);
        //enter the coupons code
        // apply coupons
    }}





