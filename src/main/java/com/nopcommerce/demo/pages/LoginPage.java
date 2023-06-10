package com.nopcommerce.demo.pages;

import com.aventstack.extentreports.Status;
import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;
    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;
    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;

    /*By welcomeText = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
    By emailField = By.id("Email");
    By passwordField = By.name("Password");
    By loginButton = By.xpath("//button[contains(text(),'Log in')]");
    By errorMessage = By.xpath("//div[@class='message-error validation-summary-errors']");*/

    public String getWelcomeText(){
        String message = getTextFromElement(welcomeText);
        log.info("Getting text from : " + welcomeText.toString());
        return message;
    }

    public void enterEmailId(String email){
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS,"Enter EmailId " + email);
        log.info("Enter email : "+ email + emailField.toString());
    }

    public void enterPassword(String password){
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password " + password);
        log.info("Enter password : "+ password + passwordField.toString());
    }

    public void clickOnLoginButton(){
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"Click on loginButton");
        log.info("Click on login Button : "+ loginButton.toString());
    }

    public String getErrorMessage(){
        String message = getTextFromElement(errorMessage);
        CustomListeners.test.log(Status.PASS,"Get errorMessage");
        log.info("Get error message "+ errorMessage.toString());
        return message;
    }
}
