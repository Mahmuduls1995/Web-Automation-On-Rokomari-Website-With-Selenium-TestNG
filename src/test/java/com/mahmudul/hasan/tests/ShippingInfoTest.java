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
//        PageDriver.getCurrentDriver().get(ShippingUrl);
//        Thread.sleep(9000);
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

    @Test(priority = 2)
    public void AlterNativePhoneNum() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Provide Alternative Phone Number</b></p>");
        ShippingInfoPage AlterNativePhoneNum = new ShippingInfoPage(childTest);
        AlterNativePhoneNum.AlternativePhoneNumberGiven();
    }

    @Test(priority = 3)
    public void CountryDropDown() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Provide Country</b></p>");
        ShippingInfoPage CountryDropDown = new ShippingInfoPage(childTest);
        CountryDropDown.CountrySelected();
    }


    @Test(priority = 4)
    public void CityDropDown() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Provide City</b></p>");
        ShippingInfoPage CityDropDown = new ShippingInfoPage(childTest);
        CityDropDown.CityDropDown();
    }
    @Test(priority = 5)
    public void AreaDropDown() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Provide Area</b></p>");
        ShippingInfoPage AreaDropDown = new ShippingInfoPage(childTest);
        AreaDropDown.AreaDropDown();
    }

    @Test (priority = 6)
    public void ZoneDropDown() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Provide Zone</b></p>");
        ShippingInfoPage ZoneDropDown = new ShippingInfoPage(childTest);
        ZoneDropDown.ZoneDropDown();
    }

    @Test (priority = 7)
    public void AddressGiven() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Provide Address</b></p>");
        ShippingInfoPage AddressGiven = new ShippingInfoPage(childTest);
        AddressGiven.AddressInputField();
    }

    @Test (priority = 8)
    public void ClickOnBkashCheckBox() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Click On Bkash CheckBox</b></p>");
        ShippingInfoPage ClickOnBkashCheckBox = new ShippingInfoPage(childTest);
        ClickOnBkashCheckBox.ClickOnBkashCheckBox();
    }



    @Test (priority = 9)
    public void ClickOnTerm() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Click On Term</b></p>");
        ShippingInfoPage ClickOnTerm = new ShippingInfoPage(childTest);
        ClickOnTerm.ClickOnTerm();
    }

    @Test(priority = 10)
    public void ClickOnPlaceOrder() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Click On Place Order</b></p>");
        ShippingInfoPage ClickOnPlaceOrder = new ShippingInfoPage(childTest);
        ClickOnPlaceOrder.ConfirmOrderButton();
    }



    @AfterClass
    public void afterClass() {
        report.flush();
    }
}
