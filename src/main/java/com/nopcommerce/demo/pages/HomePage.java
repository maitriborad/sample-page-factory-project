package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class);
    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;
    /*By loginLink = By.linkText("Log in");
    By registerLink = By.linkText("Register");*/

    public void clickOnLoginLink(){
        clickOnElement(loginLink);
        log.info("Clicking on login link : " + loginLink.toString());
    }

    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
        log.info("Clicking on register link : " + registerLink.toString());
    }
}
