package com.mahmudul.hasan.tests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mahmudul.hasan.basedrivers.BaseDriver;
import com.mahmudul.hasan.basedrivers.PageDriver;
import com.mahmudul.hasan.pages.WriterPage;
import com.mahmudul.hasan.utilities.ExtendFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.IOException;

public class WriterTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void startUrl(){
        PageDriver.getCurrentDriver().get(Url);
        report = ExtendFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Select Writer</b></p>")
                .assignAuthor("QA TEAM").assignDevice("Windows");
    }

    @Test(priority = 0)
    public void WriterPath() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Click On writer Path</b></p>");
        WriterPage writerPath = new WriterPage(childTest);
        writerPath.Writer();
    }

    @Test(priority = 1)
    public void WriterSelected() throws IOException{
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Select the Writer</b></p>");
        WriterPage selectWriterName = new WriterPage(childTest);
        selectWriterName.WriterSelected();
    }
    @Test(priority = 2)
    public void BestSellerFilterClick() throws IOException{
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Click On Best Seller Option</b></p>");
        WriterPage bestSellerBook = new WriterPage(childTest);
        bestSellerBook.BestSellerFilterClick();
    }


    @Test(priority = 3)
    public void ScrollDown() throws IOException{
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Scroll Down To The Category Section</b></p>");
        WriterPage scrollDown = new WriterPage(childTest);
        scrollDown.ScrollDownToCategorySection();
    }

    @AfterClass
    public void afterClass(){
        report.flush();
    }
}
