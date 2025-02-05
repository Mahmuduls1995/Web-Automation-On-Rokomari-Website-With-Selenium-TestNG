package com.mahmudul.hasan.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.mahmudul.hasan.basedrivers.PageDriver;
import com.mahmudul.hasan.utilities.CommonMethods;
import com.mahmudul.hasan.utilities.Screenshots;
import junit.framework.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ShippingInfoPage extends CommonMethods {
    ExtentTest test;

    public ShippingInfoPage(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBy(xpath = "//div[@class=\"shipping-form-container\"]//input[@name=\"name\"]")
    public WebElement Name;

    @FindBy(xpath = "//input[@name=\"phone\"]")
    public WebElement PhoneNumber;

    @FindBy(xpath = "//input[@class=\"js--alternative-phone\"]")
    public WebElement AlternativePhoneNum;

    @FindBy(xpath = "//select[@id='js--country']")
    public WebElement CountryDropDown;

    @FindBy(xpath = "//select[@id='js--city']")
    public WebElement CityDropDown;

    @FindBy(xpath = "//select[@id='js--area']")
    public WebElement AreaDropDown;

    @FindBy(xpath = "//select[@id='js--zone']")
    public WebElement ZoneDropDown;

    @FindBy(xpath = "//fieldset//textarea[@name=\"address\"]")
    public WebElement Address;

    @FindBy(xpath = "//input[@id='bkash']")
    public WebElement ClickOnBkashCheckBox;

    @FindBy(xpath = "//label[contains(text(),'এই শর্তগুলো মেনে অর্ডার প্রদান করছি।')]")
    public WebElement ClickOnTerm;

//    @FindBy(xpath = "//button[@id='js--confirm-order']")
//    public WebElement ConFirmOrderButton;

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



    public void NameGiven() throws IOException {
        test.info("Giving Name");
        try {
            if (Name.isDisplayed()) {
                Name.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                sendText(Name, "Sheikh Mahmudul Hasan");
                sleep();
                passCase("Name Given");
            }

        } catch (Exception e) {
            failCase("Name not locateable", "NameFail");
        }
    }

    public void PhoneNumberGiven() throws IOException {
        test.info("Giving Phone Number");
        try {
            if (PhoneNumber.isDisplayed()) {
                PhoneNumber.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                sendText(PhoneNumber, "01700000000");
                sleep();
                passCase("Phone Number Given");
            }

        } catch (Exception e) {
            failCase("Phone Number not locateable", "PhoneNumberFail");
        }
    }


}

//    public void ConfirmOrderButton() throws IOException {
//        test.info("Click On Confirm Order Button");
//        try {
//            if (ConFirmOrderButton.isDisplayed()) {
//                ConFirmOrderButton.click();
//                test.pass("<p style=\"color:green; font-size:13px\"><b>Place Order Button Clicking Pass</b></p>");
//                timeOut(4000);
//                @SuppressWarnings("unused")
//                String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "ConFirmOrderButtonPass");
//                String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ConFirmOrderButtonPass.png";
//                test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
//            }
//
//        } catch (Exception e) {
//            test.fail("<p style=\"color:red; font-size:13px\"><b> Place Order Button not locateable.</b></p>");
//            Throwable t = new InterruptedException("Exception");
//            test.fail(t);
//            @SuppressWarnings("unused")
//            String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), "ConFirmOrderButtonFail");
//            String dest = System.getProperty("user.dir") + "\\screenshots\\" + "ConFirmOrderButtonFail.png";
//            test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
//            Assert.assertTrue(ConFirmOrderButton.isDisplayed());
//        }
//        timeOut(5000);
//    }

