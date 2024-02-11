package com.inetbanking.testCases;

import com.inetbanking.utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String baseURL = readConfig.getApplicationURL();
    public  String username = readConfig.getUsername();
    public String password = readConfig.getPassword();
    public static WebDriver driver;

    @BeforeClass
    public void setup()
    {   System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}

