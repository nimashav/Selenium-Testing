import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class ActionKeyBoardOperationExample {

    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void KeyboardOperationsTest1() throws InterruptedException {
        driver.get("http://www.google.com");
        WebElement googleSerchTextBox = driver.findElement(By.name("q"));
        googleSerchTextBox.sendKeys("welcome");

        Actions actions = new Actions(driver);
        //Select the Text
        Action storingBuildoperation = actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build();//Keyup-release the button,keydown-button ek press krnna
        storingBuildoperation.perform();
        Thread.sleep(5000);

        actions.keyDown(Keys.SHIFT)
                .sendKeys("writing capital sentence").perform();
        Thread.sleep(5000);

        actions.keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
                .sendKeys("x")
                .keyUp(Keys.CONTROL)
                .build().perform();

//        actions.keyDown(googleSerchTextBox,Keys.SHIFT)
//                .sendKeys("learn with hashir")
//                .perform();


    }


    @Test
    public void KeyboardOperationsTest2() throws InterruptedException {
        driver.get("http://www.leafground.com/list.xhtml");
        Thread.sleep(4000);

        List<WebElement> selection = driver.findElements(By.xpath("//ul[@aria-label='From']/li"));
        int size = selection.size();
        System.out.println("Li count is : " + size);


        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(selection.get(0))
                .click(selection.get(1))
                .click(selection.get(2))
                .perform();
    }
}


//Build ek store krnn action kiyn ek use krnne
