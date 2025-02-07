package com.mahmudul.hasan.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.mahmudul.hasan.basedrivers.PageDriver;
import com.mahmudul.hasan.utilities.CommonMethods;
import com.mahmudul.hasan.utilities.Screenshots;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class GooglePage extends CommonMethods {
    ExtentTest test;

    public GooglePage(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }
    //input[@name="username"]   //input[@id="identifierId"]
    @FindAll({ @FindBy(xpath = "//input[@placeholder='Email or phone']") })
    WebElement UserEmail;

    //button[.//span[text()='Next']]
    @FindAll({ @FindBy(xpath = "//button[text()='Next']") })
    WebElement NextButton;

    //input[@aria-label='Enter your password']
    @FindAll({
            @FindBy(xpath = "//input[@placeholder=\"Password\"]") })
    WebElement Password;

    //button[.//span[text()='Next']]
    @FindAll({ @FindBy(xpath = "//body[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[2]/form[1]/button[1]") })
    WebElement ClickAfterPasswordButton;

    public void passCase(String message) {
        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
    }

    @SuppressWarnings("unused")
    public void passCaseWithSC(String message, String scName) throws IOException {
        test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>" + message + "</b></p>");
        String screenShotPath = Screenshots.capture(PageDriver.getCurrentDriver(), scName); // Capture screenshot
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + scName + ".png";
        test.info("Screenshot saved at: " + screenShotPath); // Add file path info to the report
        test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());// Attach screenshot
    }

    // Fail
    @SuppressWarnings("unused")
    public void failCase(String message, String scName) throws IOException {
        test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>" + message + "</b></p>");
        Throwable t = new InterruptedException("Exception");
        test.fail(t);
        String screenShotPath = Screenshots.capture(PageDriver.getCurrentDriver(), scName);
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + scName + ".png";
        test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
        PageDriver.getCurrentDriver().quit();
    }


    public void TypeEmailAddress() throws IOException {
        test.info("Provide Your Email Address");
        try {
            if (UserEmail.isDisplayed()) {
                sendText(UserEmail, "Sheikhmahmudul95@gmail.com");
                sleep();
                passCase("Email Enter");

            }

        } catch (Exception e) {
            failCase("Email Address not locatable.", "UserEmailFail");
        }

    }

    public void ClickOnEmailNextButton() throws IOException {
        test.info("Click On Next Button");
        try {
            if (NextButton.isDisplayed()) {
                NextButton.click();
                sleep();
                passCase("Next Button");
            }

        } catch (Exception e) {
            failCase("UserName Next Button not locatable.", "ClickOnNextButtonFail");
        }
        sleep(9000);
    }

    public void EmailPassword() throws IOException {
        test.info("Provide Email Password");
        try {
            if (Password.isDisplayed()) {
                Password.click();
                sendText(Password, "mahmud1995");
                sleep();
                passCase("Password Enter");
            }

        } catch (Exception e) {
            failCase("Password not locatable.", "PasswordFail");
        }
    }

    public void ClickOnPasswordNextButton() throws IOException {
        test.info("Click On Password Next Button");
        try {
            if (ClickAfterPasswordButton.isDisplayed()) {
                ClickAfterPasswordButton.click();
                sleep();
                passCase("Password Next Button");
            }

        } catch (Exception e) {
            failCase("Password Next Button not locatable.", "ClickAfterPasswordButtonFail");
        }
        sleep();
    }
}
