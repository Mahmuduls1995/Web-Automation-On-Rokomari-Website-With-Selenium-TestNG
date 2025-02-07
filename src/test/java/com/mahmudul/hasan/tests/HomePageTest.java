package com.mahmudul.hasan.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mahmudul.hasan.basedrivers.BaseDriver;
import com.mahmudul.hasan.basedrivers.PageDriver;
import com.mahmudul.hasan.pages.FacebookLoginPage;
import com.mahmudul.hasan.pages.HomePage;import com.mahmudul.hasan.utilities.ExtendFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BaseDriver {

    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void startUrl(){
        PageDriver.getCurrentDriver().get(Url);
        report = ExtendFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Create An Account</b></p>")
                .assignAuthor("QA TEAM").assignDevice("Windows");
    }

    @Test(priority = 0)
    public void ClickOnSignIn() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Click On SignIn Button</b></p>");
        HomePage homePage = new HomePage(childTest);
        homePage.ClickOnSignIn();
    }

    @Test(priority = 1)
    public void ClickOnFacebookButton() throws IOException{
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Click On Facebook Button</b></p>");
        HomePage homePage = new HomePage(childTest);
        homePage.ClickOnFacebookButton();
    }

    @Test(priority = 2)
    public void Facebook_login() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Completed Facebook Login</b></p>");
        FacebookLoginPage login_page = new FacebookLoginPage(childTest);
        login_page.Facebooklogin();
    }

    @AfterClass
    public void afterClass() {
        report.flush();
    }
}