package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.logging.Logger;
import com.aventstack.extentreports.ExtentReports;



public class testCaseLogin extends BaseClass {

   public static Logger logger = Logger.getLogger(String.valueOf(testCaseLogin.class));

    @Test
    public void loginTest() {
        driver.get(baseURL);
        logger.info("Opened URL");
        System.out.println("hi");

        LoginPage lp = new LoginPage(driver);
        lp.setUsername(username);
        logger.info("Entered username");

        lp.setPassword(password);
        logger.info("Entered password");

        lp.clickLogin();
        System.out.println(driver.getCurrentUrl());

        if (driver.getTitle().equals(" Guru99 Bank Manager HomePage "))
        {Assert.assertTrue(true);
        }
        else {
            Assert.assertFalse(false);
        }
        logger.info("Login test passed");
    }
}

