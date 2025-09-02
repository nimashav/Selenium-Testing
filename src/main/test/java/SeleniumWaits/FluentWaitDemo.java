package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitDemo {

    WebDriver driver;

    @BeforeMethod
    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/waits.xhtml");
    }

    @Test
    public void fluentWaitTest(){


        //declaration
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                               .withTimeout(Duration.ofSeconds(30)) //Maximum time to wait
                               .pollingEvery(Duration.ofSeconds(5)) //Frequency to check the condition
                               .ignoring(NoSuchElementException.class); //ignore specific excptions //selenium walin tami exception eka ghnn ona


        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();

        //1 st way(standard way)
        WebElement fluentwaitElement = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
               return driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span"));
            }
        });

        //2nd way
        //WebElement fluentwaitElement = wait.until(ExpectedConditions.visibilityOfElementLocated(newBtnLocator));


        String newBtnText = fluentwaitElement.getText();
        System.out.println("New btn Text is : " + newBtnText);

    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
