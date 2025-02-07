package com.mahmudul.hasan.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mahmudul.hasan.basedrivers.BaseDriver;
import com.mahmudul.hasan.basedrivers.PageDriver;
import com.mahmudul.hasan.pages.GooglePage;
import com.mahmudul.hasan.utilities.ExtendFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class GooglePageTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void Parent() {
//        PageDriver.getCurrentDriver().get(Urllogin);
//        PageDriver.getCurrentDriver().manage().window().maximize();
        report = ExtendFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Google LogIn</b></p>")
                .assignAuthor("QA TEAM").assignDevice("Windows");

    }

    @Test(priority = 0)
    public void EmailAddress() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Provide Email Address</b></p>");
        GooglePage UserEmail = new GooglePage(childTest);
        UserEmail.TypeEmailAddress();
    }

    @Test(priority = 1)
    public void ClickOnNextButton() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Click On Next Button</b></p>");
        GooglePage ClickOnNextButton = new GooglePage(childTest);
        ClickOnNextButton.ClickOnEmailNextButton();
    }

    @Test(priority = 2)
    public void EmailPassword() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Provide Password</b></p>");
        GooglePage EmailPassword = new GooglePage(childTest);
        EmailPassword.EmailPassword();
    }

    @Test(priority = 3)
    public void ClickOnPasswordNextButton() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Click On Next Button</b></p>");
        GooglePage ClickOnPasswordNextButton = new GooglePage(childTest);
        ClickOnPasswordNextButton.ClickOnPasswordNextButton();
    }

    @AfterClass
    public void afterClass() {
        report.flush();
    }
}
