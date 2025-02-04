package com.mahmudul.hasan.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.mahmudul.hasan.basedrivers.PageDriver;
import com.mahmudul.hasan.utilities.CommonMethods;
import com.mahmudul.hasan.utilities.Screenshots;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class AddToCartPage extends CommonMethods {

    ExtentTest test;

    public AddToCartPage(ExtentTest test) {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
        this.test = test;
    }

    @FindBy(xpath = "//div[@class='books-wrapper__item' and @title='অপেক্ষা হুমায়ূন আহমেদ']")
    public WebElement FirstBookHover;

    @FindBy(xpath = "//button[@product-id=\"222273\"]")
    public WebElement FirstBookToCart;

    @FindBy(xpath = "//div[@class='books-wrapper__item' and @title='তোমাকে হুমায়ূন আহমেদ']")
    public WebElement SecondBookHover;

    @FindBy(xpath = "//button[@product-id=\"884\"]")
    public WebElement SecondBookToCart;

    @FindBy(xpath = "//div[@class='books-wrapper__item' and @title='হিমু সমগ্র হুমায়ূন আহমেদ']")
    public WebElement ThirdBookHover;

    @FindBy(xpath = "//button[@product-id=\"201\"]")
    public WebElement ThirdBookToCart;

    @FindBy(xpath = "//a[@id='js-cart-menu']")
    public WebElement ClickOnCartIcon;


    @FindBy(xpath = "//a[@data-product-name='হিমু সমগ্র']")
    public WebElement RemoveFirstBook;

    @FindBy(xpath = "//button[contains(text(),'হ্যাঁ')]")
    public WebElement ConfirmRemoveFirstBook;

    @FindBy(xpath = "//strong[contains(text(),'Undo')]")
    public WebElement UndoRemoveFirstBook;

    @FindBy(xpath = " //span[contains(text(),'Proceed to Checkout')]")
    public WebElement ProceedToCheckout;


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


    public void HoverOnFirstBook() throws IOException {
        test.info("Hover on First Book");
        try {
            if (FirstBookHover.isDisplayed()) {
                sleep();
                hover(FirstBookHover);
                sleep();
                passCase("Hover on First Book");
//                passCaseWithSC("Hover on First Book", "HoverOnFirstBook");
            }
        } catch (Exception e) {
            failCase("Hover on First Book", "HoverOnFirstBook");
        }
    }

    public void AddFirstBookToCart() throws IOException {
        test.info("Add First Book to Cart");
        try {
            if (FirstBookToCart.isDisplayed()) {
                FirstBookToCart.click();
                sleep();
                passCase("First Book Added to Cart");
//                passCaseWithSC("First Book Added to Cart", "FirstBookAddedToCart");
            }
        } catch (Exception e) {
            failCase("First Book Added to Cart", "FirstBookAddedToCart");
        }
    }

    public void HoverOnSecondBook() throws IOException {
        test.info("Hover on Second Book");
        try {
            if (SecondBookHover.isDisplayed()) {
                sleep();
                hover(SecondBookHover);
                sleep();
                passCase("Hover on Second Book");
//                passCaseWithSC("Hover on Second Book", "HoverOnSecondBook");
            }
        } catch (Exception e) {
            failCase("Hover on Second Book", "HoverOnSecondBook");
        }
    }

    public void AddSecondBookToCart() throws IOException {
        test.info("Add Second Book to Cart");
        try {
            if (SecondBookToCart.isDisplayed()) {
                SecondBookToCart.click();
                sleep();
                passCase("Second Book Added to Cart");
//                passCaseWithSC("Second Book Added to Cart", "SecondBookAddedToCart");
            }
        } catch (Exception e) {
            failCase("Second Book Added to Cart", "SecondBookAddedToCart");
        }
    }

    public void HoverOnThirdBook() throws IOException {
        test.info("Hover on Third Book");
        try {
            if (ThirdBookHover.isDisplayed()) {
                sleep();
                hover(ThirdBookHover);
                sleep();
                passCase("Hover on Third Book");
//                passCaseWithSC("Hover on Third Book", "HoverOnThirdBook");
            }
        } catch (Exception e) {
            failCase("Hover on Third Book", "HoverOnThirdBook");
        }
    }

    public void AddThirdBookToCart() throws IOException {
        test.info("Add Third Book to Cart");
        try {
            if (ThirdBookToCart.isDisplayed()) {
                ThirdBookToCart.click();
                sleep();
                passCase("Third Book Added to Cart");
//                passCaseWithSC("Third Book Added to Cart", "ThirdBookAddedToCart");
            }
        } catch (Exception e) {
            failCase("Third Book Added to Cart", "ThirdBookAddedToCart");
        }
    }


    public void ClickOnCartIcon() throws IOException {
        test.info("Click on Cart Icon");
        try {
            if (ClickOnCartIcon.isDisplayed()) {
                ClickOnCartIcon.click();
                sleep();
                passCase("Cart Icon Clicked");
                passCaseWithSC("Cart Icon Clicked", "CartIconClicked");
            }
        } catch (Exception e) {
            failCase("Cart Icon Clicked", "CartIconClicked");
        }
    }

    public void RemoveFirstElement() throws IOException {
        test.info("Remove First Element");
        try {
            if (RemoveFirstBook.isDisplayed()) {
                RemoveFirstBook.click();
                sleep();
                passCase("First Element Removed");
//                passCaseWithSC("First Element Removed", "FirstElementRemoved");
            }
        } catch (Exception e) {
            failCase("First Element Removed", "FirstElementRemoved");
        }
    }

    public void ConfirmRemoveFirstElement() throws IOException {
        test.info("Confirm Remove First Element");
        try {
            if (ConfirmRemoveFirstBook.isDisplayed()) {
                ConfirmRemoveFirstBook.click();
                sleep();
                passCase("First Element Removed");
//                passCaseWithSC("First Element Removed", "FirstElementRemoved");
            }
        } catch (Exception e) {
            failCase("First Element Removed", "FirstElementRemoved");
        }
    }

    public void UndoRemoveFirstElement() throws IOException {
        test.info("Undo Remove First Element");
        try {
            if (UndoRemoveFirstBook.isDisplayed()) {
                UndoRemoveFirstBook.click();
                sleep();
                passCase("First Element Removed");
//                passCaseWithSC("First Element Removed", "FirstElementRemoved");
            }
        } catch (Exception e) {
            failCase("First Element Removed", "FirstElementRemoved");
        }
    }

    public void ProceedToCheckout() throws IOException {
        test.info("Proceed to Checkout");
        try {
            if (ProceedToCheckout.isDisplayed()) {
                ProceedToCheckout.click();
                sleep();
                passCase("Proceed to Checkout");
               passCaseWithSC("Proceed to Checkout", "ProceedToCheckout");
            }
        } catch (Exception e) {
            failCase("Proceed to Checkout", "ProceedToCheckout");
        }
    }



}
