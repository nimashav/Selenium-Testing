import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenLinkTestPage() {
        driver = new ChromeDriver();
//        Dimension newSize = new Dimension(800,600);
//        driver.manage().window().setSize(newSize);
        driver.manage().window().maximize();
        driver.get("https://leafground.com/button.xhtml");
    }

    @Test
    public void buttonTest() {

        //01)Click and Confirm title
        WebElement clickButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
        clickButton.click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Actual Title same as expected");
        } else {
            System.out.println("Not same as expected");
        }
        //or can use testNG
        //Assert.assertEquals("actualTitle","expectedTitle","title mismatched");

        //02)Find the position in the submit button
        driver.navigate().back();
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xypoint = getPosition.getLocation();
        int x = xypoint.getX();
        int y = xypoint.getY();
        System.out.println("X position is: " + x + "Y position is: " +y);

        //03)Find the save button color
        WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt96"));
        String color = buttonColor.getCssValue("background-color");
        System.out.println("button color is: "+color);

        //04)Find the height and the width of thus button
        WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
        int height =size.getSize().getHeight();
        int width =size.getSize().getWidth();
        System.out.println("Height:" + height+ "Width:" + width);
    }
}
