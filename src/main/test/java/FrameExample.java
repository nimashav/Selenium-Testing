import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {

    WebDriver driver;

    @BeforeMethod
    public void frameTestsPage()  {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/frame.xhtml");
    }

    @Test
    public void frameTests(){
        //1) Click Me (Inside frame)

        driver.switchTo().frame(0);
        WebElement button1 = driver.findElement(By.xpath(" //button[@id='Click']"));
        button1.click();
        String afterClickButtonText = button1.getText();
        System.out.println("After click Inside frame button Text " + afterClickButtonText);
        //Meke index kiyne nkn meke search krl blnn plwn IFrame keyk tyed kiyl balala plweni ek 0 dewni ek 1 adi les danawa



        //2) Click Me (Inside Nested frame)

        driver.switchTo().defaultContent();//go to main html page

        driver.switchTo().frame(2); //inside into third frame
        driver.switchTo().frame("frame2"); //inside into third frame > Child frame

        WebElement button3 = driver.findElement(By.id("Click"));
        button3.click();

        String afterClickNestedFrameButtonText = button3.getText();
        System.out.println("After click Inside Nested frame button Text " + afterClickNestedFrameButtonText);


        //3) How many frames in this
        driver.switchTo().defaultContent();//again switch to main html page

        List<WebElement> getIframeTagCount = driver.findElements(By.tagName("iframe"));
        int size = getIframeTagCount.size();
        System.out.println("IFrame tag count : " + size);

        for (WebElement iframeElemnt : getIframeTagCount) {
            String frameSRCattribtValue = iframeElemnt.getAttribute("src");
            System.out.println("frame src attribute value : " + frameSRCattribtValue);
        }
    }
}
//HTML Page ekak athule thawath HTML page ekak tyen ewta thma kiynne frame kiyala
//frame 3 eke idn frame 4 walt ydii index ek denne 0 les mkd frame 3 eke frame tyene 1 i em nisa ehi index ek 0 i
//HTML Page eke idl tyen IFrame gan blwoth 3i enne udinm pen tik wtri ey gnne
