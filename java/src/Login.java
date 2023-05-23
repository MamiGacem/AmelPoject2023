public class Login {}
//    // cross brooowser testing is run your code in different browser
//
//
//    public void validCred (){
////            String expectedTitle="Swag Labs";
////            String actualTitle=driver.getTitle();
////            Assert.assertEquals(expectedTitle,actualTitle);
//
//        // entre username,passwoord,and click on login button
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        System.out.println("enter username success");
//
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        System.out.println("enter password success");
//        driver.findElement(By.id("login-button")).click();
//        System.out.println("click on login button success");
//        // check user is logged in
//        String expectedHomePageHeader = "Products";
//        String actualHomePageHeader = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();
//        Assert.assertEquals(expectedHomePageHeader, actualHomePageHeader);
//        System.out.println("user logged in success");
//    }
//
//
//    @Test
//    public void invalidUsername () {
//        String expectedTitle="Swag Labs";
//        String actualTitle=driver.getTitle();
//        Assert.assertEquals(expectedTitle,actualTitle);
//        // entre username,passwoord,and click on login button
//
//        driver.findElement(By.id("user-name")).sendKeys("invalid_username"); // this driver is local belongs inside the methode
//        System.out.println("enter username success");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        System.out.println("enter password success");
//        driver.findElement(By.id("login-button")).click();
//        System.out.println("click on login button success");
//        // validate the error message
//        String expectedError = "Epic sadface: sername and password do not match any user in this service";
//        String actualError = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
//        Assert.assertEquals(expectedError, actualError);
//        System.out.println("validate error success");
//    }
//
//    @Test // it is equivalent of main method and you can use it how many to run (it isrunnable)
//    public void missingUsername () {
//        String expectedTitle="Swag Labs";
//        String actualTitle=driver.getTitle();
//        Assert.assertEquals(expectedTitle,actualTitle);
//        driver.findElement(By.id("user-name")).sendKeys("");
//        System.out.println("enter username success");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        System.out.println("enter password success");
//        driver.findElement(By.id("login-button")).click();
//        System.out.println("click on login button success");
//        // validate the error message
//        String expectedError = "Epic sadface: Username is required";
//        String actualError = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
//        Assert.assertEquals(expectedError, actualError);
//        System.out.println("validate error success");
//    }
//
//    @Test
//    public void missingpassword () {
//        String expectedTitle="Swag Labs";
//        String actualTitle=driver.getTitle();
//        Assert.assertEquals(expectedTitle,actualTitle);
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        System.out.println("enter username success");
//        driver.findElement(By.id("password")).sendKeys("");
//        System.out.println("enter password success");
//        driver.findElement(By.id("login-button")).click();
//        System.out.println("click on login button success");
//        // validate the error message
//        String expectedError = "Epic sadface: Password is required";
//        String actualError = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
//        Assert.assertEquals(expectedError, actualError);
//        System.out.println("validate error success");
//    }
//}
//}
