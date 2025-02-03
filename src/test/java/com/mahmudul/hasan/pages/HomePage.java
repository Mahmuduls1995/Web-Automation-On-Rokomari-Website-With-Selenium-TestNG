package com.mahmudul.hasan.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.mahmudul.hasan.basedrivers.PageDriver;
import com.mahmudul.hasan.utilities.CommonMethods;
import com.mahmudul.hasan.utilities.Screenshots;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class HomePage extends CommonMethods {

    ExtentTest test;

    public HomePage(ExtentTest test) {

        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBys({
            @FindBy(xpath = "//a[contains(text(), 'Sign In')]"),
            @FindBy(xpath = "//a[contains(@class, 'navigation_SignIn__DAz0b') and @href='/login']")
    })
    WebElement signIn;

    @FindBys({
            @FindBy(xpath = "//button[contains(@class, 'btn-social-facebook')]"),
            @FindBy(xpath = "//button[contains(@onclick, 'callFacebookLogin')]")

    })
    WebElement Facebook;

    public void passCase(String message) {
        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
    }

    public void passCaseWithSC(String message, String scName) throws IOException {
        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
        String screenShotPath = Screenshots.capture(PageDriver.getCurrentDriver(), scName); // Capture screenshot
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + scName + ".png";
        test.info("Screenshot saved at: " + screenShotPath); // Add file path info to the report
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());// Attach screenshot
    }

    // Fail
    @SuppressWarnings({"unused", "unused"})
    public void failCase(String message, String scName) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>" + message + "</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);
        String screenShotPath = Screenshots.capture(PageDriver.getCurrentDriver(), scName);
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + scName + ".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        PageDriver.getCurrentDriver().quit();
    }

    public void ClickOnSignIn() throws IOException {
        test.info("Click on sign-in Button");
        try {
            if (signIn.isDisplayed()) {
                signIn.click();
                passCase("Sign-in Button Clicked");

            }
        } catch (Exception e) {
           failCase("No Sign-in Button", "ClickOnSignInFail");
        }
    }

    public void ClickOnFacebookButton() throws IOException {
        test.info("Facebook Button Click");
        try {
            if (Facebook.isDisplayed()) {
                Facebook.click();
                passCase("Facebook Button Clicked");
            }

        } catch (Exception e) {
            failCase("No Facebook Button", "ClickOnFacebookFail");
        }
    }


}