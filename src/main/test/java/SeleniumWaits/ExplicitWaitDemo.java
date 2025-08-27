package SeleniumWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitDemo {

    WebDriver driver;

    @BeforeMethod
    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/waits.xhtml");
    }

    //implicit wait ekt wada efficient
    //condition use krnn puluwn
    //globally handle krn ba. hama element ektm statement liyn wenw.
    // implicit and explicit mix eke use krnne na.

    @Test
    public void explicitWaitTest(){

        //declaration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();

        By newBtnLocator = By.xpath("//button[@id='j_idt87:j_idt90']/span");

        //Usage
        WebElement NewBTNElement = wait.until(ExpectedConditions.visibilityOfElementLocated(newBtnLocator));

        String newBtnText = NewBTNElement.getText();

        System.out.println("New btn Text is : " + newBtnText);
    }
}
