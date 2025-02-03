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

public class WriterPage extends CommonMethods {
    ExtentTest test;

    public WriterPage(ExtentTest test) {

        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBys({@FindBy(xpath = "//a[contains(@class, 'menu_menuLink___xE7K') and .//span[contains(@class, 'menu_menuTitle__C8CK0') and text()='লেখক']]")})
    WebElement WriterPath;

    @FindBys({@FindBy(xpath = "//a[contains(text(),'হুমায়ূন আহমেদ')]")})
    WebElement WriterChoice;

    @FindBy(xpath = "//label[contains(text(),'Best Seller')]")
    public WebElement BestSellerCheckBox;

    @FindBy(xpath = "//div[@class='product-sort__content p-0']")
    public WebElement Categories_Ids;

//    @FindBy(xpath = "//label[contains(text(),'পশ্চিমবঙ্গের বই: শিশু-কিশোর বই')]")
//    public WebElement FilterCheckBox_1;
//
//    @FindBy(xpath = "//label[contains(text(),'শিশু-কিশোর: রহস্য, গোয়েন্দা, ভৌতিক, থ্রিলার ও অ্যা')]")
//    public WebElement FilterCheckBox_2;
//
//
//    @FindBy(xpath = "//a[contains(text(),'Next')]")
//    public WebElement satyajitRayNextPage;
//
//    @FindBy(xpath = "//a[contains(text(),'Previous')]")
//    public WebElement satyajitRayPreviousPage;
//
//    @FindBy(xpath = "//h1[contains(text(),'সত্যজিৎ রায় এর বই সমূহ')]")
//    public WebElement SelectBookDiv;


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

    public void Writer() throws IOException {
        test.info("Hover on Writer Path");
        try {
            if (WriterPath.isDisplayed()) {
                sleep();
                hover(WriterPath);
                passCase("Writer Path Hovering");
            }
        } catch (Exception e) {
            failCase("Writer Path Hovering not locatable", "WriterListShowFail");
        }
    }

    public void WriterSelected() throws IOException {
        test.info("Writer Select");
        try {
            if (WriterChoice.isDisplayed()) {

                WriterChoice.click();
                sleep();
                passCase("Writer Selected");
            }
        } catch (Exception e) {
            failCase("Writer Selection not locatable", "WriterSelectionFail");
        }

    }

    public void BestSellerFilterClick() throws IOException {
        test.info("Best Seller Filtering");
        try {
            if (BestSellerCheckBox.isDisplayed()) {
                BestSellerCheckBox.click();
                sleep();
                passCase("Best Seller Filter Clicked");
//                sleep();
            }

        } catch (Exception e) {
            failCase("Best Seller Filter not locatable", "BestSellerFilterFail");
        }
        sleep();
    }


    public void ScrollDownToCategorySection() throws IOException{
        test.info("Scrolling");
        try {
            if (Categories_Ids.isDisplayed()) {
                scrollToElement(Categories_Ids);
                sleep();
                passCase("<p style=\"color:green; font-size:13px\"><b>scrolling Success</b></p>");
            }

        } catch (Exception e) {
            failCase("<p style=\"color:red; font-size:13px\"><b>scrolling Fail</b></p>", "ScrollingFail");
        }
        sleep();
    }



}
