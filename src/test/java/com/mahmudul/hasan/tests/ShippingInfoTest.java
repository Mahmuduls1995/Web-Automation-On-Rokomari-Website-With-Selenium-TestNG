package com.mahmudul.hasan.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mahmudul.hasan.basedrivers.BaseDriver;
import com.mahmudul.hasan.basedrivers.PageDriver;
import com.mahmudul.hasan.pages.ShippingInfoPage;
import com.mahmudul.hasan.utilities.ExtendFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class ShippingInfoTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;
//Sheikhmahmudul95@gmail.com   mahmud1995
    @BeforeClass
    public void Parent() throws InterruptedException {
        PageDriver.getCurrentDriver().get(ShippingUrl);
        Thread.sleep(9000);
        report = ExtendFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Shipping Information</b></p>")
                .assignAuthor("QA TEAM").assignDevice("Windows");
    }

    @Test(priority = 0)
    public void NameGiven() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Provide Name</b></p>");
        ShippingInfoPage NameGiven = new ShippingInfoPage(childTest);
        NameGiven.NameGiven();
    }

    @Test(priority = 1)
    public void PhoneNumberGiven() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Provide Phone Number</b></p>");
        ShippingInfoPage PhoneNumberGiven = new ShippingInfoPage(childTest);
        PhoneNumberGiven.PhoneNumberGiven();
    }


    @AfterClass
    public void afterClass() {
        report.flush();
    }
}
