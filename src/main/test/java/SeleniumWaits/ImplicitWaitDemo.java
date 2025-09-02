package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitDemo {

    // wait use krnne exceptions(errors) handle krnna

//    1)why do we get exceptions when interacting with web elements?
//       Reasons:
//             1. The element we try to interact/find is not at all present in the DOM
//             2. Element is present in the DOM but Not visible
//             3. Element is present in the DOM but not interactable(enabled)
//
//        DOM = Document Object Model(web page ekaka penna tiyena kotasa)
//
//    2) Why to do in this case?
//       Known solution for us : Thread.sleep(Ms);
//
//    3) Why to use Selenium waits?
//            time wasting adu krnw thread.sleep ekt wada
//
//    4) what are selenium waits?
//        Implicit, Explicit, FluentWait
//
//    5) Which one is better?

//    PageLoadTimeOut()
//
//    meka support krnnr driver.get() and driver.navigate().to() methods walata
//
//    adv: Can check performance issue in the web page
//    dis adv: time eka madi unm exception ekak return krnw


    WebDriver driver;

    @BeforeMethod
    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //meka thresd.sleep eka wage hamathanm dann ona na. eka parak dammam globally wada krnw eka
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1)); //page eka load krnw
        driver.get("https://leafground.com/waits.xhtml");
    }

    @Test
    public void implicitWaitTests(){

        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();

        String newBtnText = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span")).getText();
        System.out.println("New btn Text is : " + newBtnText);
//implicit wait eke dis adv ekak tami DOM eke interact wela nathi elememts check wen na
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
