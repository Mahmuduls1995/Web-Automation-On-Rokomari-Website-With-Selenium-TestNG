package com.mahmudul.hasan.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mahmudul.hasan.basedrivers.BaseDriver;
import com.mahmudul.hasan.basedrivers.PageDriver;
import com.mahmudul.hasan.pages.AddToCartPage;
import com.mahmudul.hasan.utilities.ExtendFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartTest extends BaseDriver {
    ExtentReports report;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void startUrl(){
        PageDriver.getCurrentDriver().get(UrlCart);
        report = ExtendFactory.getInstance();
        parentTest = report.createTest("<p style=\"color:DarkBlue; font-size:20px\"><b>Add To Cart</b></p>")
                .assignAuthor("QA TEAM").assignDevice("Windows");
    }

    @Test(priority = 0)
    public void FirstBookHover() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Hover On First Book</b></p>");
        AddToCartPage FirstBookHover = new AddToCartPage(childTest);
        FirstBookHover.HoverOnFirstBook();
    }

    @Test(priority = 1)
    public void FirstBookInAddToCart() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>First Book To Cart</b></p>");
        AddToCartPage FirstBookInAddToCart = new AddToCartPage(childTest);
        FirstBookInAddToCart.AddFirstBookToCart();
    }

    @Test(priority = 2)
    public void SecondBookHover() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Hover On Second Book </b></p>");
        AddToCartPage SecondBookHover = new AddToCartPage(childTest);
        SecondBookHover.HoverOnSecondBook();
    }

    @Test(priority = 3)
    public void SecondBookInAddToCart() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Second Book To Cart</b></p>");
        AddToCartPage SecondBookInAddToCart = new AddToCartPage(childTest);
        SecondBookInAddToCart.AddSecondBookToCart();
    }
    @Test(priority = 4)
    public void ThirdBookHover() throws IOException {
        childTest = parentTest
                .createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Hover On Third Book </b></p>");
        AddToCartPage ThirdBookHover = new AddToCartPage(childTest);
        ThirdBookHover.HoverOnThirdBook();
    }

    @Test(priority = 5)
    public void ThirdBookInAddToCart() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Third Book To Cart</b></p>");
        AddToCartPage ThirdBookInAddToCart = new AddToCartPage(childTest);
        ThirdBookInAddToCart.AddThirdBookToCart();
    }

    @Test(priority = 6)
    public void ClickOnCartIcon() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Click On Cart Icon</b></p>");
        AddToCartPage clickOnCartIcon = new AddToCartPage(childTest);
        clickOnCartIcon.ClickOnCartIcon();
    }
    @Test(priority = 7)
    public void RemoveFirstElement() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Remove First Element</b></p>");
        AddToCartPage removeFirstElement = new AddToCartPage(childTest);
        removeFirstElement.RemoveFirstElement();
    }
    @Test(priority = 8)
    public void ConfirmRemoveFirstElement() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Remove Second Element</b></p>");
        AddToCartPage removeSecondElement = new AddToCartPage(childTest);
        removeSecondElement.ConfirmRemoveFirstElement();
    }


    @Test(priority = 9)
    public void UndoRemoveFirstElement() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Undo Remove First Element</b></p>");
        AddToCartPage undoRemoveFirstElement = new AddToCartPage(childTest);
        undoRemoveFirstElement.UndoRemoveFirstElement();
    }

    @Test(priority = 10)
    public void ProceedToCheckout() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:DarkBlue; font-size:20px\"><b>Proceed To Checkout</b></p>");
        AddToCartPage proceedToCheckout = new AddToCartPage(childTest);
        proceedToCheckout.ProceedToCheckout();
    }



    @AfterClass
    public void afterClass() {
        report.flush();
    }





}
