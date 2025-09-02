package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;



public class TakeScreenshotExample {

    WebDriver driver;

    @BeforeMethod
    public void OpenWebPage(){

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://leafground.com/alert.xhtml");

    }

    //Copy screenshot in destinationFile, using FileUtils. (common-io) usage 90%
    //We can use Selenium's FileHandler as well to copy the file

    @Test
    public void takeScreenshotTests() throws IOException, AWTException {
        
        //1) capture Screenshot of Full web page

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // "C:\\Users\\HP\\OneDrive\\Desktop\\Selenium\\seleniumLearning\\ScreenShot\\alert_full_web_page.png"
        File destinationFile = new File( System.getProperty("user.dir") + "\\Screenshot\\" + "alert_full_web_page.png");
        FileHandler.copy(sourceFile,destinationFile);


        //2) capture Screenshot of Section of a web page
        WebElement section1pageElement = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]"));
        File source = section1pageElement.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_section_page.png");
        FileUtils.copyFile(source,target);


        //3) capture Screenshot of an Element on a Web page
        WebElement elementOfthePage = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]/div[1]"));
        File source1 = section1pageElement.getScreenshotAs(OutputType.FILE);
        File target1 = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_element_of_the_page.png");
        FileUtils.copyFile(source1,target1);
        
        //4) capture Screenshot of Full entire screen

    //Wrong way

//        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt93"));
//        alertBox.click();
//
//        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        File destinationFile = new File( System.getProperty("user.dir") + "\\Screenshot\\" + "alert_full_web_page.png");
//        FileHandler.copy(sourceFile,destinationFile);

        //Correct way
        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt93"));
        alertBox.click();

        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);
        BufferedImage source2 = robot.createScreenCapture(rectangle);
        File destinationFile2 = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_page_entire_screen.png");
        ImageIO.write(source2,"png",destinationFile2);

    }


}
