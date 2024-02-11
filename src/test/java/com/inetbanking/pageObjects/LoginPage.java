package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver ldriver;

    public LoginPage(WebDriver rdriver)
    {ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
    @FindBy(name = "uid")
    WebElement Username;

    @FindBy(name="password")
    WebElement Password;

    @FindBy(name="btnLogin")
    WebElement Login;

    public void setUsername (String a)
    {Username.sendKeys(a);}

    public void setPassword (String b)
    {Password.sendKeys(b);}

    public void clickLogin()
    {Login.click();}

}
