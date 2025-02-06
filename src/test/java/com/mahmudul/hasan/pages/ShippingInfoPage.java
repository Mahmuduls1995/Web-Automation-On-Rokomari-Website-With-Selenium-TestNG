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

    @FindBy(xpath = "//label[@for='B_KASH']//img[@alt='Pay by Bkash']")
    public WebElement ClickOnBkashCheckBox;

//    @FindBy(xpath = "//label[contains(text(), 'রকমারির শর্তাবলীতে সম্মতি প্রদান করছি ৷')]")
    @FindBy(xpath = "//label[@for='js--terms-checkbox']")
    public WebElement ClickOnTerm;

    @FindBy(xpath = "//button[@id='js--confirm-order']")
    public WebElement ConFirmOrderButton;

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

    public void AlternativePhoneNumberGiven() throws IOException {
        test.info("Giving Alternative Phone Number");
        try {
            if (AlternativePhoneNum.isDisplayed()) {
                AlternativePhoneNum.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                sendText(AlternativePhoneNum, "01700000000");
                sleep();
                passCase("Alternative Phone Number Given");
            }

        } catch (Exception e) {
            failCase("Alternative Phone Number not locateable", "AlternativePhoneNumberFail");
        }
    }

    public void CountrySelected() throws IOException {
        test.info("Selecting Country");
        try {
            if (CountryDropDown.isDisplayed()) {
                CountryDropDown.click();
                selectItemByIndex(CountryDropDown, 0);
                sleep();
                passCase("Country Selected");
            }

        } catch (Exception e) {
            failCase("Country not locateable", "CountryFail");
        }
    }

    public void CityDropDown() throws IOException {
        test.info("Selecting City");
        try {
            if (CityDropDown.isDisplayed()) {
                CityDropDown.click();
                selectItemByIndex(CityDropDown, 8);
                sleep();
                passCase("City Selected");
            }

        } catch (Exception e) {
            failCase("City not locateable", "CityFail");
        }
    }

    public void AreaDropDown() throws IOException {
        test.info("Selecting Area");
        try {
            if (AreaDropDown.isDisplayed()) {
                AreaDropDown.click();
                selectItemByIndex(AreaDropDown, 5);
                sleep();
                passCase("Area Selected");
            }

        } catch (Exception e) {
            failCase("Area not locateable", "AreaFail");
        }
    }

    public void ZoneDropDown() throws IOException {
        test.info("Selecting Zone");
        try {
            if (ZoneDropDown.isDisplayed()) {
                ZoneDropDown.click();
                selectItemByIndex(ZoneDropDown, 5);
                sleep();
                passCase("Zone Selected");
            }

        } catch (Exception e) {
            failCase("Zone not locateable", "ZoneFail");
        }
    }

    public void AddressInputField() throws IOException {
        test.info("Input Address");
        try {
            if (Address.isDisplayed()) {
                Address.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                sendText(Address, "Beside debidwar, Upazila: Debidwar, District: Comilla");
                sleep();
                passCase("Address Given");
            }

        } catch (Exception e) {
            failCase("Address not locateable", "AddressFail");
        }
    }

    public void ClickOnBkashCheckBox() throws IOException {
        test.info("Click On Bkash CheckBox");
        try {
            if (ClickOnBkashCheckBox.isDisplayed()) {
                ClickOnBkashCheckBox.click();
                sleep();
                passCase("Bkash CheckBox Clicked");
            }

        } catch (Exception e) {
            failCase("Bkash CheckBox not locateable", "BkashCheckBoxFail");
        }
    }

private boolean isTermClicked = true;
public void ClickOnTerm() throws IOException {
    test.info("Click On Term CheckBox");
    try {
        if (ClickOnTerm.isDisplayed() && !isTermClicked) {
            ClickOnTerm.click();
            isTermClicked = true;
            sleep();
            passCase("Term CheckBox Clicked");
        } else {
            test.info("Term CheckBox was already clicked");
        }
    } catch (Exception e) {
        failCase("Term CheckBox not locateable", "TermCheckBoxFail");
    }
}


    public void ConfirmOrderButton() throws IOException {
        test.info("Click On Confirm Order Button");
        try {
            if (ConFirmOrderButton.isDisplayed()) {
                ConFirmOrderButton.click();
                sleep();
                passCase("Place Order Button Clicked");
                passCaseWithSC("Place Order Button Clicked", "ConFirmOrderButtonPass");
            }

        } catch (Exception e) {
            failCase("Place Order Button not locateable", "ConFirmOrderButtonFail");
        }
        sleep();
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

