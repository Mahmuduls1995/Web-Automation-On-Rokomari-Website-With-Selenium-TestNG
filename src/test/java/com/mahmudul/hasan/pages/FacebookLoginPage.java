package com.mahmudul.hasan.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.mahmudul.hasan.basedrivers.PageDriver;
import com.mahmudul.hasan.utilities.CommonMethods;
import com.mahmudul.hasan.utilities.ExcelUtils;
import com.mahmudul.hasan.utilities.Screenshots;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class FacebookLoginPage extends CommonMethods {
    ExtentTest test;
    ExcelUtils excelutils = new ExcelUtils();

    // Locator for the email field
    @FindBys({@FindBy(xpath = "//input[@placeholder='Email address or phone number']")})
    WebElement number;
    @FindBys({@FindBy(xpath = "//input[@name='pass']")})
    WebElement password;
    @FindBys({@FindBy(xpath = "//button[@name='login']")})
    WebElement login_button;


    // Locator for the login button

    public FacebookLoginPage(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

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


    public void Facebooklogin() throws IOException {
        try {
            // Read credentials from Excel
            excelutils.ReadExcel();
            test.info("Please enter the email or phone number");

            // Wait for the phone number field to be visible
            WebDriverWait wait = new WebDriverWait(PageDriver.getCurrentDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(number));
            if (number.isDisplayed()) {
                number.sendKeys(ExcelUtils.number);
                passCase("Phone number entered successfully");
                sleep();
                test.info("Please enter the password");
                wait.until(ExpectedConditions.visibilityOf(password));

                if (password.isDisplayed()) {
                    password.sendKeys(ExcelUtils.password);
                    passCase("Password entered successfully");
                    sleep();

                    test.info("Please click the login button");
                    wait.until(ExpectedConditions.elementToBeClickable(login_button));

                    if (login_button.isDisplayed()) {
                        login_button.click();
                        sleep();
                        passCaseWithSC("You successfully logged in", "login_success");
                    } else {
                        failCase("Login button not found", "login_button_not_found");
                    }
                } else {
                    failCase("Password field not found", "password_field_not_found");
                }
            } else {
                failCase("Phone number field not found", "phone_field_not_found");
            }
        } catch (Exception e) {
            failCase("Exception occurred: " + e.getMessage(), "exception_occurred");
        }
    }






}
